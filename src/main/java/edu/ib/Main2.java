package edu.ib;

import org.apache.commons.math3.ode.FirstOrderIntegrator;
import org.apache.commons.math3.ode.nonstiff.ClassicalRungeKuttaIntegrator;
import org.apache.commons.math3.ode.nonstiff.EulerIntegrator;

public class Main2 {
    public static void main(String[] args) {
        HarmonicOscillator oscillator = new HarmonicOscillator(1.0);
        Pohl oscillator2 = new Pohl(1.0);
        FirstOrderIntegrator euler = new EulerIntegrator(0.001);
        FirstOrderIntegrator rk4 = new ClassicalRungeKuttaIntegrator(0.001);

        double[] x0 = {1, 0};
        double[] x = new double[2];
        rk4.addStepHandler(new ConsoleStepper());
        rk4.integrate(oscillator2, 0, x0, 50, x);
        System.out.println(x[0]+"\t"+x[1]);
    }
}
