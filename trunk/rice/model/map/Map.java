package rice.model.map;

import java.util.List;

import rice.util.Position;

public abstract class Map {
	private Tile[][] tiles;
	private int width;
	private int height;
	private MapPositionTranslator mpt;
	
	public Map(MapPositionTranslator mpt)
	{
		this.mpt=mpt;
	}
	
	//Set the tiles
	void setTiles(Tile[][] tiles)
	{
		this.tiles=tiles;
	}
	
	//Return the width of the map
	public int getWidth()
	{
		return this.width;
	}
	//Return the width of the map
	public int getHeight()
	{
		return this.height;
	}
	//set the width of the map
	void setWidth(int width)
	{
		this.width=width;
	}
	//set the width of the map
	void setHeight(int height)
	{
		this.height=height;
	}
	
	//Check if the input location is within map bounds
	public boolean verifyLocation(Position position)
	{
		if((position.getX()<0) || (position.getX()>=this.width) || (position.getY()<0) || (position.getY()>=this.height))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	//returns a tile at position
	public Tile getTile(Position position)
	{
		return this.tiles[position.getY()][position.getX()];
	}
	
	//return adjacent position depending on current position and angle
	public Position getAdjecentPosition(Position position, double angle)
	{
		return this.mpt.getAdjecentPosition(position, this.mpt.getDirection(angle));
	}
	
	//return a list of positions surrounding the origin with a certain radius
	public List<Position> getPositionRing(Position origin, int radius)
	{
		return this.mpt.getPositionRing(origin, radius);
	}
	
}
