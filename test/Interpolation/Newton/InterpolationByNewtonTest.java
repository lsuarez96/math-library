/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interpolation.Newton;


import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Luisito Suarez
 */
public class InterpolationByNewtonTest {
    
    public InterpolationByNewtonTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of interpolateByNewton method, of class InterpolationByNewton.
     */
    @Test
    public void testInterpolateByNewton() {
        System.out.println("interpolateByNewton");
        List<Double> xValues = new ArrayList<>();
        List<Double> yValues = new ArrayList<>();
         double [] xtemp=new double[]{2,2.5,3,3.5,4,4.5,5,5.5,6,6.5};
        double[] ytemp=new double[]{3,14,34,64,107,165,240,336,451,591};
        for(int i=0;i<xtemp.length;i++){
            xValues.add(xtemp[i]);
            yValues.add(ytemp[i]);
        }
        double value = 2.5;
        double tolerance = 0.0;
        List<AuxNewtonResult> expResult = null;
        List<AuxNewtonResult> result = InterpolationByNewton.interpolateByNewton(xValues, yValues, value, tolerance);
        System.out.println(result);
       
    }
    
}
