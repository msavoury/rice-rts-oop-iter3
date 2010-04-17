package rice.model.map;

import rice.util.Position;

public abstract class Tile
{
	private Position position;
	
	Tile(Position position)
	{
		this.position=position;
	}
	
	public Position getPosition()
	{
		return this.position;
	}
}
