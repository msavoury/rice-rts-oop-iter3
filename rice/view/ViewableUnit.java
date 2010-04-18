/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.view;

/**
 *
 * @author spock
 */
public interface ViewableUnit extends ViewableLocatable{
    public abstract double getHealth();
    public abstract int getSpeed();
    public abstract int getArmor();
    public abstract int getAttack();
    public abstract int getDefense();
    public abstract String getStatus();
    public abstract int getSize();
    public abstract int getID();
    public abstract String getViewableUnitOwner();
    public abstract void accept(UOVisitor u);
    public abstract void accept(MSVisitor m);
}
