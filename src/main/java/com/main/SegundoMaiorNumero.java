package com.main;

public class SegundoMaiorNumero {
    
  
    public static int encontrarSegundoMaior(int[] numeros) {
        if (numeros == null) {
            throw new IllegalArgumentException("O array não pode ser nulo");
        }
        
        if (numeros.length < 2) {
            throw new IllegalArgumentException("O array deve ter pelo menos dois elementos");
        }
        
        // Inicializa com o primeiro elemento do array
        int maior = numeros[0];
        int segundoMaior = Integer.MIN_VALUE;
        boolean encontrouSegundo = false;
        
        for (int i = 1; i < numeros.length; i++) {
            int numero = numeros[i];
            
            if (numero > maior) {
                segundoMaior = maior;
                maior = numero;
                encontrouSegundo = true;
            } else if (numero > segundoMaior && numero < maior) {
                segundoMaior = numero;
                encontrouSegundo = true;
            } else if (segundoMaior == Integer.MIN_VALUE && numero < maior) {
                segundoMaior = numero;
                encontrouSegundo = true;
            }
        }
        
        if (!encontrouSegundo) {
            throw new IllegalArgumentException("Não existe segundo maior número (todos os números são iguais)");
        }
        
        return segundoMaior;
    }
    
  
    public static double encontrarSegundoMaior(double[] numeros) {
        if (numeros == null) {
            throw new IllegalArgumentException("O array não pode ser nulo");
        }
        
        if (numeros.length < 2) {
            throw new IllegalArgumentException("O array deve ter pelo menos dois elementos");
        }
        
        // Inicializa com o primeiro elemento do array
        double maior = numeros[0];
        double segundoMaior = -Double.MAX_VALUE;
        boolean encontrouSegundo = false;
        
        for (int i = 1; i < numeros.length; i++) {
            double numero = numeros[i];
            
            if (numero > maior) {
                segundoMaior = maior;
                maior = numero;
                encontrouSegundo = true;
            } else if (numero > segundoMaior && numero < maior) {
                segundoMaior = numero;
                encontrouSegundo = true;
            } else if (segundoMaior == -Double.MAX_VALUE && numero < maior) {
                segundoMaior = numero;
                encontrouSegundo = true;
            }
        }
        
        if (!encontrouSegundo) {
            throw new IllegalArgumentException("Não existe segundo maior número (todos os números são iguais)");
        }
        
        return segundoMaior;
    }
}