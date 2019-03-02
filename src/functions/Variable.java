package functions;

public class Variable extends Function {
    private Variable(){}
    public final static Variable X = new Variable() ;

    @Override
    public String toString(){
        return "x" ;
    }

    public double evaluate(double x){
        return x ;
    }

    public Function derivative(){
        return new Constant(1.0) ;
    }

    @Override
    public double integral(double lower, double upper, int traps){
        Variable var = Variable.X ;
        double result = ((0.5) * var.evaluate(upper) * var.evaluate(upper)) ;
        result -= ((0.5) * var.evaluate(lower) * var.evaluate(lower)) ;
        return result ;
    }

    public boolean isConstant(){
        return false ;
    }
}
