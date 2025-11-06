package com.main;

public class CalculoMedia {
    
    private CalculoMedia() {
        // Construtor privado para evitar instanciação
    }
    
    public static double calcularMedia(double[] numeros) {
        if (numeros == null || numeros.length == 0) {
            throw new IllegalArgumentException("O array não pode ser nulo ou vazio");
        }
        
        double soma = 0;
        for (double num : numeros) {
            soma += num;
        }
        
        return soma / numeros.length;
    }
}