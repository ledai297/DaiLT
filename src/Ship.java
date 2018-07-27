import java.util.ArrayList;

public class Ship {
	
	private ArrayList<Coordinate> listCoordinate;
	
	

	public Ship(ArrayList<Coordinate> listCoordinate) {
		super();
		this.listCoordinate = listCoordinate;
	}

	public ArrayList<Coordinate> getListCoordinate() {
		return listCoordinate;
	}

	public void setListCoordinate(ArrayList<Coordinate> listCoordinate) {
		this.listCoordinate = listCoordinate;
	}
	
	
}
