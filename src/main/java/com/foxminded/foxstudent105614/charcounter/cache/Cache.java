package com.foxminded.foxstudent105614.charcounter.cache;

import java.util.HashMap;
import java.util.LinkedList;

public class Cache<K, V> extends HashMap<K, V> {
    private final int maxSize;
    private final LinkedList<K> keys;

    public Cache() {
        this(100);
    }

    public Cache(int maxSize) {
        super(maxSize + 1, 1.0f);
        this.maxSize = maxSize;
        this.keys = new LinkedList<>();
    }

    @Override
    public V put(K key, V value) {
        if (size() >= maxSize) {
            K oldestKey = keys.poll();
            if (oldestKey != null) {
                remove(oldestKey);
            }
        }
        keys.offer(key);
        return super.put(key, value);
    }
}
