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
public class Melee extends Unit {
  public Melee(String typeName, int id, Player owner) {
		super(typeName, id, owner);
		// TODO Auto-generated constructor stub
	}
public void accept(MSVisitor v){

    }
  public void accept(UOVisitor u) {
  //      throw new UnsupportedOperationException("Not supported yet.");
  }
  public boolean isSoldier() {
		return true;
	}
  
	public void accept(RiceSelector s)
	{
		s.addMelee(this);
	}
}
