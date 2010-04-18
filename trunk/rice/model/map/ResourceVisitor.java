package rice.model.map;

import rice.model.accessories.Accessory;
import rice.model.accessories.Resources;

public class ResourceVisitor
{
	private Resources resources;
	
	public ResourceVisitor()
	{
		
	}
	
	public Resources getResources()
	{
		return this.resources;
	}
	
	public void visit(Accessory a)
	{
		
	}
	
	public void visit(Resources r)
	{
		this.resources=r;
	}
	
}
