import java.util.ArrayList;
import java.util.Random;

public class Generator {
	private Grid grid;
	
	public Generator(Grid grid) {
		this.grid = grid;
		generateSudoku();
		if (new Validator(grid).validateSudoku()) {
			System.out.println("Generated Sudoku is valid");
		} else {
			System.out.println("Generated Sudoku is invalid");
		}
	}
	
	private void generateSudoku(){
		
		// diagonals
		generateBoxRandomly(BoxLocation.TOP_LEFT);
		generateBoxRandomly(BoxLocation.MIDDLE_CENTER);
		generateBoxRandomly(BoxLocation.BOTTOM_RIGHT);
		// squares
		new Solver(grid).solveSudoku();
	}
	
	private void generateBoxRandomly(BoxLocation location) {
		ArrayList<Integer> remainingNumbers = getArraylistNumbers();
		Random random = new Random();
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				int randNum = random.nextInt(remainingNumbers.size());
				grid.getGridValues()[x + location.getX()][y + location.getY()] = remainingNumbers.get(randNum);
				remainingNumbers.remove(randNum);
			}
		}
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
