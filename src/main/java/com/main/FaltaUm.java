package com.main;

public class FaltaUm {
    
  
    public static int encontrarNumeroFaltante(int[] numeros) {
        if (numeros == null) {   //condição que terei que cobrir teste
            throw new IllegalArgumentException("O array não pode ser nulo"); //terei que lancar execeção teste
        }
        
        int n = numeros.length; 
        int somaEsperada = n * (n + 1) / 2;
        int somaReal = 0;
        
        for (int numero : numeros) {
            if (numero < 0 || numero > n) { //terei que cobrir esse teste
                throw new IllegalArgumentException("Os números devem estar no intervalo [0, " + n + "]"); //terei que lancar exceção teste
            }
            somaReal += numero;  //ver se esta certo
        }
        
        return somaEsperada - somaReal; //retorna o numero faltante (cobrir teste)
    }
    
    
    public static int encontrarNumeroFaltanteXOR(int[] numeros) {
        if (numeros == null) { //condição que terei que cobrir teste
            throw new IllegalArgumentException("O array não pode ser nulo"); //terei que lancar execeção teste
        }
        
        int n = numeros.length; 
        int xor = 0;
        
       
        for (int i = 0; i <= n; i++) { 
            xor ^= i; //terei que cobrir esse teste
        }
        
    
        for (int numero : numeros) {
            if (numero < 0 || numero > n) {  //terei que cobrir esse teste
                throw new IllegalArgumentException("Os números devem estar no intervalo [0, " + n + "]"); //terei que lancar exceção teste
            }
            xor ^= numero; //ver se esta certo
        }
        
        return xor; //retorna o numero faltante (cobrir teste)
    }
}