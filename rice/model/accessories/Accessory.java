/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.model.accessories;

import rice.model.Locatable;
import rice.model.map.ResourceVisitor;
import rice.model.map.ResourceVisitorAcceptor;

/**
 *
 * @author Marcos
 */
public abstract class Accessory extends Locatable implements ResourceVisitorAcceptor {

	public Accessory(String typeName)
	{
		super(typeName);
	}
	
	public void accept(ResourceVisitor v)
	{
		v.visit(this);
	}

}
