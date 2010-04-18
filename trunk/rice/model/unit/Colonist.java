/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.model.unit;

import rice.model.player.Player;
import rice.model.player.RiceSelector;
import rice.view.MSVisitor;
import rice.view.UOVisitor;

/**
 *
 * @author Marcos
 */
public class Colonist extends Unit {

    public Colonist(String typeName, int id, Player owner) {
		super(typeName, id, owner);
		
	}
    
    public Colonist(int id, Player owner){
    	this("Colonist", id, owner);
    }
    public boolean isSoldier() {
		return false;
	}
    
	public void accept(UOVisitor u) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void accept(MSVisitor m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
	public void accept(RiceSelector s)
	{
		s.addColonist(this);
	}

}
