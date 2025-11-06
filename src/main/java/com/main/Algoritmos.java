package com.main;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Algoritmos {
    
    private static Par par = new Par();
    private static Primo primo = new Primo();
    private static Fatorial fatorial = new Fatorial();
    private static ContadorOcorrencia contador = new ContadorOcorrencia();
    private static Strings strings = new Strings();
    private static CalculoMedia calculoMedia = new CalculoMedia();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== DEMONSTRAÇÃO DOS ALGORITMOS ===");
            System.out.println("1 - Verificar se número é par");
            System.out.println("2 - Verificar se número é primo");
            System.out.println("3 - Calcular fatorial");
            System.out.println("4 - Contador de ocorrências");
            System.out.println("5 - Pesquisa linear");
            System.out.println("6 - Inversão de String");
            System.out.println("7 - Verificar anagrama");
            System.out.println("8 - Cálculo da média");
            System.out.println("9 - Segundo maior número");
            System.out.println("10 - Soma de dois números");
            System.out.println("11 - Verificar palíndromo");
            System.out.println("12 - Encontrar número faltante");
            System.out.println("13 - Gerar e abrir relatório de cobertura de testes");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            
            if (opcao == 0) {
                System.out.println("Encerrando programa...");
                break;
            }
            
            switch (opcao) {
                case 1:
                    demonstrarPar(scanner);
                    break;
                case 2:
                    demonstrarPrimo(scanner);
                    break;
                case 3:
                    demonstrarFatorial(scanner);
                    break;
                case 4:
                    demonstrarContadorOcorrencias(scanner);
                    break;
                case 5:
                    demonstrarPesquisaLinear(scanner);
                    break;
                case 6:
                    demonstrarInversaoString(scanner);
                    break;
                case 7:
                    demonstrarAnagrama(scanner);
                    break;
                case 8:
                    demonstrarCalculoMedia(scanner);
                    break;
                case 9:
                    demonstrarSegundoMaior(scanner);
                    break;
                case 10:
                    demonstrarSomaDois(scanner);
                    break;
                case 11:
                    demonstrarPalindromo(scanner);
                    break;
                case 12:
                    demonstrarFaltaUm(scanner);
                    break;
                case 13:
                    gerarEAbrirRelatorioCobertura();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        
        scanner.close();
    }
    
    private static void gerarEAbrirRelatorioCobertura() {
        System.out.println("=== GERANDO E ABRINDO RELATÓRIO DE COBERTURA ===");
        
        try {
            // Primeiro: Tentar compilar e testar
            System.out.println("🔄 Compilando e executando testes...");
            ProcessBuilder compileBuilder = new ProcessBuilder();
            
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                compileBuilder.command("cmd.exe", "/c", "mvn", "clean", "compile", "test");
            } else {
                compileBuilder.command("bash", "-c", "mvn clean compile test");
            }
            
            compileBuilder.inheritIO();
            Process compileProcess = compileBuilder.start();
            int compileExitCode = compileProcess.waitFor();
            
            if (compileExitCode != 0) {
                System.out.println("❌ Erro na compilação/testes. Tentando apenas testes...");
                
                // Tentar apenas os testes se a compilação falhar
                ProcessBuilder testBuilder = new ProcessBuilder();
                if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                    testBuilder.command("cmd.exe", "/c", "mvn", "test");
                } else {
                    testBuilder.command("bash", "-c", "mvn test");
                }
                
                testBuilder.inheritIO();
                Process testProcess = testBuilder.start();
                int testExitCode = testProcess.waitFor();
                
                if (testExitCode != 0) {
                    System.out.println("❌ Testes também falharam. Verifique o código.");
                    return;
                }
            }
            
            System.out.println("✅ Compilação e testes executados com sucesso!");
            
            // Gerar relatório JaCoCo
            System.out.println("🔄 Gerando relatório de cobertura...");
            ProcessBuilder reportBuilder = new ProcessBuilder();
            
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                reportBuilder.command("cmd.exe", "/c", "mvn", "jacoco:report");
            } else {
                reportBuilder.command("bash", "-c", "mvn jacoco:report");
            }
            
            reportBuilder.inheritIO();
            Process reportProcess = reportBuilder.start();
            int reportExitCode = reportProcess.waitFor();
            
            if (reportExitCode != 0) {
                System.out.println("❌ Erro ao gerar relatório.");
                return;
            }
            
            System.out.println("✅ Relatório gerado com sucesso!");
            
            // Abrir o relatório
            abrirRelatorioNoNavegador();
            
        } catch (IOException | InterruptedException e) {
            System.out.println("❌ Erro durante o processo: " + e.getMessage());
            System.out.println("💡 Execute manualmente no terminal:");
            System.out.println("   mvn clean compile test jacoco:report");
        }
    }
    
    private static void abrirRelatorioNoNavegador() {
        try {
            String caminhoRelatorio = "target/site/jacoco/index.html";
            String caminhoAbsoluto = System.getProperty("user.dir") + "\\" + caminhoRelatorio;
            
            System.out.println("📁 Caminho do relatório: " + caminhoAbsoluto);
            
            // Verificar se o arquivo foi gerado
            java.io.File arquivo = new java.io.File(caminhoAbsoluto);
            if (!arquivo.exists()) {
                System.out.println("❌ Relatório não foi gerado!");
                System.out.println("💡 Tente executar manualmente: mvn test jacoco:report");
                return;
            }
            
            System.out.println("🔄 Abrindo relatório no navegador...");
            
            ProcessBuilder browserBuilder = new ProcessBuilder();
            
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                browserBuilder.command("cmd.exe", "/c", "start", "", caminhoAbsoluto);
            } else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                browserBuilder.command("open", caminhoAbsoluto);
            } else {
                browserBuilder.command("xdg-open", caminhoAbsoluto);
            }
            
            Process browserProcess = browserBuilder.start();
            
            // Para Windows, não esperamos o processo terminar
            if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
                int browserExitCode = browserProcess.waitFor();
                if (browserExitCode == 0) {
                    System.out.println("✅ Relatório aberto com sucesso!");
                } else {
                    System.out.println("❌ Erro ao abrir relatório. Código: " + browserExitCode);
                }
            } else {
                Thread.sleep(2000); // Dar tempo para o navegador abrir
                System.out.println("✅ Relatório deve estar aberto no navegador!");
            }
            
        } catch (IOException | InterruptedException e) {
            System.out.println("❌ Erro ao abrir relatório: " + e.getMessage());
            System.out.println("📋 Abra manualmente: target/site/jacoco/index.html");
        }
    }
    
    // Os demais métodos permanecem iguais...
    private static void demonstrarPar(Scanner scanner) {
        System.out.print("Digite um número: ");
        int numero = scanner.nextInt();
        System.out.println(par.verificarParImpar(numero));
    }
    
    private static void demonstrarPrimo(Scanner scanner) {
        System.out.print("Digite um número: ");
        int numero = scanner.nextInt();
        System.out.println(primo.verificarPrimo(numero));
    }
    
    private static void demonstrarFatorial(Scanner scanner) {
        System.out.print("Digite um número: ");
        int numero = scanner.nextInt();
        System.out.println(fatorial.verificarFatorial(numero));
    }
    
    private static void demonstrarContadorOcorrencias(Scanner scanner) {
        System.out.print("Digite o tamanho do vetor: ");
        int tamanho = scanner.nextInt();
        int[] vetor = new int[tamanho];
        
        System.out.println("Digite os elementos do vetor:");
        for (int i = 0; i < tamanho; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            vetor[i] = scanner.nextInt();
        }
        
        System.out.print("Digite o número a ser contado: ");
        int numero = scanner.nextInt();
        
        System.out.println(contador.verificarOcorrencias(vetor, numero));
        System.out.println(contador.encontrarPosicoes(vetor, numero));
    }
    
    private static void demonstrarPesquisaLinear(Scanner scanner) {
        System.out.print("Digite o tamanho da lista: ");
        int tamanho = scanner.nextInt();
        int[] lista = new int[tamanho];
        
        System.out.println("Digite os elementos da lista:");
        for (int i = 0; i < tamanho; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            lista[i] = scanner.nextInt();
        }
        
        System.out.print("Digite o número a ser procurado: ");
        int numero = scanner.nextInt();
        
        try {
            int indice = PesquisaLinear.pesquisar(lista, numero);
            if (indice != -1) {
                System.out.println("Número encontrado no índice: " + indice);
            } else {
                System.out.println("Número não encontrado na lista");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    private static void demonstrarInversaoString(Scanner scanner) {
        scanner.nextLine(); // Limpar buffer
        System.out.print("Digite uma string: ");
        String texto = scanner.nextLine();
        
        try {
            String invertida = strings.inverterString(texto);
            System.out.println("String original: " + texto);
            System.out.println("String invertida: " + invertida);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    private static void demonstrarAnagrama(Scanner scanner) {
        scanner.nextLine(); // Limpar buffer
        System.out.print("Digite a primeira string: ");
        String str1 = scanner.nextLine();
        
        System.out.print("Digite a segunda string: ");
        String str2 = scanner.nextLine();
        
        boolean resultado = strings.isAnagrama(str1, str2);
        System.out.println("As strings \"" + str1 + "\" e \"" + str2 + "\" são anagramas? " + resultado);
    }
    
    private static void demonstrarCalculoMedia(Scanner scanner) {
        System.out.print("Digite o tamanho do vetor: ");
        int tamanho = scanner.nextInt();
        double[] vetor = new double[tamanho];
        
        System.out.println("Digite os elementos do vetor:");
        for (int i = 0; i < tamanho; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            vetor[i] = scanner.nextDouble();
        }
        
        try {
            double media = CalculoMedia.calcularMedia(vetor);
            System.out.println("Vetor: " + Arrays.toString(vetor));
            System.out.println("Média: " + media);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    private static void demonstrarSegundoMaior(Scanner scanner) {
        System.out.print("Digite o tamanho do array: ");
        int tamanho = scanner.nextInt();
        int[] numeros = new int[tamanho];
        
        System.out.println("Digite os elementos do array:");
        for (int i = 0; i < tamanho; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }
        
        try {
            int segundoMaior = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
            System.out.println("Array: " + Arrays.toString(numeros));
            System.out.println("Segundo maior número: " + segundoMaior);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    private static void demonstrarSomaDois(Scanner scanner) {
        System.out.print("Digite o tamanho do array: ");
        int tamanho = scanner.nextInt();
        int[] numeros = new int[tamanho];
        
        System.out.println("Digite os elementos do array:");
        for (int i = 0; i < tamanho; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }
        
        System.out.print("Digite o valor alvo da soma: ");
        int alvo = scanner.nextInt();
        
        try {
            int[] indices = SomaDois.encontrarIndicesSoma(numeros, alvo);
            System.out.println("Array: " + Arrays.toString(numeros));
            System.out.println("Alvo: " + alvo);
            System.out.println("Índices: " + Arrays.toString(indices));
            System.out.println("Números: " + numeros[indices[0]] + " + " + numeros[indices[1]] + " = " + alvo);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    private static void demonstrarPalindromo(Scanner scanner) {
        scanner.nextLine(); // Limpar buffer
        System.out.print("Digite uma string: ");
        String texto = scanner.nextLine();
        
        try {
            boolean resultado = strings.isPalindromo(texto);
            System.out.println("A string \"" + texto + "\" é um palíndromo? " + resultado);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    private static void demonstrarFaltaUm(Scanner scanner) {
        System.out.print("Digite o tamanho do array (n): ");
        int n = scanner.nextInt();
        int[] numeros = new int[n];
        
        System.out.println("Digite " + n + " números no intervalo [0, " + (n) + "] (um número deve estar faltando):");
        for (int i = 0; i < n; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }
        
        try {
            int faltante = FaltaUm.encontrarNumeroFaltante(numeros);
            System.out.println("Array: " + Arrays.toString(numeros));
            System.out.println("Número faltante: " + faltante);
            
            // Demonstração com XOR também
            int faltanteXOR = FaltaUm.encontrarNumeroFaltanteXOR(numeros);
            System.out.println("Número faltante (XOR): " + faltanteXOR);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}