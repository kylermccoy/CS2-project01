package functions;

public class Sine extends Function {
    private Function func ;

    public Sine(Function func){
        this.func = func ;
    }

    public double evaluate(double x){
        double eval = this.func.evaluate(x) ;
        return Math.sin(eval) ;
    }

    @Override
    public String toString(){
        return "sin( " + this.func.toString() + " )" ;
    }

    public Function derivative(){
        return new Product(new Cosine(this.func), this.func.derivative()) ;
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
