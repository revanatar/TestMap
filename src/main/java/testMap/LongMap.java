package testMap;

import java.util.ArrayList;
import java.util.Vector;

public class LongMap<V> implements TestMap<V> {

    private ArrayList<Pair<V>>[] table;
    private final int length;

    /**
     * @param length кол-во элементов карты
     */
    @SuppressWarnings("unchecked")
    public LongMap(int length) {
        this.length = length;
        table = new ArrayList[length];
    }

    /**
     * Вычисление индекса карты
     *
     * @param hash значение hashCode() от ключа
     * @param length кол-во элементов карты
     * @return индекс карты
     */
    private int indexOf(int hash, int length) {

        return hash & (length - 1);
    }

    public V put(long key, V value) {

        V oldValue;
        int n;
        int index = indexOf(Long.hashCode(key), length);

        try {
            n = table[index].size();
        } catch (NullPointerException e) {
            table[index] = new ArrayList<Pair<V>>();
            n = 0;
        }

        for (int i = 0; i < n; i++) {
            if (table[index].get(i).getKey() == key) {
                oldValue = table[index].get(i).getValue();
                table[index].set(i, new Pair<V>(key, value));

                return oldValue;
            }
        }

        table[index].add(new Pair<V>(key, value));

        return null;
    }

    public V get(long key) {

        int index = indexOf(Long.hashCode(key), length);
        int n;

        try {
            n = table[index].size();
        } catch (NullPointerException e) {
            return null;
        }
        for (int i = 0; i < n; i++) {
            if (table[index].get(i).getKey() == key) {
                return table[index].get(i).getValue();
            }
        }
        return null;
    }

    public V remove(long key) {

        int index = indexOf(Long.hashCode(key), length);
        int n;
        V oldValue;

        try {
            n = table[index].size();
        } catch (NullPointerException e) {
            return null;
        }
        for (int i = 0; i < n; i++) {
            if (table[index].get(i).getKey() == key) {
                oldValue = table[index].get(i).getValue();
                table[index].remove(i);

                return oldValue;
            }
        }

        return null;
    }

    public boolean isEmpty() {

        for (int i = 0; i < length; i++) {
            if (table[i] != null) {
                return false;
            }
        }

        return true;
    }

    public boolean containsKey(long key) {

        int index = indexOf(Long.hashCode(key), length);
        int n;

        try {
            n = table[index].size();
        } catch (NullPointerException e) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (table[index].get(i).getKey() == key) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(V value) {

        int n;

        outer: for (int i = 0; i < length; i++) {
            try {
                n = table[i].size();
            } catch (NullPointerException e) {
                continue outer;
            }
            for (int j = 0; j < n; j++) {
                if (table[i].get(j).getValue() == value) {
                    return true;
                }
            }
        }

        return false;
    }

    public long[] keys() {

        Vector<Long> keys = new Vector<Long>(10, 1);
        int n;

        outer: for (int i = 0; i < length; i++) {
            try {
                n = table[i].size();
            } catch (NullPointerException e) {
                continue outer;
            }
            for (int j = 0; j < n; j++) {
                keys.add(Long.valueOf(table[i].get(j).getKey()));
            }
        }

        long[] lkeys = new long[keys.size()];

        for (int i = 0; i < keys.size(); i++) {
            lkeys[i] = keys.get(i);
        }

        return lkeys;
    }

    public Vector<V> values() {

        Vector<V> values = new Vector<V>(10, 1);
        int n;

        outer: for (int i = 0; i < length; i++) {
            try {
                n = table[i].size();
            } catch (NullPointerException e) {
                continue outer;
            }
            for (int j = 0; j < n; j++) {
                values.add(table[i].get(j).getValue());
            }
        }

        return values;
    }

    public long size() {

        long size = 0;
        int n;

        outer: for (int i = 0; i < length; i++) {
            try {
                n = table[i].size();
            } catch (NullPointerException e) {
                continue outer;
            }
            size += n;
        }

        return size;
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        table = new ArrayList[length];
    }
}
