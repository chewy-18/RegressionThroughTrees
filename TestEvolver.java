/* This file: TestEvolver.java
 * Programmer: David Chiu (dchiu1@andrew.cmu.edu) adapted from Steve's code
 * Course/Section 95-712A
 * Assignment: Homework 9.1, Evolve trees with new methods 
 * chooseTreeProportionalToFitness in generation class; 
 * New evolver class that evolves trees based on fitness 
 * and test class that tests evolver class
 * Description: Tests evolver class by creating a generation of 
 * 500 trees and evolving the generation 5 times  
 */

import java.util.*;
/**
 * Tests evolver class by creating a generation of 
 * 500 trees and evolving the generation 5 times
 * @author David
 *
 */
public class TestEvolver {
	static int maxDepth = 5;
	static Random rand = new Random();
	public static void main(String[] args) {
		DataSet ds = new DataSet(".\\src\\Data2.dat"); //pass in data file
    	Node[] ops = {new Plus(), new Minus(), new Mult(), new Divide()}; //deciding operations available  
   	 	OperatorFactory o = new OperatorFactory(ops); 
    	TerminalFactory t = new TerminalFactory(ds.numIndepVars());
    	Generation myGen=new Generation(500,o,t,maxDepth,rand); //generate generation of trees
    	
    	myGen.evalAll(ds); //eval generation
    	myGen.printBestTree(); //print best tree
    	Evolver test=new Evolver(myGen,ds,rand);
	  	for(int i=0;i<5;i++){ //evolve five times 
	  		myGen=test.makeNewGeneration(); //set myGen = new generation 
	    	myGen.evalAll(ds); //eval 
	    	myGen.printBestTree(); //print best tree
	  	}
    	
	}
}
