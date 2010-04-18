package rice.model.structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import rice.model.Controllable;
import rice.model.accessories.AreaBonus;
import rice.model.accessories.BonusGiver;
import rice.model.map.AreaMap;
import rice.model.player.Player;
import rice.model.player.RiceSelector;
import rice.model.unit.Unit;
import rice.model.unit.UnitOwner;
import rice.util.Position;

public class Fort extends Structure implements UnitOwner, BonusGiver
{
	private ArrayList<AreaBonus> bonuses = new ArrayList<AreaBonus>();
	private int bonusRadius = 0;
	
	public Fort(int id, Player owner)
	{
		super("Fort", id, owner);
		  //default stats initializations
		  this.setMaxHealth(250.00);
		  this.setHealth(10.00);
		  this.setArmor(15);
		  this.setOffensiveDamage(50);
		  this.setDefensiveDamage(10);
		  this.setVisibilityRadius(2);
		  HashMap<String,Integer> newUpkeep = new HashMap<String,Integer>();
		  newUpkeep.put("Ore", 15);
		  newUpkeep.put("Food", 0);
		  newUpkeep.put("Energy", 15);
		  this.setUpkeep(newUpkeep);
	}
	
	private void addBonuses(int radius)
	{
		for(int i=this.bonusRadius;i<radius;i++)
		{
			List<Position> positions = AreaMap.getInstance().getPositionRing(this.getLocation(), i);
			Iterator<Position> iter = positions.iterator();
			while(iter.hasNext())
			{
				Position position = iter.next();
				AreaBonus newBonus = new AreaBonus("Armor", this, i);
				this.bonuses.add(newBonus);
				AreaMap.getInstance().putAccessory(newBonus, position);
			}			
		}
		this.bonusRadius=radius;
	}
	
	public int getVisibilityRadius()
	{
		int radius=super.getVisibilityRadius();
		if(radius>this.bonusRadius)
		{
			this.addBonuses(radius);
		}		
		return radius;
	}
	

	@Override
	public void addUnit(Unit u) {
		// TODO Auto-generated method stub
				
	}

	@Override
	public List<Unit> getAllUnits() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeUnit(Unit u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int addWorkers(int workers) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int getIdleWorkerCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalWorkerCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeIdleWorkers(int num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeWorkers() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getAllocation() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setAlocation(double percentage) {
		// TODO Auto-generated method stub
		
	}
	
	public void accept(RiceSelector s)
	{
		s.addFort(this);
	}

	public int getBonus(String bonus, int radius, Controllable c)
	{
		if(this.getPowerStatus() && this.getOwner().equals(c.getOwner()) && (radius<=this.getVisibilityRadius()))
		{
			return (this.getVisibilityRadius()/(this.getVisibilityRadius()+radius))*5;
		}
		else
		{
			return 0;
		}
	}
	
	public void destroy()
	{
		Iterator<AreaBonus> iter = this.bonuses.iterator();
		while(iter.hasNext())
		{
			iter.next().removeFromTile();
		}
		super.destroy();
	}
}
