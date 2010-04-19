package rice.model.player;

import java.util.Iterator;
import java.util.List;

import rice.controller.Tickable;
import rice.model.Controllable;
import rice.model.unit.*;
import rice.model.controllable.RallyPoint;
import rice.model.structures.*;

public class RiceSelector extends Selector<Controllable> implements Tickable
{
	
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
	private SelectorNode<Controllable> army;
	
	private RallyPoint selectedRally;
	
	public RiceSelector(IDHashMap idMap) {
		super();
		
		//set unit limits and id tables
		idMap.addIDTable("Unit", 25);
			idMap.addIDTable("Colonist", 1);
			idMap.addIDTable("Explorer", 10);
			idMap.addIDTable("Melee", 10);
			idMap.addIDTable("Ranged", 10);
			idMap.addIDTable("Bulldozer", 10);
			idMap.addIDTable("Transporter", 10);
		idMap.addIDTable("Structure", 10);
			idMap.addIDTable("Capital", 1);
			idMap.addIDTable("Mine", 10);
			idMap.addIDTable("Farm", 10);
			idMap.addIDTable("PowerPlant", 10);
			idMap.addIDTable("Fort", 10);
			idMap.addIDTable("ObservatoryTower", 10);
			idMap.addIDTable("University", 10);		
		idMap.addIDTable("Rally", 10);
		
		
		
		unit=addNode("Main", "Unit");
		structure=addNode("Main", "Structure");
		rally=addNode("Main", "Rally");
		army=addNode("Main", "Army");		
		
		controllables=new SelectorNode<Controllable>("");
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
		
		
		rallyPoint = new SelectorNode<Controllable>("RallyPoint");
		rallyPoint = addNode("Rally","RallyPoint");
		addNode("Army","Entire Army");
		addNode("Army","Combat Army");
		addNode("Army","Support Army");
		
	}
	
	//gets the current selection
	public Controllable getSelected()
	{
		//update army
		if(this.rallyPoint.getSelectedLeaf() != this.selectedRally)
		{
			this.selectedRally=(RallyPoint)this.rallyPoint.getSelectedLeaf();
			army.removeAllChildren();
			
			SelectorNode<Controllable> fullArmy=addNode("Army","Entire Army");
			SelectorNode<Controllable> combatArmy=addNode("Army","Combat Army");
			SelectorNode<Controllable> supportArmy=addNode("Army","Support Army");
			if(this.selectedRally!=null)
			{
				List<Unit> fullArmyUnits = this.selectedRally.getFullArmy();
				List<Unit> combatArmyUnits = this.selectedRally.getCombatArmy();
				List<Unit> supportArmyUnits = this.selectedRally.getSupportArmy();
				
				Iterator<Unit> iter1 = fullArmyUnits.iterator();
				while(iter1.hasNext())
				{
					fullArmy.addChild(new SelectorNode<Controllable>(iter1.next()));
				}
				
				Iterator<Unit> iter2 = combatArmyUnits.iterator();
				while(iter2.hasNext())
				{
					combatArmy.addChild(new SelectorNode<Controllable>(iter2.next()));
				}
				
				Iterator<Unit> iter3 = supportArmyUnits.iterator();
				while(iter3.hasNext())
				{
					supportArmy.addChild(new SelectorNode<Controllable>(iter3.next()));
				}
			}			
		}		
		return super.getSelected();
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
	
	public void removeRanged(Ranged r){
		ranged.removeChild(r);
	}
	
	public void removeColonist(Colonist c){
		colonist.removeChild(c);
	}
	
	public void removeExplorer(Explorer e){
		explorer.removeChild(e);
	}
	
	public void removeMelee(Melee m){
		melee.removeChild(m);
	}
	
	public void removeTransporter(Transporter t){
		transporter.removeChild(t);
	}
	
	public void removeBulldozer(Bulldozer b){
		bulldozer.removeChild(b);
	}
	
	public void removeCapital(Capital c){
		capital.removeChild(c);;
	}
	
	public void removeMine(Mine m){
		mine.removeChild(m);
	}
	
	public void removeFarm(Farm f){
		farm.removeChild(f);
	}
	
	public void removePowerPlant(PowerPlant p){
		powerPlant.removeChild(p);
	}
	
	public void removeFort(Fort f){
		fort.removeChild(f);
	}
	
	public void removeObservatoryTower(ObservatoryTower o){
		observatoryTower.removeChild(o);
	}
	
	public void removeUniversity(University u){
		university.removeChild(u);
	}
	
	public void removeRallyPoint(RallyPoint r){
		rallyPoint.removeChild(r);
	}

	public void tick(int tickNum)
	{
		List<Controllable> leafs = this.controllables.getAllLeafs();
		Iterator<Controllable> iter = leafs.iterator();
		while(iter.hasNext())
		{
			iter.next().tick();
		}
	}
	
	public List<Controllable> getAllUnits()
	{
		return this.unit.getAllLeafs();
	}
	
	public List<Controllable> getAllStructures()
	{
		return this.structure.getAllLeafs();
	}
	
	public List<Controllable> getAllRally()
	{
		return this.rallyPoint.getAllLeafs();
	}
	
	public Unit getSelectedUnit(){
		return (Unit)this.unit.getSelectedLeaf();
	}
	
	public Structure getSelectedStructure() {
		return (Structure)this.structure.getSelectedLeaf();
	}
	
	public RallyPoint getSelectedRallyPoint(){
		return (RallyPoint)this.rally.getSelectedLeaf();
	}

	public void processCommand(String command) {
		this.getSelected().performSelectedAbility(command);
	}

}
