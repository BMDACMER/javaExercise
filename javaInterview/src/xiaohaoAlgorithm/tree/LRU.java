package xiaohaoAlgorithm.tree;

import java.util.LinkedHashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/19 10:56
 *
 * 146. LRU »º´æ»úÖÆ
 */
public class LRU {

    int cap;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    public LRU(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key))
            return -1;
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int val) {
        if (cache.containsKey(key)) {
            cache.put(key, val);
            makeRecently(key);
            return;
        }

        if (cap >= cache.size()) {
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }

        cache.put(key, val);
    }

    private void makeRecently(int key) {
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }

}
