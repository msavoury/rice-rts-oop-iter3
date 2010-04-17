package rice.model.structures;

import rice.model.map.AreaTile;

public interface EnergyHarvester
{
	public void harvestEnergy(AreaTile tile, int workers);
}
