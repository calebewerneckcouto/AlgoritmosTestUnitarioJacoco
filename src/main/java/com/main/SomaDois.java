package com.main;

import java.util.HashMap;
import java.util.Map;

public class SomaDois {
    
  
    public static int[] encontrarIndicesSoma(int[] numeros, int alvo) {
        if (numeros == null || numeros.length < 2) {
            throw new IllegalArgumentException("O array deve ter pelo menos dois elementos");
        }
        
        Map<Integer, Integer> mapa = new HashMap<>();
        
        for (int i = 0; i < numeros.length; i++) {
            int complemento = alvo - numeros[i];
            
            if (mapa.containsKey(complemento)) {
                return new int[]{mapa.get(complemento), i};
            }
            
            mapa.put(numeros[i], i);
        }
        
        throw new IllegalArgumentException("Não foram encontrados dois números que somem ao valor alvo");
    }
    
   
    public static int[] encontrarIndicesSomaPrimeiro(int[] numeros, int alvo) {
        if (numeros == null || numeros.length < 2) {
            throw new IllegalArgumentException("O array deve ter pelo menos dois elementos");
        }
        
        for (int i = 0; i < numeros.length; i++) {
            for (int j = i + 1; j < numeros.length; j++) {
                if (numeros[i] + numeros[j] == alvo) {
                    return new int[]{i, j};
                }
            }
        }
        
        throw new IllegalArgumentException("Não foram encontrados dois números que somem ao valor alvo");
    }
}