/* This file: Const.java
 * Programmer: David Chiu (dchiu1@andrew.cmu.edu) adapted from Steve's code
 * Course/Section 95-712A
 * Assignment: Homework 9.1, Evolve trees with new methods 
 * chooseTreeProportionalToFitness in generation class; 
 * New evolver class that evolves trees based on fitness 
 * and test class that tests evolver class
 * Description: Contains const class that describes the values 
 * held in nodes that are not operators; Has addRandomKids 
 * method but does nothing in this class
 * 
 */
import java.util.*;
import java.text.*;

/** A Node wrapper for a constant in an algebraic expression. */
public class Const extends Node {
    private double value;
    public Const(double d) {value = d; }
    public void setChild(int position, Node n) {}
    public double eval(double[] data) { return value; }
    public String toString() {
        String s = new String();
        s += NumberFormat.getInstance().format(value);
        return s;
    }
    public void addRandomKids(OperatorFactory o, TerminalFactory t,
                              int maxDepth, Random rand) {}

    public Node duplicate() {
        Const alterEgo = new Const(value);
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

    /** Should never be called, since constants have no children. */
    public void changeChild(Node oldChild, Node newChild) {
        System.out.println("Const.changeChild() should never be called!");
    }
}
