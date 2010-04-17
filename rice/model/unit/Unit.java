/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.model.unit;

import java.awt.Dimension;

import rice.model.Controllable;
import rice.model.player.Player;
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

    public Dimension getLocation() {
        throw new UnsupportedOperationException("Not supported yet.");

    }
}
