package LearnDynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * About the code :
 */
public class LIS {
    static int[] lis = null;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
//        int rec_res = getRecursive(arr,n);
//        System.out.println(rec_res);
        lis = new int[n+1];
        Arrays.fill(lis,1);
        int mem_res = getMem(arr,n);
        System.out.println(mem_res);

    }

    private static int getMem(int[] arr, int n) {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && lis[i] < lis[j]+1){
                    lis[i] = lis[j]+1;
                    max = Math.max(max, lis[i]);
                }
            }
        }

        return max;
    }

    private static int getRecursive(int[] arr,int n) {
        if (n == 1) {
            return 1;
        }
        int res=0;
        int max = 1;
        for (int i = 1; i < n; i++) {
            res = getRecursive(arr,i);
            if(arr[i-1]<arr[n-1] && res+1 > max){
                max = res+1;
            }
        }
        return max;

    }

}
