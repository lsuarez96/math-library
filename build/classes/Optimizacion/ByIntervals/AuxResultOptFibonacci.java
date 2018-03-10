/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Optimizacion.ByIntervals;

/**
 *
 * @author Luisito
 */
public class AuxResultOptFibonacci extends AuxResultOptimBisect {
    private double a;
    private double b;
    private int evaluations;
    private int iteration;
    private double error;
    private double factor;

    public AuxResultOptFibonacci(double a, double b, int evaluations, int iteration, double error, double factor) {
        super(a, b, error, evaluations, factor, iteration);       
    }
    
    

    /**
     * @return the a
     */
    public double getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(double a) {
        this.a = a;
    }

    /**
     * @return the b
     */
    public double getB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(double b) {
        this.b = b;
    }

    /**
     * @return the evaluations
     */
    public int getEvaluations() {
        return evaluations;
    }

    /**
     * @param evaluations the evaluations to set
     */
    public void setEvaluations(int evaluations) {
        this.evaluations = evaluations;
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
     * @return the error
     */
    public double getError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(double error) {
        this.error = error;
    }

    /**
     * @return the factor
     */
    public double getFactor() {
        return factor;
    }

    /**
     * @param factor the factor to set
     */
    public void setFactor(double factor) {
        this.factor = factor;
    }
    
    
}
