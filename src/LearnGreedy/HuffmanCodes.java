package LearnGreedy;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Sandeep on 10/31/2016.
 */
class FrequencyComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer a, Integer b) {
        if (a < b) {
            return -1;
        }
        if (a > b) {
            return 1;
        }

        return 0;
    }
}

public class HuffmanCodes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Comparator<Integer> cmp = new FrequencyComparator();
        PriorityQueue<Integer> pq = new PriorityQueue<>(100, cmp);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            pq.add(in.nextInt());
        }

        for (int i = 0; i < n-1; i++) {
            int left = pq.poll();
            int right = pq.poll();
            pq.add(left+right);
        }
        System.out.println(pq.poll());

    }
}
