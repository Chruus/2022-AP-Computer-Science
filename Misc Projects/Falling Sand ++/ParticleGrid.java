//Christopher Petty
public class ParticleGrid {

    Particle[][] grid;

    public ParticleGrid(int rows, int cols) {
        grid = new Particle[rows][cols];
    }

    public Particle set(int r, int c, Particle particle) {
        if (r >= grid.length || r < 0 || c >= grid[r].length || c < 0)
            return null;
        Particle oldParticle = grid[r][c];
        grid[r][c] = particle;
        return oldParticle;
    }

    public Particle get(int r, int c) {
        return grid[r][c];
    }

    public int rows() {
        return grid.length;
    }

    public int cols() {
        return grid[0].length;
    }

    public boolean isInBounds(int row, int col) {
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[row].length)
            return true;
        return false;
    }

    public void swap(int r1, int c1, int r2, int c2) {
        Particle temp = grid[r1][c1];
        grid[r1][c1] = grid[r2][c2];
        grid[r2][c2] = temp;
    }
}
