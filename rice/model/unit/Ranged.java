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
public class Ranged extends Unit{

    public Ranged(String typeName, int id, Player owner) {
		super(typeName, id, owner);
		// TODO Auto-generated constructor stub
	}
    
    public boolean isSoldier() {
		return true;
	}

	public void accept(UOVisitor u) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void accept(MSVisitor m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
	public void accept(RiceSelector s)
	{
		s.addRanged(this);
	}

}
