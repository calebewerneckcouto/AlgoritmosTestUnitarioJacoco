package com.main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContadorOcorrenciaTest {
    
    private ContadorOcorrencia contador;
    
    @BeforeEach
    void setUp() {
        contador = new ContadorOcorrencia();
    }
    
    @Test
    void contarOcorrenciasNumeroPresenteTest() {
        int[] vetor = {1, 2, 3, 4, 2, 5, 2};
        int resultado = contador.contarOcorrencias(vetor, 2);
        assertEquals(3, resultado);
    }
    
    @Test
    void contarOcorrenciasNumeroAusenteTest() {
        int[] vetor = {1, 2, 3, 4, 5};
        int resultado = contador.contarOcorrencias(vetor, 6);
        assertEquals(0, resultado);
    }
    
    @Test
    void contarOcorrenciasNumeroUnicoTest() {
        int[] vetor = {1, 2, 3, 4, 5};
        int resultado = contador.contarOcorrencias(vetor, 3);
        assertEquals(1, resultado);
    }
    
    @Test
    void contarOcorrenciasVetorVazioTest() {
        int[] vetor = {};
        int resultado = contador.contarOcorrencias(vetor, 5);
        assertEquals(0, resultado);
    }
    
    @Test
    void contarOcorrenciasVetorNuloTest() {
        int resultado = contador.contarOcorrencias(null, 5);
        assertEquals(0, resultado);
    }
    
    @Test
    void contarOcorrenciasTodosElementosIguaisTest() {
        int[] vetor = {5, 5, 5, 5, 5};
        int resultado = contador.contarOcorrencias(vetor, 5);
        assertEquals(5, resultado);
    }
    
    @Test
    void contarOcorrenciasNumeroNegativoTest() {
        int[] vetor = {-1, 2, -1, 3, -1, 4};
        int resultado = contador.contarOcorrencias(vetor, -1);
        assertEquals(3, resultado);
    }
    
    @Test
    void verificarOcorrenciasComStringMultiplasTest() {
        int[] vetor = {1, 2, 3, 2, 4, 2};
        String resultado = contador.verificarOcorrencias(vetor, 2);
        assertEquals("O número 2 aparece 3 vezes no vetor", resultado);
    }
    
    @Test
    void verificarOcorrenciasComStringUmaOcorrenciaTest() {
        int[] vetor = {1, 2, 3, 4, 5};
        String resultado = contador.verificarOcorrencias(vetor, 3);
        assertEquals("O número 3 aparece 1 vez no vetor", resultado);
    }
    
    @Test
    void verificarOcorrenciasComStringNenhumaOcorrenciaTest() {
        int[] vetor = {1, 2, 3, 4, 5};
        String resultado = contador.verificarOcorrencias(vetor, 6);
        assertEquals("O número 6 não foi encontrado no vetor", resultado);
    }
    
    @Test
    void encontrarPosicoesEncontradasTest() {
        int[] vetor = {1, 2, 3, 2, 4, 2};
        String resultado = contador.encontrarPosicoes(vetor, 2);
        assertEquals("Posições: [1, 3, 5]", resultado);
    }
    
    @Test
    void encontrarPosicoesNaoEncontradasTest() {
        int[] vetor = {1, 2, 3, 4, 5};
        String resultado = contador.encontrarPosicoes(vetor, 6);
        assertEquals("Número não encontrado", resultado);
    }
    
    @Test
    void encontrarPosicoesVetorNuloTest() {
        String resultado = contador.encontrarPosicoes(null, 5);
        assertEquals("Número não encontrado", resultado);
    }
    
    @Test
    void encontrarPosicoesUmaPosicaoTest() {
        int[] vetor = {1, 2, 3, 4, 5};
        String resultado = contador.encontrarPosicoes(vetor, 3);
        assertEquals("Posições: [2]", resultado);
    }
    
    @Test
    void encontrarPosicoesPrimeiraPosicaoTest() {
        int[] vetor = {5, 2, 3, 4, 1};
        String resultado = contador.encontrarPosicoes(vetor, 5);
        assertEquals("Posições: [0]", resultado);
    }
    
    @Test
    void encontrarPosicoesUltimaPosicaoTest() {
        int[] vetor = {1, 2, 3, 4, 5};
        String resultado = contador.encontrarPosicoes(vetor, 5);
        assertEquals("Posições: [4]", resultado);
    }
    
    @Test
    void encontrarPosicoesPosicoesConsecutivasTest() {
        int[] vetor = {2, 2, 2, 1, 3};
        String resultado = contador.encontrarPosicoes(vetor, 2);
        assertEquals("Posições: [0, 1, 2]", resultado);
    }
    
    @Test
    void encontrarPosicoesPosicoesEspalhadasTest() {
        int[] vetor = {1, 2, 1, 3, 1, 4, 1};
        String resultado = contador.encontrarPosicoes(vetor, 1);
        assertEquals("Posições: [0, 2, 4, 6]", resultado);
    }
    
    @Test
    void contarOcorrenciasVetorGrandeTest() {
        int[] vetor = new int[100];
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (i % 10) + 1;
        }
        int resultado = contador.contarOcorrencias(vetor, 5);
        assertEquals(10, resultado);
    }
    
    @Test
    void verificarOcorrenciasVetorNuloTest() {
        String resultado = contador.verificarOcorrencias(null, 5);
        assertEquals("O número 5 não foi encontrado no vetor", resultado);
    }
    
    @Test
    void verificarOcorrenciasVetorVazioTest() {
        int[] vetor = {};
        String resultado = contador.verificarOcorrencias(vetor, 5);
        assertEquals("O número 5 não foi encontrado no vetor", resultado);
    }
}