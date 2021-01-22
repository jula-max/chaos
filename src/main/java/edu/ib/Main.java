package edu.ib;

import org.apache.commons.math3.ode.FirstOrderIntegrator;
import org.apache.commons.math3.ode.nonstiff.*;

import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println();

        SimpleODE simple = new SimpleODE();
        double t = 4;
        double h = 0.05;
        FirstOrderIntegrator eulerIntegrator= new EulerIntegrator(h);
        eulerIntegrator.addStepHandler(new ConsoleStepper());

        //modified euler
        FirstOrderIntegrator modifiedEulerMethod = new MidpointIntegrator(h);
        modifiedEulerMethod.addStepHandler(new ConsoleStepper());

        //heuna
//        double[] c = {0.0, 1.0};
//        double[][]a = {{0.0, 0.0},{1.0, 0.0}};
//        double[]b={1.0/2.0, 1.0/2.0};
//        FirstOrderIntegrator heun = new RungeKuttaIntegrator
//                ("heun",c , a, b,
//                        new ClassicalRungeKuttaStepInterpolator(),h);
        //modifiedEulerMethod.addStepHandler(new ConsoleStepper());

        //RK4
        FirstOrderIntegrator rk4 = new ClassicalRungeKuttaIntegrator(h);
        rk4.addStepHandler(new ConsoleStepper());



        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        double [] x0 = {2};
        double [] x = new double[1];

        rk4.integrate(simple, 0, x0, t, x);
        System.out.println( x[0]+"\t");

        for(double i = 0.05; i>0.0001; i*=0.5){

            eulerIntegrator= new EulerIntegrator(i);
            modifiedEulerMethod = new MidpointIntegrator(i);
            rk4 = new ClassicalRungeKuttaIntegrator(i);

            System.out.print(i+"\t");

            eulerIntegrator.integrate(simple, 0, x0, t, x);
            System.out.print( x[0]+"\t");


            modifiedEulerMethod.integrate(simple, 0, x0, t, x);
            System.out.print( x[0]+"\t");


            rk4.integrate(simple, 0, x0, t, x);
            System.out.println( x[0]+"\t");

        }
//        double X0=2;
//        double X;
//        for(double t0=0; t0<=(4-h);t0+=h){
//            X=heunMethod(h,t0,X0,t0+h);
//            System.out.println(t0+h+"\t"+X);
//        }



    }

    public static double heunMethod( double h, double t0, double x0, double t){
        return x0 +
                h*
                        (4*Math.exp(0.8*t0)-0.5*x0
                                +4*Math.exp(0.8*t)-0.5*(x0+h*(4*Math.exp(0.8*t0)-0.5*x0)
                        ))/2 ;
    }
}
