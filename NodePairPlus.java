/* This file: NodePairPlus.java
 * Programmer: David Chiu (dchiu1@andrew.cmu.edu) adapted from Steve's code
 * Course/Section 95-712A
 * Assignment: Homework 9.1, Evolve trees with new methods 
 * chooseTreeProportionalToFitness in generation class; 
 * New evolver class that evolves trees based on fitness 
 * and test class that tests evolver class
 * Description: Contains NodePairPlus class that contains the
 * parent node above the clip point, child node below the 
 * clip point and a counter 
 */
/** Holds a "clip point". A clip point is the place in a GPTree
where crossover will occur.
* @see GPTree
* @see TestGPTree
*/

public class NodePairPlus {
    /** The node above the clip point. */
    public Node parent;
    /** The node below the clip point. */
    public Node child;
    /** the count of number of nodes so far tested in the process
    * of searching for the clip point. */
    int counter;
}
