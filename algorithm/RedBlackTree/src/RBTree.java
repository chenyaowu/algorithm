public class RBTree<K extends Comparable, V> {

    private final static boolean RED = true;
    private final static boolean BLACK = false;


    private class Node {
        private K k;
        private V v;
        public Node left, right;
        public boolean color;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
            left = null;
            right = null;
            color = RED;
        }

    }


    private Node root;
    private int size;

    public RBTree() {
        root = null;
        size = 0;
    }


    public void add(K k, V v) {
        add(root, k, v);
        root.color = BLACK; //最终节点为黑色节点
    }

    /**
     * 向以node为根节点的红黑树插入k,v,递归算法
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

        if (isRed(node.right) && !isRed(node.left)) {
            node = leftRotate(node);
        }
        if (isRed(node.left) && !isRed(node.right)) {
            node = rightRotate(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            filpColors(node);
        }

        return node;
    }

    private boolean isRed(Node node) {
        return node != null && node.color;
    }

    private Node leftRotate(Node node) {
        Node x = node.right;

        node.right = x.left;
        x.left = node;

        x.color = node.color;
        node.color = RED;
        return x;
    }

    private Node rightRotate(Node node) {
        Node x = node.left;

        node.left = x.right;
        x.right = node;

        x.color = node.color;
        node.color = RED;
        return x;
    }

    private void filpColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
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

    public boolean contains(K k) {
        return getNode(root, k) != null;
    }

    public V get(K k) {
        Node node = getNode(root, k);
        return node == null ? null : node.v;
    }

    public void set(K k, V v) {
        Node node = getNode(root, k);
        if (node == null) {
            return;
        }

        node.v = v;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
