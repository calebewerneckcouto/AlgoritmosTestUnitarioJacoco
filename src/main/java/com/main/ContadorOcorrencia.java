package com.main;

import java.util.ArrayList;
import java.util.List;

public class ContadorOcorrencia {
    
    private static final String NUMERO_PREFIX = "O número ";
    
    public String verificarOcorrencias(int[] vetor, int numero) {
        if (vetor == null) {
            throw new IllegalArgumentException("O vetor não pode ser nulo");
        }
        
        int contador = 0;
        for (int valor : vetor) {
            if (valor == numero) {
                contador++;
            }
        }
        
        if (contador == 0) {
            return String.format("%s%d não foi encontrado no vetor", NUMERO_PREFIX, numero);
        }
        
        return String.format("%s%d aparece %d vez(es) no vetor", NUMERO_PREFIX, numero, contador);
    }
    
    public String encontrarPosicoes(int[] vetor, int numero) {
        if (vetor == null) {
            throw new IllegalArgumentException("O vetor não pode ser nulo");
        }
        
        List<Integer> posicoes = new ArrayList<>();
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == numero) {
                posicoes.add(i);
            }
        }
        
        if (posicoes.isEmpty()) {
            return String.format("%s%d não foi encontrado no vetor", NUMERO_PREFIX, numero);
        }
        
        return String.format("%s%d aparece nas posições: %s", NUMERO_PREFIX, numero, posicoes);
    }
}