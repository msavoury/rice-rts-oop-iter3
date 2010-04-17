/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.view;

/**
 *
 * @author spock
 */
public interface MSVisitor {

    public abstract void visit(ViewableStructure s);
    public abstract void visit(ViewableTile t);
    public abstract void visit(ViewableRallyPoint p);
    public abstract void visit(ViewableUnit u);

}
