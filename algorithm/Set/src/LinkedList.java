public class LinkedList<E> {

    private Node head;
    private int size;

    class Node {

        private E e;
        private Node next;

        public Node() {

        }

        public Node(E e) {
            this.e = e;
        }

        public Node(E e, Node node) {
            this.e = e;
            this.next = node;

        }

        @Override
        public String toString() {
            return e.toString();
        }

    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        head = new Node(e, head);
        size++;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed . Illegal index.");
        }

        Node prev = head;
        while (index-- > 1) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed . Illegal index.");
        }
        Node temp = head;
        while (index-- > 0) {
            temp = temp.next;
        }
        return temp.e;
    }

    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Illegal index. ");
        }
        Node temp = head;
        while (index-- > 0) {
            temp = temp.next;
        }
        temp.e = e;
    }

    /**
     * 是否包含某个元素
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        Node temp = head;
        while (temp != null) {
            if (temp.e.equals(e)) {
                return true;
            }
            temp = temp.next;

        }

        return false;
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove  failed. Illegal index. ");
        }

        Node predDelNode = head; //待删除节点前一个节点
        while (index-- > 1) {
            predDelNode = predDelNode.next;
        }
        Node delNode = predDelNode.next;
        predDelNode.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size-1);
    }

    /**
     * 删除元素e
     * @param e 元素
     */
    public void remove(E e){
        while(head != null && head.e.equals(e)){
            Node delNode = head;
            head = head.next;
            delNode.next = null;
        }


        Node prev = head;
        while(prev.next != null){
            if(prev.next.e.equals(e)){
                Node delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }else{
                prev = prev.next;
            }

        }
    }



    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = head;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }

        res.append("NULL");

        return res.toString();
    }

}
