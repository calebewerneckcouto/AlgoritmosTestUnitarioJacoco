package com.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class SegundoMaiorNumeroTest {
    
    @Test
    void instanciaDaClasseTest() {
        SegundoMaiorNumero instancia = new SegundoMaiorNumero();
        assertNotNull(instancia);
    }

    // Testes para encontrarSegundoMaior com int[]
    @Test
    void encontrarSegundoMaiorNumerosDistintosTest() {
        int[] numeros = {10, 5, 8, 15, 3};
        int resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(10, resultado);
    }

    @Test
    void encontrarSegundoMaiorNumerosNegativosTest() {
        int[] numeros = {-5, -10, -3, -1, -8};
        int resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(-3, resultado);
    }

    @Test
    void encontrarSegundoMaiorTodosNegativosTest() {
        int[] numeros = {-10, -5, -8, -15, -3};
        int resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(-5, resultado);
    }

    @Test
    void encontrarSegundoMaiorComRepeticaoTest() {
        int[] numeros = {10, 10, 8, 15, 15, 12};
        int resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(12, resultado);
    }

    @Test
    void encontrarSegundoMaiorDoisElementosTest() {
        int[] numeros = {20, 10};
        int resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(10, resultado);
    }

    @Test
    void encontrarSegundoMaiorDoisElementosInvertidosTest() {
        int[] numeros = {10, 20};
        int resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(10, resultado);
    }

    @Test
    void encontrarSegundoMaiorArrayNuloTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            SegundoMaiorNumero.encontrarSegundoMaior((int[]) null);
        });
        assertEquals("O array não pode ser nulo", exception.getMessage());
    }

    @Test
    void encontrarSegundoMaiorArrayVazioTest() {
        int[] numeros = {};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        });
        assertEquals("O array deve ter pelo menos dois elementos", exception.getMessage());
    }

    @Test
    void encontrarSegundoMaiorApenasUmElementoTest() {
        int[] numeros = {5};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        });
        assertEquals("O array deve ter pelo menos dois elementos", exception.getMessage());
    }

    @Test
    void encontrarSegundoMaiorTodosIguaisTest() {
        int[] numeros = {7, 7, 7, 7, 7};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        });
        assertEquals("Não existe segundo maior número (todos os números são iguais)", exception.getMessage());
    }

    @Test
    void encontrarSegundoMaiorNumerosGrandesTest() {
        int[] numeros = {1000000, 500000, 750000, 1000000, 250000};
        int resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(750000, resultado);
    }

    @Test
    void encontrarSegundoMaiorComZeroTest() {
        int[] numeros = {0, -5, 10, 5, 0};
        int resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(5, resultado);
    }

    // Testes específicos para cobrir as linhas do loop
    @Test
    void encontrarSegundoMaiorSegundoMaiorInicializadoComPrimeiroMenorTest() {
        // Testa o caso: else if (segundoMaior == Integer.MIN_VALUE && numero < maior)
        int[] numeros = {10, 5, 8, 15, 3};
        int resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(10, resultado);
    }

    @Test
    void encontrarSegundoMaiorComNumerosEmOrdemCrescenteTest() {
        int[] numeros = {1, 2, 3, 4, 5};
        int resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(4, resultado);
    }

    @Test
    void encontrarSegundoMaiorComNumerosEmOrdemDecrescenteTest() {
        int[] numeros = {5, 4, 3, 2, 1};
        int resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(4, resultado);
    }

    @Test
    void encontrarSegundoMaiorComSegundoMaiorNoInicioTest() {
        int[] numeros = {8, 10, 5, 3, 7};
        int resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(8, resultado);
    }

    @Test
    void encontrarSegundoMaiorComSegundoMaiorNoFimTest() {
        int[] numeros = {10, 5, 3, 7, 8};
        int resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(8, resultado);
    }

    // Testes para encontrarSegundoMaior com double[]
    @Test
    void encontrarSegundoMaiorDoublesTest() {
        double[] numeros = {10.5, 5.2, 8.7, 15.1, 3.8};
        double resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(10.5, resultado, 0.001);
    }

    @Test
    void encontrarSegundoMaiorDoublesNegativosTest() {
        double[] numeros = {-5.5, -10.2, -3.8, -1.1, -8.9};
        double resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(-3.8, resultado, 0.001);
    }

    @Test
    void encontrarSegundoMaiorDoublesTodosNegativosTest() {
        double[] numeros = {-15.5, -5.2, -8.7, -10.1, -3.8};
        double resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(-5.2, resultado, 0.001);
    }

    @Test
    void encontrarSegundoMaiorDoublesComRepeticaoTest() {
        double[] numeros = {10.5, 10.5, 8.7, 15.1, 15.1, 12.3};
        double resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(12.3, resultado, 0.001);
    }

    @Test
    void encontrarSegundoMaiorDoublesArrayNuloTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            SegundoMaiorNumero.encontrarSegundoMaior((double[]) null);
        });
        assertEquals("O array não pode ser nulo", exception.getMessage());
    }

    @Test
    void encontrarSegundoMaiorDoublesArrayVazioTest() {
        double[] numeros = {};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        });
        assertEquals("O array deve ter pelo menos dois elementos", exception.getMessage());
    }

    @Test
    void encontrarSegundoMaiorDoublesApenasUmElementoTest() {
        double[] numeros = {5.5};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        });
        assertEquals("O array deve ter pelo menos dois elementos", exception.getMessage());
    }

    @Test
    void encontrarSegundoMaiorDoublesTodosIguaisTest() {
        double[] numeros = {3.14, 3.14, 3.14, 3.14};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        });
        assertEquals("Não existe segundo maior número (todos os números são iguais)", exception.getMessage());
    }

    // Testes específicos para doubles cobrindo as linhas do loop
    @Test
    void encontrarSegundoMaiorDoublesSegundoMaiorInicializadoComPrimeiroMenorTest() {
        double[] numeros = {10.5, 5.2, 8.7, 15.1, 3.8};
        double resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(10.5, resultado, 0.001);
    }

    @Test
    void encontrarSegundoMaiorDoublesComNumerosEmOrdemCrescenteTest() {
        double[] numeros = {1.1, 2.2, 3.3, 4.4, 5.5};
        double resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(4.4, resultado, 0.001);
    }

    @Test
    void encontrarSegundoMaiorDoublesComNumerosEmOrdemDecrescenteTest() {
        double[] numeros = {5.5, 4.4, 3.3, 2.2, 1.1};
        double resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(4.4, resultado, 0.001);
    }

    @Test
    void encontrarSegundoMaiorDoublesComDoisElementosTest() {
        double[] numeros = {20.5, 10.2};
        double resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(10.2, resultado, 0.001);
    }

    @Test
    void encontrarSegundoMaiorDoublesComDoisElementosInvertidosTest() {
        double[] numeros = {10.2, 20.5};
        double resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(10.2, resultado, 0.001);
    }
    
    @Test
    void encontrarSegundoMaiorComPrimeiroElementoMaiorESegundoInicializadoComMIN_VALUETest() {
        // Testa: else if (segundoMaior == Integer.MIN_VALUE && numero < maior)
        // Array onde o primeiro elemento é o maior e o segundoMaior precisa ser inicializado
        int[] numeros = {15, 5, 8, 10, 3};
        int resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(10, resultado);
    }

    @Test
    void encontrarSegundoMaiorComPrimeiroMaiorESegundoInicializadoComMIN_VALUETest() {
        // Testa: else if (segundoMaior == Integer.MIN_VALUE && numero < maior)
        // Primeiro elemento é o maior, segundo elemento é menor
        int[] numeros = {20, 10, 5, 15};
        int resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(15, resultado);
    }

    @Test
    void encontrarSegundoMaiorComTodosNegativosESegundoInicializadoTest() {
        // Testa: else if (segundoMaior == Integer.MIN_VALUE && numero < maior)
        // Com números negativos
        int[] numeros = {-1, -5, -3, -8, -2};
        int resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(-2, resultado);
    }

    @Test
    void encontrarSegundoMaiorDoublesComPrimeiroElementoMaiorESegundoInicializadoTest() {
        // Testa: else if (segundoMaior == -Double.MAX_VALUE && numero < maior)
        double[] numeros = {15.5, 5.2, 8.7, 10.1, 3.8};
        double resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(10.1, resultado, 0.001);
    }

    @Test
    void encontrarSegundoMaiorDoublesComPrimeiroMaiorESegundoInicializadoTest() {
        // Testa: else if (segundoMaior == -Double.MAX_VALUE && numero < maior)
        double[] numeros = {20.5, 10.2, 5.5, 15.7};
        double resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(15.7, resultado, 0.001);
    }

    @Test
    void encontrarSegundoMaiorDoublesComTodosNegativosESegundoInicializadoTest() {
        // Testa: else if (segundoMaior == -Double.MAX_VALUE && numero < maior)
        double[] numeros = {-1.1, -5.5, -3.3, -8.8, -2.2};
        double resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(-2.2, resultado, 0.001);
    }

    @Test
    void encontrarSegundoMaiorComArrayDeTresElementosPrimeiroMaiorTest() {
        // Caso específico com 3 elementos onde o primeiro é o maior
        int[] numeros = {30, 10, 20};
        int resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(20, resultado);
    }

    @Test
    void encontrarSegundoMaiorDoublesComArrayDeTresElementosPrimeiroMaiorTest() {
        // Caso específico com 3 elementos onde o primeiro é o maior
        double[] numeros = {30.5, 10.2, 20.7};
        double resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(20.7, resultado, 0.001);
    }
    
    @Test
    void encontrarSegundoMaiorCasoExatoSegundoMaiorMIN_VALUETest() {
        // Caso EXATO que força: else if (segundoMaior == Integer.MIN_VALUE && numero < maior)
        // Primeiro elemento é o maior, segundo elemento é MENOR que o primeiro
        // e deve inicializar o segundoMaior
        int[] numeros = {100, 50, 75, 25};
        // Iteração 1: maior=100, segundoMaior=MIN_VALUE, numero=50
        //   -> entra no: else if (segundoMaior == Integer.MIN_VALUE && 50 < 100)
        //   -> segundoMaior = 50, encontrouSegundo = true
        // Iteração 2: maior=100, segundoMaior=50, numero=75  
        //   -> entra no: else if (75 > 50 && 75 < 100)
        //   -> segundoMaior = 75
        // Iteração 3: maior=100, segundoMaior=75, numero=25 -> ignora
        int resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(75, resultado);
    }

    @Test
    void encontrarSegundoMaiorApenasDoisElementosPrimeiroMaiorTest() {
        // Caso mais simples com apenas 2 elementos
        // Primeiro é maior, segundo é menor - deve inicializar segundoMaior
        int[] numeros = {30, 20};
        // Iteração 1: maior=30, segundoMaior=MIN_VALUE, numero=20
        //   -> entra no: else if (segundoMaior == Integer.MIN_VALUE && 20 < 30)
        //   -> segundoMaior = 20, encontrouSegundo = true
        int resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(20, resultado);
    }

    @Test
    void encontrarSegundoMaiorCasoExatoTodosMenoresQuePrimeiroTest() {
        // Todos os elementos são menores que o primeiro
        // O primeiro elemento permanece sendo o maior
        int[] numeros = {100, 90, 80, 95};
        // Iteração 1: maior=100, segundoMaior=MIN_VALUE, numero=90
        //   -> entra no: else if (segundoMaior == Integer.MIN_VALUE && 90 < 100)
        //   -> segundoMaior = 90
        // Iteração 2: maior=100, segundoMaior=90, numero=80 -> ignora
        // Iteração 3: maior=100, segundoMaior=90, numero=95
        //   -> entra no: else if (95 > 90 && 95 < 100)
        //   -> segundoMaior = 95
        int resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(95, resultado);
    }

    @Test
    void encontrarSegundoMaiorDoublesCasoExatoSegundoMaiorMIN_VALUETest() {
        // Mesmo caso para doubles
        double[] numeros = {100.5, 50.2, 75.7, 25.8};
        double resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(75.7, resultado, 0.001);
    }

    @Test
    void encontrarSegundoMaiorDoublesApenasDoisElementosPrimeiroMaiorTest() {
        // Caso mais simples com apenas 2 elementos para doubles
        double[] numeros = {30.5, 20.2};
        double resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(20.2, resultado, 0.001);
    }

    @Test
    void encontrarSegundoMaiorComNegativosCasoExatoTest() {
        // Com números negativos onde o primeiro é o "maior" (menos negativo)
        int[] numeros = {-10, -20, -15, -25};
        // Iteração 1: maior=-10, segundoMaior=MIN_VALUE, numero=-20
        //   -> entra no: else if (segundoMaior == Integer.MIN_VALUE && -20 < -10)
        //   -> segundoMaior = -20
        // Iteração 2: maior=-10, segundoMaior=-20, numero=-15
        //   -> entra no: else if (-15 > -20 && -15 < -10)
        //   -> segundoMaior = -15
        // Iteração 3: maior=-10, segundoMaior=-15, numero=-25 -> ignora
        int resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(-15, resultado);
    }

    @Test
    void encontrarSegundoMaiorComZeroECasoExatoTest() {
        // Incluindo zero no caso específico
        int[] numeros = {50, 0, 25, 75};
        // Iteração 1: maior=50, segundoMaior=MIN_VALUE, numero=0
        //   -> entra no: else if (segundoMaior == Integer.MIN_VALUE && 0 < 50)
        //   -> segundoMaior = 0
        // Iteração 2: maior=50, segundoMaior=0, numero=25
        //   -> entra no: else if (25 > 0 && 25 < 50)
        //   -> segundoMaior = 25
        // Iteração 3: maior=50, segundoMaior=25, numero=75
        //   -> entra no: if (75 > 50)
        //   -> segundoMaior = 50, maior = 75
        int resultado = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
        assertEquals(50, resultado);
    }
}