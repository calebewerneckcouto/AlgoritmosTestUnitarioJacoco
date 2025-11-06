package com.main;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Algoritmos {
    
    private static final Logger logger = Logger.getLogger(Algoritmos.class.getName());
    private static final String OS_NAME = "os.name";
    private static final String WINDOWS = "windows";
    private static final String CMD_EXE = "cmd.exe";
    private static final String DIGITE_NUMERO = "Digite um número: ";
    private static final String ELEMENTO = "Elemento ";
    private static final String ERRO = "Erro: ";
    private static final String ARRAY = "Array: ";
    
    private static Par par = new Par();
    private static Primo primo = new Primo();
    private static Fatorial fatorial = new Fatorial();
    private static ContadorOcorrencia contador = new ContadorOcorrencia();
    private static Strings strings = new Strings();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            logger.info("\n=== DEMONSTRAÇÃO DOS ALGORITMOS ===");
            logger.info("1 - Verificar se número é par");
            logger.info("2 - Verificar se número é primo");
            logger.info("3 - Calcular fatorial");
            logger.info("4 - Contador de ocorrências");
            logger.info("5 - Pesquisa linear");
            logger.info("6 - Inversão de String");
            logger.info("7 - Verificar anagrama");
            logger.info("8 - Cálculo da média");
            logger.info("9 - Segundo maior número");
            logger.info("10 - Soma de dois números");
            logger.info("11 - Verificar palíndromo");
            logger.info("12 - Encontrar número faltante");
            logger.info("13 - Gerar e abrir relatório de cobertura de testes");
            logger.info("0 - Sair");
            logger.info("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            
            if (opcao == 0) {
                logger.info("Encerrando programa...");
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
                    logger.warning(() -> "Opção inválida selecionada: " + opcao);
            }
        }
        
        scanner.close();
    }
    
    private static void gerarEAbrirRelatorioCobertura() {
        logger.info("=== GERANDO E ABRINDO RELATÓRIO DE COBERTURA ===");
        
        try {
            logger.info("Compilando e executando testes...");
            ProcessBuilder compileBuilder = new ProcessBuilder();
            
            if (System.getProperty(OS_NAME).toLowerCase().contains(WINDOWS)) {
                compileBuilder.command(CMD_EXE, "/c", "mvn", "clean", "compile", "test");
            } else {
                compileBuilder.command("bash", "-c", "mvn clean compile test");
            }
            
            compileBuilder.inheritIO();
            Process compileProcess = compileBuilder.start();
            int compileExitCode = compileProcess.waitFor();
            
            if (compileExitCode != 0) {
                logger.warning("Erro na compilação/testes. Tentando apenas testes...");
                
                ProcessBuilder testBuilder = new ProcessBuilder();
                if (System.getProperty(OS_NAME).toLowerCase().contains(WINDOWS)) {
                    testBuilder.command(CMD_EXE, "/c", "mvn", "test");
                } else {
                    testBuilder.command("bash", "-c", "mvn test");
                }
                
                testBuilder.inheritIO();
                Process testProcess = testBuilder.start();
                int testExitCode = testProcess.waitFor();
                
                if (testExitCode != 0) {
                    logger.severe("Testes também falharam. Verifique o código.");
                    return;
                }
            }
            
            logger.info("Compilação e testes executados com sucesso!");
            
            logger.info("Gerando relatório de cobertura...");
            ProcessBuilder reportBuilder = new ProcessBuilder();
            
            if (System.getProperty(OS_NAME).toLowerCase().contains(WINDOWS)) {
                reportBuilder.command(CMD_EXE, "/c", "mvn", "jacoco:report");
            } else {
                reportBuilder.command("bash", "-c", "mvn jacoco:report");
            }
            
            reportBuilder.inheritIO();
            Process reportProcess = reportBuilder.start();
            int reportExitCode = reportProcess.waitFor();
            
            if (reportExitCode != 0) {
                logger.severe("Erro ao gerar relatório.");
                return;
            }
            
            logger.info("Relatório gerado com sucesso!");
            
            abrirRelatorioNoNavegador();
            
        } catch (IOException e) {
            logger.log(Level.SEVERE, e, () -> "Erro durante o processo: " + e.getMessage());
            logger.info("Execute manualmente no terminal: mvn clean compile test jacoco:report");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.log(Level.SEVERE, e, () -> "Processo interrompido: " + e.getMessage());
        }
    }
    
    private static void abrirRelatorioNoNavegador() throws InterruptedException {
        try {
            String caminhoRelatorio = "target/site/jacoco/index.html";
            String caminhoAbsoluto = String.format("%s\\%s", System.getProperty("user.dir"), caminhoRelatorio);
            
            logger.info(() -> String.format("Caminho do relatório: %s", caminhoAbsoluto));
            
            java.io.File arquivo = new java.io.File(caminhoAbsoluto);
            if (!arquivo.exists()) {
                logger.severe("Relatório não foi gerado!");
                logger.info("Tente executar manualmente: mvn test jacoco:report");
                return;
            }
            
            logger.info("Abrindo relatório no navegador...");
            
            ProcessBuilder browserBuilder = new ProcessBuilder();
            
            if (System.getProperty(OS_NAME).toLowerCase().contains(WINDOWS)) {
                browserBuilder.command(CMD_EXE, "/c", "start", "", caminhoAbsoluto);
            } else if (System.getProperty(OS_NAME).toLowerCase().contains("mac")) {
                browserBuilder.command("open", caminhoAbsoluto);
            } else {
                browserBuilder.command("xdg-open", caminhoAbsoluto);
            }
            
            Process browserProcess = browserBuilder.start();
            
            if (!System.getProperty(OS_NAME).toLowerCase().contains(WINDOWS)) {
                int browserExitCode = browserProcess.waitFor();
                if (browserExitCode == 0) {
                    logger.info("Relatório aberto com sucesso!");
                } else {
                    logger.severe(() -> String.format("Erro ao abrir relatório. Código: %d", browserExitCode));
                }
            } else {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                logger.info("Relatório deve estar aberto no navegador!");
            }
            
        } catch (IOException e) {
            logger.log(Level.SEVERE, e, () -> "Erro ao abrir relatório: " + e.getMessage());
            logger.info("Abra manualmente: target/site/jacoco/index.html");
        }
    }
    
    private static void demonstrarPar(Scanner scanner) {
        logger.info(DIGITE_NUMERO);
        int numero = scanner.nextInt();
        logger.info(par.verificarParImpar(numero));
    }
    
    private static void demonstrarPrimo(Scanner scanner) {
        logger.info(DIGITE_NUMERO);
        int numero = scanner.nextInt();
        logger.info(primo.verificarPrimo(numero));
    }
    
    private static void demonstrarFatorial(Scanner scanner) {
        logger.info(DIGITE_NUMERO);
        int numero = scanner.nextInt();
        logger.info(fatorial.verificarFatorial(numero));
    }
    
    private static void demonstrarContadorOcorrencias(Scanner scanner) {
        logger.info("Digite o tamanho do vetor: ");
        int tamanho = scanner.nextInt();
        int[] vetor = new int[tamanho];
        
        logger.info("Digite os elementos do vetor:");
        for (int i = 0; i < tamanho; i++) {
            final int currentIndex = i;
            logger.info(() -> String.format("%s%d: ", ELEMENTO, (currentIndex + 1)));
            vetor[i] = scanner.nextInt();
        }
        
        logger.info("Digite o número a ser contado: ");
        int numero = scanner.nextInt();
        
        logger.info(contador.verificarOcorrencias(vetor, numero));
        logger.info(contador.encontrarPosicoes(vetor, numero));
    }
    
    private static void demonstrarPesquisaLinear(Scanner scanner) {
        logger.info("Digite o tamanho da lista: ");
        int tamanho = scanner.nextInt();
        int[] lista = new int[tamanho];
        
        logger.info("Digite os elementos da lista:");
        for (int i = 0; i < tamanho; i++) {
            final int currentIndex = i;
            logger.info(() -> String.format("%s%d: ", ELEMENTO, (currentIndex + 1)));
            lista[i] = scanner.nextInt();
        }
        
        logger.info("Digite o número a ser procurado: ");
        int numero = scanner.nextInt();
        
        try {
            int indice = PesquisaLinear.pesquisar(lista, numero);
            if (indice != -1) {
                logger.info(() -> String.format("Número encontrado no índice: %d", indice));
            } else {
                logger.info("Número não encontrado na lista");
            }
        } catch (IllegalArgumentException e) {
            logger.info(() -> String.format("%s%s", ERRO, e.getMessage()));
        }
    }
    
    private static void demonstrarInversaoString(Scanner scanner) {
        scanner.nextLine();
        logger.info("Digite uma string: ");
        String texto = scanner.nextLine();
        
        try {
            String invertida = strings.inverterString(texto);
            logger.info(() -> String.format("String original: %s", texto));
            logger.info(() -> String.format("String invertida: %s", invertida));
        } catch (IllegalArgumentException e) {
            logger.info(() -> String.format("%s%s", ERRO, e.getMessage()));
        }
    }
    
    private static void demonstrarAnagrama(Scanner scanner) {
        scanner.nextLine();
        logger.info("Digite a primeira string: ");
        String str1 = scanner.nextLine();
        
        logger.info("Digite a segunda string: ");
        String str2 = scanner.nextLine();
        
        boolean resultado = strings.isAnagrama(str1, str2);
        logger.info(() -> String.format("As strings \"%s\" e \"%s\" são anagramas? %s", str1, str2, resultado));
    }
    
    private static void demonstrarCalculoMedia(Scanner scanner) {
        logger.info("Digite o tamanho do vetor: ");
        int tamanho = scanner.nextInt();
        double[] vetor = new double[tamanho];
        
        logger.info("Digite os elementos do vetor:");
        for (int i = 0; i < tamanho; i++) {
            final int currentIndex = i;
            logger.info(() -> String.format("%s%d: ", ELEMENTO, (currentIndex + 1)));
            vetor[i] = scanner.nextDouble();
        }
        
        try {
            double media = CalculoMedia.calcularMedia(vetor);
            logger.info(() -> String.format("%s%s", ARRAY, Arrays.toString(vetor)));
            logger.info(() -> String.format("Média: %s", media));
        } catch (IllegalArgumentException e) {
            logger.info(() -> String.format("%s%s", ERRO, e.getMessage()));
        }
    }
    
    private static void demonstrarSegundoMaior(Scanner scanner) {
        logger.info("Digite o tamanho do array: ");
        int tamanho = scanner.nextInt();
        int[] numeros = new int[tamanho];
        
        logger.info("Digite os elementos do array:");
        for (int i = 0; i < tamanho; i++) {
            final int currentIndex = i;
            logger.info(() -> String.format("%s%d: ", ELEMENTO, (currentIndex + 1)));
            numeros[i] = scanner.nextInt();
        }
        
        try {
            int segundoMaior = SegundoMaiorNumero.encontrarSegundoMaior(numeros);
            logger.info(() -> String.format("%s%s", ARRAY, Arrays.toString(numeros)));
            logger.info(() -> String.format("Segundo maior número: %d", segundoMaior));
        } catch (IllegalArgumentException e) {
            logger.info(() -> String.format("%s%s", ERRO, e.getMessage()));
        }
    }
    
    private static void demonstrarSomaDois(Scanner scanner) {
        logger.info("Digite o tamanho do array: ");
        int tamanho = scanner.nextInt();
        int[] numeros = new int[tamanho];
        
        logger.info("Digite os elementos do array:");
        for (int i = 0; i < tamanho; i++) {
            final int currentIndex = i;
            logger.info(() -> String.format("%s%d: ", ELEMENTO, (currentIndex + 1)));
            numeros[i] = scanner.nextInt();
        }
        
        logger.info("Digite o valor alvo da soma: ");
        int alvo = scanner.nextInt();
        
        try {
            int[] indices = SomaDois.encontrarIndicesSoma(numeros, alvo);
            logger.info(() -> String.format("%s%s", ARRAY, Arrays.toString(numeros)));
            logger.info(() -> String.format("Alvo: %d", alvo));
            logger.info(() -> String.format("Índices: %s", Arrays.toString(indices)));
            logger.info(() -> String.format("Números: %d + %d = %d", 
                numeros[indices[0]], numeros[indices[1]], alvo));
        } catch (IllegalArgumentException e) {
            logger.info(() -> String.format("%s%s", ERRO, e.getMessage()));
        }
    }
    
    private static void demonstrarPalindromo(Scanner scanner) {
        scanner.nextLine();
        logger.info("Digite uma string: ");
        String texto = scanner.nextLine();
        
        try {
            boolean resultado = strings.isPalindromo(texto);
            logger.info(() -> String.format("A string \"%s\" é um palíndromo? %s", texto, resultado));
        } catch (IllegalArgumentException e) {
            logger.info(() -> String.format("%s%s", ERRO, e.getMessage()));
        }
    }
    
    private static void demonstrarFaltaUm(Scanner scanner) {
        logger.info("Digite o tamanho do array (n): ");
        int n = scanner.nextInt();
        int[] numeros = new int[n];
        
        logger.info(() -> String.format("Digite %d números no intervalo [0, %d] (um número deve estar faltando):", n, n));
        for (int i = 0; i < n; i++) {
            final int currentIndex = i;
            logger.info(() -> String.format("%s%d: ", ELEMENTO, (currentIndex + 1)));
            numeros[i] = scanner.nextInt();
        }
        
        try {
            int faltante = FaltaUm.encontrarNumeroFaltante(numeros);
            logger.info(() -> String.format("%s%s", ARRAY, Arrays.toString(numeros)));
            logger.info(() -> String.format("Número faltante: %d", faltante));
            
            int faltanteXOR = FaltaUm.encontrarNumeroFaltanteXOR(numeros);
            logger.info(() -> String.format("Número faltante (XOR): %d", faltanteXOR));
        } catch (IllegalArgumentException e) {
            logger.info(() -> String.format("%s%s", ERRO, e.getMessage()));
        }
    }
}