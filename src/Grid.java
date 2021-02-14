
public class Grid {
	private int[][] gridValues;
	
	public Grid() {
		gridValues = new int[9][9];
	}
	
	public Grid(Grid g) {
		this.gridValues = g.getGridValues();
	}
	
	public int[][] getGridValues() {
		return gridValues;
	}
	
	public void setGridValues(int[][] gridValues) {
		this.gridValues = gridValues;
	}
	
	public String toString() {
		String output = " -----------------------\n";
		for (int y = 0; y < 9; y++) {
			output += "| ";
			for (int x = 0; x < 9; x++) {
				if (x == 3 || x == 6) {
					output += "| ";
				}
				output += gridValues[x][y] + " ";
			}
			output += "|\n";
			if (y == 2 || y == 5) {
				output += " -----------------------\n";
			}
		}
		output += " -----------------------";
		return output;
	}
}
