package rice.model.structures;

import rice.model.Controllable;
import rice.model.map.ATVisitorAcceptor;
import rice.model.map.AreaTileVisitor;
import rice.model.player.Player;
import rice.model.player.RiceSelector;
import rice.model.unit.WorkerOwner;
import rice.util.Position;
import rice.view.MSVisitor;
import rice.view.SOVisitor;
import rice.view.ViewableStructure;

public abstract class Structure extends Controllable implements WorkerOwner, Allocatable, ViewableStructure
{
	private double completionLevel=0;

	public Structure(String typeName, int id, Player owner)
	{
		super(typeName, id, owner);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isCompleted()
	{
		return this.completionLevel==100;
	}
	
	public void increaseCompletion(double value)
	{
		if(!this.isCompleted())
		{
			//increase completion level and health
			double perc = value/100;
			this.changeHealth(perc*this.getMaxHealth());
			this.completionLevel+=value;
			if(this.completionLevel>100)
			{
				this.completionLevel=100;
			}
		}
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

	public double getHealthPercentage()
	{
		return this.getHealth()/this.getMaxHealth();
	}

	@Override
	public void accept(RiceSelector s) {
		// TODO Auto-generated method stub
		
	}
	
}
