package lintcode.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Test53 {
    Queue<TreeNode> queue = new LinkedList<>();
    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot != null)
            queue.add(pRoot);
        while (!queue.isEmpty()) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            int cnt = queue.size();
            while (cnt-- > 0) {
                TreeNode node = queue.poll();
                if (node == null)
                    continue;
                arrayList.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }

            if (arrayList.size() != 0)
                lists.add(arrayList);
        }
        return lists;
    }


}
