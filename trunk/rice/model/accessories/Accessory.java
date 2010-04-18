/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.model.accessories;

import rice.model.Locatable;
import rice.model.map.AreaTile;
import rice.model.map.MVAcceptor;
import rice.model.map.ModifierVisitor;
import rice.model.map.ResourceVisitor;
import rice.model.map.ResourceVisitorAcceptor;

/**
 *
 * @author Marcos
 */
public abstract class Accessory extends Locatable implements ResourceVisitorAcceptor, MVAcceptor {

	public Accessory(String typeName)
	{
		super(typeName);
	}
	
	public void setTile(AreaTile areaTile)
	{
	  	this.removeFromTile();
	  	areaTile.putAccessory(this);
		super.setTile(areaTile);
	}
	
	public void removeFromTile()
	{
		if(this.getTile()!=null)
		{
			this.getTile().removeAccessory(this);
		}
	}
	
	public void accept(ResourceVisitor v)
	{
		v.visit(this);
	}

	public void accept(ModifierVisitor v)
	{
		v.visit(this);
	}	
}
