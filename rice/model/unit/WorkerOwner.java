/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.model.unit;

/**
 *
 * @author Marcos
 */
public interface WorkerOwner {
  public int getIdleWorkerCount();
  public int getTotalWorkerCount();
  public int addWorkers(int workers );
  /**
   * Returns the amount that you actually removed
   */
   public int removeWorkers();
   public int removeIdleWorkers(int num );
   public void assignToResource();
   public void unassignFromResource();
}
