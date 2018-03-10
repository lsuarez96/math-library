/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interpolation.CurveAdjustment;

import EcuationDefinition.ExpressionEvaluator;
import LinearSystems.Gauss.Gauss;
import MatrixUtilities.Matrix;
import java.util.Arrays;

/**
 *
 * @author Luisito
 */
public class CurveAdjustment {

    /**
     * Metodo para ajuste lineal de curvas
     *
     * @param expressions Lista de expresiones g(x)
     * @param x Valores de x
     * @param y Valores de la funcion para cada valor de x
     * @return Los coeficientes lineales de cada funcion g(x)
     * @throws Exception
     */
    public static double[] adjustLinealModel(String[] expressions, double[] x, double[] y) throws Exception {
        int n = expressions.length;
        int m = x.length;
        double[] result;
        double[][] g = new double[n][m];
        System.out.println(" g");
        double[][] gaux = new double[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //ExpressionEvaluator ExpressionEvaluator = new ExpressionEvaluator(expressions[i]);
                g[i][j] = ExpressionEvaluator.evaluateExpression(expressions[i], x[j]);
                gaux[j][i] = ExpressionEvaluator.evaluateExpression(expressions[i], x[j]);
            }

        }
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(g[i]));
        }
        System.out.println("gaux");
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(gaux[i]));
        }
        // double[][] gTrasp = Matrix.trasposition(gaux);//Calcula la traspuesta de g
        double[][] product = Matrix.multiplyMatrix(gaux, g);//Producto de g por su traspuesta
        System.out.println("prod");
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(product[i]));
        }
        double[][] Y = new double[m][1];//Matriz columna de terminos independientes
        for (int i = 0; i < m; i++) {
            Y[i][0] = y[i];
        }

        double[][] gy = Matrix.multiplyMatrix(Y, g);//producto de g con y para hallar la matriz columna de term indep
        double[] GY = new double[gy[0].length];
        System.out.println("GY");
        for (int i = 0; i < gy[0].length; i++) {

            GY[i] = gy[0][i];
            System.out.println((GY[i]));
        }
        result = Gauss.solveSystemByParcialEliminationGauss(product, GY).getSolutions();//solucion del sistema por la estrategia total de Gauss
        //tambien es posible uzar estrategia parcial
        return result;
    }

}
