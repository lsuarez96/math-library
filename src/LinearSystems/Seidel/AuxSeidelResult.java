/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinearSystems.Seidel;

import java.util.Arrays;

/**
 *
 * @author Luisito Suarez
 */
public class AuxSeidelResult {
    private double[] result;
    private double maxError;
    private int iterationsNumber;
    private double maxDiference;
    private double convergenceFactor;

    public AuxSeidelResult(double[] result, double maxError,double maxDiference, double convergenceFactor,int iterationsNumber) {
        this.result = result;
        this.maxError = maxError;
        this.iterationsNumber = iterationsNumber;
        this.maxDiference=maxDiference;
        this.convergenceFactor=convergenceFactor;
    }
    
    

    /**
     * @return the result
     */
    public double[] getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(double[] result) {
        this.result = result;
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
     * @return the iterationsNumber
     */
    public int getIterationsNumber() {
        return iterationsNumber;
    }

    /**
     * @param iterationsNumber the iterationsNumber to set
     */
    public void setIterationsNumber(int iterationsNumber) {
        this.iterationsNumber = iterationsNumber;
    }
    
    @Override
    public String toString(){
        return "Soluciones: "+Arrays.toString(result)+"  Error: "+String.valueOf(maxError)+" maxima diferencia "+String.valueOf(maxDiference)+"  Iteracion: "+String.valueOf(iterationsNumber)+"\n";
    }

    /**
     * @return the maxDiference
     */
    public double getMaxDiference() {
        return maxDiference;
    }

    /**
     * @param maxDiference the maxDiference to set
     */
    public void setMaxDiference(double maxDiference) {
        this.maxDiference = maxDiference;
    }

    /**
     * @return the convergenceFactor
     */
    public double getConvergenceFactor() {
        return convergenceFactor;
    }

    /**
     * @param convergenceFactor the convergenceFactor to set
     */
    public void setConvergenceFactor(double convergenceFactor) {
        this.convergenceFactor = convergenceFactor;
    }
}
