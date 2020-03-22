public class BSTMap<K extends Comparable, V> implements Map<K, V> {

    private class Node {
        private K k;
        private V v;
        public Node left, right;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
            left = null;
            right = null;
        }

    }


    private Node root;
    private int size;

    public BSTMap() {
        root = null;
        size = 0;
    }

    @Override
    public void add(K k, V v) {
        if (root == null) {
            root = new Node(k, v);
            size++;
            return;
        }

        add(root, k, v);
    }

    /**
     * 向以node为根节点的二分搜索树插入k,v,递归算法
     *
     * @param node
     * @param k
     * @param v
     */
    private Node add(Node node, K k, V v) {
        if (node == null) {
            size++;
            return new Node(k, v);
        }

        if (k.compareTo(node.k) > 0) {
            node.right = add(node.right, k, v);
        } else if (k.compareTo(node.k) < 0) {
            node.left = add(node.left, k, v);
        } else if (k.compareTo(node.k) == 0) {
            node.v = v;
        }

        return node;
    }

    public Node getNode(Node node, K k) {
        if (node == null) {
            return null;
        }
        if (node.k.compareTo(k) == 0) {
            return node;
        }
        if (node.k.compareTo(k) < 0) {
            return getNode(node.left, k);
        }
        return getNode(node.right, k);

    }

    @Override
    public V remove(K k) {
        Node node = getNode(root, k);
        if (node == null) {
            return null;
        }

        root = remove(root, k);
        return node.v;

    }

    private Node remove(Node node, K k) {
        if (node == null) {
            return null;
        }

        if (k.compareTo(node.k) < 0) {
            node.left = remove(node.left, k);
            return node;
        }

        if (k.compareTo(node.k) > 0) {
            node.right = remove(node.right, k);
            return node;
        }


        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        Node successor = minimum(node.right);
        successor.right = removeMin(node.right);
        successor.left = node.left;
        node.left = node.right = null;

        return successor;
    }

    private Node minimum(Node node) {

        if (node.left == null) {
            return node;
        }
        return minimum(node.left);

    }

    private Node removeMin(Node node) {

        if (node.left == null) {
            Node rightTree = node.right;
            node.right = null;
            size--;
            return rightTree;
        }

        node.left = removeMin(node.left);
        return node;
    }

    @Override
    public boolean contains(K k) {
        return getNode(root, k) != null;
    }

    @Override
    public V get(K k) {
        Node node = getNode(root, k);
        return node == null ? null : node.v;
    }

    @Override
    public void set(K k, V v) {
        Node node = getNode(root, k);
        if (node == null) {
            return;
        }

        node.v = v;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
