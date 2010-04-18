package rice.model.structures;

import rice.model.Controllable;
import rice.model.map.ATVisitorAcceptor;
import rice.model.map.AreaTileVisitor;
import rice.model.player.Player;
import rice.model.unit.WorkerOwner;
import rice.util.Position;
import rice.view.MSVisitor;
import rice.view.SOVisitor;
import rice.view.ViewableStructure;

public abstract class Structure extends Controllable implements WorkerOwner, Allocatable, ViewableStructure
{

	public Structure(String typeName, int id, Player owner) {
		super(typeName, id, owner);
		// TODO Auto-generated constructor stub
	}
	
	public double getAllocation(){
		//TODO: Fix default value:
		return 0.0;
	}
	public void setAlocation(double percentage){
		//TODO: Implement
	}
	
	public int getIdleWorkerCount(){
		//TODO: Implement
		return 0;
	}
	
	public int getTotalWorkerCount(){
		//TODO: Implement
		return 0;
	}
	
	public int addWorkers(int workers ){
		//TODO: Implement
		return 0;
	}
	
	/**
	  * Returns the amount that you actually removed
	  */
	public int removeWorkers(){
		//TODO: Implement
		return 0;
	}
	public int removeIdleWorkers(int num ){
		//TODO: Implement
		return 0;	
	}

	public void accept(AreaTileVisitor v)
	{
		v.visit(this);
	}

	public void accept(SOVisitor s)
	{
		s.visit(this);		
	}

	public void accept(MSVisitor m)
	{
		m.visit(this);		
	}

	public int getID()
	{
		return this.getId();
	}

	public Position getLocation()
	{
		return this.getLocation();
	}
	
}
