package LearnGraphs;

/**
 * About the code :
 */
public class FloydWarshallAlgorithm {
    public static final int INF = 99999;
    public static int[][] dist;
    static int v = 0;

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
        int[][] graph = {{0, 5, INF, 10},
                {INF, 0, 3, INF},
                {INF, INF, 0, 1},
                {INF, INF, INF, 0}
        };
        v = graph.length;
        dist = new int[v][v];
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                dist[i][j] = graph[i][j];
            }
        }
        floydWarshall();
        printSolution(dist);
    }

    private static void printSolution(int[][] dist) {
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist.length; j++) {
                if (dist[i][j] == INF) {
                    System.out.print(" INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private static void floydWarshall() {
        for (int k = 0; k < v; k++) {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }
}
