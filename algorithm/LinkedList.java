public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node(Node next) {
            this(null, next);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    // 获取链表中的元素个数
    public int getSize() {
        return size;
    }

    // 返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 在链表头添加新的元素e
    public void addFirst(E e) {
        head = new Node(e, head);
        size++;
    }

    // 在链表index中添加新的元素e
    public void add(int index, E e) {
        if (index < 0 || index > 0) {
            throw new IllegalArgumentException("Add failed . Illegal index.");
        }
        if (index == 0) {
            addFirst(e);
        }
        Node pre = head;
        for (int i = 0; i < index - 1; i++) {
            pre = pre.next;
        }

        pre.next = new Node(e, pre.next);
        size++;
    }

    // 在链表末尾添加的元素e
    public void addLast(E e) {
        add(size, e);
    }

}
