/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinearSystems.Jacobi;

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
public class JacobiTest {

    public JacobiTest() {
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
     * Test of jacobi method, of class Jacobi.
     */
    @Test
    public void testJacobi() {
        System.out.println("jacobi");

        double[][] systemMatrix = {{7, 3, 1}, {2, -6, 3}, {-1, 2, 5}};
        double[] solutions = {14, 19, 11};
        double tolerance = 2.5;

        List<JacobiAuxResult> expResult = null;
        List<JacobiAuxResult> result = Jacobi.jacobi(systemMatrix, solutions, tolerance);
        System.out.println(result);

//assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

}
