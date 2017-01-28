package LearnGreedy;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueueLearning {
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
