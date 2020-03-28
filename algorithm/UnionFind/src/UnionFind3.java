public class UnionFind3 implements UF {

    private int[] parent;
    private int[] sz; // sz[i]表示以i为根的集合中元素个数

    public UnionFind3(int size) {
        parent = new int[size];
        sz = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }


    @Override
    public int getSize() {
        return parent.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("Out of range");
        }
        int root = parent[p];
        while (root != p) {
            root = parent[root];
        }

        return root;
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }
        if (sz[qRoot] < sz[pRoot]) {
            parent[qRoot] = pRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            parent[pRoot] = qRoot;
            sz[pRoot] += sz[qRoot];
        }

    }
}
