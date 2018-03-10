/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiDimensionalOptimization;

import java.util.Arrays;

/**
 *
 * @author Luisito
 */
public class AuxCoordinatesResult {
    private int iteration;
    private double maxX;
    private double xn[];

    public AuxCoordinatesResult(int iteration, double maxX) {
        this.iteration = iteration;
        this.maxX = maxX;
    }
    
    public AuxCoordinatesResult(int iteration,double[] xn){
        this.xn=xn;
        this.iteration=iteration;
    }

    /**
     * @return the iteration
     */
    public int getIteration() {
        return iteration;
    }

    /**
     * @param iteration the iteration to set
     */
    public void setIteration(int iteration) {
        this.iteration = iteration;
    }

    /**
     * @return the maxX
     */
    public double getMaxX() {
        return maxX;
    }

    /**
     * @param maxX the maxX to set
     */
    public void setMaxX(double maxX) {
        this.maxX = maxX;
    }
    
    public String toString(){
        return "iter " + String.valueOf(iteration)+"value "+String.valueOf(Arrays.toString(xn))+"\n";
    }
}
