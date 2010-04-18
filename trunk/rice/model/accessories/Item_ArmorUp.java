package rice.model.accessories;

import rice.model.Controllable;

public class Item_ArmorUp extends Item
{
	private int value;
	
	public Item_ArmorUp()
	{
		this(5);
	}
	
	public Item_ArmorUp(int value)
	{
		super("Item_ArmorUp");
		this.value=(value>0 ? value : 5);
	}

	public void apply(Controllable c)
	{
		c.changeArmor(value);
		this.getTile().removeAccessory(this);
	}

}