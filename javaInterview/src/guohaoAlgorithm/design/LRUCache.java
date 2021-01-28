package guohaoAlgorithm.design;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/28 12:00
 *
 * ������ 16.25. LRU ����  medium
 *
 * https://leetcode-cn.com/problems/lru-cache-lcci/
 */

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * ������ԭʼ�� hashmap+linkedlistʵ��
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

    // �����������ݽṹ֮���ṩһ������API
    private void makeRecently(int key) {
        Node x = map.get(key);
        cache.remove(x);
        cache.addLast(x);
    }

    // ������ʹ�õ�Ԫ��
    private void addRecently(int key, int val) {
        Node x = new Node(key, val);
        cache.addLast(x);
        map.put(key, x);
    }

    // ɾ��һ��key  ��֤keyһ������
    private void deleteKey(int key) {
        Node x = map.get(key);
        cache.remove(x);
        map.remove(x);
    }

    // ɾ�����δʹ�õ�Ԫ��
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
 * ������  �������ݽṹ
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
