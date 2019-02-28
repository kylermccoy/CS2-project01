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
        String result = "( " ;
        double constant_sum = 0 ;
        boolean check = false ;
        int count = 0 ;
        int size = elements.size() ;
        for(Function func: elements){
            if(func.isConstant()){
                constant_sum += func.evaluate(0) ;
            }else {
                result = result + "" + func.toString();
                check = true ;
            }
            count++ ;
            if(check && count < size-1){
                result = result + " + " ;
                check = false ;
            }
        }
        if(!check){
            result = result + "" + constant_sum ;
        }
        if(constant_sum > 0 && check){
            result = result + " + " + constant_sum ;
        }
        result = result + " )" ;
        return result ;
    }

    public Function derivative(){
        ArrayList<Function> deriv_array = new ArrayList<>() ;
        for(Function func: elements){
            deriv_array.add(func.derivative()) ;
        }
        Function[] deriv =  new Function[deriv_array.size()] ;
        return new Sum(deriv_array.toArray(deriv)) ;
    }

    public double integral(double lower, double upper, int traps){
        double integral_sum = 0 ;
        for(Function func: elements){
            integral_sum += func.integral(lower, upper, traps) ;
        }
        return integral_sum ;
    }
    public boolean isConstant(){
        boolean result = false ;
        for(Function func: elements){
            result = func.isConstant() ;
        }
        return result ;
    }
}
