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
public class AuxResultOptimBisect {

    private double a;
    private double b;
    private double error;
    private int evaluations;
    private double halfPoint;
    private int iteration;

    public AuxResultOptimBisect(double a, double b, double error, int evaluations, double halfpoint, int iteration) {
        this.a = a;
        this.b = b;
        this.error = error;
        this.iteration = iteration;
        this.evaluations = evaluations;
        this.halfPoint = halfpoint;
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
    public String toString() {
        return "Iteracion " + String.valueOf(iteration) + " Izquierdo: " + String.valueOf(a) + " Derecho: " + String.valueOf(b) + "\n";
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
     * @return the halfPoint
     */
    public double getHalfPoint() {
        return halfPoint;
    }

    /**
     * @param halfPoint the halfPoint to set
     */
    public void setHalfPoint(double halfPoint) {
        this.halfPoint = halfPoint;
    }
}
