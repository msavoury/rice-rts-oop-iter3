package rice.model.player;

import java.util.Iterator;
import java.util.List;

import rice.model.map.AreaMap;
import rice.model.map.AreaTile;
import rice.model.map.Map;
import rice.model.map.MapPositionTranslator;
import rice.util.Position;
import rice.view.MSVisitor;
import rice.view.MSVisitorAcceptor;

public class VisibilityMap extends Map implements MSVisitorAcceptor
{	
	private int currentTick;
	
	public VisibilityMap(AreaMap areaMap)
	{

		super(areaMap.getMapPositionTranslator());
		VisibilityTile[][] tiles = new VisibilityTile[areaMap.getHeight()][areaMap.getWidth()];
		int w=areaMap.getWidth();
		int h=areaMap.getHeight();
		for(int i=0;i<h;i++)
		{
			for (int j=0;j<w;j++)
			{
				tiles[i][j]= new VisibilityTile(new Position(j,i), areaMap.getTile(new Position(j,i)));
			}
		}
		this.setTiles(tiles);
		this.setWidth(w);
		this.setHeight(h);
		
	}
	
	public VisibilityTile getTile(Position position)
	{
		return (VisibilityTile)super.getTile(position);
	}
	
	public void tick(int tick)
	{
		this.currentTick=tick;
	}
	
	public void UpdateTiles(Position origin, int radius)
	{
		List<Position> area = this.getMapPositionTranslator().getPositionArea(origin,radius);
		Iterator<Position> iter = area.iterator();
		while(iter.hasNext())
		{
			this.getTile(iter.next()).updateTile(this.currentTick);
		}
	}
	
	public void UpdateResources(Position origin, int radius)
	{
		List<Position> area = this.getMapPositionTranslator().getPositionArea(origin,radius);
		Iterator<Position> iter = area.iterator();
		while(iter.hasNext())
		{
			this.getTile(iter.next()).updateResources(this.currentTick);
		}
	}

	public void accept(MSVisitor v)
	{
		for(int i=0;i<this.getHeight();i++)
		{
			for (int j=0;j<this.getWidth();j++)
			{
				VisibilityTile tile = this.getTile(new Position(j,i));
				tile.accept(v);
			}
		}
	}
}
