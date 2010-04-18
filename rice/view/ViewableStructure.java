/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.view;

/**
 *
 * @author spock
 */
public interface ViewableStructure extends ViewableControllable{
    public abstract double getHealth();
    public abstract int getArmor();
    public abstract int getAttack();
    public abstract int getDefense();
    public abstract String getStatus();
    public abstract int getID();
    public abstract void accept(SOVisitor s);
    public abstract void accept(MSVisitor m);
}
