/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diferentials.Euler;

/**
 *
 * @author Luisito Suarez
 */
public class AuxEulerResult {
    private int iteration;
    private double xn;
    private double yn;

    public AuxEulerResult(int iteration, double xn, double yn) {
        this.iteration = iteration;
        this.xn = xn;
        this.yn = yn;
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
     * @return the yn
     */
    public double getYn() {
        return yn;
    }

    /**
     * @param yn the yn to set
     */
    public void setYn(double yn) {
        this.yn = yn;
    }
    
    @Override
    public String toString(){
        return "Xn: "+String.valueOf(xn)+" Yn: "+String.valueOf(yn)+" Iteracion: "+String.valueOf(iteration)+"\n";
    }
}
