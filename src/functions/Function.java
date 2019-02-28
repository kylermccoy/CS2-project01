package functions ;

public abstract class Function {

    public abstract double evaluate(double x) ;

    public abstract String toString(); ;

    public abstract Function derivative() ;

    public abstract double integral(double lower, double upper, int traps) ;

    public abstract boolean isConstant() ;
}
