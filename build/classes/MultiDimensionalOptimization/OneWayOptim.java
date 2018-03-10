/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiDimensionalOptimization;

import EcuationDefinition.ExpressionEvaluator;
import EcuationDefinition.ReplaceMentForMultVar;
import MatrixUtilities.Matrix;
import Optimizacion.ByIntervals.AuxResultOptimBisect;
import Optimizacion.ByIntervals.OptimizationByBisection;
import UnidimencionalOptimizacion.AuxSequentialAndUniformResult;
import UnidimencionalOptimizacion.SequentialAndUniform;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luisito
 */
public class OneWayOptim {

    public static double maxUnidim(String expression, double[] x0, double[] dirVect, double tolerance) throws Exception {
        double s = 1;
        double[] dir = Matrix.vectorTimesEscalar(dirVect, s);
        List<Double> suml = new ArrayList<>();
        List<Double> xV = new ArrayList<>();
        double[] sum = Matrix.sumVectors(x0, dir);
        String[] copyDirVector = new String[dirVect.length];
        String[] copyX0 = new String[x0.length];
        for (int i = 0; i < dirVect.length; i++) {
            copyDirVector[i] = String.valueOf(dirVect[i]) + "*x";
        }
        for (int i = 0; i < copyX0.length; i++) {
            if (dirVect[i] >= 0) {
                copyX0[i] = "(" + String.valueOf(x0[i]) + "+" + copyDirVector[i] + ")";
            } else {
                copyX0[i] = "(" + "(" + String.valueOf(x0[i]) + ")" + "(" + copyDirVector[i] + ")" + ")";
            }
        }
        for (int i = 0; i < sum.length; i++) {
            suml.add(sum[i]);
            xV.add(x0[i]);
        }

        String expression1 = ReplaceMentForMultVar.replace(expression, suml);
        String expression2 = ReplaceMentForMultVar.replace(expression, xV);
        String expression2Copy = ReplaceMentForMultVar.replace(expression, xV);
//        ExpressionEvaluator ExpressionEvaluator = new ExpressionEvaluator(expression1);
//        ExpressionEvaluator ExpressionEvaluator = new ExpressionEvaluator(expression2);
        double minLambda = -1, maxLambda = -1;
        double ev1 = ExpressionEvaluator.evaluateExpression(expression1);// ScriptEngineEvaluator.evaluateMultiVar(expression, suml);//
        double ev2 = ExpressionEvaluator.evaluateExpression(expression2);// ScriptEngineEvaluator.evaluateMultiVar(expression, xV); //
        while (ev1 < ev2 && s > (tolerance / 10)) {
            s /= 2;
            dir = Matrix.vectorTimesEscalar(dirVect, s);
            sum = Matrix.sumVectors(x0, dir);
            suml.clear();
            for (int i = 0; i < sum.length; i++) {
                suml.add(sum[i]);
            }
            expression1 = ReplaceMentForMultVar.replace(expression, suml);
            // expression2 = ReplaceMentForMultVar.replace(expression, xV);
            ev1 = ExpressionEvaluator.evaluateExpression(expression1);
            //eval2 = new ExpressionEvaluator(expression2);
            //ev1 = ExpressionEvaluator.evaluateExpression();//ScriptEngineEvaluator.evaluateMultiVar(expression, suml);//
            //ev2=eval2.evaluateExpression();
        }
        boolean successfull = true;
        if (s < tolerance / 10) {
            successfull = false;
        } else {

            String expressionLambda = ReplaceMentForMultVar.replaceForMaxUnidim(expression, copyX0);
            List<AuxSequentialAndUniformResult> list = SequentialAndUniform.uniformSequentialForMaxUnidim(0, expressionLambda, s);
            if (list.size() >= 2) {
                minLambda = list.get(list.size() - 2).getResearch();
                maxLambda = list.get(list.size() - 1).getResearch();
            } else {
                successfull = false;
            }
            if (successfull) {
                List<AuxResultOptimBisect> rbList = OptimizationByBisection.optimIntervalByBiseccionMaxUnidim(expressionLambda, minLambda, maxLambda, tolerance / 20, tolerance);
                minLambda = rbList.get(rbList.size() - 1).getA();
                maxLambda = rbList.get(rbList.size() - 1).getB();
                successfull = true;
            }
        }
        if (successfull) {
            return (minLambda + maxLambda) / 2;
        }

        return -1.0;
    }

    public static void main(String[] a) throws Exception {
        System.out.println(maxUnidim("u1-u2*u3+u4", new double[]{1, 2, 3, 4}, new double[]{0, 1, 0, 0}, 0));
    }
}
