import java.util.TreeMap;

public class HashTable<K, V> {

    private static final int upperTol = 10;
    private static final int lowerTol = 2;
    private static final int initCapacity = 10;
    private TreeMap<K, V>[] hashTable;
    private int M; //长度
    private int size;

    public HashTable(int M) {
        this.M = M;
        size = 0;
        hashTable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashTable[i] = new TreeMap<>();
        }
    }

    public HashTable() {
        this(initCapacity);
    }

    public int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize() {
        return size;
    }

    public void add(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];
        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            map.put(key, value);
            size++;

            if (size >= upperTol * M) {
                resize(2 * M);
            }
        }
    }

    public V remove(K key) {
        TreeMap<K, V> map = hashTable[hash(key)];
        V ret = null;
        if (map.containsKey(key)) {
            ret = map.remove(key);
            size--;

            if (size < lowerTol * M && M / 2 >= initCapacity) {
                resize(M / 2);
            }
        }
        return ret;
    }

    private void resize(int newM) {
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];

        for (int i = 0; i < newM; i++) {
            newHashTable[i] = new TreeMap<>();
        }

        this.M = newM;
        for (int i = 0; i < M; i++) {
            TreeMap<K, V> treeMap = hashTable[i];
            for (K key : treeMap.keySet()) {
                newHashTable[hash(key)].put(key, treeMap.get(key));
            }
        }

        this.hashTable = newHashTable;
    }

    public void set(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException(key + "doesn't exist!");
        } else {
            map.put(key, value);
        }
    }

    public boolean contains(K key) {
        return hashTable[hash(key)].containsKey(key);
    }

    public V get(K key) {
        return hashTable[hash(key)].get(key);
    }


}
