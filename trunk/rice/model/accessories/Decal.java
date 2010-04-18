package rice.model.accessories;

import rice.model.map.AreaTileVisitor;

public class Decal extends TileEnrichement
{
	public Decal(String typeName)
	{
		super("Decal_"+typeName);
	}
	
	public void accept(AreaTileVisitor v)
	{
		v.visit(this);
	}
}
