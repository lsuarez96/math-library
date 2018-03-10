/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Roots.NewtonRaphson;

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
public class NewtonRaphsonTest {

    public NewtonRaphsonTest() {
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
     * Test of newtonRaphson method, of class NewtonRaphson.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testNewtonRaphson() throws Exception {
        System.out.println("newtonRaphson");
        String expression = "sin(x)";
        String derivateExpression = "cos(x)";
        double initialValue = Math.PI / 4;
        double tolerance = 0.00004;
        List<AuxNewtonResult> expResult = null;
        List<AuxNewtonResult> result = NewtonRaphson.newtonRaphson(expression, derivateExpression, initialValue, tolerance);
        //assertEquals(expResult, result);
        System.out.println(result.toString());
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

}
