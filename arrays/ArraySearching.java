package arrays;
import java.util.Arrays;

public class ArraySearching {
    
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; // if not Found
    }

    // Binary search: array must be sorted
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {    // run loop until left <= right
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2, 9, 1};
        int target = 4;

        // Linear search
        int linearResult = linearSearch(arr, target);
        System.out.println("Linear Search: Index of " + target + " is " + linearResult);

        // For binary search, array must be sorted
        //java.util.Arrays.sort(arr);
        Arrays.sort(arr); // Assuming a sort method is defined elsewhere
        int binaryResult = binarySearch(arr, target);
        System.out.println("Binary Search: Index of " + target + " in sorted array is " + binaryResult);
    }
}