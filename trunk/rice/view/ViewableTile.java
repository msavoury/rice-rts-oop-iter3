/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.view;
import java.util.HashMap;
import java.util.List;
import rice.util.Position;

/**
 *
 * @author spock
 */
public interface ViewableTile extends ViewableLocatable{
    public abstract Position getLocation();
    public abstract double getFlow();
    public abstract String getItem();
    public abstract String getDecal();
    public abstract String getObstacle();
    public abstract String getTerrainType();
    public abstract List<ViewableRallyPoint> getRallyPoints();
    public abstract String getStructure();
    public abstract HashMap<String, Integer> getResourceValues();
    public abstract String getHarvestingResource();
    public abstract int getBreedingWorkers();
    public abstract int getIdleWorkers();
    public abstract int getNumUnitsNotInRP();
    public abstract int getVisibilityMode();
    public abstract int getHarvestingWorkers();
    public abstract void accept(MSVisitor v);
}
