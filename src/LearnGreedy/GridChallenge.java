package LearnGreedy;

import java.util.Arrays;
import java.util.Scanner;

public class GridChallenge {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();


        while (T > 0) {
            boolean isSym = true;
            int N = in.nextInt();
            char[][] grid = new char[N][N];
            for (int i = 0; i < N; i++) {
                grid[i] = in.next().toCharArray();
            }

            for (int i = 0; i < N; i++) {
                Arrays.sort(grid[i]);
            }

            for (int col = 0; col < N; col++) {
                if(isSym == false){
                    break;
                }
                char cur = grid[0][col];
                for (int row = 1; row < N; row++) {
                    if(!(grid[row][col]>=cur)){
                        isSym = false;
                        break;
                    }
                }
            }

            if(isSym){
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }


            T--;
        }
    }
}
