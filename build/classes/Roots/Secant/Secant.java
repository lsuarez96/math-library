/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Roots.Secant;

import EcuationDefinition.ExpressionEvaluator;
import java.util.ArrayList;
import java.util.List;

/**
 * Provee las herramientas para calcular el valor de la raiz de una funcion mdte
 * el metodo de la secante
 *
 * @author Luisito Suarez
 */
public class Secant {

    /**
     * Calcula el valor aproximado de la raiz de una ecuacion mediante el metodo
     * de la Secante, dado un intervalo donde se conoce que esta existe y la
     * tolerancia de error requerida en el resultado
     *
     * @param expression Representacion de la funcion matematica en una cadena
     * de caracteres
     * @param leftExtreme Extremo izquierdo del intervalo donde se asume que
     * existe la raiz
     * @param rigthExtreme Extremo derecho del intervalo
     * @param tolerance tolerancia maxima al error
     * @return lista con el valor aproximado de la raiz,los extremos del
     * intervalo donde se utilizo y el error cometido en cada iteracion del
     * algoritmo
     * @throws Exception Lanza una excepcion si no se pudo parsear la
     * representacion de la funcion matematica
     */
    public static List<AuxSecantResult> secant(String expression, double leftExtreme, double rigthExtreme, double tolerance) throws Exception {
        List<AuxSecantResult> list = new ArrayList<>();//lista de los resultados
        //ExpressionEvaluator ExpressionEvaluator = new ExpressionEvaluator(expression);//instancia del evaluador de funciones
        double lEval = ExpressionEvaluator.evaluateExpression(expression, leftExtreme);//funcion evaluada en el extremo izquierdo del intervalo
        double rEval = ExpressionEvaluator.evaluateExpression(expression, rigthExtreme);//funcion evaluada en el extemo derecho del intervalo
        double maxErr;//error maximo cometido
        int iterationsNumber = 0;//numero de iteraciones
        do {
            double value = rigthExtreme - (((rigthExtreme - leftExtreme) / (rEval - lEval)) * rEval);//formula de la secante
            double rValue = ExpressionEvaluator.evaluateExpression(expression, value);//resultado de la funcion evaluada en el valor aproximado de la raiz calculado anteriormente
            maxErr = Math.abs(value - rigthExtreme);//error maximo cometido en esta iteracion
            AuxSecantResult result = new AuxSecantResult(leftExtreme, rigthExtreme, maxErr, value, iterationsNumber);
            list.add(result);
            //si el valor de la raiz calculado es exacto se rompe el ciclo y se retorna el resultado ||NOTA: ESTO ES UNA MODIFICACION AL ALGORITMO ORIGINAL
            if (rValue == 0) {
                return list;
            }
            //actualizacion de los intervalos sobre los cuales se va a calcuar la raiz en la proxima iteracion
            leftExtreme = rigthExtreme;
            lEval = rEval;
            rigthExtreme = value;
            rEval = rValue;
            iterationsNumber++;//incremetar el numero de iteraciones
        } while (maxErr > tolerance);//este ciclo se va ejecutar mientras el error cometido al aproximar la raiz sea mayor que la tolerancia maxima al error
        return list;
    }
}
