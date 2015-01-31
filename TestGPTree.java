/* This file: TestGPTree.java
 * Programmer: David Chiu (dchiu1@andrew.cmu.edu) adapted from Steve's code
 * Course/Section 95-712A
 * Assignment: Homework 9.1, Evolve trees with new methods 
 * chooseTreeProportionalToFitness in generation class; 
 * New evolver class that evolves trees based on fitness 
 * and test class that tests evolver class
 * Description: Tests GPTree with a crossover method;
 * Crossover takes two trees and crosses them over at 
 * a random point
 */
import java.util.*;
import java.text.*;

public class TestGPTree {
    static int maxDepth = 5;
	static Random rand = new Random();
    public static void crossover(GPTree t1, GPTree t2, Random rand) { //crossover trees at random node 
        NodePairPlus pair1 = t1.randomParentAndChild(rand); 
        NodePairPlus pair2 = t2.randomParentAndChild(rand);
        pair1.parent.changeChild(pair1.child, pair2.child);
        pair2.parent.changeChild(pair2.child, pair1.child);
    }
    public static void main(String[] args) {
        DataSet ds = new DataSet(".\\src\\Data2.dat"); //pass in data file
    	Node[] ops = {new Plus(), new Minus(), new Mult(), new Divide()};
   	 	OperatorFactory o = new OperatorFactory(ops);
    	TerminalFactory t = new TerminalFactory(ds.numIndepVars());
        GPTree tree1 = new GPTree(o, t, 2, rand); //create two trees
        GPTree tree2 = new GPTree(o, t, 2, rand);
        System.out.println(tree1);//print original trees 
        System.out.println(tree2);
        System.out.println();
        crossover(tree1, tree2, rand);
        System.out.println(tree1);//print crossover trees 
        System.out.println(tree2);
    }
}
