package edu.ib;

import org.apache.commons.math3.ode.FirstOrderIntegrator;
import org.apache.commons.math3.ode.nonstiff.ClassicalRungeKuttaIntegrator;
import org.apache.commons.math3.ode.nonstiff.EmbeddedRungeKuttaIntegrator;
import org.apache.commons.math3.ode.nonstiff.EulerIntegrator;
import org.apache.commons.math3.ode.nonstiff.MidpointIntegrator;

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
//        FirstOrderIntegrator heune = new ;
//        modifiedEulerMethod.addStepHandler(new ConsoleStepper());

        //RK4
        FirstOrderIntegrator rk4 = new ClassicalRungeKuttaIntegrator(h);
        rk4.addStepHandler(new ConsoleStepper());

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        double [] x0 = {2};
        double [] x = new double[1];



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


    }
}
