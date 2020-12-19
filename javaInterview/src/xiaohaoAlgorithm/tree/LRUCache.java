package xiaohaoAlgorithm.tree;

import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/19 9:56
 *
 * 146. LRU 缓存机制
 */
public class LRUCache {
    // key --> Node(key, val)
    HashMap<Integer, Node> map;
    // Node(k1, v1) --> Node(k2, v2)
    private DoubleList cache;
    // 最大容量
    private int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    // 将某个key提升为最近使用的
    private void makeRecently(int key) {
        Node node = map.get(key);
        cache.remove(node);
        cache.addLast(node);
    }

    // 添加最近使用的元素
    private void addRecently(int key, int val) {
        Node x = new Node(key, val);
        cache.addLast(x);
        map.put(key, x);
    }

    // 删除某一个key
    public void deleteKey(int key) {
        Node x = map.get(key);
        cache.remove(x);
        map.remove(key);
    }

    // 删除最久未使用的元素
    public void removeLeastRecently() {
        // 链表头部的第一个元素就是最久未使用的
        Node deleteNode = cache.removeFirst();
        // 同时别忘了从map中删除它的key
        int deleteKey = deleteNode.key;
        map.remove(deleteKey);
    }

    //************************************//
    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        // 将该数据提升为最近使用
        makeRecently(key);
        return map.get(key).val;
    }

    public void put(int key, int val) {
        if (map.containsKey(key)) {
            //删除旧数据
            deleteKey(key);
            // 新插入的数据为最近使用的数据
            addRecently(key, val);
            return;
        }

        if (cap == cache.size())
            // 删除最久未使用的元素
            removeLeastRecently();

        // 添加为最近使用的元素
        addRecently(key, val);
    }
}
