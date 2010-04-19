package rice.model.controllable;

import java.util.ArrayList;
import java.util.List;

import rice.model.Controllable;
import rice.model.player.Player;
import rice.model.player.RiceSelector;
import rice.model.unit.Unit;
import rice.util.Position;
import rice.view.MSVisitor;
import rice.view.ViewableRallyPoint;
import rice.view.ViewableUnit;

public class RallyPoint extends Controllable implements ViewableRallyPoint {
	private ArrayList<Unit> combatArmy = new ArrayList<Unit>();
	private ArrayList<Unit> supportArmy = new ArrayList<Unit>();
	
	public RallyPoint(String typeName, int id, Player owner) {
		super(typeName, id, owner);
		// TODO Auto-generated constructor stub
	}
	
	public RallyPoint(int id, Player owner){
		super("Rally Point",id, owner);
	}

	@Override
	public void accept(MSVisitor m) {
		// TODO Auto-generated method stub
		
	}
	
	public List<Unit> getFullArmy()
	{
		List<Unit> fullArmy=new ArrayList<Unit>();
		fullArmy.addAll(this.getCombatArmy());
		fullArmy.addAll(this.getSupportArmy());
		return fullArmy;
	}
	
	public List<Unit> getCombatArmy()
	{
		return this.combatArmy;
	}
	
	public List<Unit> getSupportArmy()
	{
		return this.supportArmy;
	}

	@Override
	public List<ViewableUnit> getAllUnits()
	{
		List<ViewableUnit> viewableUnits=new ArrayList<ViewableUnit>();
		viewableUnits.addAll(this.getFullArmy());
		return viewableUnits;
	}

	@Override
	public List<ViewableUnit> getBattleGroup()
	{
		List<ViewableUnit> viewableUnits=new ArrayList<ViewableUnit>();
		viewableUnits.addAll(this.getCombatArmy());
		return viewableUnits;
	}
	
	@Override
	public List<ViewableUnit> getSupportGroup()
	{
		List<ViewableUnit> viewableUnits=new ArrayList<ViewableUnit>();
		viewableUnits.addAll(this.getSupportArmy());
		return viewableUnits;
	}

	@Override
	public String getDirection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void accept(RiceSelector s)
	{
		s.addRallyPoint(this);		
	}

	@Override
	public String getCommand() {
		
		return "default Rally Command";
	}

}
