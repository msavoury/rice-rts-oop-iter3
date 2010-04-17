package rice.model.map;

import java.util.List;

import rice.util.Position;


public abstract class MapPositionTranslator
{
	private Map map;
	
	public MapPositionTranslator(Map map)
	{
		this.map=map;
	}
	
	//Check if the input location is within map bounds
	public boolean verifyLocation(Position position)
	{
		return this.map.verifyLocation(position);
	}
	
	//get number of directions
	public abstract int getDirectionCount();
	
	//get direction from angle
	public abstract int getDirection(double angle);
	
	//gets the optimal direction between two positions
	public abstract int getOptimalDirection(Position origin, Position destination);
	
	//return adjacent position depending on current position and angle
	public abstract Position getAdjecentPosition(Position position, int direction);
	
	//return a list of positions surrounding the origin with a certain radius
	public abstract List<Position> getPositionRing(Position origin, int radius);
}
