package rice.model.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import rice.controller.Tickable;
import rice.model.accessories.Resources;
import rice.model.map.AreaTile;
import rice.model.map.AreaTileVisitor;
import rice.model.map.ResourceVisitor;
import rice.model.map.Tile;
import rice.util.Position;
import rice.view.MSVisitor;
import rice.view.ViewableRallyPoint;
import rice.view.ViewableTile;

public class VisibilityTile extends Tile implements ViewableTile, Tickable
{
	public static final int NONVISIBLE=0;
	public static final int SHROUDED=1;
	public static final int VISIBLE=2;
	
	private AreaTile areaTile;
	private Player owner;
	
	private double flow;
	private String decal;
	private String item;
	private String obstacle;
	private String terrainType;
	private String structure;
	private int breedingWorkers;
	private int idleWorkers;
	private int numUnitsNotInRPI;
	private List<ViewableRallyPoint> ownedRallyPoints = new ArrayList<ViewableRallyPoint>();
	private List<ViewableRallyPoint> enemyRallyPoints = new ArrayList<ViewableRallyPoint>();
	
	private HashMap<String,Integer> resourceValues = new HashMap<String,Integer>();
	private String harvestingResource;
	private int harvestingWorkers;
	
	private boolean discovered=false;
	private int lastSeenTick;
	private int currentTick;
	
	
	public VisibilityTile(Position position, AreaTile areaTile, Player owner)
	{
		super(position);
		this.areaTile=areaTile;
	}
	
	public void tick(int tick)
	{
		this.currentTick=tick;
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

	public double getFlow()
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
		return this.getPosition();
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
		ArrayList<ViewableRallyPoint> rallyPoints = new ArrayList<ViewableRallyPoint>();
		rallyPoints.addAll(this.ownedRallyPoints);
		if(this.getVisibilityMode()==VISIBLE)
		{
			rallyPoints.addAll(this.enemyRallyPoints);			
		}	
		return rallyPoints;
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

	//returns the visibility mode
	public int getVisibilityMode()
	{
            System.out.println(this.currentTick);
            System.out.println(this.lastSeenTick);
		if(this.discovered)
		{
			if(this.currentTick==this.lastSeenTick)
			{
				return VISIBLE;
			}
			else
			{
				return SHROUDED;
			}
		}
		else
		{
			return NONVISIBLE;
		}
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateTile(int tick)
	{
		this.discovered=true;
		this.lastSeenTick=tick;
		AreaTileVisitor aTV = new AreaTileVisitor(this.owner);
		this.areaTile.accept(aTV);
		
		this.decal=aTV.getDecal();
		this.obstacle=aTV.getObstacle();
		this.structure=aTV.getStructure();
		this.item=aTV.getItem();
		this.flow=aTV.getFlow();
		this.terrainType=aTV.getTerrain();
		this.numUnitsNotInRPI=aTV.getNumUnitsNotInRPI();
		this.idleWorkers=aTV.getIdleWorkers();
		this.breedingWorkers=aTV.getBreedingWorkers();
		this.enemyRallyPoints=aTV.getEnemyRallyPoints();
		this.ownedRallyPoints=aTV.getOwnedRallyPoints();
	}

	public void updateResources(int tick)
	{
		this.discovered=true;
		this.lastSeenTick=tick;
		ResourceVisitor rV=new ResourceVisitor();
                this.areaTile.accept(rV);
		Resources resources=rV.getResources();
		if(resources!=null)
		{

			this.resourceValues=resources.getResources();
			this.harvestingResource=resources.getHarvestedType();
			this.harvestingWorkers=resources.getWorkerCount();
		}
                
		
	}

	public int getHarvestingWorkers()
	{
		return this.harvestingWorkers;
	}

}
