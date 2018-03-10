/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinearSystems.Jacobi;

import java.util.Arrays;

/**
 *
 * @author Luisito Suarez
 */
public class JacobiAuxResult {
      private double[] solution;
      private double maxError;
      private int iteration;

    public JacobiAuxResult(double[] solution, double maxError, int iteration) {
        this.solution = solution;
        this.maxError = maxError;
        this.iteration = iteration;
    }      

    /**
     * @return the solution
     */
    public double[] getSolution() {
        return solution;
    }

    /**
     * @param solution the solution to set
     */
    public void setSolution(double[] solution) {
        this.solution = solution;
    }

    /**
     * @return the maxError
     */
    public double getMaxError() {
        return maxError;
    }

    /**
     * @param maxError the maxError to set
     */
    public void setMaxError(double maxError) {
        this.maxError = maxError;
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
      
      @Override
      public String toString(){
          return "Solucion "+Arrays.toString(solution)+" Error "+String.valueOf(maxError)+" Iteracion: "+String.valueOf(iteration)+"\n";
      }
}
