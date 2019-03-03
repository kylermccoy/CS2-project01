/**
 * Function.java
 * Author: Kyle McCoy krm7269@rit.edu
 * CS Project 1
 * implements the Function abstract class
 */

package functions ;

public abstract class Function {
    /**
     * find the value of the function at the given x
     * @param x double to be applied to the function
     * @return value of the function
     */
    public abstract double evaluate(double x) ;
    /**
     * prints the string value of function
     * @return string
     */
    public abstract String toString(); ;
    /**
     * calculates the derivative of the function
     * @return function
     */
    public abstract Function derivative() ;
    /**
     * calculates the integral of the function
     * @param lower the lower bound of the integral
     * @param upper the upper bound of the integral
     * @param traps number of trapezoids to be used
     * @return double value of the integral
     */
    public abstract double integral(double lower, double upper, int traps) ;
    /**
     * checks if the function is a constant
     * @return boolean
     */
    public abstract boolean isConstant() ;
}
