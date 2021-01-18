package guohaoAlgorithm.tree;

import java.util.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/18 22:25
 *
 * 501. �����������е�����
 */
public class FindMode {

    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();  // key--�ڵ�ֵ  value -- ���ִ���
        traverse(root, map);
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            max = Math.max(max, entry.getValue());
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }
        // תΪ����
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private void traverse(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null) return;
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        traverse(root.left, map);
        traverse(root.right, map);
    }


    /**
     * �Ż���Ĵ���
     */
    List<Integer> answer = new ArrayList<>();
    int base, count, maxCount;

    public int[] findMode2(TreeNode root) {
        dfs(root);
        int[] mode = new int[answer.size()];
        for (int i = 0; i < mode.length; i++) {
            mode[i] = answer.get(i);
        }
        return mode;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        update(root.val);
        dfs(root.right);
    }

    private void update(int x) {
        if (x == base) {
            ++count;
        } else {
            count = 1;
            base = x;
        }
        if (count == maxCount) {
            answer.add(base);
        }
        if (count > maxCount) {
            maxCount = count;
            answer.clear();
            answer.add(base);
        }
    }
}
