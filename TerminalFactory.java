/* This file: TerminalFactory.java
 * Programmer: David Chiu (dchiu1@andrew.cmu.edu) adapted from Steve's code
 * Course/Section 95-712A
 * Assignment: Homework 9.1, Evolve trees with new methods 
 * chooseTreeProportionalToFitness in generation class; 
 * New evolver class that evolves trees based on fitness 
 * and test class that tests evolver class
 * Description: Contains the TerminalFactory class
 * that stores an int for number of Independent Variables;
 * Produces a node object const or variable when called
 */

import java.util.*;

/** Produces a terminal Node (either a Variable or a Const). */

public class TerminalFactory {
    private int numIndepVars;
    /** Sets the range of X-variables that this factory can supply.
    * @param n The number of independent variables. */
    TerminalFactory(int n) { numIndepVars = n; }
    /** Returns a randomly selected Variable or Const. The selection is uniform
    * over the range [X0, X1,...Xn, Const] */
    public Node getTerminal(Random rand) {
        Node n = null;
        int i = rand.nextInt(numIndepVars + 1);
        if (i < numIndepVars)
            n = new Variable(i);
        else
            n = new Const(rand.nextDouble());
        return n;
    }
    public int getNumIndepVars() { return numIndepVars; }
}
