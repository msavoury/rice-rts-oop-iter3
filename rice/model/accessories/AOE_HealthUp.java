package rice.model.accessories;

import rice.model.Controllable;

public class AOE_HealthUp extends AreaOfEffect
{
	private double value;
	
	public AOE_HealthUp()
	{
		this(5);
	}
	
	public AOE_HealthUp(double value)
	{
		super("AOE_HealthUp");
		this.value=(value>0 ? value : 5);
	}

	public void apply(Controllable c)
	{
		c.changeHealth(value);
	}

}
