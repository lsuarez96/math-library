/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diferentials.RungeKuttaForSystems;

import static Diferentials.RungeKuttaForSystems.RungeKuttaForSystems.solveDifSystemByRK2;
import java.util.ArrayList;
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
public class RungeKuttaForSystemsTest {

    public RungeKuttaForSystemsTest() {
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
     * Test of solveDifSystemByRK2 method, of class RungeKuttaForSystems.
     */
    @Test
    public void testSolveDifSystemByRK2() throws Exception {
        System.out.println("solveDifSystemByRK2");
        String[] ex = new String[]{"x+u2-u1*u3", "x*u3", "u1+u2-u3"};
        double[] u = new double[]{3, 1.7, 2.5};
        List<String> expressions = new ArrayList<>();
        List<Double> u0 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            expressions.add(ex[i]);
            u0.add(u[i]);
        }
        System.out.println(solveDifSystemByRK2(expressions, 1.4, 3, 0.1, u0));
    }

    @Test
    public void testSolveDifSystemByRK4() throws Exception {
        System.out.println("solveDifSystemByRK4");
        String[] ex = new String[]{"x+u2-u1*u3", "x*u3", "u1+u2-u3"};
        double[] u = new double[]{3, 1.7, 2.5};
        List<String> expressions = new ArrayList<>();
        List<Double> u0 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            expressions.add(ex[i]);
            u0.add(u[i]);
        }
        System.out.println(RungeKuttaForSystems.solveDifSystemByRK4(expressions, 1.4, 3, 0.1, u0));
    }
}
