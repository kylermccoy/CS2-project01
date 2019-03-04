/**
 * FunctionTest1.java
 * Author: Kyle McCoy krm7269@rit.edu
 * CS Project 1
 * test functions for equations based on the part 1 implementation
 */

import functions.* ;

public class FunctionTest1 {

    public static void main( String[] args ) {
        if ( args.length != 0 ) {
            System.err.println( "FnTest0 takes no command line arguments." );
            System.exit( 1 );
        }
        Variable var = Variable.X;
        // test 1
        Function test1 = new
                Sum( var, var );
        System.out.println( "Function " + test1 );
        System.out.println( "Value at 0: " + test1.evaluate( 0.0 ) );
        System.out.println( "Value at 100: " + test1.evaluate( 100.0 ) );
        System.out.println( "Derivative: " + test1.derivative() );
        double iResult = 0.0;
        iResult = test1.integral( 10, 20, 1000000 );
        System.out.println( "Integral from 0 to 10: " + iResult + "\n" );
        // test 2
        Function test2 = new
                Sum( new Constant(0.0), var);
        System.out.println( "Function " + test2 );
        System.out.println( "Value at 5: " + test2.evaluate( 5.0 ) );
        System.out.println( "Value at 15: " + test2.evaluate( 15.0 ) );
        System.out.println( "Derivative: " + test2.derivative() );
        iResult = 0.0;
        iResult = test2.integral( 5, 25, 1000000 );
        System.out.println( "Integral from 5 to 25: " + iResult + "\n" );
        // test 3
        Function test3 = new
                Sum( new Constant(-99.0), var, var, new Constant(-24.00));
        System.out.println( "Function " + test3 );
        System.out.println( "Value at -10: " + test3.evaluate( -10.0 ) );
        System.out.println( "Value at 25: " + test3.evaluate( 25.0 ) );
        System.out.println( "Derivative: " + test3.derivative() );
        iResult = 0.0;
        iResult = test3.integral( -15, 5, 1000000 );
        System.out.println( "Integral from -15 to 5: " + iResult + "\n" );
        // test 4
        Function test4 = new
                Sum( new Constant(-15.0), new Constant(15.0));
        System.out.println( "Function " + test4 );
        System.out.println( "Value at -1: " + test4.evaluate( -1.0 ) );
        System.out.println( "Value at 1: " + test4.evaluate( 1.0 ) );
        System.out.println( "Derivative: " + test4.derivative() );
        iResult = 0.0;
        iResult = test4.integral( -1, 1, 1000000 );
        System.out.println( "Integral from -1 to 1: " + iResult + "\n" );
        // test 5
        Function test5 = new
                Sum( new Constant(-15.0), new Constant(15.0), var);
        System.out.println( "Function " + test5 );
        System.out.println( "Value at -15: " + test5.evaluate( -15.0 ) );
        System.out.println( "Value at 15: " + test5.evaluate( 15.0 ) );
        System.out.println( "Derivative: " + test5.derivative() );
        iResult = 0.0;
        iResult = test5.integral( -15, 15, 1000000 );
        System.out.println( "Integral from -15 to 15: " + iResult + "\n" );
        // test 6
        Function test6 = new
                Sum( new Product(new Constant(-1.0), var), var);
        System.out.println( "Function " + test6 );
        System.out.println( "Value at -15: " + test6.evaluate( -15.0 ) );
        System.out.println( "Value at 15: " + test6.evaluate( 15.0 ) );
        System.out.println( "Derivative: " + test6.derivative() );
        iResult = 0.0;
        iResult = test6.integral( -15, 15, 1000000 );
        System.out.println( "Integral from -15 to 15: " + iResult + "\n" );
    }
}
/* EXPECTED OUTPUT
Function ( x + x )
Value at 0: 0.0
Value at 100: 200.0
Derivative: 2.0
Integral from 0 to 10: 300.0

Function x
Value at 5: 5.0
Value at 15: 15.0
Derivative: 1.0
Integral from 5 to 25: 300.0

Function ( x + x + -123.0 )
Value at -10: -143.0
Value at 25: -73.0
Derivative: 2.0
Integral from -15 to 5: -2660.0

Function 0.0
Value at -1: 0.0
Value at 1: 0.0
Derivative: 0.0
Integral from -1 to 1: 0.0

Function x
Value at -15: -15.0
Value at 15: 15.0
Derivative: 1.0
Integral from -15 to 15: 0.0
*/