package edu.ib;

import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.ode.sampling.StepHandler;
import org.apache.commons.math3.ode.sampling.StepInterpolator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ConsoleStepper implements StepHandler {

    private double prevX;

    @Override
    public void init(double t0, double[] x0, double t) {
        System.out.println("ROZWIAZANIE");
        System.out.println(t0 +" "+ x0[0]);

    }

    @Override
    public void handleStep(StepInterpolator interpolator, boolean isLast) throws MaxCountExceededException {
        double t = interpolator.getCurrentTime();
        double[] x = interpolator.getInterpolatedState();

        System.out.println(t +" "+ x[0]);
//        double e = Math.abs(x[0]-prevX)/prevX*100;
//
//        System.out.println("e[%] = "+e);
        prevX = x[0];
    }



    public void handleStep2(StepInterpolator interpolator, boolean isLast) throws MaxCountExceededException {
        double t = interpolator.getCurrentTime();
        double[] x = interpolator.getInterpolatedState();

        File file = new File("Wyniki.txt");


            try {
                if(!file.exists())
                    file.createNewFile();

                FileWriter writer = new FileWriter(file);

                writer.write(t +"\t"+ x[0]);
                writer.flush();
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        //System.out.println(t +" "+ x[0]);
//        double e = Math.abs(x[0]-prevX)/prevX*100;
//
//        System.out.println("e[%] = "+e);
        //prevX = x[0];
    }

}
