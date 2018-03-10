/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Roots.Secant;

/**
 *
 * @author Luisito Suarez
 */
public class AuxSecantResult {

    private double value;
    private double maxErr;
    private double initLeftExtreme;
    private double initRigthExtreme;
    private int iterationsNumber;

    public AuxSecantResult(double initLeftExtreme, double initRigthExtreme, double maxErr, double value, int iterationsNumber) {
        this.value = value;
        this.maxErr = maxErr;
        this.initLeftExtreme = initLeftExtreme;
        this.initRigthExtreme = initRigthExtreme;
        this.iterationsNumber = iterationsNumber;
    }

    /**
     * @return the value
     */
    public double getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * @return the maxErr
     */
    public double getMaxErr() {
        return maxErr;
    }

    /**
     * @param maxErr the maxErr to set
     */
    public void setMaxErr(double maxErr) {
        this.maxErr = maxErr;
    }

    /**
     * @return the initLeftExtreme
     */
    public double getInitLeftExtreme() {
        return initLeftExtreme;
    }

    /**
     * @param initLeftExtreme the initLeftExtreme to set
     */
    public void setInitLeftExtreme(double initLeftExtreme) {
        this.initLeftExtreme = initLeftExtreme;
    }

    /**
     * @return the initRigthExtreme
     */
    public double getInitRigthExtreme() {
        return initRigthExtreme;
    }

    /**
     * @param initRigthExtreme the initRigthExtreme to set
     */
    public void setInitRigthExtreme(double initRigthExtreme) {
        this.initRigthExtreme = initRigthExtreme;
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

}
