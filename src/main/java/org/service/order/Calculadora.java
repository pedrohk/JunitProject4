package org.service.order;

public class Calculadora {
    public int soma(int a, int b) {

        return a + b;
    }

    int subtrair(int a, int b) {
        return a - b;
    }

    double dividir(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }

}
