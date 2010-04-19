package rice.model.controllable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import rice.model.Controllable;
import rice.model.player.Player;
import rice.model.player.RiceSelector;
import rice.model.unit.Unit;
import rice.model.unit.UnitOwner;
import rice.util.Position;
import rice.view.MSVisitor;
import rice.view.ViewableRallyPoint;
import rice.view.ViewableUnit;

public class RallyPoint extends Controllable implements ViewableRallyPoint, UnitOwner {
	private ArrayList<Unit> combatArmy;
	private ArrayList<Unit> supportArmy;
	
	public RallyPoint(String typeName, int id, Player owner)
	{
		super(typeName, id, owner);
		combatArmy = new ArrayList<Unit>();
		supportArmy = new ArrayList<Unit>();
		// TODO Auto-generated constructor stub
	}
	
	public RallyPoint(int id, Player owner){
		super("Rally Point",id, owner);
	}

	@Override
	public void accept(MSVisitor m)
	{
		m.visit(this);
		
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
		if(this.combatArmy!=null) 
		{
			return this.combatArmy;
		}
		else
		{
			return new ArrayList<Unit>();
		}
		
	}
	
	public List<Unit> getSupportArmy()
	{
		if(this.supportArmy!=null) 
		{
			return this.supportArmy;
		}
		else
		{
			return new ArrayList<Unit>();
		}
	}

	public List<ViewableUnit> getAllViewableUnits()
	{
		List<ViewableUnit> viewableUnits=new ArrayList<ViewableUnit>();
		viewableUnits.addAll(this.getFullArmy());
		return viewableUnits;
	}

	public List<ViewableUnit> getBattleGroup()
	{
		List<ViewableUnit> viewableUnits=new ArrayList<ViewableUnit>();
		viewableUnits.addAll(this.getCombatArmy());
		return viewableUnits;
	}
	
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
	
	public double getHealth()
	{
		int health=0;
		List<Unit> units = this.getCombatArmy();
		if(units != null)
		{
			Iterator<Unit> iter = units.iterator();
			while(iter.hasNext())
			{
				health+=iter.next().getHealth();
			}
		}
		return health;
	}
	
	public int getAttack()
	{
		int attack=0;
		Iterator<Unit> iter = this.getCombatArmy().iterator();
		while(iter.hasNext())
		{
			attack+=iter.next().getAttack();
		}
		return attack;
	}
	
	public int getDefense()
	{
		int defense=0;
		Iterator<Unit> iter = this.getCombatArmy().iterator();
		while(iter.hasNext())
		{
			defense+=iter.next().getDefense();
		}
		return defense;
	}
	
	public int getArmor()
	{
		int armor=0;
		Iterator<Unit> iter = this.getCombatArmy().iterator();
		while(iter.hasNext())
		{
			armor+=iter.next().getArmor();
		}
		return armor;
	}
	
	public void takeDamage(double value)
	{
		  if(value<0)
		  {
			  value=value*(-1);
		  }
		  double dmg=(double)this.getArmor()-value;
		  double indivDmg=dmg/this.getCombatArmy().size();
		  Iterator<Unit> iter = this.getCombatArmy().iterator();
			while(iter.hasNext())
			{
				iter.next().changeHealth(-indivDmg);
			}
	}
	
	public double getMaxHealth()
	{
		int maxHealth=0;
		Iterator<Unit> iter = this.getCombatArmy().iterator();
		while(iter.hasNext())
		{
			maxHealth+=iter.next().getMaxHealth();
		}
		return maxHealth;
	}

	public int getVisibilityRadius()
	{
		int visibility=0;
		Iterator<Unit> iter = this.getCombatArmy().iterator();
		while(iter.hasNext())
		{
			visibility=Math.max(iter.next().getSpeed(), visibility);
		}
		return visibility;
	}
	
	@Override
	public int getSpeed()
	{
		int speed=0;
		Iterator<Unit> iter = this.getCombatArmy().iterator();
		if(iter.hasNext())
		{
			speed=iter.next().getSpeed();		
			while(iter.hasNext())
			{
				speed=Math.min(iter.next().getSpeed(), speed);
			}
		}
		return speed;
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

	@Override
	public void addUnit(Unit u)
	{
		u.setUnitOwner(this);
		if((u.getTile()==this.getTile()) && (u.getPowerStatus()))
		{
			this.supportArmy.remove(u);
			if(!this.combatArmy.contains(u))
			{
				this.combatArmy.add(u);
				//put the unit "inside" Rally
				u.setTile(null);
			}			
		}
		else
		{
			if(u.getTile()==null)
			{
				u.setTile(this.getTile());
			}
			this.combatArmy.remove(u);
			if(!this.supportArmy.contains(u))
			{
				this.supportArmy.add(u);
			}
		}
		
	}

	@Override
	public void removeUnit(Unit u)
	{
		if(u.getTile()==null)
		{
			u.setTile(this.getTile());
		}
		this.combatArmy.remove(u);
		this.supportArmy.remove(u);
	}


	public List<Unit> getAllUnits()
	{
		return this.getFullArmy();
	}


}
