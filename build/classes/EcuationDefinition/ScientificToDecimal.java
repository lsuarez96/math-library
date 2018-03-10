/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcuationDefinition;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 *
 * @author Luisito
 */
public class ScientificToDecimal {

    //Convierte un numero en notacion cientifica a numero normal
    public static String conversion(double valor) {
       Locale.setDefault(Locale.US);
      DecimalFormat num = new DecimalFormat("0.0000000000000000000");
      return num.format(valor);
    }

    
    public static void main(String[] args){
        System.out.println(9.9/10000000000000.0);
        double num=9.9999/100000000000000.0;
        System.out.println(conversion(num));
    }
}
