/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.model.unit;

import rice.model.player.Player;
import rice.view.ViewableVehicle;

/**
 *
 * @author Marcos
 */
public abstract class Vehicle extends Unit implements ViewableVehicle, UnitOwner {

	public Vehicle(String typeName, int id, Player owner) {
		super(typeName, id, owner);
		// TODO Auto-generated constructor stub
	}

}
