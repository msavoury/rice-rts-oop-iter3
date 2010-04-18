package rice.model.structures;

import rice.model.map.AreaTile;
import rice.model.player.Player;
import rice.model.player.RiceSelector;

public class Farm extends HarvestingStructure implements FoodHarvester 
{
	public Farm(int id, Player owner)
	{
		super("Farm", id, owner);
	}

	@Override
	public void harvestFood(AreaTile tile, int workers) {
		// TODO Auto-generated method stub
		
	}
	
	public void accept(RiceSelector s)
	{
		s.addFarm(this);
	}
}
