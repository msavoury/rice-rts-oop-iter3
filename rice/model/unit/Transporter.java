/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.model.unit;

import java.util.List;
import rice.view.MSVisitor;
import rice.view.UOVisitor;

/**
 *
 * @author Marcos
 */
public class Transporter extends Vehicle {

    public void accept(UOVisitor u) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void accept(MSVisitor m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getCapacity() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addUnit(Unit u) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void removeUnit(Unit u) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Unit> getAllUnits() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
