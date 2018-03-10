/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MatrixUtilities;

import java.util.Arrays;

/**
 *
 * @author Luisito
 */
public class Matrix {

    public static double[][] multiplyMatrix(double[][] a, double[][] b) {
        boolean isPosible = true;
        for (int i = 0; i < a[0].length && i < b.length; i++) {
            if (a.length != b[i].length) {
                isPosible = false;
            }
        }
        double[][] p = new double[a[0].length][b.length];
        if (isPosible) {
            double temp;
            for (int i = 0; i < a[0].length; i++) {
                for (int j = 0; j < b.length; j++) {
                    for (int t = 0; t < b[0].length; t++) {
                        temp = a[t][i] * b[j][t];
                        p[i][j] += temp;
                    }
                }
            }
            return p;
        }

        return null;
    }

    public static double[][] trasposition(double[][] matrix) {
        double[][] result = new double[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[i][j] = matrix[j][i];
            }
        }
        return result;
    }

    public static double[] vectorTimesEscalar(double[] vector, double x) {
        double[] resultVector = new double[vector.length];
        for (int i = 0; i < vector.length; i++) {
            resultVector[i] = x * vector[i];
        }
        return resultVector;
    }

    public static double[][] matrixTimesEscalar(double[][] matrix, double x) {
        double[][] resultMatrix = new double[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            resultMatrix[i] = new double[matrix[i].length];
            for (int j = 0; j < matrix[i].length; j++) {
                resultMatrix[i][j] = x * matrix[i][j];
            }
        }
        return resultMatrix;
    }

    public static double[] sumVectors(double[] a, double[] b) {
        boolean isPossible = true;
        if (a.length != b.length) {
            isPossible = false;
        }
        if (isPossible) {
            double[] res = new double[a.length];
            for (int i = 0; i < a.length; i++) {
                res[i] = a[i] + b[i];
            }
            return res;
        }
        return null;
    }

    public static double[][] sumMatrix(double[][] a, double[][] b) {
        if (a.length != b.length) {
            return null;
        }
        double[][] result = new double[a.length][];
        boolean isPossible = true;
        for (int i = 0; i < a.length && i < b.length && isPossible; i++) {
            if (a[i].length != b[i].length) {
                return null;
            } else {
                result[i] = new double[a[i].length];
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = a[i][j] + b[i][j];
                }
            }
        }
        return result;
    }

    public static double[] restVectors(double[] a, double[] b) {
        boolean isPossible = a.length == b.length;
        if (isPossible) {
            double[] res = new double[a.length];
            for (int i = 0; i < a.length; i++) {
                res[i] = a[i] + b[i];
            }
            return res;
        }
        return null;
    }

    public static double[][] restMatrix(double[][] a, double[][] b) {
        boolean isPossible = a.length == b.length;
        if (isPossible) {
            double[][] res = new double[a.length][];
            for (int i = 0; i < res.length; i++) {
                if (a[i].length != b[i].length) {
                    return null;
                } else {
                    res[i] = new double[a[i].length];
                    for (int j = 0; j < res[i].length; j++) {
                        res[i][j] = a[i][j] - b[i][j];
                    }
                }
            }
            return res;
        }
        return null;

    }

    public static void main(String[] args) {
        double[][] a = new double[][]{{-1, 4, 2, 1}};
        double[][] b = new double[][]{{1}, {3}, {5}, {7}};
        double[][] p = multiplyMatrix(a, b);
        for (int i = 0; i < p.length; i++) {
            System.out.println(Arrays.toString(p[i]));
        }
    }
}
