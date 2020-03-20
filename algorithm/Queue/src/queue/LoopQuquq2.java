package queue;

/**
 * 不带size循环队列
 *
 * @param <E>
 */
public class LoopQuquq2<E> implements Queue<E> {

    private E[] data;
    private int front;
    private int tail;

    public LoopQuquq2(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
    }

    public LoopQuquq2() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }


    @Override
    public void enqueue(E e) {

        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;

    }

    /**
     * 扩容
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < getSize(); i++) {
            newData[i] = data[(i + front) % data.length];
        }
        tail = getSize();
        data = newData;
        front = 0;


    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        E ret = data[front];
        data[front] = null;
        if (getSize() < getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        front = (front + 1) % data.length;
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot getFront from an empty queue");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return (tail + data.length - front) % data.length;
    }

    @Override
    public boolean isEmpty() {
        return tail == front;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size= %d, capacity = %d\n", getSize(), getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
