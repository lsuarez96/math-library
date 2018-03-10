package EcuationDefinition;

import java.util.List;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ScriptEngineEvaluator {

    public static double evaluarEcuacion(String ecuacion, double valor) throws ScriptException {
        ecuacion = ecuacion.replace("sin", "Math.sin");
        ecuacion = ecuacion.replace("cos", "Math.cos");
        ecuacion = ecuacion.replace("tan", "Math.tan");
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        engine.put("x", valor);

        double resultado = (double) engine.eval(ecuacion);

        return resultado;
    }

    public static double evaluateMultiVar(String expression, List<Double> multiValues) throws ScriptException {
        Double result;
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        int i = 1;
        for (Double valor : multiValues) {
            engine.put("u" + String.valueOf(i), valor);
            i++;
        }
        result = (Double) engine.eval(expression.toLowerCase());

        return result;
    }

    public static void main(String[] args) throws ScriptException {
        double a = evaluarEcuacion("(-5)+(8*7)+x*-5", 0);
        System.out.println(a);
    }
}
