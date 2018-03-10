/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinearSystems.Gauss;

import java.util.Arrays;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Luisito Suarez
 */
public class GaussTest extends TestCase {

    public GaussTest() {
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
     * Test of solveSystemByEliminationGauss method, of class Gauss.
     */
    @Test
    public void testSolveSystemByEliminationGauss() {
        System.out.println("Directa");
        double[][] matrix = {{2.6, -2.7, 5.2}, {3.1, 0.5, -1}, {2.9, -5.2, -4.3}};
        double[] b = {7.25, 4.33, -5.6};
        double[] result = Gauss.solveSystemByEliminationGauss(matrix, b);
        @SuppressWarnings("MismatchedReadAndWriteOfArray")
        double[] expResult = new double[]{1.59557110397807, 1.03091066469506, 1.13172575467955};
        System.out.println(Arrays.toString(result));
        //assertEquals("Missmatch result error", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    public void testSolveSystemByElementaryEliminationGauss() {
        System.out.println("Elemental");
        double[][] matrix = {{2.6, -2.7, 5.2}, {3.1, 0.5, -1}, {2.9, -5.2, -4.3}};
        double[] b = {7.25, 4.33, -5.6};
        double[] expResult = {1.59557110397807, 1.03091066469506, 1.13172575467955};
        GausAuxResult r2 = Gauss.solveSystemByElementaryEliminationGauss(matrix, b);
       // assertEquals("Missmatch result error", expResult, r2);
        System.out.println("Soluciones" + Arrays.toString(r2.getSolutions()));
        System.out.println("Pivotes" + Arrays.toString(r2.getPivots()));
        
    }

    public void testSolveSystemByParcialEliminationGauss() {
        System.out.println("Parcial");
        double[][] matrix = {{2.6, -2.7, 5.2}, {3.1, 0.5, -1}, {2.9, -5.2, -4.3}};
        double[] b = {7.25, 4.33, -5.6};
        double[] expResult;
        expResult = new double[]{1.59557110397807, 1.03091066469506, 1.13172575467955};
        GausAuxResult r2 = Gauss.solveSystemByParcialEliminationGauss(matrix, b);
       // assertEquals("Missmatch result error", expResult, r2);
        System.out.println("Soluciones" + Arrays.toString(r2.getSolutions()));
        System.out.println("Pivotes" + Arrays.toString(r2.getPivots()));
        System.out.println("Parcial");
        double[][] matrix2 = {{3, -1, 1, -1}, {-1, -1, 0, 1}, {0, 4, 1, 1}, {-1, -1, -1, -1}};
        double[] b2 = {45, 0, 18, 5};       
        GausAuxResult r22 = Gauss.solveSystemByParcialEliminationGauss(matrix2, b2);
        //assertEquals("Missmatch result error", expResult2, r22);
        System.out.println("Soluciones" + Arrays.toString(r22.getSolutions()));
        System.out.println("Pivotes" + Arrays.toString(r22.getPivots()));
    }
    
  
}
