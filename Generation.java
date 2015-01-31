/* This file: Generation.java
 * Programmer: David Chiu (dchiu1@andrew.cmu.edu) adapted from Steve's code
 * Course/Section 95-712A
 * Assignment: Homework 9.1, Evolve trees with new methods 
 * chooseTreeProportionalToFitness in generation class; 
 * New evolver class that evolves trees based on fitness 
 * and test class that tests evolver class
 * Description: Container class for GPTrees; generates the trees
 * and determines the fitness of each tree based on a passed in 
 * data file 
 */
import java.util.*;
import java.text.*;

/** A container of GPTrees. */
public class Generation {
    private int numTrees;
    private GPTree[] population;
    private double[] fitness;
    private Random rand = new Random();

    /** Specifies the number of GPTrees in this generation, the
    * factories used to generate the individual trees, the maximum tree depth,
    * and the Random object used. */
    Generation(int numTrees, OperatorFactory o, TerminalFactory t, int m, Random r) {
        this.numTrees = numTrees;
        population = new GPTree[numTrees];
        for (int i = 0; i < numTrees; i++)
            population[i] = new GPTree(o, t, m, r);
    }
    Generation(int numTrees){
    	this.numTrees=numTrees;
    	population=new GPTree[numTrees];
    }
    
    public void addTree(int index,GPTree tree){
    	population[index]=tree;
    }
    
    /** Evaluate each tree in this generation, and set each tree's fitness value. */
    public void evalAll(DataSet d) {
        for (int i = 0; i < numTrees; i++)
            population[i].setFitness(1/(population[i].eval(d)));
    }

    /** Print the symbolicEval of each tree, and its fitness value. Very lengthy! */
    public void printAll() {
        for (int i = 0; i < numTrees; i++) {
            System.out.println(population[i]);
            System.out.println("This tree's fitness is "
                +  NumberFormat.getInstance().format(population[i].getFitness())); //change fitness back
        }
    }

    /** Prints the tree with the lowest fitness value. */
    public void printBestTree() {
        Arrays.sort(population);
        //printAll();
        System.out.println(population[numTrees-1]);
        System.out.println("Its fitness is " + population[numTrees-1].getFitness());
    }
    
    
    
    public GPTree chooseTreeProportionalToFitness(){
    	double sumsquares=0;
    	GPTree returnTree = null;
    	for(int i=0;i<numTrees;i++){
    		sumsquares+=population[i].getFitness();
    	}
    	double chosennum=rand.nextDouble()*sumsquares;
    	double numsum=0;
    	for(int i=0;i<numTrees;i++){
    		numsum+=population[i].getFitness();
    		if(chosennum<=numsum && chosennum>=numsum-population[i].getFitness()){
    			returnTree=population[i];
    		}
    	}
    	return returnTree;
    }
    public int getNumTrees(){return numTrees;}
    	
}
