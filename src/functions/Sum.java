package functions;

import java.util.ArrayList;

public class Sum extends Function {
    private ArrayList<Function> elements ;
    public Sum(Function... terms){
        this.elements = new ArrayList<>() ;
        for(Function func: terms){
            elements.add(func) ;
        }
    }
    public double evaluate(double x){
        float sum = 0 ;
        for(Function func: elements){
            sum += func.evaluate(x) ;
        }
        return sum ;
    }

    @Override
    public String toString(){
        String result = "(" ;
        for(Function func: elements){
            result = result + " " + func.toString() ;
        }
        result = result + " )" ;
        return result ;
    }

    public Function derivative(){
        for(Function func: elements){

        }
        return null ;
    }

    public double integral(double lower, double upper, int traps){
        return 0 ;
    }
    public boolean isConstant(){
        boolean result = false ;
        for(Function func: elements){
            result = func.isConstant() ;
        }
        return result ;
    }
}
