/**
 * Constant.java
 * Author: Kyle McCoy krm7269@rit.edu
 * CS Project 1
 * implements a constant number class
 */

package functions;

public class Constant extends Function {
    // number value of the constant
    private double constant ;

    /**
     * constructor for the constant class
     * @param value double value of the constant
     */
    public Constant(double value){
        this.constant = value ;
    }

    /**
     * prints the string value of the constant
     * @return string
     */
    @Override
    public String toString(){
        return "" + constant + "" ;
    }

    /**
     * find the value of the function at the given x
     * @param x double to be applied to the function
     * @return value of the constant
     */
    public double evaluate(double x){
        return constant ;
    }

    /**
     * calculates the derivative of the constant
     * @return constant zero
     */
    public Function derivative(){
        return new Constant(0.0) ;
    }

    /**
     * calculates the integral of the function
     * @param lower the lower bound of the integral
     * @param upper the upper bound of the integral
     * @param traps number of trapezoids to be used
     * @return double value of the integral
     */
    @Override
    public double integral(double lower, double upper, int traps){
        Variable var = Variable.X ;
        return ((constant * var.evaluate(upper)) - (constant * var.evaluate(lower))) ;
    }

    /**
     * checks if the function is a constant
     * @return boolean
     */
    public boolean isConstant(){
        return true ;
    }
}
