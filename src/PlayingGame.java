import java.util.ArrayList;
import java.util.Scanner;

public class PlayingGame {
	
	static Scanner sc = new Scanner(System.in);	
	
	public Map putShipOnMap(Player player,Map map) {
		Ship ship = player.getShip();
		ArrayList<Coordinate> listCoorShip = ship.getListCoordinate();
		int[][] mapArray = map.getMapCoordinate();
		for(int i=0;i<listCoorShip.size();i++) {
			mapArray[listCoorShip.get(i).getX()][listCoorShip.get(i).getY()] = player.getId();
		}
		map.setMapCoordinate(mapArray);
		return map;
	}
	
	public boolean checkHit(Coordinate coordinate,Player player) {
		ArrayList<Coordinate> listCoordinate = player.getShip().getListCoordinate();
		for(int i = 0; i<listCoordinate.size();i++) {
			if(coordinate.getX()==listCoordinate.get(i).getX()
					&& coordinate.getY() == listCoordinate.get(i).getY()) {
				return true;
			}
			
		}
		return false;
	}
	
	public void updatePlayer(Coordinate coordinate,Player player) {
		if(checkHit(coordinate, player)==true) {
			player.setMark(player.getMark()-1);
		}
	}
	
	
	public void updateMap(Map map,Coordinate coordinate,Player focus) {
		int[][] mapArray = map.getMapCoordinate();
		if(checkHit(coordinate, focus)==true) {
			mapArray[coordinate.getX()][coordinate.getY()] = 8; // trúng
		}
		else {
			mapArray[coordinate.getX()][coordinate.getY()] = 4; // trượt
		}
		map.setMapCoordinate(mapArray);
	}
	
	public void hit(Map map,Player focus) {// player == focus
		
		System.out.println("Turn of the player " );
		System.out.println("input focus's coordinate");
		System.out.println(" Input X :");
		int x = sc.nextInt();
		System.out.println("Input Y : ");
		int y = sc.nextInt();
		Coordinate coordinate = new Coordinate(x, y);
		updateMap(map, coordinate, focus);
		updatePlayer(coordinate, focus);
		
	}
	
	public Player createPlayer() {
		System.out.println("Nhap ID Player:");
		int id = sc.nextInt();
		System.out.println("Input Ship's coordinate of player"+ id);
		System.out.println("Input x1 :");
		int x1 = sc.nextInt();
		System.out.println("Input y1 :");
		int y1 = sc.nextInt();
		
		Coordinate coor1 = new Coordinate(x1, y1);
		System.out.println("Input x2 : ");
		int x2 = sc.nextInt();
		System.out.println("Input y1 :");
		int y2 = sc.nextInt();
		
		Coordinate coor2 = new Coordinate(x2, y2);
		
		ArrayList<Coordinate> list = new ArrayList<>();
		list.add(coor1);
		list.add(coor2);
		Player player = new Player(id, new Ship(list));
		return player;
		
		
	}
	
	public Map createMap(int maxX , int maxY) {
		
		Map newMap = new Map(new Coordinate(maxX, maxY), new int[maxX][maxY]);
		return newMap;
	}
	public Map inputMap() {
		System.out.println("input number of rows : ");
		int maxX = sc.nextInt();
		System.out.println("'input number of column : '");
		int maxY = sc.nextInt();
		Map map = createMap(maxX, maxY);
		map.displayMap(map);
		return map;
	}
	
	public boolean checkOverGame(Player player1 , Player player2) {
		if(player1.getMark()==0 || player2.getMark()== 0) {
			return true;
		}
		return false;
	}
	
	public void  notifyWinner(Player player1, Player player2) {
		if(checkOverGame(player1, player2)) {
			if(player1.getMark()>0) {
				System.out.println("Player 1 win");
			}
			else System.out.println("Player 2 win");
		}
		
	}
	
	public static void main(String[] args) {
	
		PlayingGame p = new PlayingGame();
		Map map = p.inputMap();
		Player player1 = p.createPlayer();
		map = p.putShipOnMap(player1, map);
		map.displayMap(map);
		Player player2 = p.createPlayer();
		sc.nextLine();
		map = p.putShipOnMap(player2, map);
		map.displayMap(map);
		while(!p.checkOverGame(player1, player2)) {
			p.hit(map, player2);
			map.displayMap(map);
			p.hit(map, player1);
			map.displayMap(map);
		}
		p.notifyWinner(player1, player2);
	}
}
