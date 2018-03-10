/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinearSystems.Inversion;

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
public class InversionGaussTest {
    
    public InversionGaussTest() {
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
     * Test of inversionByGaussMethod method, of class InversionGauss.
     */
    @Test
    public void testInversionByGaussMethod() {
        System.out.println("inersionByGauss");
        double[][] matrix ={{4,3},{2,1}};
        InversionGauss instance = new InversionGauss();
        AuxInvResult expResult = null;
        AuxInvResult result = instance.inversionByGaussMethod(matrix);
        //assertEquals(expResult, result);
        System.out.println(result.toString());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
