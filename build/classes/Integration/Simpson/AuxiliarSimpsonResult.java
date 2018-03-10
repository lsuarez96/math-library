/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Integration.Simpson;

/**
 *
 * @author Luisito Suarez
 */
public class AuxiliarSimpsonResult {
    private double maxError,result;

    public AuxiliarSimpsonResult(double maxError, double result) {
        this.maxError = maxError;
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
     * @return the result
     */
    public double getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(double result) {
        this.result = result;
    }
    
    @Override
    public String toString(){
        return "Resultado: "+String.valueOf(result)+" Error: "+String.valueOf(maxError)+"\n";
    }
}
