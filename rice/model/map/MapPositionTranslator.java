package rice.model.map;

import java.util.List;
import util.Position;


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
	
	//return adjacent position depending on current position and angle
	public abstract Position getAdjecentPosition(Position position, double angle);
	
	//return a list of positions surrounding the origin with a certain radius
	public abstract List<Position> getPositionRing(Position origin, int radius);
}
