package rice.model.player;


import java.util.Iterator;
import java.util.List;

import rice.model.unit.Colonist;
import rice.controller.Tickable;

import rice.util.Position;
import rice.view.MSVisitor;
import rice.view.MSVisitorAcceptor;

public class Player implements Tickable, MSVisitorAcceptor {

	//static members
	private static int playerCount = 1;
		
	//instance members
	private int id;
	private Position startingPostion;
	private RiceSelector selector;
	private VisibilityMap vmap;
	
	public Player(Position startingPosition){
		this.startingPostion = startingPosition;
		this.id = playerCount;
		this.selector = new RiceSelector();
		this.vmap = new VisibilityMap(this);
		playerCount++;
	}
	
	public void initialize() {
		//TODO: remove hardcoded ID
      selector.addColonist(new Colonist(1, this));
	}
	
	public void setStartingPosition(Position p){
		this.startingPostion = p;
	}
	
	public void updateTiles(Position origin, int radius)
	{
		vmap.updateTiles(origin, radius);
	}
	
	public void updateResources(Position origin, int radius)
	{
		vmap.updateResources(origin, radius);
	}
	
	public void tick(int tick) {
		System.out.println("Player "+ id + " ticked");
	}

	@Override
	public void accept(MSVisitor v) {
		vmap.accept(v);
		
	}
}
