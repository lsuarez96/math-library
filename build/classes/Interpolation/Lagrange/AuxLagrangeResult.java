/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interpolation.Lagrange;

/**
 *
 * @author Luisito Suarez
 */
public class AuxLagrangeResult {
    private int grade;
    private double result;

    public AuxLagrangeResult(int grade, double result) {
        this.grade = grade;
        this.result = result;
    }
    
    

    /**
     * @return the grade
     */
    public int getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }

    /**
     * @return the result
     */
    public double getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(double result) {
        this.result = result;
    }
    
    @Override
    public String toString(){
        return "Grado: "+String.valueOf(grade)+" Resultado: "+String.valueOf(result)+"\n";
    }
    
}
