package rice.model.structures;

import java.util.List;

import rice.model.map.AreaTile;
import rice.model.unit.Unit;
import rice.model.unit.UnitOwner;

public class Capital extends HarvestingStructure implements UnitOwner, OreHarvester, FoodHarvester, EnergyHarvester 
{
	public Capital(int id, Player owner)
	{
		
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
	public void harvestOre(AreaTile tile, int workers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void harvestFood(AreaTile tile, int workers) {
		// TODO Auto-generated method stub
		
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

}
