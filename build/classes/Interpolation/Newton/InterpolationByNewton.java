/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interpolation.Newton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Luisito Suarez
 */
public class InterpolationByNewton {

    /**
     * Metodo de interpolacion de Newton
     *
     * @param xValues Valores de x tomados
     * @param yValues Valores de y correspondientes a cada x
     * @param value Valor sobre el cual se va interpolar
     * @param tolerance tolerancia al error
     * @return El coeficiente de las x correspondiente a su grado por cada
     * iteracion
     */
    public static List<AuxNewtonResult> interpolateByNewton(List<Double> xValues, List<Double> yValues, double value, double tolerance) {
        List<AuxNewtonResult> list = new ArrayList<>();
        double[][] dif = new double[yValues.size()][yValues.size()];

        for (int j = 0; j < yValues.size(); j++) {
            dif[j][0] = yValues.get(j);
        }

        int l;
        for (int k = 0; k < yValues.size() - 1; k++) {
            l = 0;
            for (int i = k + 1; i < yValues.size(); i++) {
                dif[i][k + 1] = (dif[i][k] - dif[i - 1][k]) / (xValues.get(i) - xValues.get(l));
                l++;
            }
            System.out.println(Arrays.toString(dif[k]));
        }

        double p = dif[0][0];
        double prod = (value - xValues.get(0));
        double error = Math.abs(dif[1][0] * prod);
        int i = 0;
        for (int s = 0; s < yValues.size() && i < dif[0].length; s++) {
            for (int c = 0; c < s; c++) {
                p += error;
                prod = prod * (value - xValues.get(c));
                error = dif[c][s];
                i++;
            }
            System.out.println(p);
            error = dif[s][s] * prod;
            p += error;

            list.add(new AuxNewtonResult(p, error, s));
        }
        return list;
    }

}
