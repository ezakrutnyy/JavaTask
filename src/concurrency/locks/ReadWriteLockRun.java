package concurrency.locks;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockRun {
    public static void main(String[] args) {
        Map<String, Integer> map = new SyncHashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        System.out.println(map.remove("One"));
        System.out.println(map.get("Two"));
        System.out.println(map.get("Three"));
    }
}


class SyncHashMap<K, V> implements Map<K, V> {

    private final Map<K, V> map;

    private final Lock rLock;

    private final Lock wLock;

    public SyncHashMap() {
        map = new HashMap<>();
        ReadWriteLock lock = new ReentrantReadWriteLock();
        rLock = lock.readLock();
        wLock = lock.writeLock();
    }

    @Override
    public int size() {
        rLock.lock();
        try {
            return map.size();
        } finally {
            rLock.unlock();
        }

    }

    @Override
    public boolean isEmpty() {
        rLock.lock();
        try {
            return map.isEmpty();
        } finally {
            rLock.unlock();
        }
    }

    @Override
    public boolean containsKey(Object key) {
        rLock.lock();
        try {
            return map.containsKey(key);
        } finally {
            rLock.unlock();
        }
    }

    @Override
    public boolean containsValue(Object value) {
        rLock.lock();
        try {
            return map.containsValue(value);
        } finally {
            rLock.unlock();
        }
    }

    @Override
    public V get(Object key) {
        rLock.lock();
        try {
            return map.get(key);
        } finally {
            rLock.unlock();
        }
    }

    @Override
    public V put(K key, V value) {
        wLock.lock();
        try {
            return map.put(key, value);
        } finally {
            wLock.unlock();
        }
    }

    @Override
    public V remove(Object key) {
        wLock.lock();
        try {
            return map.remove(key);
        } finally {
            wLock.unlock();
        }
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        wLock.lock();
        try {
            map.putAll(m);
        } finally {
            wLock.unlock();
        }
    }

    @Override
    public void clear() {
        wLock.lock();
        try {
            map.clear();
        } finally {
            wLock.unlock();
        }
    }

    @Override
    public Set<K> keySet() {
        rLock.lock();
        try {
            return map.keySet();
        } finally {
            rLock.unlock();
        }
    }

    @Override
    public Collection<V> values() {
        rLock.lock();
        try {
            return map.values();
        } finally {
            rLock.unlock();
        }
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        rLock.lock();
        try {
            return map.entrySet();
        } finally {
            rLock.unlock();
        }
    }

    @Override
    public boolean equals(Object o) {
        rLock.lock();
        try {
            return map.equals(o);
        } finally {
            rLock.unlock();
        }
    }

    @Override
    public int hashCode() {
        rLock.lock();
        try {
            return map.hashCode();
        } finally {
            rLock.unlock();
        }
    }
}