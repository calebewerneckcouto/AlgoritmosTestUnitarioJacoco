package com.main;

public class SegundoMaiorNumero {
    
    private SegundoMaiorNumero() {
        // Construtor privado para evitar instanciação
    }
    
    public static int encontrarSegundoMaior(int[] numeros) {
        if (numeros == null) {
            throw new IllegalArgumentException("O array não pode ser nulo");
        }
        
        if (numeros.length < 2) {
            throw new IllegalArgumentException("O array deve ter pelo menos 2 elementos");
        }
        
        int maior = Integer.MIN_VALUE;
        int segundoMaior = Integer.MIN_VALUE;
        boolean encontrouSegundo = false;
        
        for (int num : numeros) {
            if (num > maior) {
                segundoMaior = maior;
                maior = num;
                encontrouSegundo = true;
            } else if (num > segundoMaior && num < maior) {
                segundoMaior = num;
                encontrouSegundo = true;
            } else if (segundoMaior == Integer.MIN_VALUE && num < maior) {
                segundoMaior = num;
                encontrouSegundo = true;
            }
        }
        
        if (!encontrouSegundo || segundoMaior == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Não existe segundo maior número distinto");
        }
        
        return segundoMaior;
    }
}