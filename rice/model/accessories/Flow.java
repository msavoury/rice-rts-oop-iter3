package rice.model.accessories;

import rice.model.map.AreaTileVisitor;

public class Flow extends Modifier
{
	private double direction;
	private double flowRate;
	
	public Flow(double angle, double flowRate) {
		super("Flow");
		this.direction=angle;
		this.flowRate=flowRate;
	}
	
	//returns the flow direction
	public double getDirection()
	{
		return this.direction;
	}
	
	//returns the flowRate
	public double getFlowRate()
	{
		return this.flowRate;
	}
	
	public void accept(AreaTileVisitor v)
	{
		v.visit(this);
	}
	
}
