public class Constant extends Function{
    private int constant ;
    public Constant(int value){
        this.constant = value ;
    }
    @Override
    public String toString(){
        return "" + constant + "" ;
    }

    public float evaluate(float x){
        return constant ;
    }

    public Function derivative(){
        return new Constant(0) ;
    }

    public double integral(double lower, double upper, int traps){
        Variable var = Variable.X ;
        return (double)(var.evaluate((float)(upper)) - var.evaluate((float)(lower))) ;
    }

    public boolean isConstant(){
        return true ;
    }
}
