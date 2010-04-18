package rice.model.structures;

import rice.model.map.AreaTile;
import rice.model.player.Player;
import rice.model.player.RiceSelector;

public class PowerPlant extends HarvestingStructure implements EnergyHarvester 
{
	public PowerPlant(int id, Player owner)
	{
		super("Power Plant", id, owner);
	}

	@Override
	public void harvestEnergy(AreaTile tile, int workers) {
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
		s.addPowerPlant(this);
	}
}
