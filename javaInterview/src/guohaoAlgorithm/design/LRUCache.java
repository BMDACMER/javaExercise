package guohaoAlgorithm.design;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/28 12:00
 *
 * 面试题 16.25. LRU 缓存  medium
 *
 * https://leetcode-cn.com/problems/lru-cache-lcci/
 */

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * 采用最原始的 hashmap+linkedlist实现
 */
public class LRUCache {
    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new DoubleList();
        this.map = new HashMap<>();
    }

    // 在这两种数据结构之上提供一层抽象的API
    private void makeRecently(int key) {
        Node x = map.get(key);
        cache.remove(x);
        cache.addLast(x);
    }

    // 添加最近使用的元素
    private void addRecently(int key, int val) {
        Node x = new Node(key, val);
        cache.addLast(x);
        map.put(key, x);
    }

    // 删除一个key  保证key一定存在
    private void deleteKey(int key) {
        Node x = map.get(key);
        cache.remove(x);
        map.remove(x);
    }

    // 删除最久未使用的元素
    private void removeLeastRecently() {
        Node deletedNode = cache.removeFirst();
        int deletedKey = deletedNode.key;
        map.remove(deletedKey);
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        makeRecently(key);
        return map.get(key).value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            deleteKey(key);
            addRecently(key, value);
            return;
        }

        if (capacity == cache.size()) {
            removeLeastRecently();
        }
        addRecently(key, value);
    }
}

/**
 * 方法二  借助数据结构
 */
class LRUCache2 {
    int cap;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    public LRUCache2(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            makeRecently(key);
            return;
        }

        if (cap <= cache.size()) {
            cache.remove(cache.keySet().iterator().next());
        }
        cache.put(key, value);
    }

    private void makeRecently(int key) {
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }
}
