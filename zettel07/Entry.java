class Entry<K, V> {
    private final K key;
    private final V value;

    public Entry(K initKey, V initValue) {
        key = initKey;
        value = initValue;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
