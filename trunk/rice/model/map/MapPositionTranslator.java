package rice.model.map;

import java.util.List;

import rice.util.Position;


public abstract class MapPositionTranslator
{
	private Map map;
	
	/**
	 * Return the given double corresponding to the direction string
	 * @param c
	 */
	public static double convertDirection(String direction) {
		double result = 0.0;
		
		if (direction.equals("NORTHEAST"))
		  result = 30.0;
		else if (direction.equals("NORTH"))
		  result = 90.0;
		else if (direction.equals("NORTHWEST"))
		  result = 150.0;
		else if (direction.equals("SOUTHWEST"))
		  result = 210.0;
		else if (direction.equals("SOUTH"))
		  result = 270.0;
		else if (direction.equals("SOUTHEAST"))
		  result = 330.0;
		
		return result;
	}
	
	public abstract int convertToDirection(String s);	
	
	public MapPositionTranslator()
	{
		
	}
	
	//link the map to the translator
	public void linkMap(Map map)
	{
		this.map=map;
	}
	
	//Check if the input location is within map bounds
	public boolean verifyLocation(Position position)
	{
		if(this.map!=null)
		{
			return this.map.verifyLocation(position);
		}
		return false;
	}
	
	//get number of directions
	public abstract int getDirectionCount();
	
	//get direction from angle
	public abstract int getDirection(double angle);
	
	//gets the optimal direction between two positions
	public abstract int getOptimalDirection(Position origin, Position destination);
	
	//return adjacent position depending on current position and angle
	public abstract Position getAdjecentPosition(Position position, int direction);
	
	//return a list of valid positions in an area surrounding the origin with a certain radius
	public abstract List<Position> getPositionArea(Position origin, int radius);
	
	//return a list of positions surrounding the origin with a certain radius
	public abstract List<Position> getPositionRing(Position origin, int radius);
}
