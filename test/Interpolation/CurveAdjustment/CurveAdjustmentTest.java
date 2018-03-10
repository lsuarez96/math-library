/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interpolation.CurveAdjustment;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Luisito
 */
public class CurveAdjustmentTest {

    public CurveAdjustmentTest() {
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
     * Test of adjustLinealModel method, of class CurveAdjustment.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testAdjustLinealModel() throws Exception {
        System.out.println("adjustLinealModel");
        String[] expressions = new String[]{"1", "x", "x^2"};
//        double[] x = new double[]{5.1, 7.7, 10.8,13.2};
//        double[] y = new double[]{0.10, 0.17, 0.24,0.30};
double[] x = new double[]{1, 2, 1,0};
        double[] y = new double[]{1, 2, 0,1};
        double[] result = CurveAdjustment.adjustLinealModel(expressions, x, y);
       System.out.println(Arrays.toString(result));

    }

}
