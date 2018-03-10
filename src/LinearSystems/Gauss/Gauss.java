/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinearSystems.Gauss;

/**
 *
 * @author Luisito Suarez
 */
public class Gauss {

    /**
     * Metodo para el calculo de incognitas en un sistema de ecuaciones lineales
     * sin el uso de pivotes
     *
     * @param matrix Matriz de incognitas
     * @param b lista de soluciones
     * @return lista de los valores de las incognitas o solucion del sistema
     */
    public static double[] solveSystemByEliminationGauss(double[][] matrix, double[] b) {

        int n = matrix.length;//tamaño de la matriz 
        double[] s = new double[n];//lista de soluciones
        double[][] amp = new double[n][n + 1];//matriz ampliada
        //Construccion de la matriz ampliada
        for (int i = 0; i < n; i++) {
            System.arraycopy(matrix[i], 0, amp[i], 0, n);
            amp[i][n] = b[i];
        }
        int i, j, k;//variables auxiliares
        double cte;//multiplicador para realizar las transformaciones elementales a la matriz ampliada
        for (i = 0; i < n - 1; i++) {
            for (j = i + 1; j < n; j++) {
                cte = (-amp[j][i]) / (amp[i][i]);//calculo del multiplicador
                for (k = i; k < n + 1; k++) {
                    amp[j][k] = ((amp[i][k] * cte)) + amp[j][k];//transformacion de la matriz ampliada
                }
            }
        }
        //proceso inverso para hallar las soluciones del sistema
        //es inverso porque se hallan las solucioes de abajo hacia arriba
        i = n - 1;
        while (i >= 0) {//Calculo de la solucion            
            s[i] = amp[i][n];
            for (j = i + 1; j < n; j++) {
                s[i] = s[i] - amp[i][j] * s[j];
            }
            s[i] = s[i] / amp[i][i];
            i--;
        }
        return s;
    }

    /**
     * Metodo para el calculo de incognitas en un sistema de ecuaciones lineales
     * mediante la estrategia de pivote elemental
     *
     * @param matrix matriz del sistema
     * @param b soluciones del sistema
     * @return lista de valores de las incognitas y de los pivotes usados
     */
    public static GausAuxResult solveSystemByElementaryEliminationGauss(double[][] matrix, double[] b) {

        int n = matrix.length;//tamaño de la matriz
        double[] s = new double[n];//lista de soluciones del sistema
        double[] p = new double[n];//lista de elementos pivotes de la matriz
        double[][] amp = new double[n][n + 1];//matriz ampliada
        //construccion de la matriz ampliada
        for (int i = 0; i < n; i++) {
            System.arraycopy(matrix[i], 0, amp[i], 0, n);
            amp[i][n] = b[i];
        }
        int i, j, k;//variables auxiliares
        double cte;//coeficiente de multiplicacion para transformaciones elementales en la matriz ampliada
        for (i = 0; i < n - 1; i++) {
            //seleccionar fila pivote mediante el metodo elemental
            if (amp[i][i] == 0) {//si el elemento de la diagonal de la fila es cero
                k = i;
                while (amp[k][i] != 0 || k > n) {
                    k++;
                }
                if (k > n) {
                    return null;
                } else {
                    //si el elemento de la diagonal de la fila seleccionada como pivote no es cero
                    //realiza el intercambio de filas
                    for (int h = 0; h <= n; h++) {
                        double temp = amp[k][h];
                        amp[k][h] = amp[i][h];
                        amp[i][h] = temp;
                    }
                }

            }
            //transformacion de la matriz ampliada una vez encontrada la fila pivote
            for (j = i + 1; j < n; j++) {
                cte = (-amp[j][i]) / (amp[i][i]);
                for (k = i; k < n + 1; k++) {
                    amp[j][k] = ((amp[i][k] * cte)) + amp[j][k];

                }
            }

        }
        //actualizar los elementos pivotes
        for (i = 0; i < n; i++) {
            p[i] = amp[i][i];
        }
        //realizar el proceso inverso
        i = n - 1;
        while (i >= 0) {
            s[i] = amp[i][n];
            for (j = i + 1; j < n; j++) {
                s[i] = s[i] - amp[i][j] * s[j];

            }
            s[i] = s[i] / amp[i][i];
            i--;
        }
        GausAuxResult r = new GausAuxResult(s, p);
        return r;
    }

    /**
     * Metodo para el calculo de incognitas en un sistema de ecuaciones lineales
     * mediante la estrategia de pivote parcial
     *
     * @param matrix matriz del sistema
     * @param b soluciones del sistema
     * @return lista de valores de las incognitas y de los pivotes usados
     */
    public static GausAuxResult solveSystemByParcialEliminationGauss(double[][] matrix, double[] b) {

        int n = matrix.length;//tamaño de la matriz
        double[] s = new double[n];//lista de soluciones
        double[] p = new double[n];//lista de elementos pivotes
        double[][] amp = new double[n][n + 1];//matriz ampliada
        //contruccio de la matriz ampliada
        for (int i = 0; i < n; i++) {
            System.arraycopy(matrix[i], 0, amp[i], 0, n);
            amp[i][n] = b[i];
        }
        int i, j, k;//variables auxiliares

        double cte;//coeficiente de multiplicacion
        for (i = 0; i < n; i++) {
            //Seleccion de la fila pivote mdte el metodo parcial
            double max = Math.abs(amp[i][i]);//maximo elemento de la columna y elemento pivote
            int maxRow = i;//indice de la fila pivote
            for (k = i + 1; k < n; k++) {//busqueda del mayor elemento
                if (Math.abs(amp[k][i]) > max) {
                    max = amp[k][i];
                    maxRow = k;
                }
            }
            p[i] = amp[maxRow][i];//agregar el elemento pivote a la lista de pivotes
            //Realiza el intercambio de filas correspondiente
            if (maxRow > i) {//No tiene sentido hacerlo si k=i
                for (int h = 0; h <= n; h++) {
                    double temp = amp[maxRow][h];
                    amp[maxRow][h] = amp[i][h];
                    amp[i][h] = temp;
                }
            }
            //Transformando la matriz ampliada
            for (j = i + 1; j < n; j++) {
                cte = (-amp[j][i]) / (amp[i][i]);
                for (k = i; k < n + 1; k++) {
                    amp[j][k] = ((amp[i][k] * cte)) + amp[j][k];

                }
            }

        }
        //Proceso inverso
        i = n - 1;
        while (i >= 0) {//calculo de las soluciones de abajo hacia arriba
            s[i] = amp[i][n];
            for (j = i + 1; j < n; j++) {
                s[i] = s[i] - amp[i][j] * s[j];

            }
            s[i] = s[i] / amp[i][i];
            i--;
        }
        GausAuxResult r = new GausAuxResult(s, p);
        return r;
    }
    
    public static GausAuxResult solveLinearSystem(double[][] matrix, double[] b,Estrategy estrategy){
        if(estrategy==Estrategy.ELEMENTARY){
            return solveSystemByElementaryEliminationGauss(matrix, b);
        }else if(estrategy==Estrategy.PARCIAL){
            return solveSystemByParcialEliminationGauss(matrix, b);
        }
        return null;
    }
}
