package rice.model.structures;

import java.util.HashMap;
import java.util.List;

import rice.model.player.Player;
import rice.model.player.RiceSelector;
import rice.model.unit.Unit;
import rice.model.unit.UnitOwner;

public class Fort extends Structure implements UnitOwner
{
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
}