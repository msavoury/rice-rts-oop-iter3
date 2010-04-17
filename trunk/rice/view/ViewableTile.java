/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.view;

import java.awt.Dimension;
import java.util.HashMap;

/**
 *
 * @author spock
 */
public interface ViewableTile extends ViewableLocatable{
    public abstract Dimension getLocation();
    public abstract String getFlow();
    public abstract String getItem();
    public abstract String getDecal();
    public abstract String getObstacle();
    public abstract String getTerrainType();
    public abstract ViewableRallyPoint getRallyPoint();
    public abstract String getStructure();
    public abstract HashMap<String, Integer> getResourceValues();
    public abstract ViewableResource getHarvestingResource();
    public abstract int getBreedingWorkers();
    public abstract int getIdleWorkers();
    public abstract int getNumUnitsNotInRP();
    public abstract int getVisibilityMode();
    public abstract void accept(MSVisitor v);
}
