/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interpolation.Lagrange;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Luisito Suarez
 */
public class LagrangeTest {
    
    public LagrangeTest() {
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
     * Test of interpolateByLagrange method, of class Lagrange.
     */
    @Test
    public void testInterpolateByLagrange() {
        System.out.println("interpolateByLagrange");
        List<Double> x = new ArrayList<>();
        List<Double> y = new ArrayList<>();
        double [] xtemp=new double[]{-0.6,-0.5,-0.4,-0.3,-0.2,-0.1,0};
        double[] ytemp=new double[]{0.1,0.13,0.2,0.3,0.5,0.8,1};
        for(int i=0;i<xtemp.length;i++){
            x.add(xtemp[i]);
            y.add(ytemp[i]);
        }
        double value = 2.0;
        double expResult = 0.0;
        List<AuxLagrangeResult> result = Lagrange.interpolateByLagrange(x, y, value);
        result.stream().forEach((l) -> {
            System.out.println(l);           
        });
    }
    
}
