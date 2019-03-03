package functions;

public class Cosine extends Function {
    private Function func ;

    public Cosine(Function func){
        this.func = func ;
    }

    public double evaluate(double x){
        double eval = this.func.evaluate(x) ;
        return Math.cos(eval) ;
    }

    @Override
    public String toString(){
        return "cos( " + this.func.toString() + " )" ;
    }

    public Function derivative(){
        Product neg_sin = new Product(new Constant(-1.0), new Sine(this.func)) ;
        return new Product(neg_sin, this.func.derivative()) ;
    }

    public double integral(double lower, double upper, int traps){
        if(traps<=0) {
            return 0.0 ;
        }
        double delta = (upper-lower)/traps ;
        int xoi ;
        double eval ;
        double sum = 0.0 ;
        for(xoi = 0; xoi <= traps; xoi++){
            eval = this.evaluate(lower + (xoi * delta)) ;
            if((xoi==0)||(xoi==traps)){
                sum += eval ;
            }else{
                sum += (2 * eval) ;
            }
        }
        double width = delta/2 ;
        return sum * width ;
    }

    public boolean isConstant(){
        return this.func.isConstant() ;
    }
}
