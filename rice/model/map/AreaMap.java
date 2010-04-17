package rice.model.map;

import java.util.List;
import rice.model.Accessory;
import util.Position;
import rice.model.Controllable;


public class AreaMap extends Map
{
	private static AreaMap instance;
	
	public AreaMap(int[][] terrain)
	{
		super();
		instance=this;
		
		int w=terrain[0].length;
		int h=terrain.length;
		//Initialize AreaTiles
		AreaTile[][] tiles = new AreaTile[h][w];
		for(int i=0;i<h;i++)
		{
			for (int j=0;j<w;j++)
			{
				tiles[i][j]= new AreaTile(new Position(j,i),terrain[i][j]);
			}
		}
		this.setTiles(tiles);
		this.setWidth(w);
		this.setHeight(h);
	}
	
	//returns the instance of the AreaMap
	public static AreaMap getInstance()
	{
		return instance;
	}

	//places a controllable on a tile
	public void putControllable(Controllable c, Position destination)
	{
		((AreaTile)this.getTile(destination)).putControllable(c);
	}
	
	//places a controllable on a tile
	public void putAccessory(Accessory a, Position destination)
	{
		((AreaTile)this.getTile(destination)).putAccessory(a);
	}
	
	public List<int[]> getPath(Position start, Position destination, int playerId, int passabilityLevel)
	{
		//TODO write pathfinding algorithm
		return null;
	}
	
}
