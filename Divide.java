/* This file: Divide.java
 * Programmer: David Chiu (dchiu1@andrew.cmu.edu) adapted from Steve's code
 * Course/Section 95-712A
 * Assignment: Homework 9.1, Evolve trees with new methods 
 * chooseTreeProportionalToFitness in generation class; 
 * New evolver class that evolves trees based on fitness 
 * and test class that tests evolver class
 * Description: Contains the division class with a method to 
 * evaluation its child nodes and a toString method to 
 * display the equation being evaluated
 */

/** Implements "restricted division": if the divisor is within 0.0001
* of zero, numericalEval() returns 1.0.
*/
public class Divide extends Binop {
    public Divide() {}
    public Divide(Node l, Node r) {
        super(l, r);
    }
    public double eval(double[] data) {
        if (Math.abs(rChild.eval(data)) < 0.0001)
            return 1;
        else
        	return lChild.eval(data) / rChild.eval(data);
    }
    public String toString() {
        String s = new String();
        s += "(" + lChild.toString() + " / " + rChild.toString() + ")";
        return s;
    }
    public Node duplicate() {
        Divide alterEgo = new Divide();
        alterEgo.lChild = lChild.duplicate();
        alterEgo.rChild = rChild.duplicate();
        return alterEgo;
    }
}
