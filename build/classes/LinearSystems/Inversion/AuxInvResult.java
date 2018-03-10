/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinearSystems.Inversion;

import java.util.Arrays;

/**
 *
 * @author Luisito Suarez
 */
public class AuxInvResult {

    private double[][] invertedMatrix;
    private double[] pivots;

    public AuxInvResult(double[][] invertedMatrix, double[] pivots) {
        this.invertedMatrix = invertedMatrix;
        this.pivots = pivots;
    }

    /**
     * @return the invertedMatrix
     */
    public double[][] getInvertedMatrix() {
        return invertedMatrix;
    }

    /**
     * @param invertedMatrix the invertedMatrix to set
     */
    public void setInvertedMatrix(double[][] invertedMatrix) {
        this.invertedMatrix = invertedMatrix;
    }

    /**
     * @return the pivots
     */
    public double[] getPivots() {
        return pivots;
    }

    /**
     * @param pivots the pivots to set
     */
    public void setPivots(double[] pivots) {
        this.pivots = pivots;
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < invertedMatrix.length; i++) {
            res += "\n" + Arrays.toString(invertedMatrix[i]);
        }
        return "Solucion: \n" + res + " \n Pivotes: \n" + Arrays.toString(pivots);
    }

}
