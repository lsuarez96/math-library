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
public class OptimizationByBisection {

    /**
     * Optimizacion de una funcion en un intervalo
     *
     * @param expression Representacion de la funcion a optimizar
     * @param leftInterv extremo izquierdo del intervalo de optim
     * @param rigthInterv extremo derecho
     * @param distance distancia requerida entre los extremos del intervalo
     * @param tolerance tolerancia al error
     * @return
     * @throws Exception
     */
    public static List<AuxResultOptimBisect> optimIntervalByBiseccion(String expression, double leftInterv, double rigthInterv, double distance, double tolerance) throws Exception {
//        ExpressionEvaluator evaluator = new ExpressionEvaluator(expression);
        List<AuxResultOptimBisect> resList = new ArrayList<>();
        int iteration = 0;
        double error = rigthInterv - ((leftInterv + rigthInterv) / 2);//calculo del error inicial
        double L;//distancia entre los extremos
        double x1, x2, y1, y2, x0, x01;//variables aux para el calculo de los extremos
        x0 = leftInterv;
        x01 = rigthInterv;
        boolean stop = false;
        resList.add(new AuxResultOptimBisect(leftInterv, rigthInterv, error, 0, ((leftInterv + rigthInterv) / 2), iteration));
        do {
            x1 = (((leftInterv + rigthInterv) / 2) - (distance / 2));//calculo de los extremos
            x2 = (((leftInterv + rigthInterv) / 2) + (distance / 2));

            y1 = ExpressionEvaluator.evaluateExpression(expression, x1); //evaluator.evaluateExpression((x1));
            y2 = ExpressionEvaluator.evaluateExpression(expression, x2);//evaluator.evaluateExpression((x2));

            iteration++;
            //System.out.println(resList.get(iteration - 1));
            if (y1 < y2) {//eleccion de los extremos calculados
                leftInterv = x1;
            } else {
                rigthInterv = x2;
            }
            if (x0 == leftInterv && x01 == rigthInterv) {
                stop = true;
            }
            x0 = leftInterv;//actualizacion de los extremos para la proxima iteracion
            x01 = rigthInterv;
            double halfPoint = (leftInterv + rigthInterv) / 2;//calculo del pto medio del interv
            error = leftInterv - halfPoint;//actualizacion del error de la act iterac
            int evaluations = iteration * 2;//calculo del num de evaluaciones
            L = rigthInterv - leftInterv;//actual de la dist entre los intervalos
            resList.add(new AuxResultOptimBisect(leftInterv, rigthInterv, error, evaluations, halfPoint, iteration));
        } while (L > tolerance && !stop);//se va a iterar mientras la distancia entre los extremos sea mayor que la requerida
        return resList;
    }

    public static List<AuxResultOptimBisect> optimIntervalByBiseccionMaxUnidim(String expression, double leftInterv, double rigthInterv, double distance, double tolerance) throws Exception {
        //ExpressionEvaluator evaluator = new ExpressionEvaluator(expression);
        List<AuxResultOptimBisect> resList = new ArrayList<>();
        int iteration = 0;
        double error = rigthInterv - ((leftInterv + rigthInterv) / 2);//calculo del error inicial
        double L;//distancia entre los extremos
        double x1, x2, y1, y2, x0, x01;//variables aux para el calculo de los extremos
        x0 = leftInterv;
        x01 = rigthInterv;
        boolean stop = false;
        resList.add(new AuxResultOptimBisect(leftInterv, rigthInterv, error, 0, ((leftInterv + rigthInterv) / 2), iteration));
        do {
            x1 = (((leftInterv + rigthInterv) / 2) - (distance / 2));//calculo de los extremos
            x2 = (((leftInterv + rigthInterv) / 2) + (distance / 2));

            y1 = ExpressionEvaluator.evaluateExpression(expression, x1);//evaluator.evaluateExpression((x1));
            y2 = ExpressionEvaluator.evaluateExpression(expression, x2);//evaluator.evaluateExpression((x2));

            iteration++;
            //System.out.println(resList.get(iteration - 1));
            if (y1 < y2) {//eleccion de los extremos calculados
                leftInterv = x1;
            } else {
                rigthInterv = x2;
            }
            if (x0 == leftInterv && x01 == rigthInterv) {
                stop = true;
            }
            x0 = leftInterv;//actualizacion de los extremos para la proxima iteracion
            x01 = rigthInterv;
            double halfPoint = (leftInterv + rigthInterv) / 2;//calculo del pto medio del interv
            error = leftInterv - halfPoint;//actualizacion del error de la act iterac
            int evaluations = iteration * 2;//calculo del num de evaluaciones
            L = rigthInterv - leftInterv;//actual de la dist entre los intervalos
            resList.add(new AuxResultOptimBisect(leftInterv, rigthInterv, error, evaluations, halfPoint, iteration));
        } while (L > tolerance && !stop);//se va a iterar mientras la distancia entre los extremos sea mayor que la requerida
        return resList;
    }
}
