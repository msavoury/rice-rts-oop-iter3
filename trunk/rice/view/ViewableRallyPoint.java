/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.view;

import java.util.List;

/**
 *
 * @author spock
 */
public interface ViewableRallyPoint extends ViewableLocatable{
    public abstract List<ViewableUnit> getAllUnits();
    public abstract List<ViewableUnit> getSupportGroup();
    public abstract List<ViewableUnit> getBattleGroup();
    public abstract int getSpeed();
    public abstract int getAttack();
    public abstract int getDefense();
    public abstract int getID();
    public abstract void accept(MSVisitor m);
}
