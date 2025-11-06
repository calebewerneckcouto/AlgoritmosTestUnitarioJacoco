package com.main;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParTest {
    
    private Par par;
    
    @BeforeEach
    void setUp() {
        par = new Par();
    }
    
    // Testes para o método ehPar()
    @Test
    void verificarSeEParTest() {
        boolean resultado = par.ehPar(4);
        assertTrue(resultado); 
    }
    
    @Test
    void verificarSeEImparTest() {
        boolean resultado = par.ehPar(3);
        assertFalse(resultado);
    }
    
    @Test
    void verificarSeZeroEParTest() {
        boolean resultado = par.ehPar(0);
        assertTrue(resultado); 
    }
    
    @Test
    void verificarNumeroNegativoParTest() {
        boolean resultado = par.ehPar(-2);
        assertTrue(resultado);
    }
    
    @Test
    void verificarNumeroNegativoImparTest() {
        boolean resultado = par.ehPar(-3);
        assertFalse(resultado);
    }
    
    @Test
    void verificarNumeroMaximoInteiroTest() {
        boolean resultado = par.ehPar(Integer.MAX_VALUE);
        assertFalse(resultado);
    }
    
    // TESTES PARA O MÉTODO verificarParImpar() - QUE ESTÁ SEM COBERTURA
    @Test
    void verificarParImparParTest() {
        String resultado = par.verificarParImpar(4);
        assertEquals("Par", resultado);
    }
    
    @Test
    void verificarParImparImparTest() {
        String resultado = par.verificarParImpar(3);
        assertEquals("Ímpar", resultado);
    }
    
    @Test
    void verificarParImparZeroTest() {
        String resultado = par.verificarParImpar(0);
        assertEquals("Par", resultado);
    }
    
    @Test
    void verificarParImparNegativoParTest() {
        String resultado = par.verificarParImpar(-2);
        assertEquals("Par", resultado);
    }
    
    @Test
    void verificarParImparNegativoImparTest() {
        String resultado = par.verificarParImpar(-3);
        assertEquals("Ímpar", resultado);
    }
    
    // TESTES PARA O MÉTODO parOuImpar() (se existir)
    @Test
    void parOuImparParTest() {
        String resultado = par.parOuImpar(4);
        assertEquals("Par", resultado);
    }
    
    @Test
    void parOuImparImparTest() {
        String resultado = par.parOuImpar(3);
        assertEquals("Ímpar", resultado);
    }
}