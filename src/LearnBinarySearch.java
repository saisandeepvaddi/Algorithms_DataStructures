import IO.InputReader;

import java.util.Arrays;

/**
 * About the code :
 */
public class LearnBinarySearch {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        System.out.println("Enter array size: ");
        int n = in.nextInt();
        System.out.println("Enter array elements: ");
        int[] arr = in.getIntArray(n);
        System.out.println("Enter element to search: ");
        int a = in.nextInt();
        Arrays.sort(arr);
        int index = BinarySearch(arr, a);
        System.out.println(index);
    }

    private static int BinarySearch(int[] arr, int a) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (a < arr[mid]) {
                hi = mid;
            } else if (a > arr[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }
}
