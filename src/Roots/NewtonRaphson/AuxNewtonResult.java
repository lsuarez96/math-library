/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Roots.NewtonRaphson;

/**
 *
 * @author Luisito Suarez
 */
public class AuxNewtonResult {
    private double maxError;
    private double root;
    private int iterationNumber;
    private double initialValue;
    
    public AuxNewtonResult(double root,double initialValue,double maxError,int iterationNumber){
        this.initialValue=initialValue;
        this.root=root;
        this.maxError=maxError;
        this.iterationNumber=iterationNumber;
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
     * @return the root
     */
    public double getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(double root) {
        this.root = root;
    }

    /**
     * @return the iterationNumber
     */
    public int getIterationNumber() {
        return iterationNumber;
    }

    /**
     * @param iterationNumber the iterationNumber to set
     */
    public void setIterationNumber(int iterationNumber) {
        this.iterationNumber = iterationNumber;
    }

    /**
     * @return the initialValue
     */
    public double getInitialValue() {
        return initialValue;
    }

    /**
     * @param initialValue the initialValue to set
     */
    public void setInitialValue(double initialValue) {
        this.initialValue = initialValue;
    }
    
    @Override
     public String toString(){
        return "Raiz: "+String.valueOf(root)+"Error :"+String.valueOf(maxError)+" Intervalo inicio: "+String.valueOf(initialValue)+"Iteracion: "+String.valueOf(iterationNumber)+"\n";
    }
}
