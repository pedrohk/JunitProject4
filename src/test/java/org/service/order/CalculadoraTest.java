package org.service.order;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class CalculadoraTest {

    private Calculadora calculadora;
    private List<String> shoppingCart;

    @BeforeAll
    public static void beforeAll() {
        out.println("Executado uma vez antes de todos os testes.");
    }


    @AfterAll
    public static void afterAll() {
        out.println("Executado uma vez depois de todos os testes.");
    }


    @BeforeEach
    public void beforeEach() {
        calculadora = new Calculadora();
        shoppingCart = new ArrayList<>();
        out.println("Executado antes de cada teste.");
    }


    @AfterEach
    public void afterEach() {
        out.println("Executado depois de cada teste.");
    }


    @Test
    public void testSoma() {
        int resultado = calculadora.soma(2, 3);
        assertEquals(5, resultado);
    }


    @Test
    public void testSomaDiferente() {
        int resultado = calculadora.soma(2, 3);
        assertNotEquals(6, resultado);
    }


    @Test
    public void testArrayEquals() {
        int[] esperado = {1, 2, 3};
        int[] real = {1, 2, 3};
        assertArrayEquals(esperado, real);
    }

    @Test
    void groupAssertions() {
        int[] numbers = {0, 1, 2, 3, 4};
        assertAll("numbers",
                () -> assertEquals(numbers[0], 0),
                () -> assertEquals(numbers[3], 3),
                () -> assertEquals(numbers[4], 4)
        );
    }

    @Test
    void trueAssumption() {
        assumeTrue(5 > 1);
        assertEquals(5 + 2, 7);
    }

    @Test
    void falseAssumption() {
        assumeFalse(5 < 1);
        assertEquals(5 + 2, 7);
    }

    @Test
    void assumptionThat() {
        String someString = "Just a string";
        assumingThat(
                someString.equals("Just a string"),
                () -> assertEquals(2 + 2, 4)
        );
    }

    @Test
    void shouldThrowException() {
        Throwable exception = assertThrows(UnsupportedOperationException.class, () -> {
            throw new UnsupportedOperationException("Not supported");
        });
        assertEquals("Not supported", exception.getMessage());
    }

    @Test
    void assertThrowsException() {
        String str = null;
        assertThrows(IllegalArgumentException.class, () -> {
            Integer.valueOf(str);
        });
    }

    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculadora.dividir(10, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }


    @ParameterizedTest
    @CsvSource({
            "10, 5, 5",
            "100, 20, 80",
            "5, 5, 0",
            "0, 0, 0"
    })
    void testSubtraction(int minuend, int subtrahend, int expectedResult) {
        int actualResult = calculadora.subtrair(minuend, subtrahend);
        assertEquals(expectedResult, actualResult,
                () -> minuend + " - " + subtrahend + " should be " + expectedResult);
    }

    @Test
    void testAddItemToShoppingCart() {
        assertTrue(shoppingCart.isEmpty(), "Shopping cart should be empty initially");
        shoppingCart.add("Laptop");
        assertEquals(1, shoppingCart.size(), "Shopping cart should have 1 item");
        assertTrue(shoppingCart.contains("Laptop"), "Shopping cart should contain Laptop");
    }

    @Test
    void testComplexScenario() {
        // Test addition
        assertEquals(7, calculadora.soma(4, 3), "Addition test failed");

        // Test subtraction
        assertEquals(2, calculadora.subtrair(5, 3), "Subtraction test failed");

        // Test adding multiple items to cart
        shoppingCart.add("Mouse");
        shoppingCart.add("Keyboard");
        assertAll("Shopping Cart and Calculator Checks",
                () -> assertEquals(2, shoppingCart.size(), "Shopping cart should have 2 items"),
                () -> assertTrue(shoppingCart.contains("Mouse"), "Cart should contain Mouse"),
                () -> assertTrue(shoppingCart.contains("Keyboard"), "Cart should contain Keyboard"),
                () -> assertEquals(10.0, calculadora.dividir(100.0, 10.0), 0.001, "Division test failed")
        );
    }

}