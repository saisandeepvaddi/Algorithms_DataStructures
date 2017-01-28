package LearnUnionFind;

/**
 * About the code :
 */

public class UnionFind {
    int[] array = null;
    int[] size = null;
    int length = 0;

    public UnionFind(int n) {
        this.array = new int[n];
        this.size = new int[n];
        for (int i = 0; i < n; i++) {
            this.array[i] = i;
            this.size[i] = 1;
        }
        this.length = n;
    }

    public int root(int a) {
        while (array[a] != a) {
            array[a] = array[array[a]];
        }
        return a;
    }

    public void union(int a, int b) {
        int a_root = root(a);
        int b_root = root(b);
        array[a_root] = b_root;

    }

    public void weightedUnion(int a, int b) {
        int a_root = root(a);
        int b_root = root(b);
        System.out.println("A_ROOT" + a_root);
        System.out.println("Arr[A_ROOT]" + array[a_root]);
        if (size[a_root] < size[b_root]) {
            array[a_root] = array[b_root];
            size[b_root] += size[a_root];
        } else {
            array[b_root] = array[a_root];
            size[a_root] += size[b_root];
        }
    }

    public boolean find(int a, int b) {
        if (root(a) == root(b)) {
            return true;
        }

        return false;
    }


}
