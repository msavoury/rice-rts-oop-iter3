package rice.model.player;


import java.util.List;

import rice.controller.Tickable;
import rice.model.Controllable;
import rice.model.map.AreaMap;
import rice.model.structures.Capital;
import rice.model.unit.Colonist;
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
	private RiceTree techs;
	private VisibilityMap vmap;
	
	public Player(Position startingPosition){
		this.startingPosition = startingPosition;
		this.id = playerCount;
		this.selector = new RiceSelector();
		this.techs = new RiceTree();
		this.vmap = new VisibilityMap(this);
		playerCount++;
	}
	
	public void initialize() {
		
	  //this.addControllable(new Colonist(1, this));
	  //TODO: remove hardcoded ID\
	  Colonist c = new Colonist(1, this);
      selector.addColonist(c);
      AreaMap.getInstance().putControllable(c, startingPosition);
            
      Capital cap = new Capital(4, this);
      selector.addCapital(cap);
      AreaMap.getInstance().putControllable(cap, new Position(1,2));
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
		//System.out.println("Player "+ id + " ticked");
		selector.tick(tick);
		vmap.updateTiles(new Position(2,2), 3);
	}
		
	@Override
	public void accept(MSVisitor v) {
		vmap.accept(v);
		
	}

	//returns specific research bonus
	public int getTechBonus(String branch, String tech)
	{
		return this.techs.getBonus(branch, tech);
	}

    public void nextMode()
    {
    	selector.selectNext(0);
    }
    public void previousMode()
    {
    	selector.selectPrev(0);
    }
    public void nextSubmode()
    {
    	selector.selectNext(1);
    }
    public void previousSubmode()
    {
    	selector.selectPrev(1);
    }
    public void nextInstance()
    {
    	selector.selectNext(2);
    }
    public void previousInstance()
    {
    	selector.selectPrev(2);
    }
    public void nextAbility(){
    	selector.getSelected().nextAbility();
    }
    public void previousAbility(){
    	selector.getSelected().previousAbility();
    }

	public void processCommand(String command) {
		// TODO Auto-generated method stub
		selector.processCommand(command);
	}
	
	public Controllable getSelected() {
		return selector.getSelected();
	}
	
	public List<String> getSelectedPath() {
		return selector.getBranchPath();
	}
}
