import functions.*;

public class FunctionTest2 {

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
        System.out.println( "Integral from 0 to 10 with 10 traps (Approximately): " + iResult );
        iResult = test1.integral( 0.0, 10.0, 100 );
        System.out.println( "Integral from 0 to 10 with 100 traps (Approximately): " + iResult + "\n" );

        Function test2 = new
                Product( new Product(var ,new Constant(2.0)));
        System.out.println( "Function " + test2 );
        System.out.println( "Value at 0: " + test2.evaluate( 0.0 ) );
        System.out.println( "Value at 10: " + test2.evaluate( 10.0 ) );
        System.out.println( "Derivative: " + test2.derivative() );
        iResult = 0.0;
        iResult = test2.integral( 0.0, 4.0, 7 );
        System.out.println( "Integral from 0 to 4 with 7 traps (Approximately): " + iResult + "\n");

        Function test3 =
                new Product(var, var, var, var, new Constant(14.0));
        System.out.println( "Function " + test3 );
        System.out.println( "Value at 0: " + test3.evaluate( 0.0 ) );
        System.out.println( "Value at 10: " + test3.evaluate( 10.0 ) );
        System.out.println( "Derivative: " + test3.derivative() );
        iResult = 0.0;
        iResult = test3.integral( 9.0, 15.0, 200 );
        System.out.println( "Integral from 9 to 15 with 200 traps (Approximately): " + iResult + "\n");

        Function test4 =
                new Product(var, var, new Sine(new Product(var, new Constant(2.0))));
        System.out.println( "Function " + test4 );
        System.out.println( "Value at 0: " + test4.evaluate( 0.0 ) );
        System.out.println( "Value at 10: " + test4.evaluate( 10.0 ) );
        System.out.println( "Derivative: " + test4.derivative() );
        iResult = 0.0;
        iResult = test4.integral( 0.0, 15.0, 200 );
        System.out.println( "Integral from 0 to 15 with 200 traps (Approximately): " + iResult + "\n");

        Function test5 =
                new Product(new Constant(2.0), new Sine(var), new Constant(3.0));
        System.out.println( "Function " + test5 );
        System.out.println( "Value at 0: " + test5.evaluate( 0.0 ) );
        System.out.println( "Value at 10: " + test5.evaluate( 10.0 ) );
        System.out.println( "Derivative: " + test5.derivative() );
        iResult = 0.0;
        iResult = test5.integral( 0.0, 10.0, 200 );
        System.out.println( "Integral from 0 to 10 with 200 traps (Approximately): " + iResult + "\n");
    }
}

/* EXPECTED OUTPUT
 Function ( ( x * x ) + ( x * 2.0 ) + 1.0 )
Value at 0: 1.0
Value at 10: 121.0
Derivative: ( ( x + x ) + 2.0 )
Integral from 0 to 10 with 10 traps (Approximately): 445.0
Integral from 0 to 10 with 100 traps (Approximately): 443.35

Function ( x * 2.0 )
Value at 0: 0.0
Value at 10: 20.0
Derivative: 2.0
Integral from 0 to 4 with 7 traps (Approximately): 16

Function ( x * x * x * x * 14.0 )
Value at 0: 0.0
Value at 10: 140000.0
Derivative: ( ( x * x * x * 14.0 ) + ( x * x * x * 14.0 ) + ( x * x * x * 14.0 ) + ( x * x * x * 14.0 ) )
Integral from 9 to 15 with 200 traps (Approximately): 1960923

Function ( x * x * sin( ( x * 2.0 ) ) )
Value at 0: 0.0
Value at 10: 91.29452507276277
Derivative: ( ( x * sin( ( x * 2.0 ) ) ) + ( x * sin( ( x * 2.0 ) ) ) + ( x * x * ( cos( ( x * 2.0 ) ) * 2.0 ) ) )
Integral from 0 to 15 with 200 traps (Approximately): -24

Function ( sin( x ) * 6.0 )
Value at 0: 0.0
Value at 10: -3.2641266653362186
Derivative: ( cos( x ) * 6.0 )
Integral from 0 to 10 with 200 traps (Approximately): 11
*/
