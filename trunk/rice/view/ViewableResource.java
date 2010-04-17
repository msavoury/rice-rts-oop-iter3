/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.view;

/**
 *
 * @author spock
 */
public interface ViewableResource extends ViewableLocatable{
    public abstract int getNumberOfWorkers();
    public abstract void accept(MSVisitor m);
}
