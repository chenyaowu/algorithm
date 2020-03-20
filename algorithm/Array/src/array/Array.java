package array;

public class Array<E> {

    private E[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     *
     * @param capacity 数组大小
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 默认构造容量为10的构造函数
     */
    public Array() {
        this(10);
    }

    /**
     * 传入数组构造Array
     *
     * @param array 数组
     */
    public Array(E[] array) {
        System.arraycopy(array, 0, data, 0, array.length);
        size = array.length;
    }

    /**
     * 获取元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 判断数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向指定位置添加元素
     *
     * @param index 索引
     * @param e     元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Index out of array");
        }
        if (size == data.length) {
            resize(data.length * 2);
        }

        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = e;
        size++;
    }

    /**
     * 向头部添加元素
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 向数组尾部添加元素
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 删除指定位置元素
     *
     * @param index 索引
     */
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed. Index out of array");
        }
        E ret = data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[size - 1] = null;

        // 缩容
        if (size < data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        size--;
        return ret;
    }

    /**
     * 删除头元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除尾元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除指定元素,并返回索引（首先出现的元素）
     *
     * @param e
     */
    public int removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }

        return index;
    }

    /**
     * 删除数组中，所有元素e
     *
     * @param e
     * @return
     */
    public int[] removeAllElement(E e) {
        int[] indexArr = findAll(e);
        if (indexArr == null) {
            return null;
        }
        for (int i = 0; i < indexArr.length; i++) {
            remove(indexArr[i] - i);
        }

        return indexArr;
    }

    /**
     * 修改数组
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed. Index out of array");
        }
        data[index] = e;
    }

    /**
     * 查找指定元素第一个索引
     *
     * @param e 元素
     * @return 索引
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 查找指定元素所有索引
     *
     * @param e
     * @return
     */
    public int[] findAll(E e) {
        int[] indexArr = new int[size];
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                indexArr[index] = i;
                index++;
            }
        }
        if (index == 0) {
            return null;
        }

        int[] resArr = new int[index];
        System.arraycopy(indexArr, 0, resArr, 0, index);
        return resArr;
    }

    /**
     * 判断数组是否包含元素e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return find(e) != -1;
    }

    /**
     * 获取指定索引元素
     * @param index
     */
    public E get(int index){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Index out of array");
        }
        return data[index];
    }

    /**
     * 获取第一个元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获取最后一个元素
     * @return
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 调整数组容量
     *
     * @param newCapatity 调整后容量
     */
    private void resize(int newCapatity) {
        E[] newData = (E[]) new Object[newCapatity];
        System.arraycopy(data, 0, newData, 0, size-1);
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size= %d, capacity = %d\n", size, data.length));
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


}
