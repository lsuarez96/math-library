/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Roots.NewtonRaphson;

import EcuationDefinition.ExpressionEvaluator;
import java.util.ArrayList;
import java.util.List;

/**
 * Provee las herramientas para el calculo de raices mediante el metodo
 * Newton-Raphson
 *
 * @author Luisito Suarez
 */
public class NewtonRaphson {

    /**
     * Calcula la raiz de una ecuacion mediante el metodo Newton-Raphson Se
     * asume que se cumplen las condiciones matematicas necesarias para el
     * empleo de este metodo
     *
     * @param expression Representacion de la ecuacion matematica en una cadena
     * de caracteres
     * @param derivateExpression Representacion de la derivada de la ecuacion en
     * una cadena de caracteres
     * @param initialValue Valor de la aproximacion inicial de la raiz
     * @param tolerance Tolerancia de error admitida
     * @return Retorna una lista con los valores de aproximacion de inicial y
     * calculados de la raiz y el error cometido en cada iteracion
     * @throws Exception Lanza una excepcion en caso de la representacion de la
     * ecuacion y de la derivada no se pueda parcear
     */
    public static List<AuxNewtonResult> newtonRaphson(String expression, String derivateExpression, double initialValue, double tolerance) throws Exception {
        int iterationNumber = 0;//numero de iteraciones realizadas
        double value = 0;//inicializa valor de la raiz
        double maxErr = Math.abs(value - initialValue);//inicializa el valor del maximo error cometido
        List<AuxNewtonResult> resultList = new ArrayList<>();//lista de los resultados
//        ExpressionEvaluator ExpressionEvaluator = new ExpressionEvaluator(expression);//Instancia del evaluador de expresiones matematicas
//        ExpressionEvaluator ExpressionEvaluator=new ExpressionEvaluator(derivateExpression);
        do {//Ciclo que se va a ejecutar mientras el error cometido al calcular la raiz sea mayor que la tolerancia admitida o se encuentre un cero exacto
            double expEval = ExpressionEvaluator.evaluateExpression(expression, initialValue);//evaluacion de la ecuacion en la aproximacion inicial del valor de la raiz
            double derEval = ExpressionEvaluator.evaluateExpression(derivateExpression, initialValue);//evaluacion de la derivada en la aproximacion inicial de la raiz
            if (expEval == 0) {//si el valor de la aproximacion inicial es cero rompe el ciclo y devuelve el resultado|| NOTA: ESTO ES UNA MODIF AL ALGORITMO ORIGINAL
                maxErr = 0;
                AuxNewtonResult result = new AuxNewtonResult(initialValue, initialValue, maxErr, iterationNumber);//guarda los resultados obtenidos en la iteracion actual
                resultList.add(result);
                return resultList;
            }
            value = initialValue - (expEval / derEval);//formula de Newton-Raphson, actualiza el valor de la iteracion anterior
            maxErr = Math.abs(value - initialValue);//actualiza el error maximo cometido en la iteracion actual
            AuxNewtonResult result = new AuxNewtonResult(value, initialValue, maxErr, iterationNumber);//guarda los resultados obtenidos en la iteracion actual
            resultList.add(result);
            initialValue = value;//actualiza el valor de la aproximacion inicial
            iterationNumber++;//incrementa el numero de iteraciones
        } while (maxErr > tolerance);
        return resultList;
    }
}
