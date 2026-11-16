// Arquivo: MainBenchmark.java
import java.util.Random;

public class MainBenchmark {
    private static final int REPETICOES = 5;

    public static void main(String[] args) {
        int[] tamanhos = {10, 100, 1000, 10000, 100000, 1000000};
        String[] cenarios = {"ALEATORIO", "ORDENADO", "INVERTIDO"};

        int[] warmup = gerarVetor(1000, "ALEATORIO");
        InsertionSort.sort(warmup.clone());
        MergeSort.sort(warmup.clone());

        for (String cenario : cenarios) {
            System.out.println("=== CENÁRIO: " + cenario + " ===");
            for (int n : tamanhos) {
                int[] base = gerarVetor(n, cenario);
                medirAlgoritmo("BubbleSort",    base);
                medirAlgoritmo("SelectionSort", base);
                medirAlgoritmo("InsertionSort", base);
                medirAlgoritmo("MergeSort",     base);
                medirAlgoritmo("QuickSort",     base);
            }
        }
    }

    private static void medirAlgoritmo(String nome, int[] vetorBase) {
        long somaNano = 0;
        for (int r = 0; r < REPETICOES; r++) {
            int[] copia = vetorBase.clone();
            long inicio = System.nanoTime();
            switch (nome) {
                case "BubbleSort":    BubbleSort.sort(copia); break;
                case "SelectionSort": SelectionSort.sort(copia); break;
                case "InsertionSort": InsertionSort.sort(copia); break;
                case "MergeSort":     MergeSort.sort(copia); break;
                case "QuickSort":     QuickSort.sortPivoFixo(copia, 0, copia.length - 1); break;
            }
            long fim = System.nanoTime();
            somaNano += (fim - inicio);
        }
        double mediaMicrossegundos = (somaNano / (double) REPETICOES) / 1000.0;
        System.out.printf("%-15s | N = %-8d | Média (5 exec): %12.2f us%n",
                          nome, vetorBase.length, mediaMicrossegundos);
    }

    private static int[] gerarVetor(int n, String cenario) {
        int[] v = new int[n];
        Random rand = new Random(42);
        for (int i = 0; i < n; i++) {
            if (cenario.equals("ALEATORIO")) v[i] = rand.nextInt(n * 10);
            else if (cenario.equals("ORDENADO")) v[i] = i + 1;
            else v[i] = n - i;
        }
        return v;
    }
}
