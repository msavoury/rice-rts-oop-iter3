/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.model.unit;

import rice.model.Controllable;
import rice.model.map.ATVisitorAcceptor;
import rice.model.map.AreaTileVisitor;
import rice.model.player.Player;
import rice.util.Position;
import rice.view.ViewableUnit;

/**
 *
 * @author Marcos
 */
public abstract class Unit extends Controllable implements ViewableUnit {
     private int speed;
     private int size;
	
     public Unit(String typeName, int id, Player owner) {
		super("Unit", id, owner);
		// TODO Auto-generated constructor stub
	 }

    public abstract boolean isSoldier();
    
    public int getSpeed() {
        return this.speed;
    }

   
   

    public String getStatus() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getSize() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getID() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Position getLocation() {
        throw new UnsupportedOperationException("Not supported yet.");

    }
    
	public void accept(AreaTileVisitor v)
	{
		v.visit(this);
	}
	
	public String getViewableUnitOwner(){
		return getOwner().toString();
	}
	
}
