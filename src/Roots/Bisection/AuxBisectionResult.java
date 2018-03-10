/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Roots.Bisection;

/**
 *
 * @author Luisito Suarez
 */
public class AuxBisectionResult {

    private double initLeftInterval;
    private double initRigthInterval;
    private double initMaxError;
    private double initTolerance;
    private int iterationNumber;
    private double root;

    public AuxBisectionResult(double initLeftInterval, double initRigthInterval, double initMaxError, double initTolerance, int iterationNumber, double root) {
        this.initLeftInterval = initLeftInterval;
        this.initRigthInterval = initRigthInterval;
        this.initMaxError = initMaxError;
        this.initTolerance = initTolerance;
        this.iterationNumber = iterationNumber;
        this.root = root;
    }

    /**
     * @return the initLeftInterval
     */
    public double getInitLeftInterval() {
        return initLeftInterval;
    }

    /**
     * @param aInitLeftInterval the initLeftInterval to set
     */
    public void setInitLeftInterval(double aInitLeftInterval) {
        initLeftInterval = aInitLeftInterval;
    }

    /**
     * @return the initRigthInterval
     */
    public double getInitRigthInterval() {
        return initRigthInterval;
    }

    /**
     * @param aInitRigthInterval the initRigthInterval to set
     */
    public void setInitRigthInterval(double aInitRigthInterval) {
        initRigthInterval = aInitRigthInterval;
    }

    /**
     * @return the initMaxError
     */
    public double getInitMaxError() {
        return initMaxError;
    }

    /**
     * @param aInitMaxError the initMaxError to set
     */
    public void setInitMaxError(double aInitMaxError) {
        initMaxError = aInitMaxError;
    }

    /**
     * @return the initTolerance
     */
    public double getInitTolerance() {
        return initTolerance;
    }

    /**
     * @param aInitTolerance the initTolerance to set
     */
    public void setInitTolerance(double aInitTolerance) {
        initTolerance = aInitTolerance;
    }

    /**
     * @return the iterationNumber
     */
    public int getIterationNumber() {
        return iterationNumber;
    }

    /**
     * @param aIterationNumber the iterationNumber to set
     */
    public void setIterationNumber(int aIterationNumber) {
        iterationNumber = aIterationNumber;
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
    
    @Override
    public String toString(){
        return "Raiz: "+String.valueOf(root)+"Error :"+String.valueOf(initMaxError)+" Intervalo inicio: "+String.valueOf(initLeftInterval)+" Intervalo fin: "+String.valueOf(initRigthInterval)+"Iteracion: "+String.valueOf(iterationNumber)+"\n";
    }
}
