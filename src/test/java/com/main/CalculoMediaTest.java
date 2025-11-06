package com.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CalculoMediaTest {

    @Test
    void calcularMediaNumerosPositivosTest() {
        double[] numeros = {10.0, 20.0, 30.0, 40.0, 50.0};
        double resultado = CalculoMedia.calcularMedia(numeros);
        assertEquals(30.0, resultado, 0.001);
    }

    @Test
    void calcularMediaNumerosNegativosTest() {
        double[] numeros = {-10.0, -20.0, -30.0};
        double resultado = CalculoMedia.calcularMedia(numeros);
        assertEquals(-20.0, resultado, 0.001);
    }

    @Test
    void calcularMediaNumerosPositivosENegativosTest() {
        double[] numeros = {-10.0, 20.0, -5.0, 15.0};
        double resultado = CalculoMedia.calcularMedia(numeros);
        assertEquals(5.0, resultado, 0.001);
    }

    @Test
    void calcularMediaComDecimaisTest() {
        double[] numeros = {1.5, 2.5, 3.5, 4.5};
        double resultado = CalculoMedia.calcularMedia(numeros);
        assertEquals(3.0, resultado, 0.001);
    }

    @Test
    void calcularMediaApenasUmNumeroTest() {
        double[] numeros = {7.5};
        double resultado = CalculoMedia.calcularMedia(numeros);
        assertEquals(7.5, resultado, 0.001);
    }

    @Test
    void calcularMediaVetorNuloTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CalculoMedia.calcularMedia(null);
        });
        assertEquals("O array não pode ser nulo ou vazio", exception.getMessage());
    }

    @Test
    void calcularMediaVetorVazioTest() {
        double[] numeros = {};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CalculoMedia.calcularMedia(numeros);
        });
        assertEquals("O array não pode ser nulo ou vazio", exception.getMessage());
    }

    @Test
    void calcularMediaComZerosTest() {
        double[] numeros = {0.0, 0.0, 0.0, 0.0};
        double resultado = CalculoMedia.calcularMedia(numeros);
        assertEquals(0.0, resultado, 0.001);
    }

    @Test
    void calcularMediaNumerosGrandesTest() {
        double[] numeros = {1000000.0, 2000000.0, 3000000.0};
        double resultado = CalculoMedia.calcularMedia(numeros);
        assertEquals(2000000.0, resultado, 0.001);
    }
}