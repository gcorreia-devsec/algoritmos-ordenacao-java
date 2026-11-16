# Trabalho Prático-Teórico: Algoritmos de Ordenação em Java
**Disciplina:** Algoritmos e Complexidade – UNIFACIMP Wyden  
**Alunos:** Guilherme Correia, Lucas, Erick  

## Sobre o Projeto
Implementação e análise empírica (benchmarking) de cinco algoritmos clássicos de ordenação em Java (JDK 21), confrontando a complexidade assintótica (Notação Big O) com o desempenho real medido via `System.nanoTime()`.

## Estrutura dos Arquivos
* `src/BubbleSort.java`: Ordenação por bolha com flag de parada antecipada $O(N)$.
* `src/SelectionSort.java`: Ordenação por seleção de mínimo com $O(N)$ trocas.
* `src/InsertionSort.java`: Ordenação por inserção sequencial otimizada para Cache L1.
* `src/MergeSort.java`: Divisão e conquista estável com vetor auxiliar $O(N)$.
* `src/QuickSort.java`: Partição com pivô fixo e versão segura com eliminação de recursão de cauda.
* `src/MainBenchmark.java`: Motor de testes automatizado (média de 5 execuções por cenário).

## Como Compilar e Executar
No diretório raiz do projeto, execute:
```bash
javac src/*.java
java -cp src MainBenchmark
