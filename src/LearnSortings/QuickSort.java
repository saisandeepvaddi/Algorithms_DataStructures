package LearnSortings;

/**
 * About the code :
 */
public class QuickSort {

    public static void Sort(int[] arr, int low, int high) {
        if (low < high) {
            int p = Partition(arr, low, high);
            Sort(arr, low, p - 1);
            Sort(arr, p + 1, high);
        }
    }

    private static int Partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int k = low-1;
        int i = low;
        for (i = low; i < high; i++) {
            if(arr[i] <= pivot){
                k++;
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }
        k++;
        int temp = arr[k];
        arr[k] = pivot;
        arr[high] = temp;
        return k;
    }


}
