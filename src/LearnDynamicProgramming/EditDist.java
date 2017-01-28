package LearnDynamicProgramming;

import java.util.Scanner;

/**
 * About the code :
 */
public class EditDist {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String X = in.next();
        String Y = in.next();
        System.out.println(getEditDist(X, Y));
    }

    private static int getEditDist(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int[][] table = new int[m+1][n+1];
        for (int row = 0; row < m + 1; row++) {
            for (int col = 0; col < n + 1; col++) {

                if(row == 0){
                    table[row][col] = col;
                }
                else if(col == 0){
                    table[row][col] = row;
                }
                else if(X.charAt(row-1) == Y.charAt(col-1)){
                    table[row][col] = table[row-1][col-1];
                }
                else{
                    table[row][col] = 1+getMin(table[row-1][col],table[row][col-1],table[row-1][col-1]);
                }
            }
        }

        return table[m][n];
    }

    private static int getMin(int a, int b, int c) {
        return Math.min(Math.min(a,b),c);
    }
}
