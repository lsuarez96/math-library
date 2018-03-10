/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diferentials.RungeKutta;

import EcuationDefinition.ExpressionEvaluator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luisito Suarez & Daniel David Acosta
 */
public class RungeKutta {

    /**
     * Metodo Runge-Kutta de orden 2: Metodo que brinda una solucion aproximada
     * al problema de Cauchy
     *
     * @param expression Representacion de la expresion matematica
     * @param x0 parametro x0 de la condicion inicial
     * @param y0 parametro y0 de la condicion inicial
     * @param xf valor final de x(ultimo valor de x para el cual se va a evaluar
     * la formula Runge-Kutta)
     * @param h paso
     * @return La solucion aproximada para cada valor de x desde x0 hasta xf
     * @throws Exception Si la expresion no se pudo parsear correctamente
     */
    public static List<AuxRungeKuttaResult> solveDiferentialByRK2(String expression, double x0, double y0, double xf, double h) throws Exception {
        List<AuxRungeKuttaResult> resList = new ArrayList<>();
        //ExpressionEvaluator evaluator = new ExpressionEvaluator(expression);
        resList.add(new AuxRungeKuttaResult(x0, y0, h, 0));
        int iterations = 0;
        double xn = x0;
        double yn = y0;
        while (xn < xf) {
            //formulas de runge-kutta
            double k1 = h * ExpressionEvaluator.evaluateExpression(expression, xn, yn);
            double k2 = h * ExpressionEvaluator.evaluateExpression(expression, xn + h, yn + k1);
            double yn1 = yn + ((k1 + k2) / 2);
            double xn1 = xn + h;
            iterations++;
            // double error=(yn-rk2(expression, x0, y0, xf, 2*h))/3;
            resList.add(new AuxRungeKuttaResult(xn1, yn1, h, iterations));
            xn = xn1;//se actualiza el valor inicial para la siguiente iteracion
            yn = yn1;
        }
        return resList;
    }

    private static double rk2(String expression, double x0, double y0, double xf, double h) throws Exception {
        //ExpressionEvaluator evaluator = new ExpressionEvaluator(expression);
        double xn = x0;
        double yn = y0;
        while (xn < xf) {
            double k1 = h * ExpressionEvaluator.evaluateExpression(expression, xn, yn);
            double k2 = h * ExpressionEvaluator.evaluateExpression(expression, xn + h, yn + k1);
            double yn1 = yn + ((k1 + k2) / 2);
            double xn1 = xn + h;
            xn = xn1;
            yn = yn1;
        }
        return yn;
    }

    public static List<AuxRungeKuttaResult> solveDiferentialByRK4(String expression, double x0, double y0, double h, double xf) throws Exception {
        List<AuxRungeKuttaResult> resultList = new ArrayList<>();
        double xn = x0;
        double yn = y0;
        int iterations = 0;
        resultList.add(new AuxRungeKuttaResult(x0, y0, h, iterations));
        //  ExpressionEvaluator ExpressionEvaluator = new ExpressionEvaluator(expression);
        while (xn < xf) {
            //Esquema de formulas de Runge-kutta
            double k1 = h * ExpressionEvaluator.evaluateExpression(expression, xn, yn);
            double k2 = h * ExpressionEvaluator.evaluateExpression(expression, xn + (h / 2), yn + (k1 / 2));
            double k3 = h * ExpressionEvaluator.evaluateExpression(expression, xn + (h / 2), yn + (k2 / 2));
            double k4 = h * ExpressionEvaluator.evaluateExpression(expression, xn + h, yn + k3);
            double xn1 = xn + h;
            double yn1 = yn + (k1 + (2 * k2) + (2 * k3) + k4) / 6;
            iterations++;
            // double error=(yn-rk4(expression, xn, yn, xf, 2*h))/15;
            resultList.add(new AuxRungeKuttaResult(xn1, yn1, h, iterations));
            xn = xn1;
            yn = yn1;
        }
        return resultList;
    }

    private static double rk4(String expression, double x0, double y0, double h, double xf) throws Exception {

        double xn = x0;
        double yn = y0;
        //ExpressionEvaluator ExpressionEvaluator = new ExpressionEvaluator(expression);
        while (xn < xf) {
            double k1 = h * ExpressionEvaluator.evaluateExpression(expression, xn, yn);
            double k2 = h * ExpressionEvaluator.evaluateExpression(expression, xn + (h / 2), yn + (k1 / 2));
            double k3 = h * ExpressionEvaluator.evaluateExpression(expression, xn + (h / 2), yn + (k2 / 2));
            double k4 = h * ExpressionEvaluator.evaluateExpression(expression, xn + h, yn + k3);
            double xn1 = xn + h;
            double yn1 = yn + (k1 + (2 * k2) + (2 * k3) + k4) / 6;
            xn = xn1;
            yn = yn1;
        }
        return yn;
    }
}
