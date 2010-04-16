package rice.model.map;

import java.awt.Dimension;
import java.util.List;

public abstract class Map {
	private Tile[][] tiles;
	private int width;
	private int height;
	private MapPositionTranslator mpt;
	
	public Map()
	{
		
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
	
	//Check if the input location is within map bounds
	public boolean verifyLocation(int x, int y)
	{
		if((x<0) || (x>=this.width) || (y<0) || (y>=this.height))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	//returns a tile at position x,y
	public Tile getTile(int x, int y)
	{
		return this.tiles[y][x];
	}
	
	//return adjacent position depending on current position and angle
	public Dimension getAdjecentPosition(int x, int y, double angle)
	{
		return this.mpt.getAdjecentPosition(x, y, angle);
	}
	
	//return a list of positions surrounding the origin with a certain radius
	public List<Dimension> getPositionRing(int originX, int originY, int radius)
	{
		return this.mpt.getPositionRing(originX, originY, radius);
	}
	
}
