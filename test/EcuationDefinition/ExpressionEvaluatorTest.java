/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcuationDefinition;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Luisito Suarez
 */
public class ExpressionEvaluatorTest {

    public ExpressionEvaluatorTest() {
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
     * Test of evaluateExpression method, of class ExpressionEvaluator.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testEvaluateExpression() throws Exception {

        double[] expected = new double[]{5, 3, 1};

        String exp = "-1*5";
        // ExpressionEvaluator instance = new ExpressionEvaluator(exp);
        System.out.println(ExpressionEvaluator.evaluateExpression(exp, 2));

        //assertEquals(expResult, result, 0.0);
    }

}
