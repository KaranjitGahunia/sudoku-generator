import java.util.ArrayList;

public class Solver {
	private Grid grid;
	
	public Solver(Grid grid) {
		this.grid = grid;
	}

	public boolean solveSudoku() {
		return generatePotentialSolution(BoxLocation.TOP_LEFT, 1);
	}
	
	private boolean generatePotentialSolution(BoxLocation location, int number) {
		System.out.println(grid.toString());
		// Check if this location already has number
		if (boxContainsNumber(number, location)) {
			// If so, get the next location
			System.out.println("--> Skip box " + location.name() + ". Already contains " + number);
			BoxLocation nextLocation = getNextLocation(location);
			
			// Increment number. If == 10, end recursion
			if (nextLocation == BoxLocation.TOP_LEFT) {
				System.out.println("--> No more boxes for number " + number);
				number++;
				if (number == 10) {
					// If next location is top left and number is 10 return true
					System.out.println("--> Complete\n");
					return true;
				} else {
					System.out.println("--> Starting number " + number + " from " + nextLocation.name());
				}
			}
			return generatePotentialSolution(nextLocation, number);
		} else {
			// loop through box coordinates
			for (int y = location.getY(); y < (3 + location.getY()); y++) {
				for (int x = location.getX(); x < (3 + location.getX()); x++) {
					// if coordinate is eligible for number, msg, store val.
					if (isEligible(number, x, y)) {
						System.out.println("Cell [" + x + ", " + y + "] is eligible for " + number);
						// Add number to grid cell
						grid.getGridValues()[x][y] = number;
						System.out.println(grid.toString());
						
						// Get next BoxLocation (left -> right, top -> bottom)
						BoxLocation nextLocation = getNextLocation(location);
						
						// Increment number. If == 10, end recursion
						if (nextLocation == BoxLocation.TOP_LEFT) {
							System.out.println("--> No more boxes for number " + number);
							number++;
							if (number == 10) {
								// If next location is top left and number is 10 return
								System.out.println("--> Complete\n");
								return true;
							} else {
								System.out.println("--> Starting number " + number + "from " + nextLocation.name());
							}
						}
						
						// Call recursive function. If returns true, pass
						// Else remove coordinates from cell and try another solution
						if (generatePotentialSolution(nextLocation, number)) {
							return true;
						} else {
							System.out.println("--> Cell [" + x + ", " + y + "] is a dead end. Reverting to 0");
							grid.getGridValues()[x][y] = 0;
							System.out.println(grid.toString());
						}
					}
				}
			}
		}
		return false;
	}
	
	private boolean isEligible(int number, int x, int y) {
		if (grid.getGridValues()[x][y] != 0) {
			return false;
		}
		for (int i = 0; i < 9; i++) {
			if (grid.getGridValues()[i][y] == number) {
				return false;
			}
		}
		for (int i = 0; i < 9; i++) {
			if (grid.getGridValues()[x][i] == number) {
				return false;
			}
		}
		return true;
	}
	
	private boolean boxContainsNumber(int number, BoxLocation location) {
		// get range of coordinates for other values in box
		int baseX = location.getX();
		int baseY = location.getY();
		for (int i = baseY; i < baseY + 3; i++) {
			for (int j = baseX; j < baseX + 3; j++) {
				if (grid.getGridValues()[j][i] == number) {
					return true;
				}
			}
		}
		return false;
	}
	
	private BoxLocation getNextLocation(BoxLocation location) {
		ArrayList<BoxLocation> orderedLocations = BoxLocation.getOrderedLocations();
		int locationIndex = orderedLocations.indexOf(location) + 1;
		if (locationIndex == orderedLocations.size()) {
			return BoxLocation.TOP_LEFT;
		}
		return orderedLocations.get(locationIndex);	
	}
}
