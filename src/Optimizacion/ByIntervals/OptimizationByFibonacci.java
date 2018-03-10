/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Optimizacion.ByIntervals;

import EcuationDefinition.ExpressionEvaluator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luisito
 */
public class OptimizationByFibonacci {

    /**
     * Optimizacion de una funcion en un intervalo
     *
     * @param expression Representacion de la funcion a optimizar
     * @param leftInterv Extremo izquierdo del intervalo de optimizacion
     * @param rigthInterv Extremo derecho del intervalo
     * @param tolerance tolerancia al error
     * @return Intervalo del punto maximo, la cant de evaluaciones, el error
     * cometido,la distancia entre los extremos del intervalo por cada iteracion
     * @throws Exception
     */
    public static List<AuxResultOptFibonacci> optimIntervByFibonacci(String expression, double leftInterv, double rigthInterv, double tolerance) throws Exception {
        List<AuxResultOptFibonacci> resultList = new ArrayList<>();
//        ExpressionEvaluator ExpressionEvaluator = new ExpressionEvaluator(expression);
        double L = rigthInterv - leftInterv;//distancia entre los extremos del intervalo
        double factor = 0.381966;//factor calculado mdte la serie de fibonacci
        //calculo de los extremos
        double x1 = leftInterv + factor * L;
        double x2 = rigthInterv - factor * L;
        //funcion evaluada en los extremos
        double y1, y2;
//        if (evaluator.isTrigonometric()) {
//            y1 = evaluator.evaluateExpression(Math.toDegrees(x1));
//            y2 = evaluator.evaluateExpression(Math.toDegrees(x2));
//        } else {
        y1 = ExpressionEvaluator.evaluateExpression(expression, (x1));
        y2 = ExpressionEvaluator.evaluateExpression(expression, (x2));
        // }
        double error = Math.abs(rigthInterv - factor * L);
        int iteration = 0;//numero de la iteracion
        boolean stop = false;
        resultList.add(new AuxResultOptFibonacci(leftInterv, rigthInterv, 0, iteration, error, L));
        double x0 = 0, x01 = 0;
        do {
            System.out.println(resultList.get(iteration));
            if (y1 < y2) {//seleccion de los nuevos extemos del intervalo para la iteracion
                leftInterv = x1;
                x1 = x2;
                y1 = y2;
                L = rigthInterv - leftInterv;
                x2 = rigthInterv - factor * L;
//                if (evaluator.isTrigonometric()) {
//                    y2 = evaluator.evaluateExpression(Math.toDegrees(x2));
//                } else {
                y2 = ExpressionEvaluator.evaluateExpression(expression, (x2));
                //}
                //y2 = ExpressionEvaluator.evaluateExpression(x2);
                error = Math.abs(rigthInterv - factor * L);
            } else {
                rigthInterv = x2;
                x2 = x1;
                y2 = y1;
                L = rigthInterv - leftInterv;
                x1 = leftInterv + factor * L;
//                if (evaluator.isTrigonometric()) {
//                    y1 = evaluator.evaluateExpression(Math.toDegrees(x1));
//                } else {
                y1 = ExpressionEvaluator.evaluateExpression(expression, (x1));
                //  }
                error = Math.abs(rigthInterv - factor * L);
            }
            if (x0 == leftInterv && x01 == rigthInterv) {
                stop = true;
            }
            x0 = leftInterv;
            x01 = rigthInterv;
            resultList.add(new AuxResultOptFibonacci(leftInterv, rigthInterv, 2 * iteration, iteration, error, L));
            iteration++;
        } while (L > tolerance && !stop);//se va iterar mientras la dist entre los extremos sea mayor que la tolerancia
        return resultList;
    }
}
