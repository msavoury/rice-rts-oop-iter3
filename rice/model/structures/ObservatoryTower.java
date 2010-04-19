package rice.model.structures;

import java.util.HashMap;

import rice.model.player.Player;
import rice.model.player.RiceSelector;

public class ObservatoryTower extends Structure {

	public ObservatoryTower(int id, Player owner)
	{
		super("Observatory", id, owner);
		  //default stats initializations
		  this.setMaxHealth(50.00);
		  this.setHealth(5.00);
		  this.setArmor(5);
		  this.setOffensiveDamage(0);
		  this.setDefensiveDamage(1);
		  this.setVisibilityRadius(3);
		  HashMap<String,Integer> newUpkeep = new HashMap<String,Integer>();
		  newUpkeep.put("Ore", 1);
		  newUpkeep.put("Food", 0);
		  newUpkeep.put("Energy", 5);
		  this.setUpkeep(newUpkeep);
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
		s.addObservatoryTower(this);
	}

}
