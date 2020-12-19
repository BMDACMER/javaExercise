package xiaohaoAlgorithm.tree;

import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/19 9:56
 *
 * 146. LRU �������
 */
public class LRUCache {
    // key --> Node(key, val)
    HashMap<Integer, Node> map;
    // Node(k1, v1) --> Node(k2, v2)
    private DoubleList cache;
    // �������
    private int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    // ��ĳ��key����Ϊ���ʹ�õ�
    private void makeRecently(int key) {
        Node node = map.get(key);
        cache.remove(node);
        cache.addLast(node);
    }

    // ������ʹ�õ�Ԫ��
    private void addRecently(int key, int val) {
        Node x = new Node(key, val);
        cache.addLast(x);
        map.put(key, x);
    }

    // ɾ��ĳһ��key
    public void deleteKey(int key) {
        Node x = map.get(key);
        cache.remove(x);
        map.remove(key);
    }

    // ɾ�����δʹ�õ�Ԫ��
    public void removeLeastRecently() {
        // ����ͷ���ĵ�һ��Ԫ�ؾ������δʹ�õ�
        Node deleteNode = cache.removeFirst();
        // ͬʱ�����˴�map��ɾ������key
        int deleteKey = deleteNode.key;
        map.remove(deleteKey);
    }

    //************************************//
    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        // ������������Ϊ���ʹ��
        makeRecently(key);
        return map.get(key).val;
    }

    public void put(int key, int val) {
        if (map.containsKey(key)) {
            //ɾ��������
            deleteKey(key);
            // �²��������Ϊ���ʹ�õ�����
            addRecently(key, val);
            return;
        }

        if (cap == cache.size())
            // ɾ�����δʹ�õ�Ԫ��
            removeLeastRecently();

        // ���Ϊ���ʹ�õ�Ԫ��
        addRecently(key, val);
    }
}
