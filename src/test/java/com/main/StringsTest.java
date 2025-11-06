package com.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringsTest {
    
    private Strings strings;
    
    @BeforeEach
    void setUp() {
        strings = new Strings();
    }
    
    // Testes para inverterString
    @Test
    void InverterString_StringNormalTest() {
        String entrada = "Hello";
        String esperado = "olleH";
        String resultado = strings.inverterString(entrada);
        assertEquals(esperado, resultado);
    }
    
    @Test
    void InverterString_StringVaziaTest() {
        String entrada = "";
        String esperado = "";
        String resultado = strings.inverterString(entrada);
        assertEquals(esperado, resultado);
    }
    
    @Test
    void InverterString_StringComEspacosTest() {
        String entrada = "Hello World";
        String esperado = "dlroW olleH";
        String resultado = strings.inverterString(entrada);
        assertEquals(esperado, resultado);
    }
    
    @Test
    void InverterString_StringComCaracteresEspeciaisTest() {
        String entrada = "123!@#";
        String esperado = "#@!321";
        String resultado = strings.inverterString(entrada);
        assertEquals(esperado, resultado);
    }
    
    @Test
    void InverterString_StringNulaTest() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> strings.inverterString(null)
        );
        assertEquals("String não pode ser nula", exception.getMessage());
    }
    
    @Test
    void InverterString_StringUnicodeTest() {
        String entrada = "café";
        String esperado = "éfac";
        String resultado = strings.inverterString(entrada);
        assertEquals(esperado, resultado);
    }
    
    // Testes para isPalindromo - ADICIONANDO OS QUE FALTAM
    @Test
    void IsPalindromo_PalindromoSimplesTest() {
        String entrada = "arara";
        boolean resultado = strings.isPalindromo(entrada);
        assertTrue(resultado);
    }
    
    @Test
    void IsPalindromo_NaoPalindromoTest() {
        String entrada = "casa";
        boolean resultado = strings.isPalindromo(entrada);
        assertFalse(resultado);
    }
    
    @Test
    void IsPalindromo_PalindromoComEspacosTest() {
        String entrada = "A base do teto desaba";
        boolean resultado = strings.isPalindromo(entrada);
        assertTrue(resultado);
    }
    
    @Test
    void IsPalindromo_PalindromoComPontuacaoTest() {
        String entrada = "A man, a plan, a canal: Panama!";
        boolean resultado = strings.isPalindromo(entrada);
        assertTrue(resultado);
    }
    
    @Test
    void IsPalindromo_PalindromoNumericoTest() {
        String entrada = "12321";
        boolean resultado = strings.isPalindromo(entrada);
        assertTrue(resultado);
    }
    
    @Test
    void IsPalindromo_NaoPalindromoNumericoTest() {
        String entrada = "12345";
        boolean resultado = strings.isPalindromo(entrada);
        assertFalse(resultado);
    }
    
    @Test
    void IsPalindromo_StringVaziaTest() {
        String entrada = "";
        boolean resultado = strings.isPalindromo(entrada);
        assertTrue(resultado); // String vazia é considerada palíndromo
    }
    
    @Test
    void IsPalindromo_UmCaractereTest() {
        String entrada = "a";
        boolean resultado = strings.isPalindromo(entrada);
        assertTrue(resultado);
    }
    
    @Test
    void IsPalindromo_DoisCaracteresPalindromoTest() {
        String entrada = "aa";
        boolean resultado = strings.isPalindromo(entrada);
        assertTrue(resultado);
    }
    
    @Test
    void IsPalindromo_DoisCaracteresNaoPalindromoTest() {
        String entrada = "ab";
        boolean resultado = strings.isPalindromo(entrada);
        assertFalse(resultado);
    }
    
    @Test
    void IsPalindromo_CaseInsensitiveTest() {
        String entrada = "Arara";
        boolean resultado = strings.isPalindromo(entrada);
        assertTrue(resultado);
    }
    
    @Test
    void IsPalindromo_StringNulaTest() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> strings.isPalindromo(null)
        );
        assertEquals("String não pode ser nula", exception.getMessage());
    }
    
    // Testes para isAnagrama - ADICIONANDO OS QUE FALTAM
    @Test
    void IsAnagrama_AnagramasValidosTest() {
        String str1 = "amor";
        String str2 = "roma";
        boolean resultado = strings.isAnagrama(str1, str2);
        assertTrue(resultado);
    }
    
    @Test
    void IsAnagrama_NaoAnagramasTest() {
        String str1 = "casa";
        String str2 = "carro";
        boolean resultado = strings.isAnagrama(str1, str2);
        assertFalse(resultado);
    }
    
    @Test
    void IsAnagrama_ComEspacosTest() {
        String str1 = "escola";
        String str2 = "loaces";
        boolean resultado = strings.isAnagrama(str1, str2);
        assertTrue(resultado);
    }
    
    @Test
    void IsAnagrama_AnagramaCaseInsensitiveTest() {
        String str1 = "Amor";
        String str2 = "Roma";
        boolean resultado = strings.isAnagrama(str1, str2);
        assertTrue(resultado);
    }
    
    @Test
    void IsAnagrama_AnagramaComPontuacaoTest() {
        String str1 = "alegria!";
        String str2 = "galeria?";
        boolean resultado = strings.isAnagrama(str1, str2);
        assertTrue(resultado);
    }
    
    @Test
    void IsAnagrama_StringsVaziasTest() {
        String str1 = "";
        String str2 = "";
        boolean resultado = strings.isAnagrama(str1, str2);
        assertTrue(resultado);
    }
    
    @Test
    void IsAnagrama_PrimeiraStringVaziaTest() {
        String str1 = "";
        String str2 = "teste";
        boolean resultado = strings.isAnagrama(str1, str2);
        assertFalse(resultado);
    }
    
    @Test
    void IsAnagrama_SegundaStringVaziaTest() {
        String str1 = "teste";
        String str2 = "";
        boolean resultado = strings.isAnagrama(str1, str2);
        assertFalse(resultado);
    }
    
    @Test
    void IsAnagrama_PrimeiraStringNulaTest() {
        String str1 = null;
        String str2 = "teste";
        boolean resultado = strings.isAnagrama(str1, str2);
        assertFalse(resultado);
    }
    
    @Test
    void IsAnagrama_SegundaStringNulaTest() {
        String str1 = "teste";
        String str2 = null;
        boolean resultado = strings.isAnagrama(str1, str2);
        assertFalse(resultado);
    }
    
    @Test
    void IsAnagrama_AmbasStringsNulasTest() {
        String str1 = null;
        String str2 = null;
        boolean resultado = strings.isAnagrama(str1, str2);
        assertFalse(resultado);
    }
    
    @Test
    void IsAnagrama_TamanhosDiferentesTest() {
        String str1 = "casa";
        String str2 = "casas";
        boolean resultado = strings.isAnagrama(str1, str2);
        assertFalse(resultado);
    }
    
    @Test
    void IsAnagrama_MesmasLetrasOrdemDiferenteTest() {
        String str1 = "listen";
        String str2 = "silent";
        boolean resultado = strings.isAnagrama(str1, str2);
        assertTrue(resultado);
    }
    
    @Test
    void IsAnagrama_ComNumerosTest() {
        String str1 = "123";
        String str2 = "321";
        boolean resultado = strings.isAnagrama(str1, str2);
        assertTrue(resultado);
    }
    
    @Test
    void IsAnagrama_ComCaracteresEspeciaisTest() {
        String str1 = "a!b@c";
        String str2 = "c@b!a";
        boolean resultado = strings.isAnagrama(str1, str2);
        assertTrue(resultado);
    }
    
    @Test
    void IsAnagrama_StringsIdenticasTest() {
        String str1 = "java";
        String str2 = "java";
        boolean resultado = strings.isAnagrama(str1, str2);
        assertTrue(resultado);
    }
    
    
    @Test
    void IsAnagrama_DeveRetornarFalseQuandoFrequenciaTemValoresPositivosTest() {
        // Caso onde str1 tem letras que não estão em str2
        String str1 = "abcde";
        String str2 = "abc"; // 'd' e 'e' não estão em str2
        boolean resultado = strings.isAnagrama(str1, str2);
        assertFalse(resultado);
    }

    @Test
    void IsAnagrama_DeveRetornarFalseQuandoFrequenciaTemValoresNegativosTest() {
        // Caso onde str2 tem letras que não estão em str1
        String str1 = "abc";
        String str2 = "abcde"; // 'd' e 'e' não estão em str1
        boolean resultado = strings.isAnagrama(str1, str2);
        assertFalse(resultado);
    }

    @Test
    void IsAnagrama_DeveRetornarFalseParaLetrasComFrequenciasDiferentesTest() {
        // Mesmas letras mas frequências diferentes
        String str1 = "aabbcc";
        String str2 = "aaabbb"; // 2 'c' vs 0 'c' e 3 'b' vs 2 'b'
        boolean resultado = strings.isAnagrama(str1, str2);
        assertFalse(resultado);
    }
}