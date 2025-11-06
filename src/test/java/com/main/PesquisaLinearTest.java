package com.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PesquisaLinearTest {
    
    private int[] listaNumeros;
    private List<Integer> listaInteger;
    
    @BeforeEach
    void setUp() {
        listaNumeros = new int[]{10, 25, 30, 45, 50, 65, 70};
        listaInteger = Arrays.asList(10, 25, 30, 45, 50, 65, 70);
    }
    
    @Test
    void instanciaDaClasseTest() {
        PesquisaLinear instancia = new PesquisaLinear();
        assertNotNull(instancia);
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
    void pesquisarArrayNuloTest() { // TESTE QUE ESTAVA FALTANDO
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            PesquisaLinear.pesquisar((int[]) null, 10);
        });
        assertEquals("A lista não pode ser nula", exception.getMessage());
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

    // Testes para o método com List<Integer>
    @Test
    void pesquisarListNumeroExistenteTest() {
        int resultado = PesquisaLinear.pesquisar(listaInteger, 30);
        assertEquals(2, resultado);
    }
    
    @Test
    void pesquisarListNumeroNaoExistenteTest() {
        int resultado = PesquisaLinear.pesquisar(listaInteger, 100);
        assertEquals(-1, resultado);
    }
    
    @Test
    void pesquisarListListaNulaTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            PesquisaLinear.pesquisar((List<Integer>) null, 10);
        });
        assertEquals("A lista não pode ser nula", exception.getMessage());
    }
    
    @Test
    void pesquisarListListaVaziaTest() {
        List<Integer> listaVazia = new ArrayList<>();
        int resultado = PesquisaLinear.pesquisar(listaVazia, 10);
        assertEquals(-1, resultado);
    }
    
    @Test
    void pesquisarListListaComUmElementoTest() {
        List<Integer> listaUnica = Arrays.asList(42);
        int resultadoEncontrado = PesquisaLinear.pesquisar(listaUnica, 42);
        int resultadoNaoEncontrado = PesquisaLinear.pesquisar(listaUnica, 10);
        
        assertEquals(0, resultadoEncontrado);
        assertEquals(-1, resultadoNaoEncontrado);
    }

    // Testes adicionais para melhor cobertura
    @Test
    void pesquisarPrimeiroElementoListTest() {
        int resultado = PesquisaLinear.pesquisar(listaInteger, 10);
        assertEquals(0, resultado);
    }
    
    @Test
    void pesquisarUltimoElementoListTest() {
        int resultado = PesquisaLinear.pesquisar(listaInteger, 70);
        assertEquals(6, resultado);
    }
    
    @Test
    void pesquisarElementoMeioListTest() {
        int resultado = PesquisaLinear.pesquisar(listaInteger, 45);
        assertEquals(3, resultado);
    }
    
    @Test
    void pesquisarListaComElementosNegativosTest() {
        int[] listaNegativos = {-5, -3, -1, 0, 2, 4};
        int resultado = PesquisaLinear.pesquisar(listaNegativos, -1);
        assertEquals(2, resultado);
    }
    
    @Test
    void pesquisarListComElementosNegativosTest() {
        List<Integer> listaNegativos = Arrays.asList(-5, -3, -1, 0, 2, 4);
        int resultado = PesquisaLinear.pesquisar(listaNegativos, -1);
        assertEquals(2, resultado);
    }
}