package lintcode.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Test54 {
    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot!=null)
            q.add(pRoot);
        boolean isReverse = false;
        while (!q.isEmpty()) {
            int cnt = q.size();
            ArrayList<Integer> arrayList = new ArrayList<>();
            while (cnt-- > 0) {
                TreeNode node = q.poll();
                if (node == null)
                    continue;
                arrayList.add(node.val);
                q.add(node.left);
                q.add(node.right);
            }

            if (isReverse) {
                Collections.reverse(arrayList);
            }
            isReverse = !isReverse;
            if (arrayList.size() != 0)
                lists.add(arrayList);
        }
        return lists;
    }
}

