package com.main;

public class ContadorOcorrencia {
    
    
    public int contarOcorrencias(int[] vetor, int numero) {
        if (vetor == null) {
            return 0;
        }
        
        int contador = 0;
        for (int elemento : vetor) {
            if (elemento == numero) {
                contador++;
            }
        }
        return contador;
    }
    
    
    public String verificarOcorrencias(int[] vetor, int numero) {
        int quantidade = contarOcorrencias(vetor, numero);
        
        if (quantidade == 0) {
            return "O número " + numero + " não foi encontrado no vetor";
        } else if (quantidade == 1) {
            return "O número " + numero + " aparece 1 vez no vetor";
        } else {
            return "O número " + numero + " aparece " + quantidade + " vezes no vetor";
        }
    }
    
    
    public String encontrarPosicoes(int[] vetor, int numero) {
        if (vetor == null || contarOcorrencias(vetor, numero) == 0) {
            return "Número não encontrado";
        }
        
        StringBuilder posicoes = new StringBuilder();
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == numero) {
                if (posicoes.length() > 0) {
                    posicoes.append(", ");
                }
                posicoes.append(i);
            }
        }
        return "Posições: [" + posicoes.toString() + "]";
    }
}