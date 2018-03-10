/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Optimizacion.Bisection;

import Optimizacion.ByIntervals.AuxResultOptimBisect;
import Optimizacion.ByIntervals.OptimizationByBisection;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Luisito
 */
public class ObtimizationByBisectionTest {

    public ObtimizationByBisectionTest() {
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
     * Test of optimIntervalByBiseccion method, of class
     * OptimizationByBisection.
     */
    @Test
    public void testOptBiseccion() throws Exception {
        System.out.println("OptBiseccion");
        String expression = "(x^2)-2";
        double minInterv = 1.0;
        double maxInterv = 2.0;
        double distGamma = 0;
        double tolerance = 0.00;
        List<AuxResultOptimBisect> expResult = null;
        List<AuxResultOptimBisect> result = OptimizationByBisection.optimIntervalByBiseccionMaxUnidim(expression, minInterv, maxInterv, distGamma, tolerance);
        System.out.println(result);

    }

}
