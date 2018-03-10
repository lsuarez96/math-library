package EcuationDefinition;

import static EcuationDefinition.TokenType.ADD;
import static EcuationDefinition.TokenType.SUB;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents and evaluates a given mathematical expression
 *
 * @author Luisito Suarez
 */
public class ExpressionEvaluatorWithErrors {

    private Queue<Token> tokensQueue;//stores in a precedence order the tokens that identify each operand and operator
    private final String expRepresentation;//Representation of the ecuation
    private double variable1;//independent variable
    private double variable2;
    private double variable3;

    public ExpressionEvaluatorWithErrors(String expression) {
        this.expRepresentation = expression;
    }

    /**
     * Generates the necesary tokens and stores them into the queue by
     * precedence order
     *
     * @throws Exception
     */
    private void generateTokens() throws Exception {
        tokensQueue = new ArrayDeque<>();
        @SuppressWarnings("StringBufferMayBeStringBuilder")
        StringBuffer input = new StringBuffer(expRepresentation);
        Pattern numPattern = Pattern.compile("\\-?-?\\*?-?\\d+(\\.\\d+)?");   //"\\d+(\\.\\d+)?"
        //Pattern numPattern = Pattern.compile("\\d+(\\.\\d+)?");

        Pattern IDPattern = Pattern.compile("\\p{Alpha}\\w+");
        while (input.length() > 0) {
            Matcher m = numPattern.matcher(input);//regular expression matcher
            // Matcher m2=numPattern2.matcher(input);
            if (m.lookingAt() && (input.charAt(0) != '*' && input.charAt(0) != '+' && input.charAt(0) != '/')) {
                tokensQueue.add(new Token(TokenType.NUMBER, m.group()));
                input.delete(0, m.end());
                continue;
            }
//            else {
//                m=numPattern2.matcher(input);
//                if(m.lookingAt()){
//                 tokensQueue.add(new Token(TokenType.NUMBER, m.group()));
//                input.delete(0, m.end());
//                continue;
//            }
//            }
            if (input.charAt(0) == 'x' || input.charAt(0) == 'X') {//is an independent variable
                tokensQueue.add(new Token(TokenType.VARIABLE_X, "x"));
                input.deleteCharAt(0);
                continue;
            }
            if (input.charAt(0) == 'y' || input.charAt(0) == 'Y') {
                tokensQueue.add(new Token(TokenType.VARIABLE_Y, "y"));
                input.deleteCharAt(0);
                continue;
            }
            if (input.charAt(0) == 'z' || input.charAt(0) == 'Z') {
                tokensQueue.add(new Token(TokenType.VARIABLE_Y, "z"));
                input.deleteCharAt(0);
                continue;
            }
            if (input.charAt(0) == '+') {//is a plus sign
                tokensQueue.add(new Token(TokenType.ADD));
                input.deleteCharAt(0);
                continue;
            }
            if (input.charAt(0) == '-') {//is a minus sign
                tokensQueue.add(new Token(TokenType.SUB));
                input.deleteCharAt(0);
                continue;
            }
            if (input.charAt(0) == '*') {//is a multiplication sign
                tokensQueue.add(new Token(TokenType.MULT));
                input.deleteCharAt(0);
                continue;
            }
            if (input.charAt(0) == '/') {//is a division sign
                tokensQueue.add(new Token(TokenType.DIV));
                input.deleteCharAt(0);
                continue;
            }
            if (input.charAt(0) == '(') {//left parenteces
                tokensQueue.add(new Token(TokenType.P_LEFT));
                input.deleteCharAt(0);
                continue;
            }
            if (input.charAt(0) == ')') {//rigth parenteces
                tokensQueue.add(new Token(TokenType.P_RIGTH));
                input.deleteCharAt(0);
                continue;
            }
            if (input.charAt(0) == '^') {//exponencial sign
                tokensQueue.add(new Token(TokenType.EXP));
                input.deleteCharAt(0);
                continue;
            }
            m = IDPattern.matcher(input);
            if (m.lookingAt()) {//mathematical expression
                String match = m.group();
                if (match.contains("ln") || match.equalsIgnoreCase("ln")) {
                    match = "log1p";
                }
                tokensQueue.add(new Token(TokenType.FUNCTION, match));
                input.delete(0, m.end());
                continue;
            }
            throw new Exception("Elemento no reconocido en la entrada: "
                    + input.charAt(0));
        }
    }

    /**
     * Deals with the evaluation of the math expression for a given value
     *
     * @return
     */
    private double expression() {
        double result = finished();
        while (!tokensQueue.isEmpty()) {
            switch (tokensQueue.element().getType()) {
                case ADD:
                    tokensQueue.remove();
                    result += finished();
                    continue;
                case SUB:
                    tokensQueue.remove();
                    result -= finished();
                    continue;
            }
            break;
        }
        return result;
    }

    private double finished() {
        double result = factor();
        while (!tokensQueue.isEmpty()) {
            switch (tokensQueue.element().getType()) {
                case MULT:
                    tokensQueue.remove();
                    result *= factor();
                    continue;
                case DIV:
                    tokensQueue.remove();
                    result /= factor();
                    continue;
                default:
            }
            break;
        }
        return result;
    }

    private double factor() {
        double result = valor();
        while (!tokensQueue.isEmpty()) {
            switch (tokensQueue.element().getType()) {
                case EXP:
                    tokensQueue.remove();
                    result = Math.pow(result, valor());
                    continue;
            }
            break;
        }
        return result;
    }

    private double valor() {
        Token token;
        try {
            double result = 0;
            token = tokensQueue.poll();
            switch (token.getType()) {
                case P_LEFT:
                    result = expression();
                    readToken(TokenType.P_RIGTH);
                    return result;
                case NUMBER:
                    return Double.parseDouble(token.getText());
                case VARIABLE_X:
                    return variable1;
                case VARIABLE_Y:
                    return variable2;
                case vARIABLE_Z:
                    return variable3;
                case FUNCTION:
                    readToken(TokenType.P_LEFT);
                    double argumento = expression();
                    readToken(TokenType.P_RIGTH);
                    Method m = java.lang.Math.class.
                            getMethod(token.getText(), Double.TYPE);
                    String f = m.getName();
                    if (f.equalsIgnoreCase("sin") || f.equalsIgnoreCase("cos") || f.equalsIgnoreCase("asin") || f.equalsIgnoreCase("acos")
                            || f.equalsIgnoreCase("tan") || f.equalsIgnoreCase("atan") || f.equalsIgnoreCase("sinh") || f.equalsIgnoreCase("cosh")) {

                        argumento = (argumento);
                    }
                    if (f.equals("sin") && (argumento == Math.PI || (argumento % (2 * Math.PI) == 0))) {
                        return 0;
                    } else if (f.equalsIgnoreCase("cos") && (argumento == Math.toRadians(90)) || (argumento % Math.toRadians(270) == 0)) {
                        return 0;
                    }
                    return (Double) m.invoke(null, argumento);
            }
            return result;
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            System.exit(0);
        }
        return 0;
    }

    private boolean readToken(TokenType t) {
        Token token = tokensQueue.poll();
        if (token.getType().equals(t)) {
            return true;
        } else {
            System.err.println("Error: elemento no permitido " + token.getText());
            return true;
        }
    }

    public double evaluateExpression(double valor) throws Exception {
        generateTokens();
        this.variable1 = valor;
        return expression();
    }

    public double evaluateExpression() throws Exception {
        generateTokens();
        return expression();
    }

    public double evaluateExpression(double X_Value, double Y_Value) throws Exception {
        generateTokens();
        this.variable2 = Y_Value;
        this.variable1 = X_Value;
        return expression();
    }

    public double evaluateExpression(double X_Value, double Y_Value, double Z_Value) throws Exception {
        generateTokens();
        this.variable2 = Y_Value;
        this.variable1 = X_Value;
        this.variable3 = Z_Value;
        return expression();
    }

    public boolean isTrigonometric() {
        boolean trig = expRepresentation.contains("sin") || expRepresentation.contains("cos") || expRepresentation.contains("tan") || expRepresentation.contains("cot");
        return trig;
    }
}
