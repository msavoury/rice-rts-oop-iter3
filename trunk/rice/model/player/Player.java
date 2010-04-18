package rice.model.player;

import rice.controller.Tickable;
import rice.util.Position;

public class Player implements Tickable {

	//static members
	private static int playerCount = 1;
	
	private Position startingPostion;
	
	//instance members
	private int id;
	
	public Player(){
		this.id = playerCount;
		playerCount++;
	}
	
	public void setStartingPosition(Position p){
		this.startingPostion = p;
	}
	
	public void tick(int tick) {

		System.out.println("Player "+ id + " ticked");
	}
}
