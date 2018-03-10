/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diferentials.RungeKuttaForSystems;

import java.util.List;

/**
 *
 * @author Luisito Suarez
 */
public class AuxResultRKSystems {

    private List<Double> u;
    private double xn;
    private int iteration;

    public AuxResultRKSystems(List<Double> u, double xn, int iteration) {
        this.u = u;
        this.xn = xn;
        this.iteration = iteration;
    }

    /**
     * @return the u
     */
    public List<Double> getU() {
        return u;
    }

    /**
     * @param u the u to set
     */
    public void setU(List<Double> u) {
        this.u = u;
    }

    /**
     * @return the xn
     */
    public double getXn() {
        return xn;
    }

    /**
     * @param xn the xn to set
     */
    public void setXn(double xn) {
        this.xn = xn;
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
        return "Soluciones: " + u.toString() + "  Xn " + String.valueOf(xn) + "  Iteracion  " + String.valueOf(iteration) + "\n";
    }

}
