/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Roots.RegulaFalsi;

import java.util.Arrays;
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
public class RegulaFalsiTest {
    
    public RegulaFalsiTest() {
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
     * Test of regulaFalsi method, of class RegulaFalsi.
     */
    @Test
    public void testRegulaFalsi() throws Exception {
        System.out.println("regulaFalsi");
        String expression = "x^2-2";
        double leftExtreme = 0.5;
        double rigthExtreme = 2.5;
        double tolerance = 0.0004;
        List<AuxRegulaFalsiResult> expResult = null;
        List<AuxRegulaFalsiResult> result = RegulaFalsi.regulaFalsi(expression, leftExtreme, rigthExtreme, tolerance);
       for(AuxRegulaFalsiResult r:result)
        System.out.println(r.getRootValue()+"   |||   "+r.getMaxError()+"  |||   "+r.getIterationNumber());
       // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
