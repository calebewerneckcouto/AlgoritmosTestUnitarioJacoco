package com.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class FaltaUmTest {

    // Teste de instanciação da classe
    @Test
    void instanciaDaClasseTest() {
        FaltaUm instancia = new FaltaUm();
        assertNotNull(instancia);
    }

    // Testes para encontrarNumeroFaltante - Casos de sucesso
    @Test
    void encontrarNumeroFaltanteNoMeioTest() {
        int[] numeros = {0, 1, 3, 4, 5};
        int resultado = FaltaUm.encontrarNumeroFaltante(numeros);
        assertEquals(2, resultado);
    }

    @Test
    void encontrarNumeroFaltanteNoInicioTest() {
        int[] numeros = {1, 2, 3, 4, 5};
        int resultado = FaltaUm.encontrarNumeroFaltante(numeros);
        assertEquals(0, resultado);
    }

    @Test
    void encontrarNumeroFaltanteNoFimTest() {
        int[] numeros = {0, 1, 2, 3, 4};
        int resultado = FaltaUm.encontrarNumeroFaltante(numeros);
        assertEquals(5, resultado);
    }

    @Test
    void encontrarNumeroFaltanteArrayPequenoTest() {
        int[] numeros = {0, 1};
        int resultado = FaltaUm.encontrarNumeroFaltante(numeros);
        assertEquals(2, resultado);
    }

    @Test
    void encontrarNumeroFaltanteArrayMinimoTest() {
        int[] numeros = {0};
        int resultado = FaltaUm.encontrarNumeroFaltante(numeros);
        assertEquals(1, resultado);
    }

    @Test
    void encontrarNumeroFaltanteArrayVazioTest() {
        int[] numeros = {};
        int resultado = FaltaUm.encontrarNumeroFaltante(numeros);
        assertEquals(0, resultado);
    }

    @Test
    void encontrarNumeroFaltanteComNumeroIgualANTest() {
        int[] numeros = {0, 1, 2, 3, 5};
        int resultado = FaltaUm.encontrarNumeroFaltante(numeros);
        assertEquals(4, resultado);
    }

    @Test
    void encontrarNumeroFaltanteOrdemAleatoriaTest() {
        int[] numeros = {3, 0, 1, 4, 2, 6};
        int resultado = FaltaUm.encontrarNumeroFaltante(numeros);
        assertEquals(5, resultado);
    }

    @Test
    void encontrarNumeroFaltanteArrayGrandeTest() {
        int[] numeros = new int[1000];
        int numeroFaltante = 567;
        
        int index = 0;
        for (int i = 0; i <= 1000; i++) {
            if (i != numeroFaltante) {
                numeros[index++] = i;
            }
        }
        
        int resultado = FaltaUm.encontrarNumeroFaltante(numeros);
        assertEquals(numeroFaltante, resultado);
    }

    // Testes para encontrarNumeroFaltante - Casos de erro
    @Test
    void encontrarNumeroFaltanteArrayNuloTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FaltaUm.encontrarNumeroFaltante(null);
        });
        assertEquals("O array não pode ser nulo", exception.getMessage());
    }

    @Test
    void encontrarNumeroFaltanteComNumeroMaiorQueNTest() {
        int[] numeros = {0, 1, 2, 6, 4}; // 6 > 4 (n = 4)
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FaltaUm.encontrarNumeroFaltante(numeros);
        });
        // Verifica apenas se contém parte da mensagem
        assertTrue(exception.getMessage().contains("números devem estar") || 
                  exception.getMessage().contains("intervalo"));
    }

    @Test
    void encontrarNumeroFaltanteComNumeroNegativoTest() {
        int[] numeros = {-1, 0, 1, 2, 3}; // -1 < 0
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FaltaUm.encontrarNumeroFaltante(numeros);
        });
        // Verifica apenas se contém parte da mensagem
        assertTrue(exception.getMessage().contains("números devem estar") || 
                  exception.getMessage().contains("intervalo"));
    }

    // Testes para encontrarNumeroFaltanteXOR - Casos de sucesso
    @Test
    void encontrarNumeroFaltanteComXORNoMeioTest() {
        int[] numeros = {0, 1, 3, 4, 5};
        int resultado = FaltaUm.encontrarNumeroFaltanteXOR(numeros);
        assertEquals(2, resultado);
    }

    @Test
    void encontrarNumeroFaltanteComXORNoInicioTest() {
        int[] numeros = {1, 2, 3, 4, 5};
        int resultado = FaltaUm.encontrarNumeroFaltanteXOR(numeros);
        assertEquals(0, resultado);
    }

    @Test
    void encontrarNumeroFaltanteComXORNoFimTest() {
        int[] numeros = {0, 1, 2, 3, 4};
        int resultado = FaltaUm.encontrarNumeroFaltanteXOR(numeros);
        assertEquals(5, resultado);
    }

    @Test
    void encontrarNumeroFaltanteComXORArrayPequenoTest() {
        int[] numeros = {0, 1};
        int resultado = FaltaUm.encontrarNumeroFaltanteXOR(numeros);
        assertEquals(2, resultado);
    }

    @Test
    void encontrarNumeroFaltanteComXORArrayMinimoTest() {
        int[] numeros = {0};
        int resultado = FaltaUm.encontrarNumeroFaltanteXOR(numeros);
        assertEquals(1, resultado);
    }

    @Test
    void encontrarNumeroFaltanteComXORArrayVazioTest() {
        int[] numeros = {};
        int resultado = FaltaUm.encontrarNumeroFaltanteXOR(numeros);
        assertEquals(0, resultado);
    }

    @Test
    void encontrarNumeroFaltanteComXORNumeroIgualANTest() {
        int[] numeros = {0, 1, 2, 3, 5};
        int resultado = FaltaUm.encontrarNumeroFaltanteXOR(numeros);
        assertEquals(4, resultado);
    }

    @Test
    void encontrarNumeroFaltanteComXORArrayGrandeTest() {
        int[] numeros = new int[500];
        int numeroFaltante = 250;
        
        int index = 0;
        for (int i = 0; i <= 500; i++) {
            if (i != numeroFaltante) {
                numeros[index++] = i;
            }
        }
        
        int resultado = FaltaUm.encontrarNumeroFaltanteXOR(numeros);
        assertEquals(numeroFaltante, resultado);
    }

    // Testes para encontrarNumeroFaltanteXOR - Casos de erro
    @Test
    void encontrarNumeroFaltanteComXORArrayNuloTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FaltaUm.encontrarNumeroFaltanteXOR(null);
        });
        assertEquals("O array não pode ser nulo", exception.getMessage());
    }

    @Test
    void encontrarNumeroFaltanteComXORNumeroMaiorQueNTest() {
        int[] numeros = {0, 1, 2, 6, 4}; // 6 > 4 (n = 4)
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FaltaUm.encontrarNumeroFaltanteXOR(numeros);
        });
        // Verifica apenas se contém parte da mensagem
        assertTrue(exception.getMessage().contains("números devem estar") || 
                  exception.getMessage().contains("intervalo"));
    }

    @Test
    void encontrarNumeroFaltanteComXORNumeroNegativoTest() {
        int[] numeros = {-1, 0, 1, 2, 3}; // -1 < 0
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FaltaUm.encontrarNumeroFaltanteXOR(numeros);
        });
        // Verifica apenas se contém parte da mensagem
        assertTrue(exception.getMessage().contains("números devem estar") || 
                  exception.getMessage().contains("intervalo"));
    }

    // Testes de consistência entre os dois métodos
    @Test
    void encontrarNumeroFaltanteAmbosMetodosConsistentesTest() {
        int[] numeros = {0, 1, 2, 4, 5, 6};
        int resultado1 = FaltaUm.encontrarNumeroFaltante(numeros);
        int resultado2 = FaltaUm.encontrarNumeroFaltanteXOR(numeros);
        assertEquals(resultado1, resultado2);
        assertEquals(3, resultado1);
    }

    // Testes adicionais para casos específicos
    @Test
    void encontrarNumeroFaltanteArrayPequenoComNumeroForaIntervaloTest() {
        int[] numeros = {0, 3}; // 3 > 1 (n = 1)
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FaltaUm.encontrarNumeroFaltante(numeros);
        });
        // Verifica apenas se contém parte da mensagem
        assertTrue(exception.getMessage().contains("números devem estar") || 
                  exception.getMessage().contains("intervalo"));
    }

    @Test
    void encontrarNumeroFaltanteComXORArrayPequenoComNumeroForaIntervaloTest() {
        int[] numeros = {0, 3}; // 3 > 1 (n = 1)
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FaltaUm.encontrarNumeroFaltanteXOR(numeros);
        });
        // Verifica apenas se contém parte da mensagem
        assertTrue(exception.getMessage().contains("números devem estar") || 
                  exception.getMessage().contains("intervalo"));
    }

    @Test
    void encontrarNumeroFaltanteComMultiplosNumerosForaIntervaloTest() {
        int[] numeros = {-1, 0, 7, 2, 3}; // -1 < 0 e 7 > 4 (n = 4)
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FaltaUm.encontrarNumeroFaltante(numeros);
        });
        // Verifica apenas se contém parte da mensagem
        assertTrue(exception.getMessage().contains("números devem estar") || 
                  exception.getMessage().contains("intervalo"));
    }
}