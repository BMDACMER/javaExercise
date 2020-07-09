package lintcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/9 11:37
 *
 * 146. LRU缓存机制
 *
 * https://leetcode-cn.com/problems/lru-cache/solution/yuan-yu-linkedhashmapyuan-ma-by-jeromememory/
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    HashMap map = new HashMap();
    LinkedHashMap linkedHashMap = new LinkedHashMap();
    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);  // 按读取顺序排序需要将其设为true
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
