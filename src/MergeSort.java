// Arquivo: MergeSort.java
public class MergeSort {
    public static void sort(int[] arr) {
        if (arr.length < 2) return;
        int[] aux = new int[arr.length];
        mergeSort(arr, aux, 0, arr.length - 1);
    }
    private static void mergeSort(int[] arr, int[] aux, int esq, int dir) {
        if (esq >= dir) return;
        int meio = esq + (dir - esq) / 2;
        mergeSort(arr, aux, esq, meio);
        mergeSort(arr, aux, meio + 1, dir);
        intercalar(arr, aux, esq, meio, dir);
    }
    private static void intercalar(int[] arr, int[] aux, int esq, int meio, int dir) {
        for (int k = esq; k <= dir; k++) aux[k] = arr[k];
        int i = esq, j = meio + 1;
        for (int k = esq; k <= dir; k++) {
            if (i > meio) arr[k] = aux[j++];
            else if (j > dir) arr[k] = aux[i++];
            else if (aux[i] <= aux[j]) arr[k] = aux[i++];
            else arr[k] = aux[j++];
        }
    }
}
