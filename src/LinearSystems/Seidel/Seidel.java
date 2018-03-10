/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinearSystems.Seidel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Luisito Suarez
 */
public class Seidel {

    /**
     * Resuelve sistemas de ecuaciones lineales mediante el metodo de Seidel
     *
     * @param systemMatrix Matriz del sistema
     * @param solutions Lista de terminos independientes
     * @param tolerance tolerancia al error
     * @return Solucion aproximada al sistema, error cometido, factor de
     * convergencia, y la maxima diferencia entre la aproximacion de cada
     * iteracion
     */
    public static List< AuxSeidelResult> seidel(double[][] systemMatrix, double[] solutions, double tolerance) {
        List<AuxSeidelResult> listR = new ArrayList<>();//lista de resultados
        double convFactor;//factor de convergencia
        int n = systemMatrix.length;//tamanno de la matriz del sistema
        int iterationsNumber = 0;//contador de iteraciones
        double maxError;//error cometido en cada iteracion
        double temp;//variable temporal para calcular cada solucion
        double qi, pi;//parametros para el calculo del coeficiente de converg
        double initAprox[] = new double[n];//vector de aproximacion inicial
        for (int i = 0; i < n; i++) {
            initAprox[i] = 0;//aproximacion inicial vector nulo
        }
        double[] cfList = new double[n];//lista de coeficientes de convergencia
        //calculo de los posibles coeficientes de convergencia por fila
        for (int i = 0; i < n; i++) {
            pi = 0;
            qi = 0;
            for (int j = 0; j < n; j++) {
                if (j < i) {
                    pi += Math.abs(systemMatrix[i][j] / systemMatrix[i][i]);
                } else if (j > i) {
                    qi += Math.abs(systemMatrix[i][j] / systemMatrix[i][i]);
                }
            }
            cfList[i] = Math.abs(qi / (1 - pi));//calculo del fact de convergencia         
        }
        System.out.println(Arrays.toString(cfList));
        convFactor = cfList[0];//seleccion del factor de convergencia
        for (int i = 1; i < n; i++) {
            if (convFactor < cfList[i]) {
                convFactor = cfList[i];
            }
        }
        System.out.println(convFactor);        
        do {           
            AuxSeidelResult result;
            maxError = 0;//se inicializa el error en cero porq es independiente de cada iteracion por lo que no se arrastra            
            for (int i = 0; i < n; i++) {//calculo de la componente '# i' de la solucion
                temp = solutions[i];
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        temp = temp - systemMatrix[i][j] * initAprox[j];
                    }
                }
                
                temp = temp / systemMatrix[i][i];
                if (Math.abs(temp - initAprox[i]) > maxError) {
                    maxError = Math.abs(temp - initAprox[i]);//calculo de la maxima diferencia
                }
                initAprox[i] = temp;//se actualiza el resultado de la iteracion anterior con la actual para calcular la
                //nueva aproximacion
            }
            double maxDiference = maxError;
            if (convFactor > 0.5) {//Si el factor de convergencia es menor que 0.5 entonces el error es igual a la diferencia maxima
                maxError *= (Math.abs((convFactor / (1 - convFactor))));
            }
            iterationsNumber++;
            result = new AuxSeidelResult(Arrays.copyOf(initAprox, n), maxError, maxDiference, convFactor, iterationsNumber);
            listR.add(result);
        } while (maxError > tolerance);//Iterar mientras el error cometido sea mayor que la tolerancia requerida
        return listR;
    }

}
