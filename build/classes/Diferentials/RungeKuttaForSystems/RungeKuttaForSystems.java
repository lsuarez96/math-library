/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diferentials.RungeKuttaForSystems;

import EcuationDefinition.ExpressionEvaluator;
import EcuationDefinition.ReplaceMentForMultVar;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luisito Suarez
 */
public class RungeKuttaForSystems {

    /**
     * Metodo iterativo Runge-Kutta de orden 2 para resolver sistemas de
     * ecuaciones diferenciales
     *
     * @param expressions Lista que contiene la representacion de las n
     * ecuaciones del sistema A la hora de escribir las ecuaciones dif las
     * variables U-k deben comenzar con indice 1 Ej: x+u1+u2*u3
     * @param x0 Valor inicial de las x
     * @param xf Valor final de las x
     * @param h Valor del paso
     * @param u0 Lista de n valores iniciales a evaluar en las ecuaciones
     * diferenciales
     * @return Una lista con las soluciones y el valor n-esimo de las x por cada
     * iteracion
     * @throws Exception
     */
    public static List<AuxResultRKSystems> solveDifSystemByRK2(List<String> expressions, double x0, double xf, double h, List<Double> u0) throws Exception {
        List<AuxResultRKSystems> results = new ArrayList<>();//llista de resultados
        List<Double> auxU0 = new ArrayList<>(u0);//lista auxiliar para calcular las soluciones
        double xn = x0;//valor inicial de x
        results.add(new AuxResultRKSystems(u0, xn, 0));//se agrega la iteracion 0 al conjunto de soluciones
        int iter = 0;//numero de iteraciones
        double[] k1, k2;//lista de incrementos verticales
        k1 = new double[auxU0.size()];
        k2 = new double[auxU0.size()];
        while (xn < xf) {
//            List<ExpressionEvaluator> evaluators = new ArrayList<>();
//            expressions.stream().forEach((String exp) -> {//parceando la expresion
//                evaluators.add(new ExpressionEvaluator(ReplaceMentForMultVar.replace(exp, auxU0)));
//            });
            for (int i = 0; i < auxU0.size(); i++) {
                //calcular k1 para cada ED
                double eval = ExpressionEvaluator.evaluateExpression(ReplaceMentForMultVar.replace(expressions.get(i), auxU0), xn);
                k1[i] = h * eval;
            }
            List<Double> aux2 = new ArrayList<>();

            for (int i = 0; i < auxU0.size(); i++) {
                aux2.add(auxU0.get(i) + k1[i]);
            }

            for (int i = 0; i < auxU0.size(); i++) {
                //calcular k2
                double eval = ExpressionEvaluator.evaluateExpression(ReplaceMentForMultVar.replace(expressions.get(i), aux2), xn + h);
                k2[i] = h * eval; //evaluators.get(i).evaluateExpression(xn + h);
            }
            for (int i = 0; i < auxU0.size(); i++) {
                //calcular cada u
                double temp = auxU0.get(i) + (k1[i] + k2[i]) / 2;//calculo de la solucion de cada sistema
                auxU0.set(i, temp);
            }
            xn += h;
            iter++;
            results.add(new AuxResultRKSystems(new ArrayList<>(auxU0), xn, iter));
        }
        return results;
    }

    public static List<AuxResultRKSystems> solveDifSystemByRK4(List<String> expressions, double x0, double xf, double h, List<Double> u0) throws Exception {
        List<AuxResultRKSystems> results = new ArrayList<>();
        List<Double> auxU0 = new ArrayList<>(u0);
        double xn = x0;
        results.add(new AuxResultRKSystems(u0, xn, 0));

        int iter = 0;
        double[] k1, k2, k3, k4;
        k1 = new double[auxU0.size()];
        k2 = new double[auxU0.size()];
        k3 = new double[auxU0.size()];
        k4 = new double[auxU0.size()];
        while (xn < xf) {
            //List<ExpressionEvaluator> evaluators = new ArrayList<>();
//            expressions.stream().forEach((exp) -> {
//                evaluators.add(new ExpressionEvaluator(ReplaceMentForMultVar.replace(exp, auxU0)));
//            });
            for (int i = 0; i < auxU0.size(); i++) {
                //calcular k1
                k1[i] = h * ExpressionEvaluator.evaluateExpression(ReplaceMentForMultVar.replace(expressions.get(i), auxU0), xn);//evaluators.get(i).evaluateExpression(xn);
            }
            List<Double> aux2 = new ArrayList<>();

            for (int i = 0; i < auxU0.size(); i++) {
                aux2.add(auxU0.get(i) + (k1[i] / 2));
            }
//            expressions.stream().forEach((exp) -> {
//                evaluators.add(new ExpressionEvaluator(ReplaceMentForMultVar.replace(exp, aux2)));
//            });
            for (int i = 0; i < auxU0.size(); i++) {
                //calcular k2
                k2[i] = h * ExpressionEvaluator.evaluateExpression(ReplaceMentForMultVar.replace(expressions.get(i), aux2), xn + (h / 2));
            }
            aux2.clear();

            for (int i = 0; i < auxU0.size(); i++) {
                aux2.add(auxU0.get(i) + (k2[i] / 2));
            }
//            expressions.stream().forEach((exp) -> {
//                evaluators.add(new ExpressionEvaluator(ReplaceMentForMultVar.replace(exp, aux2)));
//            });
            for (int i = 0; i < auxU0.size(); i++) {
                //calcular k3
                k3[i] = h * ExpressionEvaluator.evaluateExpression(ReplaceMentForMultVar.replace(expressions.get(i), aux2), xn + (h / 2));
            }

            //calcular k4
            aux2.clear();
            //evaluators.clear();
            for (int i = 0; i < auxU0.size(); i++) {
                aux2.add(auxU0.get(i) + (k3[i]));
            }
//            expressions.stream().forEach((exp) -> {
//                evaluators.add(new ExpressionEvaluator(ReplaceMentForMultVar.replace(exp, aux2)));
//            });
            for (int i = 0; i < auxU0.size(); i++) {
                //calcular k3
                k4[i] = h * ExpressionEvaluator.evaluateExpression(ReplaceMentForMultVar.replace(expressions.get(i), aux2), xn + h);
            }

            for (int i = 0; i < auxU0.size(); i++) {
                //calcular cada u
                double temp = auxU0.get(i) + ((k1[i] + (2 * k2[i]) + (2 * k3[i]) + k4[i]) / 6);
                auxU0.set(i, temp);
            }
            xn += h;
            iter++;
            results.add(new AuxResultRKSystems(new ArrayList<>(auxU0), xn, iter));
        }
        return results;
    }

}
