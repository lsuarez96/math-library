/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Integration.Simpson;

import EcuationDefinition.ExpressionEvaluator;

/**
 *
 * @author Luisito Suarez
 */
public class Simpson {

    /**
     * Metodo de solucion de integrales definidas mediante el metodo de Simpson
     * con un numero par de intervalos
     *
     * @param expression Expresion matematica a integrar
     * @param leftInterval Extremo izquierdo del intervalo de integracion
     * @param rigthInterval Extremo derecho del intervalo de integracion
     * @param nIntervals Numero de intervalos
     * @return Resultado de la integracion y el error cometido calculado por la
     * formula de Mansion
     * @throws Exception Lanza una excepcion si la expresion matematica no es
     * valida
     */
    public static AuxiliarSimpsonResult solveBySimpson(String expression, double leftInterval, double rigthInterval, int nIntervals) throws Exception {
        AuxiliarSimpsonResult results = null;
//        ExpressionEvaluator ExpressionEvaluator = new ExpressionEvaluator(expression);//instancia evaluador de funciones
        if (nIntervals % 2 == 0) {
            double a = leftInterval;
            double b = rigthInterval;
            double intervalSize = (b - a) / nIntervals;//calcular la amplitud del intervalo
            double extSum = ExpressionEvaluator.evaluateExpression(expression, leftInterval) + ExpressionEvaluator.evaluateExpression(expression, rigthInterval);//suma de los extremos del intervalo
            double sumOdd = 0;//suma intervalo impar
            for (int i = 1; i < nIntervals; i += 2) {
                double aux = a + (i * intervalSize);
                sumOdd += ExpressionEvaluator.evaluateExpression(expression, aux);
            }
            double sumEven = 0;//suma intervalo par
            for (int i = 2; i < nIntervals; i += 2) {
                double aux = a + (i * intervalSize);
                sumEven += ExpressionEvaluator.evaluateExpression(expression, aux);

            }
            double aproxIntegral = (intervalSize * (extSum + (4 * sumOdd) + (2 * sumEven))) / 3;//resultado aproximado de la integral definida

            double error = ((2.0 / 3.0)) * (intervalSize * (Math.abs((sumOdd - sumEven - (0.5 * extSum)))));//error por formula de Mansion
            results = new AuxiliarSimpsonResult(error, aproxIntegral);
        }
        return results;
    }

//    private static boolean isTrigonometric(String exp) {
//        return exp.contains("sin") || exp.contains("cos") || exp.contains("asin") || exp.contains("acos") || exp.contains("tan") || exp.contains("atan")
//                || exp.contains("cosh") || exp.contains("sinh");
//
//    }
}
