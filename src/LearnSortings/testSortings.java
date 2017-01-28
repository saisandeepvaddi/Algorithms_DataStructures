package LearnSortings;

/**
 * About the code :
 */
public class testSortings {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        QuickSort sort = new QuickSort();
        long begin = System.currentTimeMillis();
//        int n = in.nextInt();
        int n = 10;

//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = in.nextInt();
//        }
        int[] arr = {9,5,4,2,12,5,65,98,12,1};
        QuickSort.Sort(arr, 0, n-1);
//        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
        long end = System.currentTimeMillis();
        System.out.println("Running Time: "+(double)(end-begin)/1000+" sec.");

    }
}
