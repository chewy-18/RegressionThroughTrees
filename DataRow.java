/* This file: DataRow.java
 * Programmer: David Chiu (dchiu1@andrew.cmu.edu) adapted from Steve's code
 * Course/Section 95-712A
 * Assignment: Homework 9.1, Evolve trees with new methods 
 * chooseTreeProportionalToFitness in generation class; 
 * New evolver class that evolves trees based on fitness 
 * and test class that tests evolver class
 * Description: DataRow class developed so that it's objects hold
 * a y value and an array of x values; Contains methods to get the 
 * y value or array as well as a setArray method 
 */

import java.util.*;

/** Holds a single row of data, consisting of one or more X values and a single Y value.
* An ArrayList holds the (double) values of the independent variables ("X values")
* and a double holds the corresponding Y value. */
public class DataRow {
    private double yVal;
    private ArrayList xVals;

    DataRow() {
        xVals = new ArrayList();
    }
    public void setY(double y) {
        yVal = y;
    }
    /** Adds a new X value.  Be careful to add X values in the correct order
    * (i.e., X0 first, then X1, and so forth). */
    public void addX(double x) {
        xVals.add(new Double(x));
    }
    double getY() {
        return yVal;
    }
    ArrayList getXVals() {
        return xVals;
    }
}
