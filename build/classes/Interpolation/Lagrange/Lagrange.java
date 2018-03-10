/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interpolation.Lagrange;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luisito Suarez
 */
public class Lagrange {

    /**
     * Interpola un polinomio en un valor dado, dada una lista de valores de la
     * funcion que son el resultado de evaluarla en los valores de la lista xi
     *
     * @param x Lista de valores de x
     * @param y lista de valores de la funcion evaluada en x
     * @param value valor a interpolar
     * @return resultado del polinomio interpolador evaluado en un valor
     * dado(value)
     */
    public static List<AuxLagrangeResult> interpolateByLagrange(List<Double> x, List<Double> y, double value) {
        double result = 0;
        List<AuxLagrangeResult> list=new ArrayList<>();
        AuxLagrangeResult l;
        for (int i = 0; i < x.size() && i < y.size(); i++) {
            double L = 1;
            for (int j = 0; j < x.size() && j < y.size(); j++) {
                if (i != j) {
                    L = L * ((value - x.get(j)) / (x.get(i) - x.get(j)));
                }
            }
            result += y.get(i) * L;
            l=new AuxLagrangeResult(i+1, result);
            list.add(l);
        }
        return list;
    }
}
