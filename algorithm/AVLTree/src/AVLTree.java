public class AVLTree<K extends Comparable, V> {

    private class Node {
        public K k;
        public V v;
        public Node left, right;
        public int height;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
            left = null;
            right = null;
            height = 1;
        }

    }


    private Node root;
    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }


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

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balanceFactory = getBalanceFactor(node);
        // LL
        if(balanceFactory > 1 && getBalanceFactor(node.left) > 0){
            return rightRotate(node);
        }
        // RR
        if(balanceFactory < -1 && getBalanceFactor(node.right) <= 0){
            return leftRotate(node);
        }
        // LR
        if(balanceFactory > 1 && getBalanceFactor(node.left) <0){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // RL
        if(balanceFactory <-1  && getBalanceFactor(node.right) > 0){
            node.right = leftRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    /**
     * 对节点y进行向右旋转，返回操作后新的根节点x
     *            y                             x
     *          /  \                          /  \
     *        x     T4      向右旋转(y)     z     y
     *      /  \            ---------->   / \    / \
     *    z    T3                       T1  T2  T3  T4
     *   / \
     * T1   T2
     *
     * @param y
     * @return
     */
    private Node rightRotate(Node y){
        Node x = y.left;
        Node T3 = x.right;

        //向右旋转过程
        x.right = y;
        y.left = T3;

        //更新height
        y.height = Math.max(getHeight(y.left),getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left),getHeight(x.right)) + 1;

        return x;
    }

    /**
     * 对节点y进行向右旋转，返回操作后新的根节点x
 *     y                             x
 *   /  \                          /  \
     * T1   x      向左旋转(y)   y     z
     *     / \   ---------->   / \    / \
     *   T2  z               T1  T2  T3  T4
     *      | \
     *    T3  T4
     *
     * @param y
     * @return
     */
    private Node leftRotate(Node y){
        Node x = y.right;
        Node T2 = x.left;

        //向右旋转过程
        x.left = y;
        y.right = T2;

        //更新height
        y.height = Math.max(getHeight(y.left),getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left),getHeight(x.right)) + 1;

        return x;
    }

    private int getHeight(Node node) {
        return node == null ? 0 : node.height;
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


    private int getBalanceFactor(Node node) {
        return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
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
        Node retNode ;
        if (k.compareTo(node.k) < 0) {
            node.left = remove(node.left, k);
            retNode =  node;
        }

        else if (k.compareTo(node.k) > 0) {
            node.right = remove(node.right, k);
            retNode =  node;
        }


       else if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            retNode =  rightNode;
        }

       else if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            retNode =  leftNode;
        }else{
            Node successor = minimum(node.right);
            successor.right = remove(node.right,successor.k);
            successor.left = node.left;
            node.left = node.right = null;
            retNode = successor;
        }

        if (retNode == null){
            return null;
        }

        retNode.height = 1 + Math.max(getHeight(retNode.left), getHeight(retNode.right));
        int balanceFactory = getBalanceFactor(retNode);
        // LL
        if(balanceFactory > 1 && getBalanceFactor(retNode.left) > 0){
            return rightRotate(retNode);
        }
        // RR
        if(balanceFactory < -1 && getBalanceFactor(retNode.right) <= 0){
            return leftRotate(retNode);
        }
        // LR
        if(balanceFactory > 1 && getBalanceFactor(retNode.left) <0){
            retNode.left = leftRotate(retNode.left);
            return rightRotate(retNode);
        }
        // RL
        if(balanceFactory <-1  && getBalanceFactor(retNode.right) > 0){
            retNode.right = leftRotate(retNode.right);
            return leftRotate(retNode);
        }
        return retNode;
    }

    private Node minimum(Node node) {

        if (node.left == null) {
            return node;
        }
        return minimum(node.left);

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
