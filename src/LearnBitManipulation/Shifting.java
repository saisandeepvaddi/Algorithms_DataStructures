package LearnBitManipulation;

import java.util.Scanner;

/**
 * About the code :
 */
public class Shifting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 4;
        System.out.println(n + ~n + 1);
        System.out.println(n >> 2);
    }



}
