package arrays;

import java.util.Arrays;

public class SortingAlgorithms {

    // 🔹 1. Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // 🔹 2. Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // swap
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // 🔹 3. Insertion Sort
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // 🔹 4. Merge Sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // 🔹 5. Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // 🔹 6. Heap Sort
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // build heap
        for (int i = n / 2 - 1; i >= 0; i--) heapify(arr, n, i);

        // extract elements
        for (int i = n - 1; i > 0; i--) {
            // swap root with last
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // heapify reduced heap
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    // 🔹 Main method to test all sorts
    public static void main(String[] args) {
        int[] original = {64, 25, 12, 22, 11};

        // Bubble
        int[] arr1 = original.clone();
        bubbleSort(arr1);
        System.out.println("Bubble Sort: " + Arrays.toString(arr1));

        // Selection
        int[] arr2 = original.clone();
        selectionSort(arr2);
        System.out.println("Selection Sort: " + Arrays.toString(arr2));

        // Insertion
        int[] arr3 = original.clone();
        insertionSort(arr3);
        System.out.println("Insertion Sort: " + Arrays.toString(arr3));

        // Merge
        int[] arr4 = original.clone();
        mergeSort(arr4, 0, arr4.length - 1);
        System.out.println("Merge Sort: " + Arrays.toString(arr4));

        // Quick
        int[] arr5 = original.clone();
        quickSort(arr5, 0, arr5.length - 1);
        System.out.println("Quick Sort: " + Arrays.toString(arr5));

        // Heap
        int[] arr6 = original.clone();
        heapSort(arr6);
        System.out.println("Heap Sort: " + Arrays.toString(arr6));
    }
}












/*
 package arrays;

import java.util.*;

public class SortingAlgorithms {

    // 🔹 1. Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // 🔹 2. Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // 🔹 3. Insertion Sort
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // 🔹 4. Merge Sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // 🔹 5. Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // 🔹 6. Heap Sort
    public static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) heapify(arr, n, i);
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    // 🔹 7. Counting Sort (for non-negative integers)
    public static void countingSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int[] count = new int[max + 1];
        int[] output = new int[arr.length];

        for (int num : arr) count[num]++;
        for (int i = 1; i < count.length; i++) count[i] += count[i - 1];

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    // 🔹 8. Radix Sort (using Counting Sort for digits)
    public static void radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        for (int exp = 1; max / exp > 0; exp *= 10) countingSortByDigit(arr, exp);
    }

    private static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) count[(arr[i] / exp) % 10]++;
        for (int i = 1; i < 10; i++) count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }

    // 🔹 9. Bucket Sort (for decimals or uniformly distributed data)
    public static void bucketSort(float[] arr) {
        int n = arr.length;
        @SuppressWarnings("unchecked")
        List<Float>[] buckets = new ArrayList[n];

        for (int i = 0; i < n; i++) buckets[i] = new ArrayList<>();
        for (float num : arr) {
            int index = (int) (num * n); 
            buckets[index].add(num);
        }

        for (List<Float> bucket : buckets) Collections.sort(bucket);

        int idx = 0;
        for (List<Float> bucket : buckets) {
            for (float num : bucket) arr[idx++] = num;
        }
    }

    // 🔹 Main method to test all sorts
    public static void main(String[] args) {
        int[] original = {64, 25, 12, 22, 11};

        int[] arr1 = original.clone();
        bubbleSort(arr1);
        System.out.println("Bubble Sort:   " + Arrays.toString(arr1));

        int[] arr2 = original.clone();
        selectionSort(arr2);
        System.out.println("Selection Sort:" + Arrays.toString(arr2));

        int[] arr3 = original.clone();
        insertionSort(arr3);
        System.out.println("Insertion Sort:" + Arrays.toString(arr3));

        int[] arr4 = original.clone();
        mergeSort(arr4, 0, arr4.length - 1);
        System.out.println("Merge Sort:   " + Arrays.toString(arr4));

        int[] arr5 = original.clone();
        quickSort(arr5, 0, arr5.length - 1);
        System.out.println("Quick Sort:   " + Arrays.toString(arr5));

        int[] arr6 = original.clone();
        heapSort(arr6);
        System.out.println("Heap Sort:    " + Arrays.toString(arr6));

        int[] arr7 = original.clone();
        countingSort(arr7);
        System.out.println("Counting Sort:" + Arrays.toString(arr7));

        int[] arr8 = original.clone();
        radixSort(arr8);
        System.out.println("Radix Sort:   " + Arrays.toString(arr8));

        float[] arr9 = {0.42f, 0.32f, 0.23f, 0.52f, 0.25f, 0.47f, 0.51f};
        bucketSort(arr9);
        System.out.println("Bucket Sort:  " + Arrays.toString(arr9));
    }
}

 */