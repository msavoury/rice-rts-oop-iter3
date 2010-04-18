package rice.model.structures;

import java.util.HashMap;

import rice.model.map.AreaTile;
import rice.model.player.Player;
import rice.model.player.RiceSelector;

public class Mine extends HarvestingStructure implements OreHarvester 
{
	public Mine(int id, Player owner)
	{
		super("Mine", id, owner);
		  //default stats initializations
		  this.setMaxHealth(50.00);
		  this.setHealth(5.00);
		  this.setArmor(5);
		  this.setOffensiveDamage(0);
		  this.setDefensiveDamage(1);
		  this.setVisibilityRadius(1);
		  HashMap<String,Integer> newUpkeep = new HashMap<String,Integer>();
		  newUpkeep.put("Ore", 1);
		  newUpkeep.put("Food", 0);
		  newUpkeep.put("Energy", 5);
		  this.setUpkeep(newUpkeep);
	}

	@Override
	public void harvestOre(AreaTile tile, int workers) {
		// TODO Auto-generated method stub
		
	}
	
	public void accept(RiceSelector s)
	{
		s.addMine(this);
	}
}