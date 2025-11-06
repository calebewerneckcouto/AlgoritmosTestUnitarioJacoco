package com.main;

import java.util.HashMap;
import java.util.Map;

public class SomaDois {
    
    private SomaDois() {
        // Construtor privado para evitar instanciação
    }
    
    public static int[] encontrarIndicesSoma(int[] numeros, int alvo) {
        if (numeros == null || numeros.length < 2) {
            throw new IllegalArgumentException("O array deve ter pelo menos 2 elementos");
        }
        
        Map<Integer, Integer> mapa = new HashMap<>();
        
        for (int i = 0; i < numeros.length; i++) {
            int complemento = alvo - numeros[i];
            if (mapa.containsKey(complemento)) {
                return new int[]{mapa.get(complemento), i};
            }
            mapa.put(numeros[i], i);
        }
        
        throw new IllegalArgumentException("Nenhum par encontrado para a soma alvo");
    }
}