/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Optimizacion;

import UnidimencionalOptimizacion.AuxSequentialAndUniformResult;
import UnidimencionalOptimizacion.SequentialAndUniform;
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
public class SequentialAndUniformTest {

    public SequentialAndUniformTest() {
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
     * Test of uniformSequential method, of class SequentialAndUniform.
     */
    @Test
    public void testUniformSequential() throws Exception {
        System.out.println("UniformSequential");
        double Xo = 0.0;
        String expression = "(x^2)*sin(x)+3*x";
        Double s = 0.1;
        List<AuxSequentialAndUniformResult> expResult = null;
        List<AuxSequentialAndUniformResult> result = SequentialAndUniform.uniformSequentialForMaxUnidim(Xo, expression, s);
        System.out.println(result);

        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

}
