/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diferentials.RungeKutta;

/**
 *
 * @author Luisito Suarez
 */
public class AuxRungeKuttaResult {

    private double x0;
    private double y0;
    private double h;
    private int iteration;

    public AuxRungeKuttaResult(double x0, double y0, double h, int iteration) {
        this.x0 = x0;
        this.y0 = y0;
        this.h = h;
        this.iteration = iteration;

    }

    /**
     * @return the x0
     */
    public double getX0() {
        return x0;
    }

    /**
     * @param x0 the x0 to set
     */
    public void setX0(double x0) {
        this.x0 = x0;
    }

    /**
     * @return the y0
     */
    public double getY0() {
        return y0;
    }

    /**
     * @param y0 the y0 to set
     */
    public void setY0(double y0) {
        this.y0 = y0;
    }

    /**
     * @return the h
     */
    public double getH() {
        return h;
    }

    /**
     * @param h the h to set
     */
    public void setH(double h) {
        this.h = h;
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
    @Override
    public String toString() {
        return "Iter: " + String.valueOf(iteration) + "X: " + String.valueOf(x0) + "Y: " + String.valueOf(y0) + "\n";
    }

}
