package com.main;



public class Strings {
  
    public String inverterString(String texto) {
        if (texto == null) {
            throw new IllegalArgumentException("String não pode ser nula");
        }
        
        
        return new StringBuilder(texto).reverse().toString();
        
        
    }
    
    
    public boolean isPalindromo(String texto) {
        if (texto == null) {
            throw new IllegalArgumentException("String não pode ser nula");
        }
        
        String textoLimpo = texto.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String invertida = inverterString(textoLimpo);
        
        return textoLimpo.equals(invertida);
    }
    
    
    public boolean isAnagrama(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        
      
        String s1 = str1.replaceAll("\\s", "").toLowerCase();
        String s2 = str2.replaceAll("\\s", "").toLowerCase();
        
       
        if (s1.length() != s2.length()) {
            return false;
        }
        
       
        int[] frequencia = new int[26]; 
        
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            
            if (Character.isLetter(c1)) {
                frequencia[c1 - 'a']++;
            }
            if (Character.isLetter(c2)) {
                frequencia[c2 - 'a']--;
            }
        }
        
       
        for (int count : frequencia) {
            if (count != 0) {
                return false;
            }
        }
        
        return true;
    }
}