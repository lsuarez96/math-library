/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinearSystems.Seidel;

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
public class SeidelTest {

    public SeidelTest() {
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
     * Test of seidel method, of class Seidel.
     */
    @Test
    public void testSeidel() {
        System.out.println("Test Seidel");
        double[][] systemMatrix = {{9, -1, 2}, {1, 8, 2}, {1, -1, 11}};
        double[] solutions = {9, 19, 10};
        double tolerance = 0.00001;
        List<AuxSeidelResult> result = Seidel.seidel(systemMatrix, solutions, tolerance);
        System.out.println(result + "\n");

        double[][] systemMatrix1 = {{2, -6, 3}, {7, 3, 1}, {-1, 2, 5}};
        double[] solutions1 = {19, 14, 11};
        result = Seidel.seidel(systemMatrix1, solutions1, tolerance);
        System.out.println(result);
    }

}
