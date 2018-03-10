/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Roots.RegulaFalsi;

/**
 *
 * @author Luisito Suarez
 */
public class AuxRegulaFalsiResult {

    private double initLeftInterval;
    private double initRigthInterval;
    private double maxError;
    private double rootValue;
    private int iterationNumber;

    public AuxRegulaFalsiResult(double initLeftInterval, double initRigthInterval, double maxError, double rootValue, int iterationNumber) {
        this.initLeftInterval = initLeftInterval;
        this.initRigthInterval = initRigthInterval;
        this.maxError = maxError;
        this.rootValue = rootValue;
        this.iterationNumber = iterationNumber;
    }

    /**
     * @return the initLeftInterval
     */
    public double getInitLeftInterval() {
        return initLeftInterval;
    }

    /**
     * @param initLeftInterval the initLeftInterval to set
     */
    public void setInitLeftInterval(double initLeftInterval) {
        this.initLeftInterval = initLeftInterval;
    }

    /**
     * @return the initRigthInterval
     */
    public double getInitRigthInterval() {
        return initRigthInterval;
    }

    /**
     * @param initRigthInterval the initRigthInterval to set
     */
    public void setInitRigthInterval(double initRigthInterval) {
        this.initRigthInterval = initRigthInterval;
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
     * @return the rootValue
     */
    public double getRootValue() {
        return rootValue;
    }

    /**
     * @param rootValue the rootValue to set
     */
    public void setRootValue(double rootValue) {
        this.rootValue = rootValue;
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

}
