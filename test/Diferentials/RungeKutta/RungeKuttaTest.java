/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diferentials.RungeKutta;

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
public class RungeKuttaTest {

    public RungeKuttaTest() {
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
     * Test of solveDiferentialByRK2 method, of class RungeKutta.
     */
    @Test
    public void testSolveDiferentialByRK2() throws Exception {
        System.out.println("solveDiferentialByRK2");
        String expression = "(x^2)-(y^2)";
        double x0 = 0.0;
        double xf = 3.0;
        double y0 = 1;
        double h = 0.1;
        List<AuxRungeKuttaResult> expResult = null;
        List<AuxRungeKuttaResult> result = RungeKutta.solveDiferentialByRK4(expression, x0, y0, xf, h);
        System.out.println(result);
//assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of solveDiferentialByRK4 method, of class RungeKutta.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testSolveDiferentialByRK4() throws Exception {
        System.out.println("solveDiferentialByRK4");
        String expression = "x-y";
        double x0 = 1.0;
        double y0 = 3.0;
        double h = 0.1;
        double xf = 5.0;
        List<AuxRungeKuttaResult> expResult = null;
        List<AuxRungeKuttaResult> result = RungeKutta.solveDiferentialByRK4(expression, x0, y0, h, xf);
        System.out.println(result);
        // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

}
