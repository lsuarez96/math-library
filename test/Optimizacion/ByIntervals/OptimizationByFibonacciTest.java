/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Optimizacion.ByIntervals;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Luisito
 */
public class OptimizationByFibonacciTest {
    
    public OptimizationByFibonacciTest() {
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
     * Test of optimIntervByFibonacci method, of class OptimizationByFibonacci.
     */
    @Test
    public void testOptimByFibonacci() throws Exception {
        System.out.println("optimByFibonacci");
        String expression = "sin(x)";
        double minInterv = 2.0;
        double maxInterv = 2.1;
        double tolerance = 0.0;
        List<AuxResultOptFibonacci> expResult = null;
        List<AuxResultOptFibonacci> result = OptimizationByFibonacci.optimIntervByFibonacci(expression, minInterv, maxInterv, tolerance);
        System.out.println(result);

    }
    
}
