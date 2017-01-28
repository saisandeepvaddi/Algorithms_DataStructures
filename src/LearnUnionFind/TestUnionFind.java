package LearnUnionFind;

import java.util.Arrays;
import java.util.Scanner;

/**
 * About the code :
 */
public class TestUnionFind {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
//        UnionFind unionFind = new UnionFind(n);
        WeightedCompressedUnionFind unionFind = new WeightedCompressedUnionFind(n);
        int option = -1;
        while (option != 3) {
            System.out.println("Select Option: 1) Find 2) Union 3) Quit");
            option = in.nextInt();
            switch (option) {
                case 1: {
                    int a = in.nextInt();
                    int b = in.nextInt();
                    boolean find = unionFind.find(a, b);
                    System.out.println(Arrays.toString(unionFind.arr));
                    System.out.println(find);
                    break;
                }

                case 2: {
                    int a = in.nextInt();
                    int b = in.nextInt();
                    System.out.println(Arrays.toString(unionFind.arr));
                    unionFind.union(a, b);
                    System.out.println(Arrays.toString(unionFind.arr));
                    System.out.println(unionFind.find(a, b));
                    break;
                }

                default:
                    System.out.println("Bye Bye!!");
                    break;
            }
        }
    }
}
