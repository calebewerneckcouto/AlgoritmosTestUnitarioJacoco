package com.main;

public class FaltaUm {
    
    private FaltaUm() {
        // Construtor privado para evitar instanciação
    }
    
    public static int encontrarNumeroFaltante(int[] numeros) {
        if (numeros == null) {
            throw new IllegalArgumentException("O array não pode ser nulo");
        }
        
        int n = numeros.length;
        int somaEsperada = n * (n + 1) / 2;
        int somaReal = 0;
        
        for (int num : numeros) {
            somaReal += num;
        }
        
        return somaEsperada - somaReal;
    }
    
    public static int encontrarNumeroFaltanteXOR(int[] numeros) {
        if (numeros == null) {
            throw new IllegalArgumentException("O array não pode ser nulo");
        }
        
        int xorEsperado = 0;
        int xorReal = 0;
        
        for (int i = 0; i <= numeros.length; i++) {
            xorEsperado ^= i;
        }
        
        for (int num : numeros) {
            xorReal ^= num;
        }
        
        return xorEsperado ^ xorReal;
    }
}