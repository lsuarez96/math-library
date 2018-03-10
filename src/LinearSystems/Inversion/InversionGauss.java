/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinearSystems.Inversion;

/**
 *
 * @author Luisito Suarez
 */
public class InversionGauss {

    /**
     * Calcula la matriz invertida mediante el metodo de Gauss
     *
     * @param matrix Una matriz cuadrada
     * @return La matriz invertida y la lista de elementos pivotes
     */
    @SuppressWarnings("ManualArrayToCollectionCopy")
    public AuxInvResult inversionByGaussMethod(double[][] matrix) {
        double[][] identicMatrix, auxMatrix, resultMatrix;//matriz identica correspondiente,ampliacion de la matriz con la matriz identica y la matriz resultante respectivamente
        double[] pivotsList;//lista de elementos pivote
        int n = matrix.length;//tamaño de la matriz del sistema
        int nA = 2 * n;//cantidad de columnas de la matriz ampliada
        resultMatrix = new double[n][n];
        auxMatrix = new double[n][nA];
        identicMatrix = new double[n][n];
        pivotsList = new double[n];
        //construccion de la matriz identica y parte de la ampliada
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    identicMatrix[i][j] = 1;
                } else {
                    identicMatrix[i][j] = 0;
                }
                auxMatrix[i][j] = matrix[i][j];
            }

        }
        //agregando los elementos de la matriz identica a la ampliada
        int p;
        for (int i = 0; i < n; i++) {
            p = 0;
            for (int j = n; j < nA && p < n; j++) {
                auxMatrix[i][j] = identicMatrix[i][p];
                p++;
            }

        }

        for (int i = 0; i < n - 1; i++) {
            //busqueda de la fila pivote mediante la estrategia parcial
            double max = Math.abs(auxMatrix[i][i]);
            int maxRow = i;
            for (int k = i + 1; k < n; k++) {
                if (Math.abs(auxMatrix[k][i]) > max) {
                    max = Math.abs(auxMatrix[k][i]);
                    maxRow = k;
                }
            }
            pivotsList[i] = max;//almacenando los elementos pivote
            if (maxRow > i) {//Intercambiando filas(No tiene sentido hacerlo si maxRow es i, esto significa que la pivote es ella)
                for (int h = 0; h <= nA; h++) {
                    double temp = auxMatrix[maxRow][h];
                    auxMatrix[maxRow][h] = auxMatrix[i][h];
                    auxMatrix[i][h] = temp;
                }
            }
            //transformando la matriz ampliada
            for (int k = i + 1; k < n; k++) {
                double m = auxMatrix[k][i] / auxMatrix[i][i];
                for (int j = 0; j < nA; j++) {
                    auxMatrix[k][j] = (auxMatrix[k][j] - (m * auxMatrix[i][j]));
                }
            }
        }

        //Proceso inverso para hallar la solucion
        for (int j = 0; j < n; j++) {
            int i = n - 1;
            while (i >= 0) {
                resultMatrix[i][j] = auxMatrix[i][n + j];
                for (int k = i + 1; k < n; k++) {
                    resultMatrix[i][j] = resultMatrix[i][j] - (auxMatrix[i][k] * resultMatrix[k][j]);
                }
                resultMatrix[i][j] = resultMatrix[i][j] / auxMatrix[i][i];
                i--;
            }
        }
        AuxInvResult r = new AuxInvResult(resultMatrix, pivotsList);
        return r;
    }
}
