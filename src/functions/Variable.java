/**
 * Variable.java
 * Author: Kyle McCoy krm7269@rit.edu
 * CS Project 1
 * implements a variable class
 */

package functions;

public class Variable extends Function {
    // constructor
    private Variable(){}
    // instance of variable
    public final static Variable X = new Variable() ;

    /**
     * converts variable to string
     * @return string
     */
    @Override
    public String toString(){
        return "x" ;
    }

    /**
     * evaluates the value of the variable
     * @param x double to be applied to the function
     * @return x
     */
    public double evaluate(double x){
        return x ;
    }

    /**
     * determines the derivative of the variable
     * @return constant 1.0
     */
    public Function derivative(){
        return new Constant(1.0) ;
    }

    /**
     * evaluates the integral of the variable
     * @param lower the lower bound of the integral
     * @param upper the upper bound of the integral
     * @param traps number of trapezoids to be used
     * @return double
     */
    @Override
    public double integral(double lower, double upper, int traps){
        Variable var = Variable.X ;
        double result = ((0.5) * var.evaluate(upper) * var.evaluate(upper)) ;
        result -= ((0.5) * var.evaluate(lower) * var.evaluate(lower)) ;
        return result ;
    }
    /**
     * checks if the function is a constant
     * @return boolean
     */
    public boolean isConstant(){
        return false ;
    }
}
