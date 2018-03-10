/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcuationDefinition;

import java.util.List;

/**
 *
 * @author Luisito Suarez
 */
public class ReplaceMentForMultVar {

    public static String replace(String expression, List<Double> uValues) {
        String replacement = expression;
        for (int i = 0; i < uValues.size(); i++) {
            String rep = String.valueOf(uValues.get(i));
            if (rep.contains("E") || rep.contains("e")) {
                rep = ScientificToDecimal.conversion(uValues.get(i));
            }
            replacement = replacement.replaceAll("u" + String.valueOf(i + 1), rep);
        }
        return replacement;
    }

    public static String replaceForMaxUnidim(String expression, String[] uValues) {
        String replacement = expression;
        for (int i = 0; i < uValues.length; i++) {
            String rep = String.valueOf(uValues[i]);
            if (rep.contains("E") || rep.contains("e")) {
                rep = ScientificToDecimal.conversion(Double.valueOf(uValues[i]));
            }
            replacement = replacement.replaceAll("u" + String.valueOf(i + 1), rep);
        }
        return replacement;
    }

    public static String replace(String expression, List<Double> uValues, int indexToReplace) {
        String replacement = expression;
        for (int i = 0; i < uValues.size(); i++) {
            String rep = String.valueOf(uValues.get(i));
            if (rep.contains("E") || rep.contains("e")) {
                rep = ScientificToDecimal.conversion(uValues.get(i));
            }
            replacement = replacement.replaceAll("u" + String.valueOf(indexToReplace), rep);
        }
        return replacement;
    }

    public static String replaceForMaxUnidim(String expression, String[] uValues, int index) {
        String replacement = expression;
        for (int i = 0; i < uValues.length; i++) {
            String rep = String.valueOf(uValues[i]);
            if (rep.contains("E") || rep.contains("e")) {
                rep = ScientificToDecimal.conversion(Double.valueOf(uValues[i]));
            }
            replacement = replacement.replaceAll("u" + String.valueOf(index), rep);
        }
        return replacement;
    }
}
