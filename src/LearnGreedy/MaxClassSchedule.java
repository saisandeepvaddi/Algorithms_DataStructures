package LearnGreedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Sandeep on 10/30/2016.
 */
public class MaxClassSchedule {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> S = new ArrayList<>();
        List<Integer> F = new ArrayList<>();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            S.add(in.nextInt());
        }
        for (int i = 0; i < n; i++) {
            F.add(in.nextInt());
        }
        // Should sort F and change S to the same indexes as sorted F
        printMaxClasses(S,F,n);
    }

    private static void printMaxClasses(List<Integer> s, List<Integer> f, int n) {
        List<Integer> X = new ArrayList<>();
        int count = 0;
        X.add(f.get(0));
        System.out.println("I: "+0);
        for (int i = 1; i < n; i++) {
            if(s.get(i)>f.get(count)){
                count++;
                X.add(s.get(i));
                System.out.println("I: "+i);
            }
        }
//        for (int i = 0; i < X.size(); i++) {
//            System.out.print(X.get(i)+" ");
//        }
        System.out.println("Max classes: "+(count+1));
    }
}
