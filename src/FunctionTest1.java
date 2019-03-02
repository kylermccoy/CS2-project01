import functions.*;

public class FunctionTest1 {

    public static void main( String[] args ) {
        if ( args.length != 0 ) {
            System.err.println( "FnTest0 takes no command line arguments." );
            System.exit( 1 );
        }
        Variable var = Variable.X;
        Function f = new
                Sum( new Product(var ,var), new Product(var, new Constant(2.0)), new Constant(1.0) );
        System.out.println( "Function " + f );
        System.out.println( "Value at 0: " + f.evaluate( 0.0 ) );
        System.out.println( "Value at 10: " + f.evaluate( 10.0 ) );
        System.out.println( "Derivative: " + f.derivative() );
        double iResult = 0.0;
        iResult = f.integral( 0.0, 10.0, 10 );
        System.out.println( "Integral from 0 to 10 with 10 traps: " + iResult );
        iResult = f.integral( 0.0, 10.0, 100 );
        System.out.println( "Integral from 0 to 10 with 100 traps: " + iResult );
    }
}
