package rice.model.map;

import java.awt.Dimension;
import java.util.List;


public abstract class MapPositionTranslator
{

	public MapPositionTranslator()
	{
		
	}
	
	//return adjacent position depending on current position and angle
	public abstract Dimension getAdjecentPosition(int x, int y, double angle);
	//return a list of positions surrounding the origin with a certain radius
	public abstract List<Dimension> getPositionRing(int originX, int originY, int radius);
}
