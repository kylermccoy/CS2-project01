package functions;

import java.util.ArrayList;

public class Product extends Function {
    private ArrayList<Function> elements ;

    public Product(Function... terms){
        this.elements = new ArrayList<>() ;
        for(Function func: terms){
            elements.add(func) ;
        }
    }

    public double evaluate(double x){
        double product = 1 ;
        for(Function func: elements){
            product = product * func.evaluate(x) ;
        }
        return product ;
    }

    @Override
    public String toString(){
        String result = "( " ;
        double constant_product = 1 ;
        boolean check = false ;
        int count = 0 ;
        int size = elements.size() ;
        for(Function func: elements){
            if(func.isConstant()){
                constant_product = constant_product * func.evaluate(0) ;
            }else {
                result = result + "" + func.toString();
                check = true ;
            }
            count++ ;
            if(check && count < size-1){
                result = result + " * " ;
                check = false ;
            }
        }
        if(!check){
            result = result + "" + constant_product ;
        }
        if(constant_product > 1 && check){
            result = result + " * " + constant_product ;
        }
        result = result + " )" ;
        return result ;
    }

    public Function derivative(){
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
