package rice.model.accessories;

import rice.model.Controllable;

public class AOE_TakeDamage extends AreaOfEffect
{
	private double value;
	
	public AOE_TakeDamage()
	{
		this(5);		
	}
	
	public AOE_TakeDamage(int value)
	{
		super("AOE_TakeDamage");
		this.value=(value>0 ? value : 5);	
	}

	public void apply(Controllable c)
	{
		c.takeDamage(value);
	}

}
