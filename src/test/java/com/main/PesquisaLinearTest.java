package com.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PesquisaLinearTest {
    
    private int[] listaNumeros;
    
    @BeforeEach
    void setUp() {
        listaNumeros = new int[]{10, 25, 30, 45, 50, 65, 70};
    }

    // Testes para o método com int[]
    @Test
    void pesquisarNumeroExistenteNoInicioTest() {
        int resultado = PesquisaLinear.pesquisar(listaNumeros, 10);
        assertEquals(0, resultado);
    }
    
    @Test
    void pesquisarNumeroExistenteNoMeioTest() {
        int resultado = PesquisaLinear.pesquisar(listaNumeros, 45);
        assertEquals(3, resultado);
    }
    
    @Test
    void pesquisarNumeroExistenteNoFimTest() {
        int resultado = PesquisaLinear.pesquisar(listaNumeros, 70);
        assertEquals(6, resultado);
    }
    
    @Test
    void pesquisarNumeroNaoExistenteTest() {
        int resultado = PesquisaLinear.pesquisar(listaNumeros, 100);
        assertEquals(-1, resultado);
    }
    
    @Test
    void pesquisarListaVaziaTest() {
        int[] listaVazia = new int[]{};
        int resultado = PesquisaLinear.pesquisar(listaVazia, 10);
        assertEquals(-1, resultado);
    }
    
    @Test
    void pesquisarArrayNuloTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            PesquisaLinear.pesquisar(null, 10);
        });
        assertEquals("O array não pode ser nulo", exception.getMessage());
    }
    
    @Test
    void pesquisarNumeroRepetidoTest() {
        int[] listaComRepetidos = new int[]{10, 20, 30, 20, 40};
        int resultado = PesquisaLinear.pesquisar(listaComRepetidos, 20);
        assertEquals(1, resultado);
    }
    
    @Test
    void pesquisarListaComUmElementoTest() {
        int[] listaUnica = new int[]{42};
        int resultadoEncontrado = PesquisaLinear.pesquisar(listaUnica, 42);
        int resultadoNaoEncontrado = PesquisaLinear.pesquisar(listaUnica, 10);
        
        assertEquals(0, resultadoEncontrado);
        assertEquals(-1, resultadoNaoEncontrado);
    }
    
    @Test
    void pesquisarPrimeiroElementoTest() {
        int resultado = PesquisaLinear.pesquisar(listaNumeros, 10);
        assertEquals(0, resultado);
    }
    
    @Test
    void pesquisarUltimoElementoTest() {
        int resultado = PesquisaLinear.pesquisar(listaNumeros, 70);
        assertEquals(6, resultado);
    }
    
    @Test
    void pesquisarElementoMeioTest() {
        int resultado = PesquisaLinear.pesquisar(listaNumeros, 45);
        assertEquals(3, resultado);
    }
    
    @Test
    void pesquisarListaComElementosNegativosTest() {
        int[] listaNegativos = {-5, -3, -1, 0, 2, 4};
        int resultado = PesquisaLinear.pesquisar(listaNegativos, -1);
        assertEquals(2, resultado);
    }
}