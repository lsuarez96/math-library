/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcuationDefinition;

/**
 * Defines the type of token Each value stands for a basic type of operator or
 * operand: Operands: Number: represents a constant number Variable: represents
 * an independent variable of the function Function: stands for the definition
 * or identification of a mathematical function Operators: ADD: represents
 * addicion "+" SUB: represents substraccion "-" MULT: represents multiplication
 * "*" DIV: represents division "/" EXP: represents the operator of potenciation
 * "^" P_LEFT/P_Rigth: represents the operator of precedence parenteces "(/)"
 * Others: ERROR: stands for an error ocurred while parsing
 *
 * @author Luisito Suarez
 */
public enum TokenType {
    NUMBER, VARIABLE_X, VARIABLE_Y, vARIABLE_Z, FUNCTION, ADD, SUB, MULT, DIV, EXP, P_LEFT, P_RIGTH, ERROR
}
