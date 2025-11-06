package com.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class SomaDoisTest {

    // Testes para encontrarIndicesSoma
    @Test
    void encontrarIndicesSomaParEncontradoTest() {
        int[] numeros = {2, 7, 11, 15};
        int alvo = 9;
        int[] resultado = SomaDois.encontrarIndicesSoma(numeros, alvo);
        assertEquals(2, resultado.length);
        assertEquals(alvo, numeros[resultado[0]] + numeros[resultado[1]]);
    }

    @Test
    void encontrarIndicesSomaComNegativosTest() {
        int[] numeros = {-3, 4, 3, 90};
        int alvo = 0;
        int[] resultado = SomaDois.encontrarIndicesSoma(numeros, alvo);
        assertEquals(2, resultado.length);
        assertEquals(alvo, numeros[resultado[0]] + numeros[resultado[1]]);
    }

    @Test
    void encontrarIndicesSomaNumerosRepetidosTest() {
        int[] numeros = {3, 3, 4, 5};
        int alvo = 6;
        int[] resultado = SomaDois.encontrarIndicesSoma(numeros, alvo);
        assertEquals(2, resultado.length);
        assertEquals(alvo, numeros[resultado[0]] + numeros[resultado[1]]);
    }

    @Test
    void encontrarIndicesSomaAlvoGrandeTest() {
        int[] numeros = {10, 20, 30, 40, 50};
        int alvo = 90;
        int[] resultado = SomaDois.encontrarIndicesSoma(numeros, alvo);
        assertEquals(2, resultado.length);
        assertEquals(alvo, numeros[resultado[0]] + numeros[resultado[1]]);
    }

    @Test
    void encontrarIndicesSomaAlvoPequenoTest() {
        int[] numeros = {1, 2, 3, 4, 5};
        int alvo = 3;
        int[] resultado = SomaDois.encontrarIndicesSoma(numeros, alvo);
        assertEquals(2, resultado.length);
        assertEquals(alvo, numeros[resultado[0]] + numeros[resultado[1]]);
    }

    @Test
    void encontrarIndicesSomaArrayNuloTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            SomaDois.encontrarIndicesSoma(null, 10);
        });
        assertEquals("O array deve ter pelo menos 2 elementos", exception.getMessage());
    }

    @Test
    void encontrarIndicesSomaArrayVazioTest() {
        int[] numeros = {};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            SomaDois.encontrarIndicesSoma(numeros, 10);
        });
        assertEquals("O array deve ter pelo menos 2 elementos", exception.getMessage());
    }

    @Test
    void encontrarIndicesSomaApenasUmElementoTest() {
        int[] numeros = {5};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            SomaDois.encontrarIndicesSoma(numeros, 10);
        });
        assertEquals("O array deve ter pelo menos 2 elementos", exception.getMessage());
    }

    @Test
    void encontrarIndicesSomaNaoEncontradoTest() {
        int[] numeros = {1, 2, 3, 4};
        int alvo = 10;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            SomaDois.encontrarIndicesSoma(numeros, alvo);
        });
        assertEquals("Nenhum par encontrado para a soma alvo", exception.getMessage());
    }

    @Test
    void encontrarIndicesSomaComZeroTest() {
        int[] numeros = {0, 4, 3, 0};
        int alvo = 0;
        int[] resultado = SomaDois.encontrarIndicesSoma(numeros, alvo);
        assertEquals(2, resultado.length);
        assertEquals(alvo, numeros[resultado[0]] + numeros[resultado[1]]);
    }

    @Test
    void encontrarIndicesSomaNumerosGrandesTest() {
        int[] numeros = {1000000, 500000, 750000, 250000};
        int alvo = 1250000;
        int[] resultado = SomaDois.encontrarIndicesSoma(numeros, alvo);
        assertEquals(2, resultado.length);
        assertEquals(alvo, numeros[resultado[0]] + numeros[resultado[1]]);
    }

    @Test
    void encontrarIndicesSomaOrdemDiferenteTest() {
        int[] numeros = {8, 2, 5, 1};
        int alvo = 7;
        int[] resultado = SomaDois.encontrarIndicesSoma(numeros, alvo);
        assertEquals(2, resultado.length);
        assertEquals(alvo, numeros[resultado[0]] + numeros[resultado[1]]);
    }

    @Test
    void encontrarIndicesSomaComMesmoElementoDuasVezesTest() {
        int[] numeros = {3, 2, 4};
        int alvo = 6;
        int[] resultado = SomaDois.encontrarIndicesSoma(numeros, alvo);
        assertEquals(2, resultado.length);
        assertEquals(alvo, numeros[resultado[0]] + numeros[resultado[1]]);
        assertNotEquals(resultado[0], resultado[1]);
    }

    @Test
    void encontrarIndicesSomaIndicesDiferentesTest() {
        int[] numeros = {1, 2, 3, 4};
        int alvo = 5;
        int[] resultado = SomaDois.encontrarIndicesSoma(numeros, alvo);
        assertEquals(2, resultado.length);
        assertEquals(alvo, numeros[resultado[0]] + numeros[resultado[1]]);
        assertNotEquals(resultado[0], resultado[1]);
    }

    @Test
    void encontrarIndicesSomaMultiplasSolucoesTest() {
        int[] numeros = {1, 2, 3, 4, 5};
        int alvo = 6;
        int[] resultado = SomaDois.encontrarIndicesSoma(numeros, alvo);
        assertEquals(2, resultado.length);
        assertEquals(alvo, numeros[resultado[0]] + numeros[resultado[1]]);
    }

    @Test
    void encontrarIndicesSomaComDoisElementosTest() {
        int[] numeros = {2, 7};
        int alvo = 9;
        int[] resultado = SomaDois.encontrarIndicesSoma(numeros, alvo);
        assertEquals(2, resultado.length);
        assertEquals(alvo, numeros[resultado[0]] + numeros[resultado[1]]);
    }

    @Test
    void encontrarIndicesSomaComTresElementosTest() {
        int[] numeros = {1, 2, 3};
        int alvo = 5;
        int[] resultado = SomaDois.encontrarIndicesSoma(numeros, alvo);
        assertEquals(2, resultado.length);
        assertEquals(alvo, numeros[resultado[0]] + numeros[resultado[1]]);
    }
}