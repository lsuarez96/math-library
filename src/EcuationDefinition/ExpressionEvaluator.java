package EcuationDefinition;

import jme.*;

/**
 * Represents and evaluates a given mathematical expression
 *
 * @author Luisito Suarez
 */
public class ExpressionEvaluator {

    public static double evaluateExpression(String expression, double valor) throws Exception {
        Expresion exp = new Expresion(expression);
        exp.setVariable("x", valor);

        return Double.valueOf(exp.evaluar().toString());
    }

    public static double evaluateExpression(String expression) throws Exception {
        Expresion exp = new Expresion(expression);

        return Double.valueOf(exp.evaluar().toString());
    }

    public static double evaluateExpression(String expression, double X_Value, double Y_Value) throws Exception {
        Expresion exp = new Expresion(expression);
        exp.setVariable("x", X_Value);
        exp.setVariable("y", Y_Value);

        return Double.valueOf(exp.evaluar().toString());
    }

    public static double evaluateExpression(String expression, double X_Value, double Y_Value, double Z_Value) throws Exception {
        Expresion exp = new Expresion(expression);
        exp.setVariable("x", X_Value);
        exp.setVariable("y", Y_Value);
        exp.setVariable("z", Z_Value);
        return Double.valueOf(exp.evaluar().toString());

    }

}
