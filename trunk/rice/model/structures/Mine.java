package rice.model.structures;

import rice.model.map.AreaTile;
import rice.model.player.Player;

public class Mine extends HarvestingStructure implements OreHarvester 
{
	public Mine(int id, Player owner)
	{
		super("Mine", id, owner);
	}

	@Override
	public void harvestOre(AreaTile tile, int workers) {
		// TODO Auto-generated method stub
		
	}
}