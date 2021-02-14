import java.util.ArrayList;

public enum BoxLocation {
	TOP_LEFT (0,0),
	TOP_CENTER (3,0),
	TOP_RIGHT (6,0),
	MIDDLE_LEFT (0,3),
	MIDDLE_CENTER (3,3),
	MIDDLE_RIGHT (6,3),
	BOTTOM_LEFT (0,6),
	BOTTOM_CENTER (3,6),
	BOTTOM_RIGHT (6,6);
	
	private final int x,y;
	
	BoxLocation(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public static ArrayList<BoxLocation> getOrderedLocations(){
		ArrayList<BoxLocation> orderedLocations = new ArrayList<BoxLocation>();
		orderedLocations.add(BoxLocation.TOP_LEFT);
		orderedLocations.add(BoxLocation.TOP_CENTER);
		orderedLocations.add(BoxLocation.TOP_RIGHT);
		orderedLocations.add(BoxLocation.MIDDLE_LEFT);
		orderedLocations.add(BoxLocation.MIDDLE_CENTER);
		orderedLocations.add(BoxLocation.MIDDLE_RIGHT);
		orderedLocations.add(BoxLocation.BOTTOM_LEFT);
		orderedLocations.add(BoxLocation.BOTTOM_CENTER);
		orderedLocations.add(BoxLocation.BOTTOM_RIGHT);
		return orderedLocations;
	}
}
