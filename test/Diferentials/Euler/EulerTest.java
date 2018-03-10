/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diferentials.Euler;

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
public class EulerTest {
    
    public EulerTest() {
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
     * Test of solveDifByEuler method, of class Euler.
     */
    @Test
    public void testSolveDifByEuler() throws Exception {
        System.out.println("solveDifByEuler");
        String expression = "(x^2)-(y^2)";
        double x0 = 0.0;
        double xf = 3.0;
        double y0 = 1;
        double h = 0.1;
        List<AuxEulerResult> expResult = null;
        List<AuxEulerResult> result = Euler.solveDifByEuler(expression, x0, xf, y0, h);
        System.out.println(result);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
