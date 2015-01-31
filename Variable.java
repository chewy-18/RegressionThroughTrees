/* This file: Variable.java
 * Programmer: David Chiu (dchiu1@andrew.cmu.edu) adapted from Steve's code
 * Course/Section 95-712A
 * Assignment: Homework 9.1, Evolve trees with new methods 
 * chooseTreeProportionalToFitness in generation class; 
 * New evolver class that evolves trees based on fitness 
 * and test class that tests evolver class
 * Description: Contains variable class; Has attribute
 * called index that gives the index of the data array
 * passed when eval method called; Has addRandomKids 
 * method but does nothing in this class
 */

import java.util.*;

/** A variable in an algebraic expression. Holds an index referring to
*   its subcript in a algebraic expression. */
public class Variable extends Node {
    private int index;
    /** @param i the subscript of the variable; subscripts start at zero. */
    public Variable(int i) {
        index = i;
    }

    /** This should never be called! Should throw an exception,
    * but doesn't yet. */
	public void setChild(int position, Node n) {
        System.out.println("Attempt to add child to Variable");
    }
    public String toString() {
        String s = new String();
        s += "X" + index;
        return s;
    }

    /** Returns the value in data indexed by this Variable's index member. */
	public double eval(double[] data) {
        if (index < data.length)
        	return data[index];
        else {
            System.out.println("Variable index exceeds data array length.");
            return 0;
        }
    }

    /** Does nothing, since Variables can't have children. */
    public void addRandomKids(OperatorFactory o, TerminalFactory t,
                              int maxDepth, Random rand) {}

    /** Returns a new Variable object with the same index. */
    public Node duplicate() {
        Variable alterEgo = new Variable(index);
        return alterEgo;
    }

    /** Returns a NodePairPlus object whose parent and child are null,
    * and whose counter equals the incoming nodeNumber. */
    public NodePairPlus traceTree(int nodeNumber, int clipNumber) {
        NodePairPlus p = new NodePairPlus();
        p.parent = null;
        p.child = null;
        p.counter = nodeNumber;
        return p;
    }

    /** This should never be called! Should throw an exception. */
    public void changeChild(Node oldChild, Node newChild) {
        System.out.println("Variable.changeChild() should never be called!");
    }
}
