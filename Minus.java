/* This file: Evolver.java
 * Programmer: David Chiu (dchiu1@andrew.cmu.edu) adapted from Steve's code
 * Course/Section 95-712A
 * Assignment: Homework 9.1, Evolve trees with new methods 
 * chooseTreeProportionalToFitness in generation class; 
 * New evolver class that evolves trees based on fitness 
 * and test class that tests evolver class
 * Description: Contains the subtraction class with a method to 
 * evaluation its child nodes and a toString method to 
 * display the equation being evaluated
 */

public class Minus extends Binop {
    public Minus() {}
    public Minus(Node l, Node r) {
        super(l, r);
    }
    public double eval(double[] data) {
        return lChild.eval(data) - rChild.eval(data);
    }
    public String toString() {
        String s = new String();
        s += "(" + lChild.toString() + " - " + rChild.toString() + ")";
        return s;
    }
    public Node duplicate() {
        Minus alterEgo = new Minus();
        alterEgo.lChild = lChild.duplicate();
        alterEgo.rChild = rChild.duplicate();
        return alterEgo;
    }
}
