/**
 * Product.java
 * Author: Kyle McCoy krm7269@rit.edu
 * CS Project 1
 * implements the multiplication operation class
 */

package functions;

import java.util.ArrayList;

public class Product extends Function {
    // ArrayList of functions
    private ArrayList<Function> elements ;

    /**
     * constructor for the product class
     * @param terms array of functions to be multiplied
     */
    public Product(Function... terms){
        this.elements = new ArrayList<>() ;
        boolean check = false ;
        double constant = 1.0 ;
        for(Function func: terms){
            if(func.isConstant()){
                constant = constant * func.evaluate(0.0) ;
            }else {
                check = true ;
                elements.add(func);
            }
        }
        if(constant==0.0){
            this.elements = new ArrayList<>() ;
            elements.add(new Constant(0.0)) ;
        }
        if((constant>1)||(!check)||(constant<1)){
            elements.add(new Constant(constant)) ;
        }
    }
    /**
     * evaluates the value of the function
     * @param x double to be applied to the function
     * @return value of the derivative
     */
    public double evaluate(double x){
        double product = 1.0 ;
        for(Function func: elements){
            product = (product * func.evaluate(x)) ;
        }
        return product ;
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
                result = result + " * ";
            }
            count++ ;
        }
        if(count > 1) {
            result =  "( " + result + " )";
        }
        return result ;
    }

    /**
     * solves the derivative of the function
     * @return function using product rule
     */
    public Function derivative(){
        int index = 0 ;
        ArrayList<Function> deriv = new ArrayList<>() ;
        for(Function func: elements){
            ArrayList<Function> deriv_list = new ArrayList<>();
            int loop ;
            for(loop = 0;loop<elements.size();loop++){
                if(loop==index){
                    deriv_list.add(elements.get(loop).derivative()) ;
                }else{
                    deriv_list.add(elements.get(loop)) ;
                }
            }
            Function[] product_array = new Function[deriv_list.size()] ;
            deriv.add(new Product(deriv_list.toArray(product_array))) ;
            index++ ;
        }
        Function[] deriv_array = new Function[deriv.size()] ;
        return new Sum(deriv.toArray(deriv_array)) ;
    }

    /**
     * evaluates the value of the integral of the function
     * @param lower the lower bound of the integral
     * @param upper the upper bound of the integral
     * @param traps number of trapezoids to be used
     * @return double
     */
    public double integral(double lower, double upper, int traps){
        if(traps<=0) {
            return 0.0 ;
        }
        double delta = (upper-lower)/traps ;
        int xoi ;
        double eval ;
        double sum = 0.0 ;
        for(xoi = 0; xoi <= traps; xoi++){
            eval = this.evaluate(lower + (xoi * delta)) ;
            if((xoi==0)||(xoi==traps)){
                sum += eval ;
            }else{
                sum += (2 * eval) ;
            }
        }
        double width = delta/2 ;
        return sum * width ;
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
