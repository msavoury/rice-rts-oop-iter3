/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.model;

import rice.model.player.Player;
import rice.view.Viewable;


/**
 *
 * @author Marcos
 */
public abstract class Controllable extends Locatable implements Viewable {
  private int id;
  private Player owner;
  
  public Controllable(String typeName, int id, Player owner)
  {
	  super(typeName);
	  this.id=id;
	  this.owner=owner;
  }

  public String getType() {
      return this.getTypeName();
  }
  
  //return the controllables id
  public int getId()
  {
	  return this.id;
  }
  
  //return the controllables owner
  public Player getOwner()
  {
	  return this.owner;
  }
   
}
