/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiDimensionalOptimization;

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
public class SearchByCoordinatesTest {

    public SearchByCoordinatesTest() {
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
     * Test of searchByCoordinates method, of class SearchByCoordinates.
     */
    @Test
    public void testSearchByCoordinates() throws Exception {
        System.out.println("searchByCoordinates");
        String expression = "-1*(100-3*(u1^2)-(4*(u2^2))+5*(u1)*(u2)+2*(u1))";
        double[] x0 = new double[]{0, 0};
        double tolerance = 0.0000;
        List<AuxCoordinatesResult> expResult = null;
        List<AuxCoordinatesResult> result = SearchByCoordinates.searchByCoordinates(expression, x0, tolerance);
        System.out.println(result);
//assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
