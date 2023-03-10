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
  private ParticleGrid grid;
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
    grid = new ParticleGrid(numRows, numCols);
    for (int r = 0; r < grid.rows(); r++) {
      for (int c = 0; c < grid.cols(); c++) {
        grid.set(r, c, new AirParticle(r, c, grid));
      }
    }
  }

  // called when the user clicks on a location using the given tool
  private void locationClicked(int row, int col, int tool) {
    if (tool == SAND)
      grid.set(row, col, new SandParticle(row, col, grid));
    if (tool == WATER)
      grid.set(row, col, new WaterParticle(row, col, grid));
  }

  // copies each element of grid into the display
  public void updateDisplay() {
    for (int r = 0; r < grid.rows(); r++) {
      for (int c = 0; c < grid.cols(); c++) {
        display.setColor(r, c, grid.get(r, c).color());
      }
    }
  }

  // called repeatedly.
  // causes one random particle to maybe do something.
  public void step() {
    int row = (int) (Math.random() * (grid.rows() - 1));
    int col = (int) (Math.random() * (grid.cols()));
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
