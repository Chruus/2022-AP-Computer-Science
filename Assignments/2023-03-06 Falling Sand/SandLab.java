import java.awt.*;
import java.util.*;

public class SandLab {
  public static void main(String[] args) {
    SandLab lab = new SandLab(120, 80);
    lab.run();
  }

  // add constants for particle types here
  public static final int BARRIER = -1;
  public static final int EMPTY = 0;
  public static final int METAL = 1;
  public static final int SAND = 2;
  public static final int WATER = 3;
  public static final int BALL = 4;

  // do not add any more fields
  private int[][] grid;
  private SandDisplay display;

  public SandLab(int numRows, int numCols) {
    String[] names;
    names = new String[5];
    names[EMPTY] = "Empty";
    names[METAL] = "Metal";
    names[SAND] = "Sand";
    names[WATER] = "Water";
    names[BALL] = "Ball";
    display = new SandDisplay("Falling Sand", numRows, numCols, names);
    grid = new int[numRows][numCols];
  }

  // called when the user clicks on a location using the given tool
  private void locationClicked(int row, int col, int tool) {
    if (grid[row][col] == WATER && tool != EMPTY) {
      moveWaterIntoWater(row, col);
      removeBarriers();
    }
    grid[row][col] = tool;
  }

  // copies each element of grid into the display
  public void updateDisplay() {
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[r].length; c++) {
        Color color = new Color(0, 0, 0);
        if (grid[r][c] == METAL)
          color = new Color(100, 100, 100);
        if (grid[r][c] == SAND)
          color = new Color(255, 255, 0);
        if (grid[r][c] == WATER)
          color = new Color(0, 0, 255);
        if (grid[r][c] == BALL)
          color = new Color(255, 0, 0);
        display.setColor(r, c, color);
      }
    }
  }

  // called repeatedly.
  // causes one random particle to maybe do something.
  public void step() {
    int row = (int) (Math.random() * (grid.length - 1));
    int col = (int) (Math.random() * (grid[row].length));
    if (grid[row][col] == BALL)
      calculateBall(row, col);
    if (grid[row][col] == SAND)
      calculateSand(row, col);
    if (grid[row][col] == WATER)
      calculateWater(row, col);
  }

  private void calculateBall(int row, int col) {
    if (isInBounds(row + 1, col) && grid[row + 1][col] == EMPTY) {
      swapParticle(row, col, row + 1, col);
    } else if (isInBounds(row - 1, col) && grid[row - 1][col] == WATER) {
      swapParticle(row, col, row - 1, col);
    } else if (isInBounds(row - 1, col - 1) && grid[row - 1][col - 1] == WATER) {
      swapParticle(row, col, row, col - 1);
    } else if (isInBounds(row - 1, col + 1) && grid[row - 1][col + 1] == WATER) {
      swapParticle(row, col, row, col + 1);
    }
  }

  private void calculateSand(int row, int col) {
    if (!isInBounds(row + 1, col) || grid[row + 1][col] == SAND || grid[row + 1][col] == METAL)
      return;

    if (grid[row + 1][col] == BALL) {
      if (isInBounds(row + 1, col - 1) && (grid[row + 1][col - 1] == EMPTY || grid[row + 1][col - 1] == WATER)) {
        swapParticle(row + 1, col, row + 1, col - 1);
      } else if (isInBounds(row + 1, col + 1) && (grid[row + 1][col + 1] == EMPTY || grid[row + 1][col + 1] == WATER)) {
        swapParticle(row + 1, col, row + 1, col + 1);
      } else
        return;
    }

    if (grid[row + 1][col] == WATER) {
      grid[row][col] = WATER;
      calculateWater(row, col);
    } else {
      grid[row][col] = EMPTY;
    }
    grid[row + 1][col] = SAND;
  }

  private void calculateWater(int row, int col) {
    ArrayList<String> directions = new ArrayList<String>();

    if (isInBounds(row + 1, col) && (grid[row + 1][col] == EMPTY || grid[row + 1][col] == BALL))
      directions.add("down");
    if (isInBounds(row, col + 1) && (grid[row][col + 1] == EMPTY || grid[row][col + 1] == BALL))
      directions.add("right");
    if (isInBounds(row, col - 1) && (grid[row][col - 1] == EMPTY || grid[row][col - 1] == BALL))
      directions.add("left");

    if (directions.size() == 0) {
      return;
    }

    int direction = (int) (Math.random() * directions.size());
    if (directions.get(direction).equals("down")) {
      swapParticle(row, col, row + 1, col);
    }
    if (directions.get(direction).equals("right")) {
      swapParticle(row, col, row, col + 1);
    }
    if (directions.get(direction).equals("left")) {
      swapParticle(row, col, row, col - 1);
    }
  }

  private void swapParticle(int row1, int col1, int row2, int col2) {
    if (!isInBounds(row1, col1) || !isInBounds(row2, col2))
      return;
    int pos1 = grid[row1][col1];
    grid[row1][col1] = grid[row2][col2];
    grid[row2][col2] = pos1;
  }

  private boolean isInBounds(int row, int col) {
    if (row < grid.length && row >= 0 && col < grid[row].length && col >= 0)
      return true;
    return false;
  }

  private boolean moveWaterIntoWater(int row, int col) {
    if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length)
      return false;
    if (grid[row][col] == EMPTY) {
      grid[row][col] = WATER;
      return true;
    }
    if (grid[row][col] != WATER)
      return false;

    grid[row][col] = BARRIER;
    if (moveWaterIntoWater(row - 1, col) || moveWaterIntoWater(row + 1, col) || moveWaterIntoWater(row, col - 1)
        || moveWaterIntoWater(row, col + 1)) {
      grid[row][col] = WATER;
      return true;
    }
    return false;
  }

  private void removeBarriers() {
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[r].length; c++) {
        if (grid[r][c] == BARRIER)
          grid[r][c] = WATER;
      }
    }
  }

  // do not modify
  public void run() {
    while (true) {
      for (int i = 0; i < display.getSpeed(); i++)
        step();
      updateDisplay();
      display.repaint();
      display.pause(1); // wait for redrawing and for mouse
      int[] mouseLoc = display.getMouseLocation();
      if (mouseLoc != null) // test if mouse clicked
        locationClicked(mouseLoc[0], mouseLoc[1], display.getTool());
    }
  }
}
