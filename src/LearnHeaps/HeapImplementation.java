package LearnHeaps;

import java.util.Scanner;

/**
 * About the code :
 */
public class HeapImplementation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MinHeap heap = new MinHeap();
        int no_elements = in.nextInt();
        int no = no_elements;
        while(no-- > 0){
            heap.add(in.nextInt());
        }

        while(heap.size > 0){
            System.out.println(heap.poll());
        }

    }
}
