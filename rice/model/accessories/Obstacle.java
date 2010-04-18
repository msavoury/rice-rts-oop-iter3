package rice.model.accessories;

import rice.model.map.AreaTile;
import rice.model.map.AreaTileVisitor;

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
    
	public void accept(AreaTileVisitor v)
	{
		v.visit(this);
	}

}
