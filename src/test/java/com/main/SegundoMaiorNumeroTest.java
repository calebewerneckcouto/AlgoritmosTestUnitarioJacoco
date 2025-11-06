package com.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class SegundoMaiorNumeroTest {

    // Testes para encontrarSegundoMaior com int[]
    @Test
    void encontrarSegundoMaiorNumerosDistintosTest() {
        int[] numeros = {10, 5, 8, 15, 3};
        int resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(10, resultado);
    }

    @Test
    void encontrarSegundoMaiorNumerosNegativosTest() {
        int[] numeros = {-5, -10, -3, -1, -8};
        int resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(-3, resultado);
    }

    @Test
    void encontrarSegundoMaiorTodosNegativosTest() {
        int[] numeros = {-10, -5, -8, -15, -3};
        int resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(-5, resultado);
    }

    @Test
    void encontrarSegundoMaiorComRepeticaoTest() {
        int[] numeros = {10, 10, 8, 15, 15, 12};
        int resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(12, resultado);
    }

    @Test
    void encontrarSegundoMaiorDoisElementosTest() {
        int[] numeros = {20, 10};
        int resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(10, resultado);
    }

    @Test
    void encontrarSegundoMaiorDoisElementosInvertidosTest() {
        int[] numeros = {10, 20};
        int resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(10, resultado);
    }

    @Test
    void encontrarSegundoMaiorArrayNuloTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            SegundoMaiorNumero.encontrarSegundoMaior(null);
        });
        assertEquals("O array não pode ser nulo", exception.getMessage());
    }

    @Test
    void encontrarSegundoMaiorArrayVazioTest() {
        int[] numeros = {};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        });
        assertEquals("O array deve ter pelo menos 2 elementos", exception.getMessage());
    }

    @Test
    void encontrarSegundoMaiorApenasUmElementoTest() {
        int[] numeros = {5};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        });
        assertEquals("O array deve ter pelo menos 2 elementos", exception.getMessage());
    }

    @Test
    void encontrarSegundoMaiorTodosIguaisTest() {
        int[] numeros = {7, 7, 7, 7, 7};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        });
        assertEquals("Não existe segundo maior número distinto", exception.getMessage());
    }

    @Test
    void encontrarSegundoMaiorNumerosGrandesTest() {
        int[] numeros = {1000000, 500000, 750000, 1000000, 250000};
        int resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(750000, resultado);
    }

    @Test
    void encontrarSegundoMaiorComZeroTest() {
        int[] numeros = {0, -5, 10, 5, 0};
        int resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(5, resultado);
    }

    @Test
    void encontrarSegundoMaiorComNumerosEmOrdemCrescenteTest() {
        int[] numeros = {1, 2, 3, 4, 5};
        int resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(4, resultado);
    }

    @Test
    void encontrarSegundoMaiorComNumerosEmOrdemDecrescenteTest() {
        int[] numeros = {5, 4, 3, 2, 1};
        int resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(4, resultado);
    }
}