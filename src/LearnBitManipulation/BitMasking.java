package LearnBitManipulation;

import java.util.Scanner;

/**
 * About the code :
 */
public class BitMasking {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int x = in.nextInt();
//        int pos = in.nextInt();
        int x = 33;
        int pos = 2;
        int bit_set = set_bit(x, pos);
        System.out.println("Input : " + Integer.toBinaryString(x));
        System.out.println("Set Bit: " + Integer.toBinaryString(bit_set));
        System.out.println("Output: " + bit_set);

        int bit_clear = clear_bit(x, pos);
        System.out.println("Clear Bit: " + Integer.toBinaryString(bit_clear));
        System.out.println("Output: " + bit_clear);

        int flip_bit = flip_bit(x, pos);
        System.out.println("Flip Bit: " + Integer.toBinaryString(flip_bit));
        System.out.println("Output: " + flip_bit);

        boolean is_bit_set = is_bit_set(x, pos);
        System.out.println("Is Bit Set: " + is_bit_set);

        int modify_bit = modify_bit(x, pos, 1);
        System.out.println("modify Bit: " + Integer.toBinaryString(modify_bit));
        System.out.println("Output: " + modify_bit);

        System.out.println("Even/Odd: " + checkEvenOdd(x));
        System.out.println("Is Power of Two: "+checkIsPowerOfTwo(x));

    }

    private static boolean checkIsPowerOfTwo(int x) {
        return (x > 0 && (x & (x-1)) == 0);
    }

    private static String checkEvenOdd(int x) {
        if ((x & 1) == 0) {
            return "Even";
        } else {
            return "Odd";
        }
    }

    private static int modify_bit(int x, int pos, int state) {
        int mask = 1 << pos;
        return (x & ~mask) | (-state & mask);

    }

    private static boolean is_bit_set(int x, int pos) {
        int mask = x >> pos;
        return (1 & mask) == 1;
    }

    private static int flip_bit(int x, int pos) {
        int mask = 1 << pos;
        return x ^ mask;
    }


    public static int set_bit(int x, int pos) {
        int mask = 1 << pos;
        return x | mask;
    }

    public static int clear_bit(int x, int pos) {
        int mask = 1 << pos;
        return x & ~mask;
    }


}
