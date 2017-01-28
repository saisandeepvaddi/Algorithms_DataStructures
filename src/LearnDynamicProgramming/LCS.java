package LearnDynamicProgramming;

import java.util.Scanner;

/**
 * About the code :
 */
public class LCS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String X = in.next();
        String Y = in.next();
        System.out.println(getLCS(X, Y));


    }

    private static int getLCS(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int[][] table = new int[m + 1][n + 1];
        for (int row = 0; row < m; row++) {
            table[row][0] = 0;
        }
        for (int col = 0; col < n; col++) {
            table[0][col] = 0;
        }

        for (int row = 1; row < m + 1; row++) {
            for (int col = 1; col < n + 1; col++) {
                if (X.charAt(row - 1) == Y.charAt(col - 1)) {
                    table[row][col] = table[row - 1][col - 1] + 1;
                } else {
                    table[row][col] = table[row - 1][col] > table[row][col - 1] ? table[row - 1][col] : table[row][col - 1];
                }
            }
        }


        return table[m][n];
    }
}
