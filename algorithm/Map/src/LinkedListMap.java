public class LinkedListMap<K, V> implements Map<K, V> {

    class Node {

        private K k;
        private V v;
        private Node next;

        public Node() {
            this(null, null, null);
        }

        public Node(K k, V v) {
            this(k, v, null);
        }

        public Node(K k, V v, Node node) {
            this.k = k;
            this.k = k;
            this.next = node;

        }

        @Override
        public String toString() {
            return k.toString() + ":" + v.toString();
        }

    }

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }


    @Override
    public void add(K k, V v) {
        Node node = getNode(k);
        if (node == null) {
            dummyHead.next = new Node(k, v, dummyHead.next);
            size++;
            return;
        }

        node.v = v;

    }

    @Override
    public V remove(K k) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.k.equals(k)) {
                break;
            }
            prev = prev.next;
        }

        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.v;
        }

        return null;
    }

    @Override
    public boolean contains(K k) {
        return getNode(k) == null;
    }

    @Override
    public V get(K k) {
        Node node = getNode(k);
        return node == null ? null : node.v;
    }

    @Override
    public void set(K k, V v) {
        Node node = getNode(k);
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

    private Node getNode(K k) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.k.equals(k)) {
                return cur;
            }
            cur = cur.next;
        }

        return null;
    }


}
