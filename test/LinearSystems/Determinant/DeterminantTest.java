/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinearSystems.Determinant;

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
public class DeterminantTest {
    
    public DeterminantTest() {
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
     * Test of calculateDeterminant method, of class Determinant.
     */
    @Test
    public void testCalculateDeterminant() {
        System.out.println("calculateDeterminant");
        double[][] matrix = {{2,2},{2,4}};
        double expResult = 4;
        double result = Determinant.calculateDeterminant(matrix);
        System.out.println(result);
        assertEquals(expResult, result, 4.0);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
