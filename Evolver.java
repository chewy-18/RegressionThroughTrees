/* This file: Evolver.java
 * Programmer: David Chiu (dchiu1@andrew.cmu.edu) adapted from Steve's code
 * Course/Section 95-712A
 * Assignment: Homework 9.1, Evolve trees with new methods 
 * chooseTreeProportionalToFitness in generation class; 
 * New evolver class that evolves trees based on fitness 
 * and test class that tests evolver class
 * Description: Evolves trees from a given generation; 
 * Chooses two trees randomly based on fitness; 
 * Crosses over those two trees and adds them to a new
 * generation of the same size 
 */

import java.util.*;

/**
 * 
 * @author David
 *
 */
public class Evolver {
	Generation myGen; //default values 
	DataSet myDataSet;
	Random rand;
	/**
	 * Default constructor 
	 * @param g Generation of trees
	 * @param ds Dataset from file 
	 * @param r Random number generator
	 */
	public Evolver(Generation g, DataSet ds,Random r){ //default constructor 
		myGen=g;
		myDataSet=ds;
		myGen.evalAll(ds);
		rand=r;
		
	}
	/**
	 * Make new generation filled evolved trees 
	 * @return New generation at same size filled with randomly selected crossed over trees 
	 */
	public Generation makeNewGeneration(){
		Generation returnGen=new Generation(myGen.getNumTrees()); //create new generation with no trees 
		for(int i=0;i<myGen.getNumTrees();i+=2){// loop to add trees
			GPTree tree1=myGen.chooseTreeProportionalToFitness().duplicate(); //randomly select tree based on fitness
			GPTree tree2=myGen.chooseTreeProportionalToFitness().duplicate(); //randomly select tree based on fitness
			NodePairPlus pair1 = tree1.randomParentAndChild(rand); 
	        NodePairPlus pair2 = tree2.randomParentAndChild(rand);
	        pair1.parent.changeChild(pair1.child, pair2.child); //crossover 
	        pair2.parent.changeChild(pair2.child, pair1.child);
	        returnGen.addTree(i,tree1); //add crossed over trees
	        returnGen.addTree(i+1,tree2);
		}
			
		return returnGen; //return new generation 
		
	}

}
