package LearnGraphs;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


/**
 * About the code :
 */
class MinIntComparator implements Comparator<Integer> {
    int[] dist = DijkstraAlgorithm.dist;

    @Override
    public int compare(Integer o1, Integer o2) {
        if (dist[o1] < dist[o2]) return -1;
        else if (dist[o1] > dist[o2]) return 1;
        return 0;
    }
}

public class DijkstraAlgorithm {
    public static int INF = Integer.MAX_VALUE;
    public static int n = 0;
    public static int[][] graph = null;
    public static boolean[] visited = null;
    public static int[] dist = null;
    public static int[] pred = null;
    public static int s = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter no of vertices: ");
        n = in.nextInt();
        graph = new int[n][n];
        dist = new int[n];
        pred = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = in.nextInt();
            }
        }
        System.out.println("Enter starting node: ");
        s = in.nextInt();
        Dijkstra();


    }

    private static void Dijkstra() {
        InitSSSP(0);
        Comparator<Integer> minComparator = new MinIntComparator();
        PriorityQueue<Integer> pq = new PriorityQueue<>(minComparator);
        pq.add(s);
        while (!pq.isEmpty()) {
            int u = pq.poll();
            System.out.println("Top Vertex: " + u);
            for (int i = 0; i < n; i++) {
                if (graph[u][i] > 0) {
                    if (dist[u] + graph[u][i] < dist[i]) {
                        Relax(u, i);
                        pred[i] = u;
                        System.out.println("Relaxed: " + i + ", New dist: " + dist[i]);
                        if (!pq.contains(i)) pq.add(i);
                    }
                }
            }
        }

        System.out.println("Printing predecessors: ");
        for (int i = 0; i < n; i++) {
            System.out.println(pred[i]);
        }

    }


    private static void Relax(int u, int v) {
        dist[v] = dist[u] + graph[u][v];
    }

    private static void InitSSSP(int s) {
        dist[s] = 0;
        pred[s] = -1;
        for (int i = 0; i < n; i++) {
            if (i != s) {
                dist[i] = INF;
                pred[i] = -1;
            }
        }

    }

}
