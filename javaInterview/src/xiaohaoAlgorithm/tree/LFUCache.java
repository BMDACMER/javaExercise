package xiaohaoAlgorithm.tree;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/19 11:55
 *
 * 460. LFU ª∫¥Ê
 * P230-234 °∂labuladongÀ„∑®–°≥≠°∑
 */
public class LFUCache {
    HashMap<Integer, Integer> keyToVal;
    HashMap<Integer, Integer> keyToFreq;
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;

    int minFreq;
    int cap;

    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.cap = capacity;
        this.minFreq = 0;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) return -1;

        increaseFreq(key);
        return keyToVal.get(key);
    }

    private void increaseFreq(int key) {
        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);
        freqToKeys.get(freq).remove(key);
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeys.get(freq+1).add(key);

        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            if (freq == this.minFreq)
                this.minFreq++;
        }
    }

    public void put(int key, int value) {
        if (this.cap <= 0) return;

        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            increaseFreq(key);
            return;
        }

        if (this.cap <= keyToVal.size()) removeMinFreqKey();

        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        this.minFreq = 1;
    }

    private void removeMinFreqKey() {
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
        int deletedKey = keyList.iterator().next();
        keyList.remove(deletedKey);
        if (keyList.isEmpty()) {
            freqToKeys.remove(this.minFreq);
        }

        keyToVal.remove(deletedKey);
        keyToFreq.remove(deletedKey);
    }
}
