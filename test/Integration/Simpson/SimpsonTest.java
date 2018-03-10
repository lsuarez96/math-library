/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Integration.Simpson;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Luisito Suarez
 */
public class SimpsonTest {
    
    public SimpsonTest() {
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
     * Test of solveBySimpson method, of class Simpson.
     * @throws java.lang.Exception
     */
    @Test
    public void testSolveBySimpson() throws Exception {
        System.out.println("solveBySimpson");
        String expression = "sin(x)";
        double leftInterval = 0.0;
        double rigthInterval = 3.14159;       
        int nIntervals = 8;
        AuxiliarSimpsonResult expResult = null;
        AuxiliarSimpsonResult result = Simpson.solveBySimpson(expression, leftInterval, rigthInterval, nIntervals);
        System.out.println(result.toString());
       // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
