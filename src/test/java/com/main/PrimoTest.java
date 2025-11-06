package com.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrimoTest {
    
    private Primo primo;
    
    @BeforeEach
    void setUp() {
        primo = new Primo();
    }
    
    
    @Test
    void verificarSeDoisEPrimo() {
        assertTrue(primo.ehPrimo(2));
    }
    
    @Test
    void verificarSeTresEPrimo() {
        assertTrue(primo.ehPrimo(3));
    }
    
    @Test
    void verificarSeCincoEPrimo() {
        assertTrue(primo.ehPrimo(5));
    }
    
    @Test
    void verificarSeSeteEPrimo() {
        assertTrue(primo.ehPrimo(7));
    }
    
    @Test
    void verificarSeOnzeEPrimo() {
        assertTrue(primo.ehPrimo(11));
    }
    
    @Test
    void verificarNumeroPrimoGrande() {
        assertTrue(primo.ehPrimo(97)); 
    }
    
    
    @Test
    void verificarSeUmNaoEPrimo() {
        assertFalse(primo.ehPrimo(1));
    }
    
    @Test
    void verificarSeQuatroNaoEPrimo() {
        assertFalse(primo.ehPrimo(4));
    }
    
    @Test
    void verificarSeSeisNaoEPrimo() {
        assertFalse(primo.ehPrimo(6));
    }
    
    @Test
    void verificarSeNoveNaoEPrimo() {
        assertFalse(primo.ehPrimo(9));
    }
    
    @Test
    void verificarSeQuinzeNaoEPrimo() {
        assertFalse(primo.ehPrimo(15));
    }
    
  
    @Test
    void verificarSeZeroNaoEPrimo() {
        assertFalse(primo.ehPrimo(0));
    }
    
    @Test
    void verificarSeNumeroNegativoNaoEPrimo() {
        assertFalse(primo.ehPrimo(-5));
    }
    
    @Test
    void verificarPrimoComString() {
        assertEquals("Primo", primo.verificarPrimo(7));
    }
    
    @Test
    void verificarNaoPrimoComString() {
        assertEquals("Não primo", primo.verificarPrimo(8));
    }
    

    @Test
    void verificarNumeroCompostoGrande() {
        assertFalse(primo.ehPrimo(100)); 
    }
}