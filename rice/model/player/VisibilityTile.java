package rice.model.player;

import java.util.HashMap;
import java.util.List;

import rice.model.map.AreaTile;
import rice.model.map.Tile;
import rice.util.Position;
import rice.view.MSVisitor;
import rice.view.ViewableRallyPoint;
import rice.view.ViewableResource;
import rice.view.ViewableTile;

public class VisibilityTile extends Tile implements ViewableTile
{
	private AreaTile areaTile;
	
	private String flow;
	private String decal;
	private String item;
	private String obstacle;
	private String terrainType;
	private String rallyPoint;
	private String structure;
	private HashMap<String,Integer> resourceValues = new HashMap<String,Integer>();
	private String harvestingResource;
	private int harvestingWorkers;
	private int breedingWorkers;
	private int idleWorkers;
	private int numUnitsNotInRPI;
	private int visibilityLevel;
	private int lastSeenTick;
	
	
	public VisibilityTile(Position position, AreaTile areaTile)
	{
		super(position);
		this.areaTile=areaTile;
	}

	//accept visitor
	public void accept(MSVisitor v)
	{
		v.visit(this);		
	}

	
	public int getBreedingWorkers()
	{
		return this.breedingWorkers;
	}

	
	public String getDecal()
	{
		return this.decal;
	}

	public String getFlow()
	{
		return this.flow;
	}


	public String getHarvestingResource()
	{
		return this.harvestingResource;
	}

	public int getIdleWorkers()
	{
		return this.idleWorkers;
	}

	public String getItem()
	{
		return this.item;
	}
	
	
	

	public Position getLocation()
	{
		return this.getLocation();
	}

	public int getNumUnitsNotInRP()
	{
		return this.numUnitsNotInRPI;
	}

	public String getObstacle()
	{
		return this.obstacle;
	}

	public List<ViewableRallyPoint> getRallyPoints()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public HashMap<String, Integer> getResourceValues()
	{
		return this.resourceValues;
	}

	public String getStructure()
	{
		return this.structure;
	}

	public String getTerrainType()
	{
		return this.terrainType;
	}

	@Override
	public int getVisibilityMode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateTile(int tick)
	{
		// TODO Auto-generated method stub
		
	}

	public void updateResources(int tick)
	{
		// TODO Auto-generated method stub
		
	}

	public int getHarvestingWorkers()
	{
		return this.harvestingWorkers;
	}

}
