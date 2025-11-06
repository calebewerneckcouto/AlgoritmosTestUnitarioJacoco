package com.main;

import java.util.List;

public class PesquisaLinear {
    
    public static int pesquisar(int[] lista, int numeroProcurado) {
        if (lista == null) {
            throw new IllegalArgumentException("A lista não pode ser nula");
        }
        
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == numeroProcurado) {
                return i;
            }
        }
        return -1;
    }
    
    public static int pesquisar(List<Integer> lista, int numeroProcurado) {
        if (lista == null) {
            throw new IllegalArgumentException("A lista não pode ser nula");
        }
        
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) == numeroProcurado) {
                return i;
            }
        }
        return -1;
    }
}