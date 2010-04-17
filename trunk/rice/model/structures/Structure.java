package rice.model.structures;

import rice.model.Controllable;
import rice.model.player.Player;
import rice.model.unit.WorkerOwner;

public abstract class Structure extends Controllable implements WorkerOwner, Allocatable
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

	
}
