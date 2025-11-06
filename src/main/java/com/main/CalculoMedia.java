package com.main;

public class CalculoMedia {
    
  
    public static double calcularMedia(double[] numeros) {
        if (numeros == null) {
            throw new IllegalArgumentException("O vetor não pode ser nulo");
        }
        
        if (numeros.length == 0) {
            throw new IllegalArgumentException("O vetor não pode estar vazio");
        }
        
        double soma = 0;
        for (double numero : numeros) {
            soma += numero;
        }
        
        return soma / numeros.length;
    }
    
    
    public static double calcularMedia(int[] numeros) {
        if (numeros == null) {
            throw new IllegalArgumentException("O vetor não pode ser nulo");
        }
        
        if (numeros.length == 0) {
            throw new IllegalArgumentException("O vetor não pode estar vazio");
        }
        
        double soma = 0;
        for (int numero : numeros) {
            soma += numero;
        }
        
        return soma / numeros.length;
    }
}