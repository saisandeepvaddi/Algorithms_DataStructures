package LearnGreedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Sandeep on 10/31/2016.
 */
public class JewelleryGreedy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("N: ");
        int n = in.nextInt();
        int s = in.nextInt();
        List<Integer> V = new ArrayList<>();
        List<Integer> S = new ArrayList<>();
        List<Integer> VS = new ArrayList<>();

        int maxValue = 0;

        for (int i = 0; i < n; i++) {
            S.add(in.nextInt());
        }
        for (int i = 0; i < n; i++) {
            V.add(in.nextInt());
        }
        for (int i = 0; i < n; i++) {
            VS.add(V.get(i) / S.get(i));
        }

        int temp_size = 0;

        while (temp_size < s){
            int cur_max = getMaxIndex(VS);
            int needed = s-temp_size;
            if(S.get(cur_max)<=needed){
                maxValue += VS.get(cur_max)*S.get(cur_max);
                temp_size += S.get(cur_max);
                V.remove(cur_max);
                S.remove(cur_max);
                VS.remove(cur_max);
            }
            else {
                maxValue += VS.get(cur_max)*needed;
                temp_size += needed;
                V.remove(cur_max);
                S.remove(cur_max);
                VS.remove(cur_max);

            }
        }

        System.out.println("Max Value: "+maxValue);

    }

    public static int getMaxIndex(List<Integer> A) {
        int max = Integer.MIN_VALUE;
        int max_index = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) > max) {
                max = A.get(i);
                max_index = i;
            }
        }
        return max_index;
    }
}
