// Arquivo: QuickSort.java
public class QuickSort {
    public static void sortPivoFixo(int[] arr, int baixo, int alto) {
        if (baixo < alto) {
            int pi = particionar(arr, baixo, alto);
            sortPivoFixo(arr, baixo, pi - 1);
            sortPivoFixo(arr, pi + 1, alto);
        }
    }
    private static int particionar(int[] arr, int baixo, int alto) {
        int pivo = arr[alto];
        int i = (baixo - 1);
        for (int j = baixo; j < alto; j++) {
            if (arr[j] <= pivo) {
                i++;
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }
        int temp = arr[i + 1]; arr[i + 1] = arr[alto]; arr[alto] = temp;
        return i + 1;
    }
}
