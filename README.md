# README.md

## Projeto: Algoritmos e Estruturas de Dados em Java

### Estrutura do Projeto

```
.
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── main
│   │               ├── CalculoMedia.java
│   │               ├── ContadorOcorrencia.java
│   │               ├── Fatorial.java
│   │               ├── PesquisaLinear.java
│   │               ├── Primo.java
│   │               ├── SegundoMaiorNumero.java
│   │               └── Strings.java
│   └── test
│       └── java
│           └── com
│               └── main
│                   ├── CalculoMediaTest.java
│                   ├── ContadorOcorrenciaTest.java
│                   ├── FatorialTest.java
│                   ├── ParTest.java
│                   ├── PesquisaLinearTest.java
│                   └── StringsTest.java
```

### Linguagens de Programação

- **Java**: Principal linguagem utilizada para o desenvolvimento do projeto.

### Dependências

- **JUnit 5**: Utilizado para a execução dos testes unitários.
- **Apache Maven**: Utilizado para gerenciar as dependências e compilar o projeto.

### Instruções de Instalação

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/seuusuario/algoritmos-estruturas-dados.git
   ```

2. **Instale as dependências**:
   ```bash
   cd algoritmos-estruturas-dados
   mvn install
   ```

### Como Rodar o Projeto

1. **Compilar o projeto**:
   ```bash
   mvn compile
   ```

2. **Executar o projeto**:
   ```bash
   mvn exec:java -Dexec.mainClass="com.main.App"
   ```

### Como Executar os Testes

```bash
mvn test
```

### Explicação Detalhada dos Arquivos de Código

#### `Fatorial.java`
- **Funções**:
  - `calcularFatorial(int numero)`: Calcula o fatorial de um número de forma iterativa.
  - `calcularFatorialRecursivo(int numero)`: Calcula o fatorial de um número de forma recursiva.
  - `verificarFatorial(int numero)`: Retorna uma string formatada com o resultado do fatorial ou uma mensagem de erro.

- **Responsabilidades**: Fornecer diferentes implementações para o cálculo de fatorial e garantir que o resultado seja formatado corretamente.

#### `ContadorOcorrencia.java`
- **Funções**:
  - `contarOcorrencias(int[] numeros)`: Conta quantas vezes um número aparece em um array.
  - `verificarOcorrencias(int[] numeros, int numero)`: Retorna uma string formatada com a quantidade de ocorrências.
  - `encontrarPosicoes(int[] numeros, int numero)`: Retorna as posições onde o número aparece no array.

- **Responsabilidades**: Contar e localizar ocorrências de um número em um array.

#### `CalculoMedia.java`
- **Funções**:
  - `calcularMedia(double[] numeros)`: Calcula a média de um array de doubles.
  - `calcularMedia(int[] numeros)`: Calcula a média de um array de inteiros.

- **Responsabilidades**: Calcular a média de arrays numéricos e garantir que a função funcione corretamente com diferentes tipos de dados.

#### `PesquisaLinear.java`
- **Funções**:
  - `pesquisar(int[] lista, int numeroProcurado)`: Retorna o índice do número procurado em um array.
  - `pesquisar(List<Integer> lista, int numeroProcurado)`: Retorna o índice do número procurado em uma lista.

- **Responsabilidades**: Realizar pesquisa linear em arrays e listas de inteiros.

#### `Strings.java`
- **Funções**:
  - `inverterString(String texto)`: Inverte a ordem dos caracteres de uma string.
  - `isPalindromo(String texto)`: Verifica se uma string é um palíndromo.
  - `saoAnagramas(String str1, String str2)`: Verifica se duas strings são anagramas.

- **Responsabilidades**: Manipular strings, invertendo-as, verificando se são palíndromos e se duas strings são anagramas.

### Exemplos de Uso

#### Fatorial
```java
Fatorial fatorial = new Fatorial();
int resultadoIterativo = fatorial.calcularFatorial(5); // Retorna 120
int resultadoRecursivo = fatorial.calcularFatorialRecursivo(5); // Retorna 120
String resultadoFormatado = fatorial.verificarFatorial(5); // Retorna "5! = 120"
```

#### Contador de Ocorrências
```java
int[] numeros = {1, 2, 2, 3, 4, 2};
ContadorOcorrencia contador = new ContadorOcorrencia();
int ocorrencias = contador.contarOcorrencias(numeros, 2); // Retorna 3
String verificacao = contador.verificarOcorrencias(numeros, 2); // Retorna "O número 2 aparece 3 vezes"
String posicoes = contador.encontrarPosicoes(numeros, 2); // Retorna "Número 2 encontrado nas posições: [1, 2, 5]"
```

#### Cálculo de Média
```java
double[] doubles = {1.0, 2.0, 3.0, 4.0};
double media = CalculoMedia.calcularMedia(doubles); // Retorna 2.5
```

### Boas Práticas e Dicas para Contribuir

1. **Codificação**:
   - Utilize nomes de variáveis e métodos descritivos.
   - Mantenha a complexidade dos métodos baixa.
   - Trate todas as possíveis entradas inválidas com exceções apropriadas.

2. **Testes**:
   - Escreva testes para cobrir todos os casos de uso, incluindo entradas nulas, vazias e casos de borda.
   - Utilize a anotação `@BeforeEach` para inicializar objetos de teste.
   - Use `assertEquals` e `assertThrows` para validar resultados e exceções.

3. **Contribuições**:
   - Fork o repositório e crie uma branch para sua funcionalidade ou correção.
   - Certifique-se de que todos os testes estão passando antes de enviar um pull request.
   - Adicione testes para qualquer nova funcionalidade ou correção de bug.
   - Mantenha o código limpo e organizado, seguindo as convenções de código Java.

### Documentação

Para mais informações sobre a família de modelos Sabiá e detalhes técnicos, visite [https://docs.maritaca.ai](https://docs.maritaca.ai).

### Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

### Contato

Para dúvidas e outras questões, entre em contato com a equipe de desenvolvimento em [contato@maritaca.ai](mailto:contato@maritaca.ai).