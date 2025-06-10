package org.service.order;

public class Calculadora {
    public int soma(int a, int b) {

        return a + b;
    }

    public int subtrair(int a, int b) {
        return a - b;
    }

    public double dividir(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }

    public int multiplicar(int a, int b) {
        return a * b;
    }

}
