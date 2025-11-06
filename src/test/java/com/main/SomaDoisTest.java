package com.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SomaDoisTest {
    
    @Test
    void instanciaDaClasseTest() {
        SomaDois instancia = new SomaDois();
        assertNotNull(instancia);
    }

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
        assertEquals("O array deve ter pelo menos dois elementos", exception.getMessage());
    }

    @Test
    void encontrarIndicesSomaArrayVazioTest() {
        int[] numeros = {};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            SomaDois.encontrarIndicesSoma(numeros, 10);
        });
        assertEquals("O array deve ter pelo menos dois elementos", exception.getMessage());
    }

    @Test
    void encontrarIndicesSomaApenasUmElementoTest() {
        int[] numeros = {5};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            SomaDois.encontrarIndicesSoma(numeros, 10);
        });
        assertEquals("O array deve ter pelo menos dois elementos", exception.getMessage());
    }

    @Test
    void encontrarIndicesSomaNaoEncontradoTest() {
        int[] numeros = {1, 2, 3, 4};
        int alvo = 10;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            SomaDois.encontrarIndicesSoma(numeros, alvo);
        });
        assertEquals("Não foram encontrados dois números que somem ao valor alvo", exception.getMessage());
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
        assertTrue(resultado[0] >= 0 && resultado[0] < numeros.length);
        assertTrue(resultado[1] >= 0 && resultado[1] < numeros.length);
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

    // Testes para encontrarIndicesSomaPrimeiro - ADICIONANDO OS TESTES DE VALIDAÇÃO
    @Test
    void encontrarIndicesSomaPrimeiroArrayNuloTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            SomaDois.encontrarIndicesSomaPrimeiro(null, 10);
        });
        assertEquals("O array deve ter pelo menos dois elementos", exception.getMessage());
    }

    @Test
    void encontrarIndicesSomaPrimeiroArrayVazioTest() {
        int[] numeros = {};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            SomaDois.encontrarIndicesSomaPrimeiro(numeros, 10);
        });
        assertEquals("O array deve ter pelo menos dois elementos", exception.getMessage());
    }

    @Test
    void encontrarIndicesSomaPrimeiroApenasUmElementoTest() {
        int[] numeros = {5};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            SomaDois.encontrarIndicesSomaPrimeiro(numeros, 10);
        });
        assertEquals("O array deve ter pelo menos dois elementos", exception.getMessage());
    }

    @Test
    void encontrarIndicesSomaPrimeiroParEncontradoTest() {
        int[] numeros = {1, 2, 3, 4, 5};
        int alvo = 6;
        int[] resultado = SomaDois.encontrarIndicesSomaPrimeiro(numeros, alvo);
        assertEquals(2, resultado.length);
        assertEquals(alvo, numeros[resultado[0]] + numeros[resultado[1]]);
    }

    @Test
    void encontrarIndicesSomaPrimeiroComNegativosTest() {
        int[] numeros = {-1, -2, -3, 5, 8};
        int alvo = 3;
        int[] resultado = SomaDois.encontrarIndicesSomaPrimeiro(numeros, alvo);
        assertEquals(2, resultado.length);
        assertEquals(alvo, numeros[resultado[0]] + numeros[resultado[1]]);
    }

    @Test
    void encontrarIndicesSomaPrimeiroNaoEncontradoTest() {
        int[] numeros = {1, 2, 3, 4};
        int alvo = 10;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            SomaDois.encontrarIndicesSomaPrimeiro(numeros, alvo);
        });
        assertEquals("Não foram encontrados dois números que somem ao valor alvo", exception.getMessage());
    }

    // Testes adicionais para melhor cobertura
    @Test
    void encontrarIndicesSomaPrimeiroPrimeiroParEncontradoTest() {
        int[] numeros = {1, 2, 3, 4};
        int alvo = 7;
        int[] resultado = SomaDois.encontrarIndicesSomaPrimeiro(numeros, alvo);
        assertEquals(2, resultado.length);
        assertEquals(alvo, numeros[resultado[0]] + numeros[resultado[1]]);
        // Deve retornar o primeiro par encontrado (3+4)
        assertTrue((resultado[0] == 2 && resultado[1] == 3) || 
                  (resultado[0] == 0 && resultado[1] == 3));
    }

    @Test
    void encontrarIndicesSomaPrimeiroComDoisElementosTest() {
        int[] numeros = {2, 7};
        int alvo = 9;
        int[] resultado = SomaDois.encontrarIndicesSomaPrimeiro(numeros, alvo);
        assertEquals(2, resultado.length);
        assertEquals(alvo, numeros[resultado[0]] + numeros[resultado[1]]);
    }

    @Test
    void encontrarIndicesSomaPrimeiroComTresElementosTest() {
        int[] numeros = {1, 2, 3};
        int alvo = 5;
        int[] resultado = SomaDois.encontrarIndicesSomaPrimeiro(numeros, alvo);
        assertEquals(2, resultado.length);
        assertEquals(alvo, numeros[resultado[0]] + numeros[resultado[1]]);
    }
}