/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiDimensionalOptimization;

import MatrixUtilities.Matrix;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Luisito
 */
public class SearchByCoordinates {

    /**
     *
     * @param expression
     * @param x0
     * @param tolerance
     * @return
     * @throws Exception
     */
    public static List<AuxCoordinatesResult> searchByCoordinates(String expression, double[] x0, double tolerance) throws Exception {
        List<AuxCoordinatesResult> resList = new LinkedList<>();
        int iterations = 0;
        double lambda = 0, lambdaMax = 0;
        double[] xn = x0;
        do {
            //lambda = 0;
            for (int i = 0; i < x0.length; i++) {
                double[] dirVector = new double[x0.length];
                for (int j = 0; j < x0.length; j++) {
                    dirVector[j] = 0;
                }
                dirVector[i] = 1;
                lambda = OneWayOptim.maxUnidim(expression, x0, dirVector, tolerance);
                if (lambda < 0) {
                    dirVector[i] = -1;
                    lambda = OneWayOptim.maxUnidim(expression, x0, dirVector, tolerance);
                    if (lambda < 0) {
                        lambda = 0;
                    }

                }
                if (lambda >= lambdaMax) {
                    lambdaMax = lambda;
                }
                xn = Matrix.sumVectors(x0, Matrix.vectorTimesEscalar(dirVector, lambdaMax));
            }
            x0 = Arrays.copyOf(xn, xn.length);
            iterations++;
            resList.add(new AuxCoordinatesResult(iterations, Arrays.copyOf(xn, xn.length)));
            System.out.println(resList.get(iterations - 1));
        } while (lambda > lambdaMax);
        return resList;
    }

}
