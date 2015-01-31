/* This file: GPTree.java
 * Programmer: David Chiu (dchiu1@andrew.cmu.edu) adapted from Steve's code
 * Course/Section 95-712A
 * Assignment: Homework 9.1, Evolve trees with new methods 
 * chooseTreeProportionalToFitness in generation class; 
 * New evolver class that evolves trees based on fitness 
 * and test class that tests evolver class
 * Description: Contains GPTree which is a wrapper for the root node 
 * of a genetic programming tree
 */

import java.util.*;

/** A wrapper for the root node of a genetic programming tree.
*/
public class GPTree implements Comparable {
    private Node root;
    private int mySize;
    private double fitness = 0;
    public GPTree() { root = null; }

    /** Constructs a random GPTree whose depth is no greater than maxDepth.
    */
    public GPTree(OperatorFactory o, TerminalFactory t, int maxDepth, Random rand) {
        root = o.getOperator(rand);
        root.addRandomKids(o, t, maxDepth, rand);
    }
    public String toString() { return root.toString(); }

    /** Evaluate this GPTree for a single row of data. */
    public double eval(DataRow dr) {
		ArrayList a = dr.getXVals();
        double[] data = new double[a.size()];
			for (int i = 0; i < a.size(); i++)
				data[i] = ((Double)a.get(i)).doubleValue();
		return root.eval(data);
    }

    /** Evaluate this GPTree for all the rows in a DataSet, and set its
    * fitness value to the result of the evaluation. */
    public double eval(DataSet ds) {
        fitness = 0;
        int numRows = ds.getNumRows();
        for (int i = 0; i < numRows; i++) {
            fitness += Math.pow(eval(ds.get(i)) - ds.get(i).getY(), 2);
        }
        return fitness;
    }

    /** Evaluate this GPTree for a single row of data. */
    public double eval(double[] data) { return fitness = root.eval(data); }

    /** Return the number of nodes in this GPTree. */
    public int mySize() { return root.mySize(); }

    /** Specifies the natural ordering, based on the value of the fitness member variable. */
	public int compareTo(Object t) {
        if (fitness < ((GPTree)t).fitness)
            return -1;
        else if (fitness > ((GPTree)t).fitness)
            return 1;
        else
            return 0;
    }
    public double getFitness() { return fitness; }
    
    public void setFitness(double newfitness){fitness=newfitness;}

    /** Returns the length of the longest branch in this GPTree. */
    public int getDepth() { return root.getDepth(); }

    /** Returns a duplicate copy of this GPTree. Used in the crossover
    * operation and when creating a new generation. */
    public GPTree duplicate() {
        GPTree copy = new GPTree();
        copy.root = root.duplicate();
        return copy;
    }

    /** Finds a random "clip point" where crossover will occur. */
    public NodePairPlus randomParentAndChild(Random rand) {
        int clipNumber = Math.abs(rand.nextInt()) % (mySize() - 1) + 2;
        NodePairPlus p;
        p = root.traceTree(1, clipNumber);
        return p;
    }
    
    
}
