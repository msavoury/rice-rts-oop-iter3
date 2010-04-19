package rice.model.player;


import java.util.ArrayList;
import java.util.List;

import rice.controller.Tickable;
import rice.model.Controllable;
import rice.model.controllable.RallyPoint;
import rice.model.map.AreaMap;
import rice.model.structures.Capital;
import rice.model.structures.Structure;
import rice.model.structures.University;
import rice.model.unit.Colonist;
import rice.model.unit.Explorer;
import rice.model.unit.Melee;
import rice.model.unit.Ranged;
import rice.model.unit.Unit;
import rice.util.Position;
import rice.view.MSVisitor;
import rice.view.MSVisitorAcceptor;
import rice.view.ViewableStructure;
import rice.view.ViewableUnit;

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
	
	  //TODO: remove hardcoded ID\
	  Colonist c = new Colonist(1, this);
      selector.addColonist(c);
      AreaMap.getInstance().putControllable(c, startingPosition);
      
      Colonist c2 = new Colonist(2,this);
      selector.addColonist(c2);
      AreaMap.getInstance().putControllable(c2,startingPosition);
      
      Melee m = new Melee(1, this);
      selector.addMelee(m);
      AreaMap.getInstance().putControllable(c, startingPosition);
            
      Capital cap = new Capital(4, this);
      selector.addCapital(cap);
      AreaMap.getInstance().putControllable(cap, new Position(1,2));
	}
	
	/**
	 * Adds:
	 * 2 Colonists
	 * 2 Melee
	 * 2 Explorer
	 * 2 Ranged
	 * 1 Capital
	 * 1 University
	 * 2 Rally Point
	 */
	public void testInitialize() {
		  Colonist c = new Colonist(1, this);
	      selector.addColonist(c);
	      AreaMap.getInstance().putControllable(c, startingPosition);
	      
	      Colonist c2 = new Colonist(2,this);
	      selector.addColonist(c2);
	      AreaMap.getInstance().putControllable(c2,startingPosition);
	      
	      Melee m = new Melee(1, this);
	      selector.addMelee(m);
	      AreaMap.getInstance().putControllable(m, startingPosition);
	      
	      Melee m2 = new Melee(2, this);
	      selector.addMelee(m2);
	      AreaMap.getInstance().putControllable(m2, startingPosition);
	      
	      Explorer e = new Explorer(1,this);
	      selector.addExplorer(e);
	      AreaMap.getInstance().putControllable(e, startingPosition);
	      
	      Explorer e2 = new Explorer(2,this);
	      selector.addExplorer(e2);
	      AreaMap.getInstance().putControllable(e2, startingPosition);
	      
	      Ranged r = new Ranged(1,this);
	      selector.addRanged(r);
	      AreaMap.getInstance().putControllable(r, startingPosition);
	      
	      Ranged r2 = new Ranged(2,this);
	      selector.addRanged(r2);
	      AreaMap.getInstance().putControllable(r2, startingPosition);
	            
	      Capital cap = new Capital(1, this);
	      selector.addCapital(cap);
	      AreaMap.getInstance().putControllable(cap, new Position(1,2));
	      
	      University u = new University(1, this);
	      selector.addUniversity(u);
	      AreaMap.getInstance().putControllable(u, new Position(2,2));
	      
	      RallyPoint rp = new RallyPoint(5, this);
	      selector.addRallyPoint(rp);
	      AreaMap.getInstance().putControllable(rp, startingPosition);
	      
	      RallyPoint rp2 = new RallyPoint(8, this);
	      selector.addRallyPoint(rp2);
	      AreaMap.getInstance().putControllable(rp2, startingPosition);
	}
	
	public void setStartingPosition(Position p){
		this.startingPosition = p;
	}
	
	public Position getStartingPosition(){
		return this.startingPosition;
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
	
	public Unit getSelectedUnit() {
		return selector.getSelectedUnit();
	}
	
	public Structure getSelectedStructure() {
		return selector.getSelectedStructure();
	}
	
	public RallyPoint getSelectedRallyPoint() {
		return selector.getSelectedRallyPoint();
	}
	
	public List<ViewableUnit> getAllUnits(){
	  List <ViewableUnit> unitList = new ArrayList<ViewableUnit>();
		for(Controllable c : selector.getAllUnits()){
		  unitList.add((Unit)c);
	  }
		return unitList;
		
	}
	
	public List<ViewableStructure> getAllStructures() {
		List<ViewableStructure> structList = new ArrayList<ViewableStructure>();
		for(Controllable c : selector.getAllUnits()){
			  structList.add((Structure)c);
		  }
			return structList;
	}
	
	public List<Position> getActionTiles() {
		return selector.getSelected().getActionTiles();
	}
	
	
}
