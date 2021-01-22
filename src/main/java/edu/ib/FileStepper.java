package edu.ib;

import org.apache.commons.math3.ode.sampling.StepHandler;
import org.apache.commons.math3.ode.sampling.StepInterpolator;

public class FileStepper implements StepHandler {
    @Override
    public void init(double t0, double[] x0, double t) {
        System.out.println("ROZWIAZANIE");
        System.out.println(t0 +" "+ x0[0]);
    }

    @Override
    public void handleStep(StepInterpolator interpolator, boolean isLast) {

    }
}
