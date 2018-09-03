package io.octoprime.algo.ds.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class SimpleLRU<K, V> extends LinkedHashMap<K, V> {
    private int cacheSize;
    private static SimpleLRU<String, String> cache;

    public SimpleLRU(int cacheSize) {
        super(16, (float) 0.75, true);
        this.cacheSize = cacheSize;
    }

    public static SimpleLRU<String, String> getInstance(int size) {
        return new SimpleLRU<String, String>(size);
    }


    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() >= cacheSize;
    }

    public static void main(String[] args) {
        cache = SimpleLRU.getInstance(3);
        cache.put("1", "A");
        cache.put("2", "B");
        cache.put("3", "C");
        cache.get("1");
        cache.put("4", "D");
        System.out.println(cache);
        cache.get("3");
        cache.put("5", "E");
        System.out.println(cache);
    }

}
