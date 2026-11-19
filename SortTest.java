import java.util.*;

public class SortTest {

    public static void insertionSort(int[] data) {
        int n = data.length;
        for (int i = 1; i < n; ++i) {
            int key = data[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && data[j] > key) {
                data[j + 1] = data[j];
                j = j - 1;
            }
            data[j + 1] = key;
        }
    }

    public static void bubbleSort(int[] data) {
        for (int end = data.length - 1; end > 0; end--) {
            boolean swapped = false;
            for (int i = 0; i < end; i++) {
                if (data[i] > data[i + 1]) {
                    int temp = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void shellSort(int[] arr) {
        int n = arr.length;

        // Start with a large gap, then reduce it step by step
        for (int gap = n / 2; gap > 0; gap /= 2) {

            // Perform a "gapped" insertion sort for this gap size
            for (int i = gap; i < n; i++) {
                
                // Current element to be placed correctly
                int temp = arr[i]; 
                int j = i;

                // Shift earlier elements that are greater than temp
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }

                // Place temp in its correct position
                arr[j] = temp;
            }
        }
    }


    public static void arraysort(String[] args) {

        // Array of primitive type
        int[] arr1 = {2, -1, 3, 4};

        // Character array
        char[] arr2 = {'b', 'a', 'c', 'b'};

        // Sorting arrays in ascending order
        Arrays.sort(arr1); 
        Arrays.sort(arr2);
    }

     static int partition(int[] arr, int low, int high)
    {

        // choose the pivot
        swap(arr, low + (high - low) / 2, high);
        int pivot = arr[high];

        // index of smaller element and indicates
        // the right position of pivot found so far
        int i = low - 1;

        // traverse arr[low..high] and move all smaller
        // elements to the left side. Elements from low to
        // i are smaller after every iteration
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Move pivot after smaller elements and
        // return its position
        swap(arr, i + 1, high);
        return i + 1;
    }

    // swap function
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // the QuickSort function implementation
    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high) {

            // pi is the partition return index of pivot
            int pi = partition(arr, low, high);

            // recursion calls for smaller elements
            // and greater or equals elements
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    static void merge(int arr[], int l, int m, int r){
        
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    static void mergeSort(int arr[], int l, int r){
        
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
    
    public static void printData(int[] data) {
        for (int x : data) {
            System.out.print(x + " ");
        }
        System.out.println("--------------------------");
        System.out.println();
    }

    public static int[] createAscendingData(int n) {
        int[] data = new int[n];

        for (int i = 0; i < data.length; i++) {
            data[i] = i;
        }

        return data;
    }

    public static int[] createRandomData(int n) {
        int[] data = new int[n];

        Random gen = new Random();

        for (int i = 0; i < data.length; i++) {
            data[i] = gen.nextInt(n);
        }

        return data;
    }
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    public static int[] CreateAscendingTable(int n) {
        int[] data = new int[n];
        for (int i = 0; i < n; i++) data[i] = i;
        return data;
    }

    public static int[] CreateDescendingTable(int n) {
        int[] data = new int[n];
        for (int i = 0; i < n; i++) data[i] = n - 1 - i;
        return data;
    }

    private static void testSort(String name, FunctionRef sorter, int[] original) {
        int[] data = original.clone();
        long start = System.nanoTime();
        sorter.sort(data);
        long elapsed = System.nanoTime() - start;
        System.out.printf("%s: %.6f seconds%n", name, elapsed / 1_000_000_000.0);
    }

    private static void compareSorts(String name, int[] data) {
        System.out.println("\n" + name + ":");
        testSort("Insertion sort", SortTest::insertionSort, data);
        testSort("Bubble sort", SortTest::bubbleSort, data);
        testSort("Arrays.sort", Arrays::sort, data);
        testSort("Shell sort", SortTest::shellSort, data);
        testSort("Quick sort", SortTest::quickSort, data);
        testSort("Merge sort", SortTest::mergeSort, data);
    }

    public static void main(String[] args) {
    int size = 10_000;
        compareSorts("Ascending table", CreateAscendingTable(size));
        compareSorts("Descending table", CreateDescendingTable(size));
    }
}
