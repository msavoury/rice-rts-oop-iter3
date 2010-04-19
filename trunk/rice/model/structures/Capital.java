package rice.model.structures;

import java.util.HashMap;
import java.util.List;

import rice.model.ability.BreedAbility;
import rice.model.map.AreaTile;
import rice.model.map.AreaTileVisitor;
import rice.model.player.Player;
import rice.model.player.RiceSelector;
import rice.model.unit.Unit;
import rice.model.unit.UnitOwner;

public class Capital extends HarvestingStructure implements UnitOwner, OreHarvester, FoodHarvester, EnergyHarvester 
{
	private int breedingWorkers;
        private int breedTicker;
        private int breedTick;
	
	public Capital(int id, Player owner)
	{
	   super("Capital", id, owner);	
	  //default stats initializations
	  this.setMaxHealth(200.00);
	  this.setHealth(10.00);
	  this.setArmor(10);
	  this.setOffensiveDamage(0);
	  this.setDefensiveDamage(5);
	  this.setVisibilityRadius(1);
	  HashMap<String,Integer> newUpkeep = new HashMap<String,Integer>();
	  newUpkeep.put("Ore", 5);
	  newUpkeep.put("Food", 0);
	  newUpkeep.put("Energy", 5);
	  this.setUpkeep(newUpkeep);
          breedTicker = 0;
          breedTick = 5;
          super.addWorkers(2);
	}

        @Override
        public void initAbilities(){
            super.initAbilities();
            super.addAbility(new BreedAbility(this));
        }

        @Override
        public void tick(){
            super.tick();
            breedTicker++;

            if(breedTicker == breedTick){
                breedTicker = 0;
                addWorkers(breedingWorkers/2);
            }
            //System.out.println("idle: " + super.getIdleWorkerCount());
            //System.out.println("breed: " + breedingWorkers);

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

        public int addBreedingWorkers(int num){
            if(num-super.getIdleWorkerCount()>=0){
                super.removeIdleWorkers(num);
                breedingWorkers += num;
                return breedingWorkers;
            }
            return 0;
        }

	@Override
	public int addWorkers(int workers) {
		// TODO Auto-generated method stub
                super.addWorkers(workers);
		return workers;
	}

	@Override
	public int getIdleWorkerCount() {
		// TODO Auto-generated method stub
                return super.getIdleWorkerCount();
	}

	@Override
	public int getTotalWorkerCount() {
		// TODO Auto-generated method stub
		return super.getTotalWorkerCount();
	}

	@Override
	public int removeIdleWorkers(int num) {
		// TODO Auto-generated method stub
		return super.removeIdleWorkers(num);
	}

	@Override
	public int removeWorkers() {
		// TODO Auto-generated method stub
		return super.removeWorkers();
	}


        @Override
        public double getHealthPercentage(){
            return super.getHealthPercentage();
        }

	//returns the number of breeding workers
	public int getBreedingWorkers()
	{
		return this.breedingWorkers;
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
