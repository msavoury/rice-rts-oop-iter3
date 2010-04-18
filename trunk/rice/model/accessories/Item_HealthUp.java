package rice.model.accessories;

import rice.model.Controllable;

public class Item_HealthUp extends Item
{
	private double value;
	
	public Item_HealthUp()
	{
		this(5);
	}
	
	public Item_HealthUp(double value)
	{
		super("Item_HealthUp");
		this.value=(value>0 ? value : 5);
	}

	public void apply(Controllable c)
	{
		c.changeHealth(value);
		this.getTile().removeAccessory(this);
	}

}
