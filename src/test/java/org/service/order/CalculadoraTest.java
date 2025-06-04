package org.service.order;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CalculadoraTest {

    @BeforeClass
    public static void beforeAll() {
        System.out.println("Executado uma vez antes de todos os testes.");
    }


    @AfterClass
    public static void afterAll() {
        System.out.println("Executado uma vez depois de todos os testes.");
    }


    @Before
    public void beforeEach() {
        System.out.println("Executado antes de cada teste.");
    }


    @After
    public void afterEach() {
        System.out.println("Executado depois de cada teste.");
    }


    @Test
    public void testSoma() {
        Calculadora calc = new Calculadora();
        int resultado = calc.soma(2, 3);
        assertEquals(5, resultado); 
    }


    @Test
    public void testSomaDiferente() {
        Calculadora calc = new Calculadora();
        int resultado = calc.soma(2, 3);
        assertNotEquals(6, resultado);
    }


    @Test
    public void testArrayEquals() {
        int[] esperado = {1, 2, 3};
        int[] real = {1, 2, 3};
        assertArrayEquals(esperado, real);
    }
}