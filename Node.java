/* This file: Node.java
 * Programmer: David Chiu (dchiu1@andrew.cmu.edu) adapted from Steve's code
 * Course/Section 95-712A
 * Assignment: Homework 9.1, Evolve trees with new methods 
 * chooseTreeProportionalToFitness in generation class; 
 * New evolver class that evolves trees based on fitness 
 * and test class that tests evolver class
 * Description: Contains the node class 
 * and defines two methods (eval and toString) to be overwritten by
 * over classes that extend node; Also has clone method that can
 * clone itself and abstract addRandomKids method to be defined later
 */
import java.util.*;

public abstract class Node implements Cloneable {
    protected int depth;
    public Node() { depth = 0; }
    public int mySize() {
    	int size=1;
    	return size;
    }
    public void setDepth(int d) { depth = d; }
    public int getDepth() { return depth; }
    public abstract void setChild(int position, Node n);
    public abstract double eval(double[] data);
    public abstract String toString();
    public abstract void addRandomKids(OperatorFactory o, TerminalFactory t,
                                       int maxDepth, Random rand);
    public abstract void changeChild(Node oldChild, Node newChild);
    public abstract NodePairPlus traceTree(int nodeNumber, int clipNumber);
    public abstract Node duplicate();
    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        }
        catch(CloneNotSupportedException e) {
            System.out.println("Node can't clone.");
        }
        return o;
    }
}
