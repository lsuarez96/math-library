/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Integration.Trapeze;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Luisito Suarez
 */
public class TrapezeTest {
    
    public TrapezeTest() {
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
     * Test of integrationByTrapeze method, of class Trapeze.
     */
    @Test
    public void testIntegrationByTrapeze() throws Exception {
        System.out.println("integrationByTrapeze");
        String expression = "sin(x)";
        double leftInteerval = 0.0;
        double rigthInterval = Math.PI;
        int nIntervals = 4;
        AuxTrapezeResult expResult = null;
        AuxTrapezeResult result = Trapeze.integrationByTrapeze(expression, leftInteerval, rigthInterval, nIntervals);
        System.out.println(result);
       // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
