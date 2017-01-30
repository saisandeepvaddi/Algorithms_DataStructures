package LearnGraphs;

import java.util.*;

/**
 * About the code : Implementation of Kruskal's Minimum Spanning Tree
 */

class Edge {
    int src = -1;
    int dest = -1;
    int weight = 0;

    Edge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

class Graph {
    public List<Edge> edges = null;
    private int n = 0;
    private int m = 0;

    Graph() {

    }

    Graph(int n, int m) {
        this.n = n;
        this.m = m;
        this.edges = new ArrayList<>();
    }

    public void addEdge(int src, int dest, int weight) {
        this.edges.add(new Edge(src, dest, weight));
    }

    public void printEdges() {
        int total = 0;
        for (Edge e : edges) {
            System.out.println(e.src + " --> " + e.dest + " : " + e.weight);
            total += e.weight;
        }
        System.out.println("Total Graph/MST Weight: " + total);
    }


}


class UnionFind {
    private int n = 0;
    private int[] arr = null;
    private int[] sizes = null;

    UnionFind(int n) {
        this.n = n;
        this.arr = new int[n];
        this.sizes = new int[n];
        for (int i = 0; i < n; i++) {
            this.arr[i] = i;
            this.sizes[i] = 1;
        }
    }

    public int root(int i) {
        while (arr[i] != i) {
            arr[i] = arr[arr[i]];
            i = arr[i];
        }
        return i;
    }


    public void union(int a, int b) {
        int root_a = root(a);
        int root_b = root(b);
        if (sizes[root_a] < sizes[root_b]) {
            arr[root_a] = root_b;
            sizes[root_b] += sizes[root_a];
        } else {
            arr[root_b] = root_a;
            sizes[root_a] += sizes[root_b];
        }
    }

    public boolean find(int a, int b) {
        if (root(a) == root(b)) return true;
        return false;
    }

}

class EdgeComparator implements Comparator<Edge> {

    @Override
    public int compare(Edge o1, Edge o2) {
        return o1.weight - o2.weight;
    }
}

public class KruskalAlgorithm {
    static int n = 0;
    static int m = 0;
    static Graph graph = null;
    static Graph mst = null;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        graph = new Graph(n, m);
        mst = new Graph(n, m);
        for (int i = 0; i < m; i++) {
            graph.addEdge(in.nextInt(), in.nextInt(), in.nextInt());
        }


        kruskal();
        mst.printEdges();
    }

    private static void kruskal() {
        PriorityQueue<Edge> sortedEdges = new PriorityQueue<>(new EdgeComparator());
//        PriorityQueue<Edge> testEdges = new PriorityQueue<>(new EdgeComparator());
        for (Edge edge : graph.edges) {
            sortedEdges.add(edge);
//            testEdges.add(edge);
        }

        /*System.out.println("Edges sorted : ");
        for (int i = 0; i < m; i++) {
            Edge e = testEdges.poll();
            System.out.println(e.src + " --> " + e.dest + " : " + e.weight);
        }
        System.out.println("=================");*/

        UnionFind unionFind = new UnionFind(n);

        for (int i = 0; i < m; i++) {
            Edge e = sortedEdges.poll();
            int u = e.src;
            int v = e.dest;
            if (!unionFind.find(u, v)) {
                unionFind.union(u, v);
                mst.addEdge(u, v, e.weight);
            }
        }

    }
}
