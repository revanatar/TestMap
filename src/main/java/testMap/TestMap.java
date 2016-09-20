package testMap;

import java.util.Vector;

public interface TestMap<V> {

    /**
     * @param key ключ
     * @param value значение
     * @return замененное значение, в ином случае null
     */
    V put(long key, V value);
    /**
     * @param key ключ
     * @return значение по переданному ключу
     */
    V get(long key);
    /**
     * @param key ключ
     * @return
     */
    V remove(long key);

    /**
     * @return true если карта не содержит пар ключ-значение
     */
    boolean isEmpty();
    /**
     * @param key ключ
     * @return true если содержится переданный ключ
     */
    boolean containsKey(long key);
    /**
     * @param value значение
     * @return true если содержится переданное значение
     */
    boolean containsValue(V value);

    /**
     * @return массив ключей
     */
    long[] keys();
    /**
     * @return массив значений
     */
    Vector<V> values(); // Изменено с V[] на Vector<V>
                        // так как джава не знает дженерик массиовов
    /**
     * @return размер карты
     */
    long size(); // но все равно размерности массивов не больше чем int
    /**
     * Очистка карты
     */
    void clear();

}
