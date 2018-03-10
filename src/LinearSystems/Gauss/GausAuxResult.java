/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinearSystems.Gauss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Luisito Suarez
 */
public class GausAuxResult {
    private double[] solutions;
    private double[] pivots;

    public GausAuxResult(double[] solution,double[] pivot) {
        this.solutions=solution;
        this.pivots=pivot;
    }

    /**
     * @return the solutions
     */
    public double[] getSolutions() {
        return solutions;
    }

    /**
     * @param solutions the solutions to set
     */
    public void setSolutions(double[] solutions) {
        this.solutions = solutions;
    }

    /**
     * @return the pivots
     */
    public double[] getPivots() {
        return pivots;
    }

    /**
     * @param pivots the pivots to set
     */
    public void setPivots(double[] pivots) {
        this.pivots = pivots;
    }
    
    
    
}
