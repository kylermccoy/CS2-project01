public abstract class Function {

    public abstract float evaluate(float x) ;

    public abstract String toString(); ;

    public abstract Function derivative() ;

    public abstract double integral(double lower, double upper, int traps) ;

    public abstract boolean isConstant() ;
}
