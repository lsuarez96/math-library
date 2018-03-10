/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Integration.Trapeze;

import EcuationDefinition.ExpressionEvaluator;

/**
 *
 * @author Luisito Suarez
 */
public class Trapeze {

    /**
     * Metodo de solucion de integrales definidas mediante el metodo de los
     * Trapecios con un numero par de intervalos
     *
     * @param expression Expresion matematica a integrar
     * @param leftInterval Extremo izquierdo del intervalo de integracion
     * @param rigthInterval Extremo derecho del intervalo de integracion
     * @param nIntervals Numero de intervalos
     * @return Resultado de la integracion y el error cometido
     *
     * @throws Exception Lanza una excepcion si la expresion matematica no es
     * valida
     */
    public static AuxTrapezeResult integrationByTrapeze(String expression, double leftInterval, double rigthInterval, int nIntervals) throws Exception {
        AuxTrapezeResult result;
        // boolean isTrigonometric = isTrigonometric(expression);//esto es un pie q tuve q meter pq java no sabe evaluar los ceros de las trigonometricas
//        ExpressionEvaluator ExpressionEvaluator = new ExpressionEvaluator(expression);
        double a = leftInterval;
        double b = rigthInterval;
//        if (isTrigonometric) {
//           // a = Math.toRadians(leftInterval);
//           // b = Math.toRadians(rigthInterval);
//        }
        double intervSize = (b - a) / nIntervals;
        double extSum = (ExpressionEvaluator.evaluateExpression(expression, leftInterval) + ExpressionEvaluator.evaluateExpression(expression, rigthInterval)) / 2.0;
        for (int i = 1; i < nIntervals; i++) {
            double aux = a + (i * intervSize);
//            if (isTrigonometric) {
//                extSum += eval.evaluateExpression(Math.toDegrees(aux));
//            } else {
            extSum += ExpressionEvaluator.evaluateExpression(expression, aux);
            // }
        }
        double aproxResult = intervSize * extSum;
        double h2 = 2 * intervSize;
        double sum2 = (ExpressionEvaluator.evaluateExpression(expression, leftInterval) + ExpressionEvaluator.evaluateExpression(expression, rigthInterval)) / 2.0;
        for (int i = 1; i < nIntervals / 2; i++) {
            double aux = a + (i * h2);
//            if (isTrigonometric) {
//                sum2 += eval.evaluateExpression(Math.toDegrees(aux));
//            } else {
            sum2 += ExpressionEvaluator.evaluateExpression(expression, aux);
            //}
        }
        double resultI2h = h2 * sum2;
        System.out.println(resultI2h);
        double error = (aproxResult - resultI2h) / 3.0;
        result = new AuxTrapezeResult(error, aproxResult);
        return result;
    }

//    private static boolean isTrigonometric(String exp) {
//        return exp.contains("sin") || exp.contains("cos") || exp.contains("asin") || exp.contains("acos") || exp.contains("tan") || exp.contains("atan")
//                || exp.contains("cosh") || exp.contains("sinh");
//
//    }
}
