import java.util.ArrayList;

public class Validator {
	private Grid grid;
	
	public Validator(Grid grid) {
		this.grid = grid;
	}
	
	public boolean validateSudoku() {
		// Check each row
		for (int y = 0; y < 9; y++) {
			ArrayList<Integer> remainingNumbers = getArraylistNumbers();
			for (int x = 0; x < 9; x++) {
				remainingNumbers.remove(new Integer(grid.getGridValues()[x][y]));
			}
			if (!remainingNumbers.isEmpty()) {
				System.out.println("--> Row " + y + " is invalid. Doesn't contain: " + remainingNumbers.toString());
				return false;
			}
		}
		
		System.out.println("All rows are valid");
		
		// Check each column
		for (int x = 0; x < 9; x++) {
			ArrayList<Integer> remainingNumbers = getArraylistNumbers();
			for (int y = 0; y < 9; y++) {
				remainingNumbers.remove(new Integer(grid.getGridValues()[x][y]));
			}
			if (!remainingNumbers.isEmpty()) {
				System.out.println("--> Column " + x + " is invalid. Doesn't contain: " + remainingNumbers.toString());
				return false;
			}
		}
		
		System.out.println("All columns are valid");
		
		return areAllBoxesValid();
	}

	private boolean isBoxValid(BoxLocation location) {
		ArrayList<Integer> remainingNumbers = getArraylistNumbers();
		int baseX = location.getX();
		int baseY = location.getY();
		for (int i = baseY; i < baseY + 3; i++) {
			for (int j = baseX; j < baseX + 3; j++) {
				remainingNumbers.remove(new Integer(grid.getGridValues()[j][i]));
			}
		}
		return remainingNumbers.isEmpty();
	}
	
	private boolean areAllBoxesValid() {
		if (!isBoxValid(BoxLocation.TOP_LEFT)) {
			return false;
		}
		if (!isBoxValid(BoxLocation.TOP_CENTER)) {
			return false;
		}
		if (!isBoxValid(BoxLocation.TOP_RIGHT)) {
			return false;
		}
		if (!isBoxValid(BoxLocation.MIDDLE_LEFT)) {
			return false;
		}
		if (!isBoxValid(BoxLocation.MIDDLE_CENTER)) {
			return false;
		}
		if (!isBoxValid(BoxLocation.MIDDLE_RIGHT)) {
			return false;
		}
		if (!isBoxValid(BoxLocation.BOTTOM_LEFT)) {
			return false;
		}
		if (!isBoxValid(BoxLocation.BOTTOM_CENTER)) {
			return false;
		}
		if (!isBoxValid(BoxLocation.BOTTOM_RIGHT)) {
			return false;
		}
		return true;
	}
	
	private ArrayList<Integer> getArraylistNumbers(){
		int[] numbers = {1,2,3,4,5,6,7,8,9};
		ArrayList<Integer> remainingNumbers = new ArrayList<Integer>();
		for (int n : numbers) {
			remainingNumbers.add(n);
		}
		return remainingNumbers;
	}
	
}
