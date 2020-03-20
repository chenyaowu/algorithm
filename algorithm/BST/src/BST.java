import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }

    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向二分搜索树添加新的元素e
     *
     * @param e
     */
    public void add(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
            return;
        }

        add(root, e);
    }

    /**
     * 向以node为根节点的二分搜索树插入元素e,递归算法
     *
     * @param node
     * @param e
     */
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        } else if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        }

        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (node.e.compareTo(e) == 0) {
            return true;
        }
        if (node.e.compareTo(e) < 0) {
            return contains(node.left, e);
        }
        return contains(node.right, e);
    }

    /**
     * 二分搜索树前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 二分搜索树前序遍历(非递归)
     */
    public void preOrderNR() {
        Stack<Node> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }

        }
    }

    /**
     * 二分搜素树中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 二分搜索树后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 二分搜索树层序遍历
     */
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    private void postOrder(Node node) {
        if (node != null) {
            preOrder(node.left);
            preOrder(node.right);
            System.out.println(node.e);
        }
    }

    private void inOrder(Node node) {
        if (node != null) {
            preOrder(node.left);
            System.out.println(node.e);
            preOrder(node.right);
        }
    }

    /**
     * 前序遍历以node为根的二分搜索树，递归算法
     *
     * @param node
     */
    private void preOrder(Node node) {

        if (node != null) {
            System.out.println(node.e);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 获取最小值
     *
     * @return
     */
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is Empty");
        }
        return minimum(root).e;
    }

    private Node minimum(Node node) {

        if (node.left == null) {
            return node;
        }
        return minimum(node.left);

    }

    /**
     * 获取最大值
     *
     * @return
     */
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is Empty");
        }
        return maximum(root).e;
    }

    private Node maximum(Node node) {

        if (node.right == null) {
            return node;
        }
        return minimum(node.right);

    }

    /**
     * 删除二分搜索树中的最大值
     *
     * @return
     */
    public E removeMax() {
        E ret = minimum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node) {

        if (node.right == null) {
            Node leftTree = node.left;
            node.left = null;
            size--;
            return leftTree;
        }

        node.right = removeMin(node.right);
        return node;
    }

    /**
     * 删除二分搜索树中的最小值
     *
     * @return
     */
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
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

    /**
     * 删除二分搜索树元素e
     *
     * @param e
     */
    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }

        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        }

        if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
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

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }

        return res.toString();
    }
}
