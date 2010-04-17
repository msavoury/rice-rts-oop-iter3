/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.view;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author spock
 */
public interface ViewableModel {

    public abstract void receiveMainScreenVisitor(MSVisitor m);
    public abstract String getCurrentlySelectedMode();
    public abstract String getCurrentlySelectedType();
    public abstract String getCurrentlySelectedInstance();
    public abstract String getCurrentlySelectedCommand();
    public abstract HashMap<String, Integer> getPlayerResources();
    public abstract ViewableRallyPoint getCurrentlySelectedRallyPoint();
    public abstract ViewableStructure getCurrentlySelectedStructure();
    public abstract ViewableUnit getCurrentlySelectedUnit();
    public abstract List<ViewableUnit> getAllUnits();
    public abstract List<ViewableStructure> getAllStructures();
    public abstract List<ViewableTech> getAllTechnology();

}
