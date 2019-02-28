public class Variable extends Function{
    private Variable(){}
    public final static Variable X = new Variable() ;

    @Override
    public String toString(){
        return "x" ;
    }

    public float evaluate(float x){
        return x ;
    }

    public Function derivative(){
        return new Constant(1) ;
    }

    public double integral(double lower, double upper, int traps){
        Variable var = Variable.X ;
        double result = ((1/2) * var.evaluate((float)(upper)) * var.evaluate((float)(upper))) ;
        result -= ((1/2) * var.evaluate((float)(lower)) * var.evaluate((float)(lower))) ;
        return result ;
    }

    public boolean isConstant(){
        return false ;
    }
}
