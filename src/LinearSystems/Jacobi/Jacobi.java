/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinearSystems.Jacobi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Luisito Suarez
 */
public class Jacobi {

    /**
     * Calcula las soluciones aproximadas de un sistema de ecuaciones en
     * dependencia de la tolerancia requerida,mediante el metodo de Jacobi. Hay
     * que considerar que se cometen errores de redondeo.
     *
     * @param syst Matriz de coeficientes del sistema
     * @param indTerm Lista de terminos independientes
     * @param tolerance Tolerancia requerida para la aproximacion de los
     * resultados
     * @return Lista que contiene los valores aproximados para la solucion del
     * sistema, error cometido al realizar la aproximacion y el numero de la
     * iteracion correspondiente por cada iteracion del metodo
     */
    public static List<JacobiAuxResult> jacobi(double[][] syst, double[] indTerm, double tolerance) {
        List<JacobiAuxResult> list = new ArrayList<>();//lista de resultados
        int n = syst.length;//tamaño de la matriz del sistema 
        double[] aprox = new double[n];//aproximacion inicial 
        double[] aux = new double[n];//vector auxiliar 
        double[] alphaV = new double[n];//Lista de posibles factores de convergencia el cual sera el mayor de los n-posibles
        int iteration = 0;//contador de iteraciones realizadas hasta que el error cometido sea menor que la tolerancia
        //inicializando la aproximacion inicial en 0
        for (int i = 0; i < n; i++) {
            aprox[i] = 0;
            aux[i] = 0;
        }
        double maxError = 0;
        do {
            JacobiAuxResult r = new JacobiAuxResult(aprox, maxError, iteration);//Agregar resultados de la iteracion anterior
            maxError = 0;//inicializar otra vez el error cometido en cero
            for (int i = 0; i < n; i++) {
                aux[i] = indTerm[i];
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        aux[i] = aux[i] - (syst[i][j] * aprox[j]);
                        alphaV[i] += Math.abs(syst[i][j] / syst[i][i]);//hallando los posibles factores de convergencia
                    }
                }
                aux[i] = aux[i] / syst[i][i];//calculando las soluciones aproximadas
                if (Math.abs(aux[i] - aprox[i]) > maxError) {
                    maxError = Math.abs(aux[i] - aprox[i]);//calculando error
                }
            }
            aprox = Arrays.copyOf(aux, n);//actualizando el vector aproximacion inicial para la proxima iteracion
            double max = alphaV[0];//hallando el factor de convergencia
            for (int i = 0; i < n; i++) {
                if (max < alphaV[i]) {
                    max = alphaV[i];
                }
            }
            maxError = maxError * (Math.abs((max / (1 - max))));//Recalculando el error en base al factor de convergencia            
            iteration++;//actualizando el numero de iteraciones
            list.add(r);//agregando los resultados de la iteracion anterior 
        } while (maxError > tolerance);//El ciclo se va a ejecutar mientras

        return list;//retornando la lista de resultados
    }
    
    
}
