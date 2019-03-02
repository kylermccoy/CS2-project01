import functions.*;

public class FunctionTest1 {

    public static void main( String[] args ) {
        if ( args.length != 0 ) {
            System.err.println( "FnTest0 takes no command line arguments." );
            System.exit( 1 );
        }
        Variable var = Variable.X;
        Function test1 = new
                Sum( new Product(var ,var), new Product(var, new Constant(2.0)), new Constant(1.0) );
        System.out.println( "Function " + test1 );
        System.out.println( "Value at 0: " + test1.evaluate( 0.0 ) );
        System.out.println( "Value at 10: " + test1.evaluate( 10.0 ) );
        System.out.println( "Derivative: " + test1.derivative() );
        double iResult = 0.0;
        iResult = test1.integral( 0.0, 10.0, 10 );
        System.out.println( "Integral from 0 to 10 with 10 traps: " + iResult );
        iResult = test1.integral( 0.0, 10.0, 100 );
        System.out.println( "Integral from 0 to 10 with 100 traps: " + iResult );

        Function test2 = new
                Product( new Product(var ,new Constant(2.0)));
        System.out.println( "Function " + test2 );
        System.out.println( "Value at 0: " + test2.evaluate( 0.0 ) );
        System.out.println( "Value at 10: " + test2.evaluate( 10.0 ) );
        System.out.println( "Derivative: " + test2.derivative() );
        iResult = 0.0;
        iResult = test2.integral( 0.0, 4.0, 7 );
        System.out.println( "Integral from 0 to 4 with 7 traps: " + iResult );
    }
}
