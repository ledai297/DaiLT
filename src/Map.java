
public class Map {
	
	private Coordinate coordinate;
	private int[][] mapCoordinate;
	
	
	public Map(Coordinate coordinate, int[][] mapCoordinate) {
		super();
		this.coordinate = coordinate;
		this.mapCoordinate = mapCoordinate;
	}
	public Coordinate getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	public int[][] getMapCoordinate() {
		return mapCoordinate;
	}
	public void setMapCoordinate(int[][] mapCoordinate) {
		this.mapCoordinate = mapCoordinate;
	}
	
	public void displayMap(Map map) {
		int[][] arrayMap = map.getMapCoordinate();
		Coordinate coordinate = map.getCoordinate();
		for(int i=0;i<coordinate.getX();i++) {
			for(int j=0;j<coordinate.getY();j++) {
				System.out.print(arrayMap[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	
	
	
}
