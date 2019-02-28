package functions;

public class Cosine extends Function {
    private Function func ;

    public Cosine(Function func){
        this.func = func ;
    }

    public double evaluate(double x){
        return 0 ;
    }

    @Override
    public String toString(){
        return "" ;
    }

    public Function derivative(){
        return null ;
    }

    public double integral(double lower, double upper, int traps){
        return 0 ;
    }

    public boolean isConstant(){
        return this.func.isConstant() ;
    }
}
