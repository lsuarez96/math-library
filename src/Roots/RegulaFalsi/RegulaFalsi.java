/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Roots.RegulaFalsi;

import EcuationDefinition.ExpressionEvaluator;
import java.util.ArrayList;
import java.util.List;

/**
 * Proporciona las herramientas para el calculo de raices mediante el metodo
 * Regula Falsi
 *
 * @author Luisito Suarez
 */
public class RegulaFalsi {

    /**
     * Calcula la raiz de una funcion en un intervalo dado donde se asume que
     * esta existe Es una ligera modificacion del metodo de biseccion para
     * mejorar su eficiencia y costo computacional
     *
     * @param expression Representacion de la funcion en una cadena de
     * caracteres
     * @param leftExtreme Valor del extremo izquierdo del intervalo donde se
     * asume que se encuentra el cero
     * @param rigthExtreme Valor del extremo derecho del intervalo
     * @param tolerance Tolerancia maxima al error
     * @return Lista con el valor aproximado de la raiz, los extremos del
     * intervalo y el error cometido por cada iteracion
     * @throws Exception Lanza una excepcion si no se puede parcear la
     * representacion de la expresion matematica
     */
    public static List<AuxRegulaFalsiResult> regulaFalsi(String expression, double leftExtreme, double rigthExtreme, double tolerance) throws Exception {
        double maxErr;//error maximo cometido
        int iterationNumber = 0;//numero de iteraciones
        double value;//valor calculado de la raiz
        List<AuxRegulaFalsiResult> list = new ArrayList<>();
//        ExpressionEvaluator ExpressionEvaluator = new ExpressionEvaluator(expression);//instancia del evaluador de funciones matematicas
        do {
            //Se evalua la funcion en los extremos izquierdo y derecho del intervalo para hallar la interseccion de la cuerda con el eje de las Y
            double lEval = ExpressionEvaluator.evaluateExpression(expression, leftExtreme);
            double rEval = ExpressionEvaluator.evaluateExpression(expression, rigthExtreme);
            value = leftExtreme - ((rigthExtreme - leftExtreme) * (lEval / (rEval - lEval)));//Se aproxima el cero de la funcion al valor del intercepto de
            //la cuerda que une ambos extremos del intervalo con el eje de las X o cero de la cuerda
            maxErr = Math.abs(value - rigthExtreme);//se actualiza el valor del error cometido en la actual iteracion
            AuxRegulaFalsiResult result = new AuxRegulaFalsiResult(leftExtreme, rigthExtreme, maxErr, value, iterationNumber);//se guardan los resultados
            double resultEval = ExpressionEvaluator.evaluateExpression(expression, value);//se evalua la expresion en la aproximacion de la raiz calculada
            //si el resultado al evaluar la funcion es cero quiere decir que el valor calculado es exacto y no es necesario realizar otra iteracion
            if (resultEval == 0) {
                maxErr = 0;
                result = new AuxRegulaFalsiResult(leftExtreme, rigthExtreme, maxErr, value, iterationNumber);
                list.add(result);
                return list;
            }
            list.add(result);
            //Se verifica en que seccion entre el punto medio del intervalo y sus extremos ocurre un cambio de signo ya que ahi se encuentra el cero
            if (lEval * resultEval < 0) {
                //Si ocurre entre el extremo izquierdo y el punto medio se intercambia el extremo derecho con el valor del punto medio
                rigthExtreme = value;
            } else {//de lo contrario
                leftExtreme = value;
            }
            iterationNumber++;//se incrementa el numero de iteraciones
        } while (maxErr > tolerance);//Este ciclo se va ejecutar mientras el error maximo sea mayor que la tolerancia al error
        return list;
    }

}
