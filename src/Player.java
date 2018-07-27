
public class Player {
	private int id,mark;
	private Ship ship;
	public Player(int id, Ship ship) {
		super();
		this.id = id;
		this.mark =2;
		this.ship = ship;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public Ship getShip() {
		return ship;
	}
	public void setShip(Ship ship) {
		this.ship = ship;
	}
	
	
}
