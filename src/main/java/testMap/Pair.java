package testMap;

public class Pair<V> {

    private final long key;
    private V value;

    public Pair(long key, V value) {
        this.key = key;
        this.value = value;
    }

    public long getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V newValue) {
        value = newValue;
    }
}
