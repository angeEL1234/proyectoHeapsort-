import java.util.Scanner;

public class HeapSort {

    // Función para aplicar heapify en un subárbol
    static void heapify(int arr[], int n, int i) {
        int largest = i; // Inicializamos la raíz como el mayor
        int left = 2 * i + 1; // Hijo izquierdo
        int right = 2 * i + 2; // Hijo derecho

        // Si el hijo izquierdo es mayor que la raíz
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Si el hijo derecho es mayor que el mayor actual
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // Si el mayor no es la raíz, se intercambia y aplica heapify recursivamente
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    // Función principal para ordenar usando Heap Sort
    static void heapSort(int arr[]) {
        int n = arr.length;

        // Construir el heap máximo
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extraer elementos del heap uno por uno
        for (int i = n - 1; i > 0; i--) {
            // Mover la raíz actual al final
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Llamar a heapify en el heap reducido
            heapify(arr, i, 0);
        }
    }

    // Método de prueba
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese la cantidad de elementos: ");
        int n = scanner.nextInt();
        
        int arr[] = new int[n];
        
        System.out.println("Ingrese los elementos:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        heapSort(arr);
        
        System.out.println("Arreglo ordenado:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        
        scanner.close();
    }
}
