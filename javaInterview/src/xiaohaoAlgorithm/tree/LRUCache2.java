package xiaohaoAlgorithm.tree;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/19 10:41
 * 146. LRU 缓存机制
 */
// 使用LinkedHashMap解决
public class LRUCache2 extends LinkedHashMap<Integer, Integer> {
    int cap;

    public LRUCache2(int capacity) {
//        super(capacity, 0.75F, true);
        super(capacity);
        this.cap = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int val) {
        super.put(key, val);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > cap;
    }
}
