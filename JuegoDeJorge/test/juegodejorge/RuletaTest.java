/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodejorge;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pablo
 */
public class RuletaTest {
    
    public RuletaTest() {
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
     * Test of determinarDinero method, of class Ruleta.
     */
    @Test
    public void testDeterminarDinero() {
        System.out.println("determinarDinero");
        Float expResult = null;
        Float result = Ruleta.determinarDinero();
        assertEquals(expResult, result);
      
        fail("The test case is a prototype.");
    }

    /**
     * Test of apuestaNumero method, of class Ruleta.
     */
    @Test
    public void testApuestaNumero() {
        System.out.println("apuestaNumero");
        int[] expResult = null;
        int[] result = Ruleta.apuestaNumero();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of apuestaColor method, of class Ruleta.
     */
    @Test
    public void testApuestaColor() throws Exception {
        System.out.println("apuestaColor");
        int[] expResult = null;
        int[] result = Ruleta.apuestaColor();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of apuestaZona method, of class Ruleta.
     */
    @Test
    public void testApuestaZona() {
        System.out.println("apuestaZona");
        int[] expResult = null;
        int[] result = Ruleta.apuestaZona();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of apuesta method, of class Ruleta.
     */
    @Test
    public void testApuesta() {
        System.out.println("apuesta");
        float dinero = 0.0F;
        float expResult = 0.0F;
        float result = Ruleta.apuesta(dinero);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ruletaMovimiento method, of class Ruleta.
     */
    @Test
    public void testRuletaMovimiento() {
        System.out.println("ruletaMovimiento");
        int expResult = 0;
        int result = Ruleta.ruletaMovimiento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculador method, of class Ruleta.
     */
    @Test
    public void testCalculador() {
        System.out.println("calculador");
        int resultado = 0;
        int[] numeros = null;
        float apostado = 0.0F;
        float expResult = 0.0F;
        float result = Ruleta.calculador(resultado, numeros, apostado);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of numeroMenu method, of class Ruleta.
     */
    @Test
    public void testNumeroMenu() {
        System.out.println("numeroMenu");
        int expResult = 0;
        int result = Ruleta.numeroMenu();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
