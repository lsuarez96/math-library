/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diferentials.Euler;

import EcuationDefinition.ExpressionEvaluator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luisito Suarez
 */
public class Euler {

    /**
     * Resuelve una ecuacion diferencial mdte el metodo de Euler
     *
     * @param expression Representacion de la ecuacion diferencial
     * @param x0 valor de x para la condicion inicial
     * @param xf valor final de x
     * @param y0 valor de y para la condicion inicial
     * @param h valor del paso
     * @return Lista con el valor de x y la solucion a la Ed para cada iteracion
     * @throws Exception
     */
    public static List<AuxEulerResult> solveDifByEuler(String expression, double x0, double xf, double y0, double h) throws Exception {
        List<AuxEulerResult> results = new ArrayList<>();
        double xn = x0;
        double yn = y0;
        int it = 0;

        results.add(new AuxEulerResult(it, xn, yn));
        while (xn < xf) {
            xn += h;
            yn += h * ExpressionEvaluator.evaluateExpression(expression, xn, yn);
            it++;
            results.add(new AuxEulerResult(it, xn, yn));
        }

        return results;
    }
}
