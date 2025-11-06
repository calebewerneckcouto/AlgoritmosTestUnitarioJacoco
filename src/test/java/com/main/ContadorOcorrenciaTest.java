package com.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContadorOcorrenciaTest {
    
    private ContadorOcorrencia contador;
    
    @BeforeEach
    void setUp() {
        contador = new ContadorOcorrencia();
    }
    
    @Test
    void verificarOcorrenciasNumeroPresenteMultiplasVezesTest() {
        int[] vetor = {1, 2, 3, 4, 2, 5, 2};
        String resultado = contador.verificarOcorrencias(vetor, 2);
        assertEquals("O número 2 aparece 3 vez(es) no vetor", resultado);
    }
    
    @Test
    void verificarOcorrenciasNumeroPresenteUmaVezTest() {
        int[] vetor = {1, 2, 3, 4, 5};
        String resultado = contador.verificarOcorrencias(vetor, 3);
        assertEquals("O número 3 aparece 1 vez(es) no vetor", resultado);
    }
    
    @Test
    void verificarOcorrenciasNumeroAusenteTest() {
        int[] vetor = {1, 2, 3, 4, 5};
        String resultado = contador.verificarOcorrencias(vetor, 6);
        assertEquals("O número 6 não foi encontrado no vetor", resultado);
    }
    
    @Test
    void verificarOcorrenciasVetorVazioTest() {
        int[] vetor = {};
        String resultado = contador.verificarOcorrencias(vetor, 5);
        assertEquals("O número 5 não foi encontrado no vetor", resultado);
    }
    
    @Test
    void verificarOcorrenciasVetorNuloTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contador.verificarOcorrencias(null, 5);
        });
        assertEquals("O vetor não pode ser nulo", exception.getMessage());
    }
    
    @Test
    void verificarOcorrenciasTodosElementosIguaisTest() {
        int[] vetor = {5, 5, 5, 5, 5};
        String resultado = contador.verificarOcorrencias(vetor, 5);
        assertEquals("O número 5 aparece 5 vez(es) no vetor", resultado);
    }
    
    @Test
    void verificarOcorrenciasNumeroNegativoTest() {
        int[] vetor = {-1, 2, -1, 3, -1, 4};
        String resultado = contador.verificarOcorrencias(vetor, -1);
        assertEquals("O número -1 aparece 3 vez(es) no vetor", resultado);
    }
    
    @Test
    void encontrarPosicoesEncontradasTest() {
        int[] vetor = {1, 2, 3, 2, 4, 2};
        String resultado = contador.encontrarPosicoes(vetor, 2);
        assertEquals("O número 2 aparece nas posições: [1, 3, 5]", resultado);
    }
    
    @Test
    void encontrarPosicoesNaoEncontradasTest() {
        int[] vetor = {1, 2, 3, 4, 5};
        String resultado = contador.encontrarPosicoes(vetor, 6);
        assertEquals("O número 6 não foi encontrado no vetor", resultado);
    }
    
    @Test
    void encontrarPosicoesVetorNuloTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contador.encontrarPosicoes(null, 5);
        });
        assertEquals("O vetor não pode ser nulo", exception.getMessage());
    }
    
    @Test
    void encontrarPosicoesUmaPosicaoTest() {
        int[] vetor = {1, 2, 3, 4, 5};
        String resultado = contador.encontrarPosicoes(vetor, 3);
        assertEquals("O número 3 aparece nas posições: [2]", resultado);
    }
    
    @Test
    void encontrarPosicoesPrimeiraPosicaoTest() {
        int[] vetor = {5, 2, 3, 4, 1};
        String resultado = contador.encontrarPosicoes(vetor, 5);
        assertEquals("O número 5 aparece nas posições: [0]", resultado);
    }
    
    @Test
    void encontrarPosicoesUltimaPosicaoTest() {
        int[] vetor = {1, 2, 3, 4, 5};
        String resultado = contador.encontrarPosicoes(vetor, 5);
        assertEquals("O número 5 aparece nas posições: [4]", resultado);
    }
    
    @Test
    void encontrarPosicoesPosicoesConsecutivasTest() {
        int[] vetor = {2, 2, 2, 1, 3};
        String resultado = contador.encontrarPosicoes(vetor, 2);
        assertEquals("O número 2 aparece nas posições: [0, 1, 2]", resultado);
    }
    
    @Test
    void encontrarPosicoesPosicoesEspalhadasTest() {
        int[] vetor = {1, 2, 1, 3, 1, 4, 1};
        String resultado = contador.encontrarPosicoes(vetor, 1);
        assertEquals("O número 1 aparece nas posições: [0, 2, 4, 6]", resultado);
    }
    
    @Test
    void verificarOcorrenciasVetorGrandeTest() {
        int[] vetor = new int[100];
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (i % 10) + 1;
        }
        String resultado = contador.verificarOcorrencias(vetor, 5);
        assertEquals("O número 5 aparece 10 vez(es) no vetor", resultado);
    }
}