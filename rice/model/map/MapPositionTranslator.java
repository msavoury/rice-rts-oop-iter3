package rice.model.map;

import java.awt.Dimension;
import java.util.List;


public abstract class MapPositionTranslator
{

	public MapPositionTranslator()
	{
		
	}
	
	public abstract Dimension getAdjecentPosition(int x, int y, double angle);
	public abstract List<Dimension> getPositionRing(int originX, int originY, int radius);
}
