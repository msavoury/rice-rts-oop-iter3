package rice.model.player;


import java.util.Iterator;
import java.util.List;

import rice.model.map.AreaMap;
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
	private Position startingPosition;
	private RiceSelector selector;
	private VisibilityMap vmap;
	
	public Player(Position startingPosition){
		this.startingPosition = startingPosition;
		this.id = playerCount;
		this.selector = new RiceSelector();
		this.vmap = new VisibilityMap(this);
		playerCount++;
	}
	
	public void initialize() {
		
	  //this.addControllable(new Colonist(1, this));
	  //TODO: remove hardcoded ID\
	  Colonist c = new Colonist(1, this);
      selector.addColonist(c);
      Colonist c2 = new Colonist(2, this);
      selector.addColonist(c2);
      Colonist c3 = new Colonist(3, this);
      selector.addColonist(c3);
      AreaMap.getInstance().putControllable(c, startingPosition);
      AreaMap.getInstance().putControllable(c2, new Position(2,3));
      AreaMap.getInstance().putControllable(c3, new Position(2,3));
      Colonist c4 = new Colonist(4, this);
      selector.addColonist(c4);
      AreaMap.getInstance().putControllable(c4, new Position(2,1));
      Colonist c5 = new Colonist(5, this);
      selector.addColonist(c5);
      AreaMap.getInstance().putControllable(c5, new Position(2,1));
      Colonist c6 = new Colonist(6, this);
      selector.addColonist(c6);
      AreaMap.getInstance().putControllable(c6, new Position(2,2));
      Colonist c7 = new Colonist(7, this);
      selector.addColonist(c7);
      AreaMap.getInstance().putControllable(c7, new Position(2,2));
	}
	
	public void setStartingPosition(Position p){
		this.startingPosition = p;
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
		vmap.updateTiles(new Position(2,2), 3);
	}
		
	@Override
	public void accept(MSVisitor v) {
		vmap.accept(v);
		
	}
}
