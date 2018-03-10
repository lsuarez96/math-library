/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Roots.Bisection;

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
public class BisectionTest {

    public BisectionTest() {
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
     * Test of bisection method, of class Bisection.
     */
    @Test
    public void testBisection() throws Exception {
        System.out.println("bisection");
        String expression = "(x^2)-2";
        double leftExtreme = 0;
        double rigthExtreme = 1.6;
        double tollerance = 0.000004;
        List<AuxBisectionResult> expResult = null;
        List<AuxBisectionResult> result = Bisection.bisection(expression, leftExtreme, rigthExtreme, tollerance);

        System.out.println(result.toString());
        //  assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //  fail("The test case is a prototype.");
    }

}
