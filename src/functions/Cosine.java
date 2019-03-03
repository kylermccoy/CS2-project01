/**
 * Cosine.java
 * Author: Kyle McCoy krm7269@rit.edu
 * CS Project 1
 * implements the trig operation cosine class
 */

package functions;

public class Cosine extends Function {
    // function to be applied inside cosine
    private Function func ;

    /**
     * constructor for cosine
     * @param func function applied inside cosine
     */
    public Cosine(Function func){
        this.func = func ;
    }
    /**
     * find the value of the function at the given x
     * @param x double to be applied to the function
     * @return value of the function
     */
    public double evaluate(double x){
        double eval = this.func.evaluate(x) ;
        return Math.cos(eval) ;
    }
    /**
     * prints the string value of cosine
     * @return string
     */
    @Override
    public String toString(){
        return "cos( " + this.func.toString() + " )" ;
    }
    /**
     * calculates the derivative of the function
     * @return chain rule function
     */
    public Function derivative(){
        Product neg_sin = new Product(new Constant(-1.0), new Sine(this.func)) ;
        return new Product(neg_sin, this.func.derivative()) ;
    }
    /**
     * calculates the integral of the function
     * @param lower the lower bound of the integral
     * @param upper the upper bound of the integral
     * @param traps number of trapezoids to be used
     * @return double value of the integral
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
        return this.func.isConstant() ;
    }
}
