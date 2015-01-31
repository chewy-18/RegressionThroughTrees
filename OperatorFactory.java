/* This file: OperatorFactory.java
 * Programmer: David Chiu (dchiu1@andrew.cmu.edu) adapted from Steve's code
 * Course/Section 95-712A
 * Assignment: Homework 9.1, Evolve trees with new methods 
 * chooseTreeProportionalToFitness in generation class; 
 * New evolver class that evolves trees based on fitness 
 * and test class that tests evolver class
 * Description: Contains the OperatorFactory class
 * that stores array of Nodes; Supplies a Node object
 * from array of Nodes when called
 */
import java.util.*;

/** Produces a random operator (e.g., Plus) by cloning from an internally held
* collection of possible operator types. */
public class OperatorFactory {
    private Node[] currentOps;

    /** Sets the types of operators that this factory can supply.
    * @param n An array of Nodes containing instances of the available operator types. */
    public OperatorFactory(Node[] n) { currentOps = n; }

    /** Returns a Node refering to a randomly chosen operator. */
    public Node getOperator(Random rand) {
		Node n = (Node)currentOps[rand.nextInt(currentOps.length)].clone();
        return n;
    }
    public int getNumOps() { return currentOps.length; }
}
