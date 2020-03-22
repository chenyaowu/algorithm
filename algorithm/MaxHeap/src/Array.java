public class Array<E> {

    private E[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     *
     * @param capacity 容量
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 构造函数，传入数组的容量capacity构造Array
     *
     * @param e 容
     */
    public Array(E[] e) {
        data = (E[]) new Object[e.length];
        System.arraycopy(e, 0, data, 0, e.length);
        size = 0;
    }

    /**
     * 无参构造函数，默认数组的容量capacity=10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组大小
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 指定位置插入元素e
     *
     * @param index 索引
     * @param e     元素
     */
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Index out of array");
        }
        if (size == data.length) {
            resize(2 * data.length);
        }
        System.arraycopy(data, index, data, index + 1, size - index);
//        for (int i = size - 1; i >= index; i--) {
//            data[i + 1] = data[i];
//        }

        //
        data[index] = e;
        size++;

    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("array.Array: size= %d, capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

    /**
     * 获取指定索引元素
     *
     * @param index 索引
     * @return 元素
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index out of array");
        }

        return data[index];
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index out of array");
        }
        data[index] = e;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除指定位置的元素，并返回
     *
     * @param index 索引
     * @return 元素
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index out of array");
        }

        E res = data[index];

        System.arraycopy(data, index + 1, data, index, size - index - 1);

        size--;
        data[size] = null;

        if (size == data.length / 4 && data.length != 0) {
            resize(data.length / 2);
        }
        return res;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("Index is illegal");
        }

        E e = data[i];
        data[i] = data[j];
        data[j] = e;
    }
}
