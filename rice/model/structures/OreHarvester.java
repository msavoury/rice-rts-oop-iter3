package rice.model.structures;

import rice.model.map.AreaTile;

public interface OreHarvester
{
	public void harvestOre(AreaTile tile, int workers);
}
