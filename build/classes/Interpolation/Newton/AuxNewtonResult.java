/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interpolation.Newton;

/**
 *
 * @author Luisito Suarez
 */
public class AuxNewtonResult {

    private double result;
    private double error;
    private double grade;

    public AuxNewtonResult(double result, double error, double grade) {
        this.result = result;
        this.error = error;
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

    /**
     * @return the error
     */
    public double getError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(double error) {
        this.error = error;
    }

    /**
     * @return the grade
     */
    public double getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(double grade) {
        this.grade = grade;
    }
    @Override
    public String toString(){
    return "Resultado: "+String.valueOf(result)+" Grado: "+String.valueOf(grade)+" Error: "+String.valueOf(error)+"\n";
}
}
