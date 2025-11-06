package com.main;

public class Fatorial {
    
    public long calcularFatorial(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("Número não pode ser negativo");
        }
        
        long resultado = 1;
        for (int i = 2; i <= numero; i++) {
            resultado *= i;
        }
        return resultado;
    }
    
    
    public long calcularFatorialRecursivo(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("Número não pode ser negativo");
        }
        if (numero == 0 || numero == 1) {
            return 1;
        }
        return numero * calcularFatorialRecursivo(numero - 1);
    }
    
 
    public String verificarFatorial(int numero) {
        try {
            long resultado = calcularFatorial(numero);
            return numero + "! = " + resultado;
        } catch (IllegalArgumentException e) {
            return "Erro: " + e.getMessage();
        }
    }
}