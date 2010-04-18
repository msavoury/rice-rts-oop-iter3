package rice.model.accessories;

import java.util.HashMap;

import rice.model.map.AreaTileVisitor;
import rice.model.map.ResourceVisitor;
import rice.model.map.ResourceVisitorAcceptor;
import rice.model.structures.HarvestingStructure;

public class Resources extends TileEnrichement
{
	private HashMap<String, Integer> resources = new HashMap<String, Integer>();
	private String harvestedType;
	private HarvestingStructure harvester;
	private int workerCount=0;
	
	public Resources()
	{
		super("Resources");
	}
	
	//adds a new resource, if it already exists replaces the old one
	public void addResource(String typeName, int value)
	{
		this.resources.put(typeName, new Integer(value));
	}
	
	//returns the resource HashMap
	public HashMap<String, Integer> getResources()
	{
		return this.resources;
	}
	
	//returns the harvested resource type
	public String getHarvestedType()
	{
		return this.harvestedType;
	}
	
	//sets the harvested resource type
	public void setHarvestedType(String type)
	{
		this.harvestedType=type;
	}
	
	//harvest an amount of resources, return the harvested value
	public int harvest(int amount)
	{
		if(this.resources.containsKey(this.harvestedType))
		{
			Integer amountLeft = this.resources.get(this.harvestedType);
			if(amountLeft<amount)
			{
				amount=amountLeft;			
			}
			amountLeft-=amount;
			return amount;
		}
		return 0;
	}
	
	//assign a harvestingStructure if not assigned, otherwise return false
	public boolean assignHarvester(HarvestingStructure harvester)
	{
		if(this.harvester==null)
		{
			this.harvester=harvester;
			return true;
		}		
		return false;
	}
	
	//return the harvestingStructure
	public HarvestingStructure getHarvester()
	{
		return this.harvester;
	}
	
	//unassigns the harvestingStructure
	public void removeHarvester()
	{
		this.harvester=null;
	}
	
	//return number of workers assigned to this resource
	public int getWorkerCount()
	{
		return this.workerCount;
	}
	
	//add workers
	public void addWorkers(int workers)
	{
		if(workers>0)
		{
			this.workerCount+=workers;
		}
	}
	
	//remove workers
	public int removeWorkers()
	{
		int workers=this.workerCount;
		this.workerCount=0;
		return workers;
	}
	
	public void accept(AreaTileVisitor v)
	{
		v.visit(this);
	}
	
	public void accept(ResourceVisitor v)
	{
		v.visit(this);
	}
	
}
