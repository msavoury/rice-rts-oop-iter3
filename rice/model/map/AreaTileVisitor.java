package rice.model.map;

import java.util.ArrayList;
import java.util.List;

import rice.model.Locatable;
import rice.model.accessories.Decal;
import rice.model.accessories.Flow;
import rice.model.accessories.Item;
import rice.model.accessories.Obstacle;
import rice.model.controllable.RallyPoint;
import rice.model.player.Player;
import rice.model.structures.Capital;
import rice.model.structures.Structure;
import rice.model.unit.Unit;
import rice.view.ViewableRallyPoint;

public class AreaTileVisitor
{
	private Player owner;
	
	private double flow;
	private String decal;
	private String item;
	private String obstacle;
	private String terrainType;
	private String structure;
	private List<ViewableRallyPoint> ownedRallyPoints = new ArrayList<ViewableRallyPoint>();
	private List<ViewableRallyPoint> enemyRallyPoints = new ArrayList<ViewableRallyPoint>();
	private int breedingWorkers;
	private int idleWorkers;
	private int numUnitsNotInRPI;
	
	public AreaTileVisitor(Player owner)
	{
		this.owner=owner;
	}
	
	public double getFlow()
	{
		return this.flow;
	}
	
	public String getDecal()
	{
		return this.decal;
	}
	
	public String getItem()
	{
		return this.item;
	}
	
	public String getObstacle()
	{
		return this.obstacle;
	}
	
	public String getTerrain()
	{
		return this.terrainType;
	}
	
	public String getStructure()
	{
		return this.structure;
	}
	
	public List<ViewableRallyPoint> getOwnedRallyPoints()
	{
		return this.ownedRallyPoints;
	}
	
	public List<ViewableRallyPoint> getEnemyRallyPoints()
	{
		return this.enemyRallyPoints;
	}
	
	public int getBreedingWorkers()
	{
		return this.breedingWorkers;
	}
	
	public int getIdleWorkers()
	{
		return this.idleWorkers;
	}
	
	public int getNumUnitsNotInRPI()
	{
		return this.numUnitsNotInRPI;
	}
	
	public void visit(Locatable l)
	{
		
	}
	
	public void visit(AreaTile tile)
	{
		this.terrainType="Terrain_"+tile.getTerrainType();
	}
	
	public void visit(Unit unit)
	{
		numUnitsNotInRPI++;
	}
	
	public void visit(Structure structure)
	{
		this.structure=structure.getType();
		this.idleWorkers=structure.getIdleWorkerCount();
                //System.out.println("broken");
	}
	
	public void visit(Capital capital)
	{
                this.breedingWorkers=capital.getBreedingWorkers();
		this.visit((Structure)capital);
	}
	
	public void visit(Flow flow)
	{
		this.flow=flow.getDirection();
	}
	
	public void visit(Decal decal)
	{
		this.decal=decal.getTypeName();
	}
	
	public void visit(Item item)
	{
		this.item = item.getTypeName();
	}
	
	public void visit(Obstacle obstacle)
	{
		this.obstacle=obstacle.getTypeName();
	}

	public void visit(RallyPoint rally)
	{
		if(this.owner.equals(rally.getOwner()))
		{
			if(!this.ownedRallyPoints.contains(rally))
			{
				this.ownedRallyPoints.add(rally);
			}
		}
		else
		{
			if(!this.enemyRallyPoints.contains(rally))
			{
				this.enemyRallyPoints.add(rally);
			}
		}
	}
	
}
