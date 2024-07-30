public class RadixSort {

    public static void radixSort(int[] arr) {
        int max = getMax(arr);

        // Aplica o counting sort para cada dígito
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, exp);
        }
    }

    // Encontra o maior número no array
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // Realiza a contagem de acordo com o dígito especificado (1, 10, 100, ...)
    public static void countSort(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n]; // Array para armazenar a saída ordenada
        int[] count = new int[10]; // Array para contar ocorrências de cada dígito

        // Contar ocorrências de cada dígito no array
        for (int i = 0; i < n; i++) {
            count[(array[i] / exp) % 10]++;
        }

        // Modificar o array de contagem para armazenar as posições reais dos dígitos na saída
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Construir a saída ordenada
        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        // Copiar a saída ordenada para o array original
        for (int i = 0; i < n; i++) {
            array[i] = output[i];
        }
    }

    // Função para imprimir o array
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 9, 5, 2, 8, 4, 10, 6, 7, 3};
        System.out.println("Array original:");
        printArray(arr);

        radixSort(arr);

        System.out.println("Array ordenado:");
        printArray(arr);
    }
}
