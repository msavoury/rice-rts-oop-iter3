package rice.model.structures;

import rice.model.map.AreaTile;
import rice.model.player.Player;
import rice.model.player.RiceSelector;

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
	
	public void accept(RiceSelector s)
	{
		s.addMine(this);
	}
}