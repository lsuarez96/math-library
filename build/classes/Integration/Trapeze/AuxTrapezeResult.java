/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Integration.Trapeze;

import Integration.Simpson.AuxiliarSimpsonResult;

/**
 *
 * @author Luisito Suarez
 */
public class AuxTrapezeResult extends AuxiliarSimpsonResult{
  
    public AuxTrapezeResult(double maxError, double result) {
        super(maxError, result);
    }
  
}
