package rice.model.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import rice.model.Controllable;
import rice.model.accessories.Accessory;
import rice.model.player.Player;
import rice.util.Position;


public class AreaMap extends Map
{
	private static AreaMap instance;
	private List<Position> startingPositions;
	private static int [][] terrain;
	private static MapPositionTranslator mpt;
	private static List<Position> staticPositions;
	
	public AreaMap(int[][] terrain, MapPositionTranslator mpt, List<Position> startingPositions)
	{
		super(mpt);
		instance=this;
		this.startingPositions=startingPositions;
		
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
	
	public static void setTranslator(MapPositionTranslator m){
		mpt = m;
	}
	
	public static void setTerrain(int [][] t){
		terrain = t;
	}
	
	public static void setPositions(List<Position> list){
		staticPositions = list;
	}
	
	//returns the instance of the AreaMap
	public static AreaMap getInstance()
	{
		if(instance == null){
			instance = new AreaMap(terrain, mpt, staticPositions);
		}
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
	
	private boolean isPassable(Position position, Player player, int passabilityLevel)
	{
		AreaTile tile = (AreaTile)this.getTile(position);
		if(tile.getPassabilityLevel()>=passabilityLevel)
		{
			return false;
		}
		
		Iterator<Controllable> iter = tile.getControllables().iterator();
		while(iter.hasNext())
		{
			if(!player.equals(iter.next().getOwner()))
			{
				return false;
			}
			else
			{
				//this is for case when only one player can occupy a tile
				return true;
			}
		}		
		return true;
	}
	
	public List<int[]> getPath(Position start, Position destination, Player player, int passabilityLevel)
	{
		//create a new path list
		ArrayList<int[]> path = new ArrayList<int[]>();
		//check if start!=destination and destination is passable
		if(!start.equals(destination) && this.isPassable(destination, player, passabilityLevel))
		{
			//create a map of all visited positions
			HashMap<String,Integer> pathMap = new HashMap<String,Integer>();
			
			//create a stack of positions to visit
			Stack<Position> positions = new Stack<Position>();
			
			//add destination position
			positions.push(destination);
			pathMap.put(destination.toString(), 0);
			boolean pathFound=false;
			
			while(!positions.isEmpty() && !pathFound)
			{
				//pop next position to check
				Position currentPosition = positions.pop();
								
				int value = pathMap.get(currentPosition.toString());
				value++;
				
				//add all surrounding tiles to list of positions to visit
				for(int i=1; i<=this.getMapPositionTranslator().getDirectionCount();i++)
				{
					//get optimal direction (straight line from current location to start location)
					int optimalDirection=this.getMapPositionTranslator().getOptimalDirection(currentPosition, start);
					
					//get new direction based on optimal direction, appear in order from the opposite to optimal with decreasing difference to optimal direction
					int newDirection=((optimalDirection + (this.getMapPositionTranslator().getDirectionCount()/2) + (i/2)*(int)Math.pow(-1, (double)(i+1))) % this.getMapPositionTranslator().getDirectionCount());
					
					//get adjacent position to current position in direction of newDirection
					Position newPosition=this.getMapPositionTranslator().getAdjecentPosition(currentPosition, newDirection);
					
					//verify newPosition and if it wasn't previously visited
					if(!pathMap.containsKey(newPosition.toString()) && this.verifyLocation(newPosition) && this.isPassable(newPosition, player, passabilityLevel))
					{
						//add newPosition
						pathMap.put(newPosition.toString(), value);
						positions.push(newPosition);
						
						//check if new position is the start position
						if(newPosition.equals(start))
						{
							pathFound=true;
							break;
						}
					}
				
				}
				
				
			}
			
			if(pathFound)
			{
				//traverse back the path from start position to destination
				Position currentPosition = new Position(start);
				while(!currentPosition.equals(destination))
				{
					int value = pathMap.get(currentPosition.toString());
					if(value>0)
					{
						value--;
						for(int i=0;i<this.getMapPositionTranslator().getDirectionCount();i++)
						{
							Position newPosition = this.getMapPositionTranslator().getAdjecentPosition(currentPosition, i);
							//check if the new position is in pathMap and if it has lower value
							if(pathMap.containsKey(newPosition.toString()) && (pathMap.get(newPosition.toString())==value))
							{
								currentPosition=newPosition;
								path.add(new int[]{currentPosition.getX(),currentPosition.getY(),i});
								break;
							}
						}
					}
				}				
			}	
		}
		return path;
	}	
}
