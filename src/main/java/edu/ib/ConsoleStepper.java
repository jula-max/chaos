package edu.ib;

import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.ode.sampling.StepHandler;
import org.apache.commons.math3.ode.sampling.StepInterpolator;

public class ConsoleStepper implements StepHandler {

    private double prevX;

    @Override
    public void init(double t0, double[] x0, double t) {
//        System.out.println("ROZWIAZANIE");
//        System.out.println(t0 +" "+ x0[0]);
//        prevX = x0[0];
    }

    @Override
    public void handleStep(StepInterpolator interpolator, boolean isLast) throws MaxCountExceededException {
//        double t = interpolator.getCurrentTime();
//        double[] x = interpolator.getInterpolatedState();
//
//        if(t==8)
//        System.out.println(t +" "+ x[0]);
        //double e = Math.abs(x[0]-prevX)/prevX*100;

        //System.out.println("e[%] = "+e);
        //prevX = x[0];
    }
}
