/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.model.unit;

import java.util.List;

/**
 *
 * @author Marcos
 */
public interface UnitOwner {
  public void addUnit(Unit u);
  public void removeUnit(Unit u);
  public List<Unit> getAllUnits();

}
