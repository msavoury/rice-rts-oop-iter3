/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.model.command;

import rice.model.CombatManager;
import rice.model.structures.Capital;

/**
 *
 * @author spock
 */
public class Breed extends Command{
        Capital c;
        int numWorkers;

        public Breed(Capital c, int numOfWorkers) {
		super(c);
                this.c = c;
                numWorkers = numOfWorkers;
                setName("Breed");
	}

	@Override
	public int execute() {
		c.addBreedingWorkers(numWorkers);
		return FINISHED;
	}
}
