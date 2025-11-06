package com.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FatorialTest {
    
    private Fatorial fatorial;
    
    @BeforeEach
    void setUp() {
        fatorial = new Fatorial();
    }
    
  
    
    @Test
    void VerificarFatorialDeZeroTest() {
        long resultado = fatorial.calcularFatorial(0);
        assertEquals(1, resultado);
    }
    
    @Test
    void VerificarFatorialDeUmTest() {
        long resultado = fatorial.calcularFatorial(1);
        assertEquals(1, resultado);
    }
    
    @Test
    void VerificarFatorialDeDoisTest() {
        long resultado = fatorial.calcularFatorial(2);
        assertEquals(2, resultado);
    }
    
    @Test
    void VerificarFatorialDeCincoTest() {
        long resultado = fatorial.calcularFatorial(5);
        assertEquals(120, resultado);
    }
    
    @Test
    void VerificarFatorialDeDezTest() {
        long resultado = fatorial.calcularFatorial(10);
        assertEquals(3628800, resultado);
    }
    
    @Test
    void VerificarFatorialNumeroNegativoTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            fatorial.calcularFatorial(-5);
        });
    }
    
   
    
    @Test
    void VerificarFatorialRecursivoDeZeroTest() {
        long resultado = fatorial.calcularFatorialRecursivo(0);
        assertEquals(1, resultado);
    }
    
    @Test
    void VerificarFatorialRecursivoDeCincoTest() {
        long resultado = fatorial.calcularFatorialRecursivo(5);
        assertEquals(120, resultado);
    }
    
    @Test
    void VerificarFatorialRecursivoNumeroNegativoTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            fatorial.calcularFatorialRecursivo(-3);
        });
    }
    
   
    
    @Test
    void VerificarFatorialComStringZeroTest() {
        String resultado = fatorial.verificarFatorial(0);
        assertEquals("0! = 1", resultado);
    }
    
    @Test
    void VerificarFatorialComStringCincoTest() {
        String resultado = fatorial.verificarFatorial(5);
        assertEquals("5! = 120", resultado);
    }
    
    @Test
    void VerificarFatorialComStringNumeroNegativoTest() {
        String resultado = fatorial.verificarFatorial(-5);
        assertEquals("Erro: Número não pode ser negativo", resultado);
    }
    
    
    
    @Test
    void VerificarConsistenciaEntreMetodosTest() {
        for (int i = 0; i <= 10; i++) {
            long iterativo = fatorial.calcularFatorial(i);
            long recursivo = fatorial.calcularFatorialRecursivo(i);
            assertEquals(iterativo, recursivo);
        }
    }
}