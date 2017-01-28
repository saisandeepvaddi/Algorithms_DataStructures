import java.util.*;


class MyQueue<T> {
    private List<T> que;

    public MyQueue() {
        que = new ArrayList<T>();
    }

    public void push(T a) {
        que.add(a);
    }

    public T poll() {
        T tmp = que.get(0);
        que.remove(0);
        return tmp;
    }

    public boolean isEmpty() {
        if (que.size() == 0) {
            return true;
        }
        return false;
    }
}

/**
 * Created by Sandeep on 10/25/2016.
 */
public class LearnDFS {

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
        System.out.println("Starting Node: ");
        int start = in.nextInt();
        System.out.println("Using Recursion: ");
        dfs(graph, visited, start);
        System.out.println("Using Stack: ");
        dfsWithStack(graph, visited, start);

        System.out.println("BFS: ");
        Arrays.fill(visited, false);
        bfs(graph, visited, start);
    }

    private static void bfs(int[][] graph, boolean[] visited, int start) {
        MyQueue<Integer> queue = new MyQueue<>();
        int n = visited.length;
        queue.push(start);
        visited[start] = true;
        System.out.println(start);
        while (!queue.isEmpty()){
            int v = queue.poll();
            for (int i = 0; i < n; i++) {
                if (graph[v][i] == 1 && visited[i] == false && i!=start){
                    System.out.println(i);
                    visited[i] = true;
                    queue.push(i);
                }
            }

        }
    }

    private static void dfsWithStack(int[][] graph, boolean[] visited, int start) {
        Arrays.fill(visited, false);
        Stack<Integer> stack = new Stack<>();
//        stack.push(start);
        visited[start] = true;
        System.out.println(start);
        for (int i = graph.length - 1; i >= 0; i--) {
            if (graph[start][i] > 0 && visited[i] == false) {
                stack.push(i);
            }
        }

        while (!(stack.empty())) {
            int cur = stack.pop();
            if (visited[cur] == false) {
                visited[cur] = true;
                System.out.println(cur);
                for (int i = graph.length - 1; i >= 0; i--) {
                    if (graph[cur][i] > 0 && visited[i] == false) {
                        stack.push(i);
                    }
                }
            }
        }


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
