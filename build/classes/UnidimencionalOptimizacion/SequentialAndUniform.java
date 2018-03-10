package UnidimencionalOptimizacion;

import EcuationDefinition.ExpressionEvaluator;
import java.util.ArrayList;
import java.util.List;

public class SequentialAndUniform {

    /**
     * Optimizacion uniforme secuencial
     *
     * @param x0 Valor inicial a partir del cual se busca el maximo
     * @param expression Representacion de la expresion a optimizar
     * @param s Paso s
     * @return El valor de x maxima con su correspondiente imagen para cada
     * iteracion
     * @throws Exception
     */
    public static List<AuxSequentialAndUniformResult> uniformSequential(double x0, String expression, double s) throws Exception {
        int iteration = 0;
        List<AuxSequentialAndUniformResult> resList = new ArrayList<>();
//        ExpressionEvaluator ExpressionEvaluator = new ExpressionEvaluator(expression);
        double x = x0;//valor inicial por donde se empieza a buscar el maximo
        double y0;
//        if (evaluator.isTrigonometric()) {
//            y0 = evaluator.evaluateExpression(Math.toDegrees(x));//valor inicial de la funcion a optimizar
//        } else {
        y0 = ExpressionEvaluator.evaluateExpression(expression, (x));
        // }
        double y = y0;
        resList.add(new AuxSequentialAndUniformResult(iteration, y0, x));
        do {
            y0 = y;//se actualiza el valor de y de la iteracion anterior
            iteration++;//se incrementa el contador de iteraciones
            x = x0 + s;//se actualiza el valor de x como el valor de la iter anterior + el paso
//            if (evaluator.isTrigonometric()) {
//                y = evaluator.evaluateExpression(Math.toDegrees(x));//se evalua la expresion en el nuevo valor de y
//            } else {
            y = ExpressionEvaluator.evaluateExpression(expression, (x));
            //}
            resList.add(new AuxSequentialAndUniformResult(iteration, y, x));//se guardan los resultados
            x0 = x;//se actualiza el valor de la iteracion anterior
        } while (y > y0);//se va a iterara mientras el valor de la funcion en la iter act sea mayor que el de la iter anterior
        return resList;
    }

    /**
     * Optimizacion secuencial uniforme acelerad
     *
     * @param x0 Valor inicial a partir del cual se busca el maximo
     * @param expression Representacion de la expresion a optimizar
     * @param s Paso s
     * @return El valor de x maxima con su correspondiente imagen para cada
     * iteracion
     * @throws Exception
     */
    public static List<AuxSequentialAndUniformResult> uniformSequentialAccelerated(double x0, String expression, double s) throws Exception {
        int iteration = 0;
        List<AuxSequentialAndUniformResult> resList = new ArrayList<>();
//        ExpressionEvaluator ExpressionEvaluator = new ExpressionEvaluator(expression);
        double x = x0;
        double y0 = ExpressionEvaluator.evaluateExpression(expression, x);
        double y = y0;
        resList.add(new AuxSequentialAndUniformResult(iteration, x, y0));
        do {
            y0 = y;
            iteration++;
            x = x0 + s;
            y = ExpressionEvaluator.evaluateExpression(expression, x);
            resList.add(new AuxSequentialAndUniformResult(iteration, x, y));
            System.out.println(resList.get(iteration));
            x0 = x;
            s *= 2;
            /*
            falta hacer una condicion de reinicio para cuando alcance el maximo local mas proximo y no se quede estancado
            Esto en metaheuristica es un hill climber
             */
        } while (y > y0);
        return resList;
    }

    public static List<AuxSequentialAndUniformResult> uniformSequentialForMaxUnidim(double x0, String expression, double s) throws Exception {
        int iteration = 0;
        List<AuxSequentialAndUniformResult> resList = new ArrayList<>();
//        ExpressionEvaluator ExpressionEvaluator = new ExpressionEvaluator(expression);
        double x = x0;//valor inicial por donde se empieza a buscar el maximo
        double y0;
//        if (evaluator.isTrigonometric()) {
//            y0 = evaluator.evaluateExpression(Math.toDegrees(x));//valor inicial de la funcion a optimizar
//        } else {
        y0 = ExpressionEvaluator.evaluateExpression(expression, x);
        //evaluator.evaluateExpression((x));
        // }
        double y = y0;
        resList.add(new AuxSequentialAndUniformResult(iteration, y0, x));
        do {
            y0 = y;//se actualiza el valor de y de la iteracion anterior
            iteration++;//se incrementa el contador de iteraciones
            x = x0 + s;//se actualiza el valor de x como el valor de la iter anterior + el paso
//            if (evaluator.isTrigonometric()) {
//                y = evaluator.evaluateExpression(Math.toDegrees(x));//se evalua la expresion en el nuevo valor de y
//            } else {
            y = ExpressionEvaluator.evaluateExpression(expression, x);//evaluator.evaluateExpression((x));
            //}

            resList.add(new AuxSequentialAndUniformResult(iteration, y, x));//se guardan los resultados
            x0 = x;//se actualiza el valor de la iteracion anterior
        } while (y > y0 && iteration < 1000);//se va a iterara mientras el valor de la funcion en la iter act sea mayor que el de la iter anterior
        return resList;
    }
}
