/**
 * Sum.java
 * Author: Kyle McCoy krm7269@rit.edu
 * CS Project 1
 * implements the addition operation class
 */

package functions;

import java.util.ArrayList;

public class Sum extends Function {
    // ArrayList of functions
    private ArrayList<Function> elements ;
    /**
     * constructor for the sum class
     * @param terms array of functions to be added
     */
    public Sum(Function... terms){
        this.elements = new ArrayList<>() ;
        double sum = 0.0 ;
        boolean check = false ;
        for(Function func: terms){
            if(func.isConstant()){
                sum += func.evaluate(0.0) ;
            }else {
                check = true ;
                elements.add(func);
            }
        }
        if((sum != 0.0)||(!check)){
            elements.add(new Constant(sum)) ;
        }
    }
    /**
     * evaluates the value of the function
     * @param x double to be applied to the function
     * @return value of the derivative
     */
    public double evaluate(double x){
        double sum = 0.0 ;
        for(Function func: elements){
            sum += func.evaluate(x) ;
        }
        return sum ;
    }
    /**
     * converts the function to string
     * @return string
     */
    @Override
    public String toString(){
        String result = "" ;
        int count = 0 ;
        int size = elements.size() ;
        for(Function func: elements) {
            result = result + "" + func ;
            if (count < size - 1) {
                result = result + " + ";
            }
            count++ ;
        }
        if(count > 1) {
            result = "( " + result + " )";
        }
        return result ;
    }
    /**
     * solves the derivative of the function
     * @return function
     */
    public Function derivative(){
        ArrayList<Function> deriv_array = new ArrayList<>() ;
        for(Function func: elements){
            deriv_array.add(func.derivative()) ;
        }
        Function[] deriv =  new Function[deriv_array.size()] ;
        return new Sum(deriv_array.toArray(deriv)) ;
    }
    /**
     * evaluates the value of the integral of the function
     * @param lower the lower bound of the integral
     * @param upper the upper bound of the integral
     * @param traps number of trapezoids to be used
     * @return double
     */
    @Override
    public double integral(double lower, double upper, int traps){
        double integral_sum = 0.0 ;
        for(Function func: elements){
            integral_sum += func.integral(lower, upper, traps) ;
        }
        return integral_sum ;
    }
    /**
     * checks if the function is a constant
     * @return boolean
     */
    public boolean isConstant(){
        boolean result = true ;
        for(Function func: elements){
            if(!func.isConstant()){
                result = false ;
            }
        }
        return result ;
    }
}
