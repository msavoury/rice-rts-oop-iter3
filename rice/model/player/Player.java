package rice.model.player;


import rice.model.unit.Colonist;
import rice.controller.Tickable;

import rice.util.Position;

public class Player implements Tickable {

	//static members
	private static int playerCount = 1;
		
	//instance members
	private int id;
	private Position startingPostion;
	private RiceSelector selector;
	
	
	public Player(Position startingPosition){
		this.startingPostion = startingPosition;
		this.id = playerCount;
		this.selector = new RiceSelector();
		playerCount++;
	}
	
	public void initialize() {
		//TODO: remove hardcoded ID
      selector.addColonist(new Colonist(1, this));
	}
	
	public void setStartingPosition(Position p){
		this.startingPostion = p;
	}
	
	public void tick(int tick) {

		System.out.println("Player "+ id + " ticked");
	}
}
