package rice.model.player;

import java.util.Iterator;
import java.util.List;

import rice.controller.Tickable;
import rice.model.Controllable;
import rice.model.unit.*;
import rice.model.controllable.RallyPoint;
import rice.model.structures.*;

public class RiceSelector extends Selector<Controllable> implements Tickable {
	
	private SelectorNode<Controllable> controllables;
	private SelectorNode<Controllable> unit;
	private SelectorNode<Controllable> structure;
	private SelectorNode<Controllable> rally;
	
	private SelectorNode<Controllable> ranged;
	private SelectorNode<Controllable> melee;
	private SelectorNode<Controllable> colonist;
	private SelectorNode<Controllable> explorer;
	private SelectorNode<Controllable> transporter;
	private SelectorNode<Controllable> bulldozer;
	
	private SelectorNode<Controllable> capital;
	private SelectorNode<Controllable> mine;
	private SelectorNode<Controllable> farm;
	private SelectorNode<Controllable> powerPlant;
	private SelectorNode<Controllable> observatoryTower;
	private SelectorNode<Controllable> fort;
	private SelectorNode<Controllable> university;
	
	private SelectorNode<Controllable> rallyPoint;
	
	public RiceSelector() {
		super();
		
		
		unit=addNode("Main", "Unit");
		structure=addNode("Main", "Structure");
		rally=addNode("Main", "Rally");
		addNode("Main", "Army");
		
		
		controllables=new SelectorNode<Controllable>();
		controllables.addChild(unit);
		controllables.addChild(structure);
		controllables.addChild(rally);		
		
		ranged = addNode("Unit","Ranged");
		
		colonist = addNode("Unit","Colonist");
		
		melee = addNode("Unit","Melee");
		
		explorer = addNode("Unit","Explorer");
		transporter =  addNode("Unit","Transporter");
		bulldozer =  addNode("Unit","Buldozer");
		
		
		
		capital = addNode("Structure","Capital");
		mine = addNode("Structure","Mine");
		farm = addNode("Structure","Farm");
		powerPlant = addNode("Structure","PowerPlant");
		observatoryTower = addNode("Structure","ObservatoryTower");
		fort = addNode("Structure","Fort");
		university = addNode("Structure","University");
		
		rallyPoint = addNode("Rally","RallyPoint");
		
	}
	
	public void addControllable(Controllable c)
	{
		c.accept(this);
	}
	
	public void addRanged(Ranged r){
		ranged.addChild(new SelectorNode<Controllable>(r));
	}
	
	public void addColonist(Colonist c){
		colonist.addChild(new SelectorNode<Controllable>(c));
	}
	
	public void addExplorer(Explorer e){
		explorer.addChild(new SelectorNode<Controllable>(e));
	}
	
	public void addMelee(Melee m){
		melee.addChild(new SelectorNode<Controllable>(m));
	}
	
	public void addTransporter(Transporter t){
		transporter.addChild(new SelectorNode<Controllable>(t));
	}
	
	public void addBulldozer(Bulldozer b){
		bulldozer.addChild(new SelectorNode<Controllable>(b));
	}
	
	public void addCapital(Capital c){
		capital.addChild(new SelectorNode<Controllable>(c));
	}
	
	public void addMine(Mine m){
		mine.addChild(new SelectorNode<Controllable>(m));
	}
	
	public void addFarm(Farm f){
		farm.addChild(new SelectorNode<Controllable>(f));
	}
	
	public void addPowerPlant(PowerPlant p){
		powerPlant.addChild(new SelectorNode<Controllable>(p));
	}
	
	public void addFort(Fort f){
		fort.addChild(new SelectorNode<Controllable>(f));
	}
	
	public void addObservatoryTower(ObservatoryTower o){
		observatoryTower.addChild(new SelectorNode<Controllable>(o));
	}
	
	public void addUniversity(University u){
		university.addChild(new SelectorNode<Controllable>(u));
	}
	
	public void addRallyPoint(RallyPoint r){
		rallyPoint.addChild(new SelectorNode<Controllable>(r));
	}

	public void tick(int tickNum)
	{
		List<Controllable> leafs = this.controllables.getAllLeafs();
		//System.out.println("Leafs size "+ leafs.size());
		Iterator<Controllable> iter = leafs.iterator();
		while(iter.hasNext())
		{
			iter.next().tick();
		}
	}

	public void processCommand(String command) {
		this.getSelected().performSelectedAbility(command);
	}

}
