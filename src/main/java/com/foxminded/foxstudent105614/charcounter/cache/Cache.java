package com.foxminded.foxstudent105614.charcounter.cache;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

public class Cache<K, V> extends HashMap<K, V>  {
    private static final int DEFAULT_MAX_SIZE = 100;
    private final LinkedList<Serializable> keys;
    private final int maxSize;

    public Cache() {
        this(DEFAULT_MAX_SIZE);
    }

    public Cache(int maxSize) {
        super(maxSize + 1, 1.0f);
        this.maxSize = maxSize;
        this.keys = new LinkedList<>();
    }

    @Override
    public V put(K key, V value) {
        if (key == null || value == null) {
            throw new NullPointerException("Key and value can't by null.");
        }
        if (size() >= maxSize) {
            Serializable oldestKey = keys.poll();
            if (oldestKey != null) {
                remove(oldestKey);
            }
        }
        keys.offer((Serializable) key);
        return super.put(key, value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keys, super.hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cache<?, ?> cache = (Cache<?, ?>) o;
        if (maxSize != cache.maxSize) return false;
        return keys.equals(cache.keys);
    }
}
