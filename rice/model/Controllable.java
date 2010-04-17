/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.model;

import rice.view.Viewable;


/**
 *
 * @author Marcos
 */
public abstract class Controllable extends Locatable implements Viewable {
  private int id;

  public String getType() {
      return this.getTypeName();
  }
   
}
