/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinearSystems.Determinant;

/**
 *
 * @author Luisito Suarez
 */
public class Determinant {

    /**
     * Calcula la el determinante de una matriz cuadrada
     *
     * @param matrix Matriz del sistema
     * @return Determinante de la matriz
     */
    public static double calculateDeterminant(double[][] matrix) {
        int n = matrix.length;//tamaño de la matriz
        int sign = 1;//signo del determinante
        for (int i = 0; i < n - 1; i++) {
            //busqueda de la fila pivote medte la estrategia parcial
            double max = Math.abs(matrix[i][i]);
            int maxRow = i;//fila pivote
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(matrix[j][i]) > max) {
                    max = Math.abs(matrix[j][i]);
                    maxRow = j;
                }
            }
            //si el pivote es cero entonces el determinante es cero
            if (max == 0) {
                return 0;
            } else if (maxRow > i) {//Intercambio de filas
                for (int h = 0; h <= n; h++) {
                    double temp = matrix[maxRow][h];
                    matrix[maxRow][h] = matrix[i][h];
                    matrix[i][h] = temp;
                }
                sign *= -1;//actualiza el signo
            }
            //transforma la matriz
            for (int k = i + 1; k < n; k++) {
                double m = matrix[k][i] / matrix[i][i];
                for (int j = 0; j < n; j++) {
                    matrix[k][j] = (matrix[k][j] - (m * matrix[i][j]));
                }
            }
        }
        //Calcula el determinante
        double determinant = sign;
        for (int i = 0; i < n; i++) {
            determinant *= matrix[i][i];
        }
        return determinant;
    }
}
