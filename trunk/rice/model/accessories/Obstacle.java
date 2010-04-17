package rice.model.accessories;

import rice.model.map.AreaTile;

public class Obstacle extends TileEnrichement
{

	public Obstacle() {
		super("Obstacle");
	}
	
    public void setTile(AreaTile areaTile)
    {
    	super.setTile(areaTile);
    	areaTile.changePassabilityLevel(1000);
    }

}
