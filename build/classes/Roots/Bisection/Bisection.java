/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Roots.Bisection;

import EcuationDefinition.ExpressionEvaluator;
import java.util.ArrayList;
import java.util.List;

/**
 * Provee las herramientas para calcular la raiz de una ecuacion mediante el
 * metodo de biseccion
 *
 * @author Luisito Suarez
 */
public class Bisection {

    /**
     * Calcula la raiz de una ecuacion matematica dado un intervalo en el que
     * previamente se conoce que existe una raiz, mediante el metodo de
     * biseccion
     *
     * @param expression Representacion de la ecuacion en formato String
     * @param leftExtreme Extremo izquierdo o de inicio del intervalo sobre el
     * cual se asume que se encuentra una unica raiz
     * @param rigthExtreme Extremo derecho o fin del intervalo
     * @param tolerance Tolerancia de error al calcular la raiz
     * @return Retorna una lista con las aproximaciones del valor de la raiz,
     * asi como los intervalos y el error cometido en cada iteracion hasta
     * alcanzar la tolerancia maxima de error
     * @throws Exception Lanza una excepcion si la representacion de la
     * expresion matematica de la ecuacion no se pudo parcear
     */
    public static List<AuxBisectionResult> bisection(String expression, double leftExtreme, double rigthExtreme, double tolerance) throws Exception {

        List<AuxBisectionResult> resultList = new ArrayList<>();//lista de resultados
//        ExpressionEvaluator ExpressionEvaluator = new ExpressionEvaluator(expression);//se crea la instancia del evaluador de funciones matematicas pasandole por parametro su representacion
        double midWay;//semisuma o punto medio del intervalo donde se encuentra la raiz
        double maxErr = Math.abs((rigthExtreme - leftExtreme) / 2);//error maximo cometido
        int totalIterations = 0;//numero de iteraciones
        do {//ciclo que se va ejecutar mientras el error maximo sea mayor que la tolerancia requerida o se encuentre la raiz exacta en el intervalo dado
            midWay = (leftExtreme + rigthExtreme) / 2;//se calcula el punto medio o la raiz
            AuxBisectionResult tempResult = new AuxBisectionResult(leftExtreme, rigthExtreme, maxErr, tolerance, totalIterations, midWay);//se guarda el resultado
            double a = ExpressionEvaluator.evaluateExpression(expression, midWay);//se evalua la funcion en la aproximacion de la raiz en la iteracion actual
            if (a == 0) {//si el resultado al evaluar la expresion es 0 significa que la raiz es exacta y se devuelve el resultado, de lo contrario pasa a la siguiente iteracion
                maxErr = 0;
                tempResult = new AuxBisectionResult(leftExtreme, rigthExtreme, maxErr, tolerance, totalIterations, midWay);
                resultList.add(tempResult);
                return resultList;
            }
            resultList.add(tempResult);
            double b = ExpressionEvaluator.evaluateExpression(expression, leftExtreme);//Evalua la expresion en el extremo izquierdo del intervalo
            if (a * b < 0) {//si entre el punto medio del intervalo y uno de los extremos ocurre un cambio de signo quiere decir que aqui se encuentra la raiz
                rigthExtreme = midWay;//por tanto se intercambian los extremos del intervalo para reducirlo y usarlo en la proxima iteracion
            } else {
                leftExtreme = midWay;
            }
            totalIterations++;//se incrementa el contador de iteraciones
            maxErr = Math.abs((rigthExtreme - leftExtreme) / 2);//se actualiza el valor del error maximo cometido para la proxima iteracion
        } while (maxErr > tolerance);

        return resultList;
    }

}
