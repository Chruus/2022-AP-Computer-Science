//Christopher Petty

public class BombingTactics {

	public static void main(String[] args) {

		Alien[][] alienGrid = { { null, new Alien(6), new Alien(8), null, null },
				{ new Alien(5), new Alien(), null, null, null },
				{ new Alien(12), new Alien(5), null, null, null },
				{ null, null, null, null, new Alien(3) },
				{ new Alien(17), null, null, new Alien(14), null } };

		Alien[][] alienGrid2 = { { new Alien(5), new Alien(12), null, null, new Alien(2) },
				{ null, new Alien(10), new Alien(4), new Alien(5), null },
				{ null, null, null, null, null },
				{ new Alien(6), null, null, new Alien(5), null },
				{ new Alien(6), new Alien(7), null, null, null } };

		System.out.println(1);
		// 1
		System.out.println("Most aliens you can destroy on Grid1: " + destroyMostAliens(alienGrid));
		System.out.println("Most aliens you can destroy on Grid2: " + destroyMostAliens(alienGrid2));
		System.out.println();

		System.out.println(2);
		// 2
		System.out.println("Drop Point Grid 1:   " + findDropPoint(alienGrid));
		System.out.println("Drop Point Grid 2:   " + findDropPoint(alienGrid2));
		System.out.println();

		System.out.println(3);
		// 3
		System.out.println("Bomb this spot on Grid1 with 1 location radius:   " + destroyMostEvil(alienGrid, 1));
		System.out.println("Bomb this spot on Grid2 with 1 location radius:   " + destroyMostEvil(alienGrid2, 1));
		System.out.println("Bomb this spot on Grid1 with 2 location radius:   " + destroyMostEvil(alienGrid, 2));
		System.out.println("Bomb this spot on Grid2 with 2 location radius:   " + destroyMostEvil(alienGrid2, 2));

	}

	// Post-condition: return the number of aliens surrounding the given row, col
	// with a 1 location radius
	private static int getSurroundingAliens(Alien[][] grid, int row, int col) {
		int output = 0;
		for (int r = row - 1; r <= row + 1; r++) {
			for (int c = col - 1; c <= col + 1; c++) {
				if (r >= 0 && r < grid.length && c >= 0 && c < grid[r].length && grid[r][c] != null) {
					output++;
				}
			}
		}
		return output;
	}

	// Post-condition: return the number of aliens surrounding the given row, col
	// with the given radius
	private static int getSurroundingAliens(Alien[][] grid, int row, int col, int radius) {
		int output = 0;
		for (int r = row - radius; row <= row + radius; row++) {
			for (int c = col - radius; col <= col + radius; col++) {
				if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length) {
					if (grid[r][c] != null)
						output++;
				}
			}
		}
		return output;
	}

	// Post-Condition: This method returns the most aliens that can be destroyed by
	// dropping
	// a bomb with a 1 location radius of explosion! (3x3)
	public static int destroyMostAliens(Alien[][] grid) {
		int output = 0;
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				output = Math.max(output, getSurroundingAliens(grid, r, c));
			}
		}
		return output;
	}

	// Post-condition: return the amount of evil surrounding the given row, col with
	// given the radius
	private static int getSurroundingEvil(Alien[][] grid, int row, int col, int radius) {
		int output = 0;
		for (int r = row - radius; r <= row + radius; r++) {
			for (int c = col - radius; c <= col + radius; c++) {
				if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length) {
					if (grid[r][c] != null)
						output += grid[r][c].getEvilAmount();
				}
			}
		}
		return output;
	}

	// Post-Condition: This method returns A location of where there are the fewest
	// aliens
	// in a 1 cell radius surrounding an empty location (3x3)
	public static Location findDropPoint(Alien[][] grid) {
		Location output = new Location(0, 0);
		int leastAliens = Integer.MAX_VALUE;
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				int surroundingAliens = getSurroundingAliens(grid, r, c);
				if (surroundingAliens < leastAliens && grid[r][c] == null) {
					leastAliens = surroundingAliens;
					output = new Location(r, c);
				}
			}
		}
		return output;
	}

	// Post-Condition: This method returns the Location of where you can destroy the
	// most evil in the given radius
	public static Location destroyMostEvil(Alien[][] grid, int radius) {
		Location output = new Location(0, 0);
		int highestEvil = 0;
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				int surroundingEvil = getSurroundingEvil(grid, r, c, radius);
				if (surroundingEvil > highestEvil) {
					highestEvil = surroundingEvil;
					output = new Location(r, c);
				}
			}
		}
		return output;
	}

}

class Alien {
	private int evilAmount;

	public Alien() {
		evilAmount = 0;
	}

	public Alien(int e) {
		evilAmount = e;
	}

	public int getEvilAmount() {
		return evilAmount;
	}
}

class Location {
	private int r;
	private int c;

	public Location(int r, int c) {
		this.r = r;
		this.c = c;
	}

	public String toString() {
		return "(" + r + ", " + c + ")";
	}
}
