package com.main;

public class PesquisaLinear {
    
    private PesquisaLinear() {
        // Construtor privado para evitar instanciação
    }
    
    public static int pesquisar(int[] array, int elemento) {
        if (array == null) {
            throw new IllegalArgumentException("O array não pode ser nulo");
        }
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] == elemento) {
                return i;
            }
        }
        
        return -1;
    }
}