package LearnGreedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * About the code :
 */
public class TopologicalOrdering {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("No of Vertices: ");
        int n;
        n = in.nextInt();
        int[][] graph = new int[n][n];
        boolean[] visited = new boolean[n];

        Arrays.fill(visited, false);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = in.nextInt();
            }
        }
        System.out.println("Source Node: ");
        int source = in.nextInt();
        TopologicalSort(graph, visited, source);

    }

    private static void TopologicalSort(int[][] graph, boolean[] visited, int source) {
        int n = visited.length;
        int[] S = new int[n];
        for (int i = 0; i < n; i++) {
            int v = getSource(graph);
            System.out.println(v);
            graph = removeSource(graph, v);
        }
    }

    private static int[][] removeSource(int[][] graph, int v) {
        int n = graph.length;
        int[][] newGraph = new int[n-1][n-1];
        int row = -1;
        int col = 0;
        for (int i = 0; i < n; i++) {
            if(i == v) continue;
            row++;
            col = 0;
            for (int j = 0; j < n; j++) {
                if (j == v) continue;
                newGraph[row][col] = graph[i][j];
                col++;
            }
        }
        return newGraph;
    }

    private static int getSource(int[][] graph){
        int source = 0;
        int n = graph.length;
        for (int col = 0; col < n; col++) {
            int count = 0;
            for (int row = 0; row < n; row++) {
                if(graph[row][col] == 0){
                    count++;
                }
                else {
                    break;
                }
            }
            if (count == n){
                source = col;
                break;
            }
        }
        return source;
    }


    private static void dfs(int[][] graph, boolean[] visited, int start) {
        visited[start] = true;
        System.out.println(start);
        ArrayList<Integer> neighbours = getNeighgours(graph, start);
        for (int i = 0; i < neighbours.size(); i++) {
            if (visited[neighbours.get(i)] == false) {
                dfs(graph, visited, neighbours.get(i));
            }

        }
    }

    private static ArrayList<Integer> getNeighgours(int[][] graph, int start) {
        ArrayList<Integer> neighbours = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (graph[start][i] > 0) {
                neighbours.add(i);
            }
        }
        return neighbours;
    }
}
