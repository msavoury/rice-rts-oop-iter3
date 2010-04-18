package rice.model.structures;

import java.util.List;

import rice.model.map.ATVisitorAcceptor;
import rice.model.map.AreaTile;
import rice.model.map.AreaTileVisitor;
import rice.model.player.Player;
import rice.model.player.RiceSelector;
import rice.model.unit.Unit;
import rice.model.unit.UnitOwner;

public class Capital extends HarvestingStructure implements UnitOwner, OreHarvester, FoodHarvester, EnergyHarvester 
{
	private int breadingWorkers;
	
	public Capital(int id, Player owner)
	{
	   super("Capital", id, owner);	
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

	//returns the number of breeding workers
	public int getBreedingWorkers()
	{
		return this.breadingWorkers;
	}

	public void accept(AreaTileVisitor v)
	{
		v.visit(this);
	}
	
	public void accept(RiceSelector s)
	{
		s.addCapital(this);
	}

}
