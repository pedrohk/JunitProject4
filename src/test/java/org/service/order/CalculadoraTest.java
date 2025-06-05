package org.service.order;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CalculadoraTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Executado uma vez antes de todos os testes.");
    }


    @AfterAll
    public static void afterAll() {
        System.out.println("Executado uma vez depois de todos os testes.");
    }


    @BeforeEach
    public void beforeEach() {
        System.out.println("Executado antes de cada teste.");
    }


    @AfterEach
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