package LearnUnionFind;

/**
 * About the code :
 */
public class WeightedCompressedUnionFind {
    int[] arr = null;
    int[] size = null;
    int n = 0;

    // Constructor initializes the UnionFind
    public WeightedCompressedUnionFind(int n) {
        this.arr = new int[n];
        this.size = new int[n];
        this.n = n;
        for (int i = 0; i < n; i++) {
            this.arr[i] = i;
            this.size[i] = 1;
        }
    }

    public int root(int i) {
        while (arr[i] != i) {
            arr[i] = arr[arr[i]];
            i = arr[i];
        }
        return i;
    }

    public boolean find(int a, int b) {
        int root_a = root(a);
        int root_b = root(b);

        if (root_a == root_b) {
            return true;
        }
        return false;
    }

    public void union(int a, int b) {
        int root_a = root(a);
        int root_b = root(b);
        if (size[root_a] < size[root_b]) {
            arr[root_a] = root_b;
            size[root_b] += size[root_a];
        } else {
            arr[root_b] = root_a;
            size[root_a] += size[root_b];
        }
    }


}
