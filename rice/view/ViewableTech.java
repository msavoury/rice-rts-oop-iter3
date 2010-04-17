/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.view;

/**
 *
 * @author spock
 */
public interface ViewableTech extends Viewable{
    public abstract int getLevel();
    public abstract int getMaxLevel();
    public abstract double getProgress();
    public abstract ViewableStructure getUniversity();
    public abstract void accept(TOVisitor t);
}
