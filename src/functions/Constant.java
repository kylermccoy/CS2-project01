package functions;

public class Constant extends Function {
    private int constant ;
    public Constant(int value){
        this.constant = value ;
    }
    @Override
    public String toString(){
        return "" + constant + "" ;
    }

    public double evaluate(double x){
        return constant ;
    }

    public Function derivative(){
        return new Constant(0) ;
    }

    public double integral(double lower, double upper, int traps){
        Variable var = Variable.X ;
        return ((constant * var.evaluate(upper)) - (constant * var.evaluate(lower))) ;
    }

    public boolean isConstant(){
        return true ;
    }
}
