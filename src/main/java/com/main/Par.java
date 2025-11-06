package com.main;

public class Par {
    
    
    
    public String verificarParImpar(int numero) {
        if (numero % 2 == 0) {
            return "Par";
        } else {
            return "Ímpar";
        }
    }
    
    
    public boolean ehPar(int numero) {
        return numero % 2 == 0;
    }
    
    
    public String parOuImpar(int numero) {
        return ehPar(numero) ? "Par" : "Ímpar";
    }
}