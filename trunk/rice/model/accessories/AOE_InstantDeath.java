package rice.model.accessories;

import rice.model.Controllable;

public class AOE_InstantDeath extends AreaOfEffect
{
	
	public AOE_InstantDeath()
	{
		super("AOE_TakeDamage");		
	}

	public void apply(Controllable c)
	{
		c.destroy();
	}

}
