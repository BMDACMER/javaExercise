package xiaohaoAlgorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/25 10:41
 *
 * 77. 组合
 */
public class Combine {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n <= 0) return result;
        List<Integer> list = new ArrayList<>();
        backtrack(n,k, 1, list);
        return result;
    }

    private void backtrack(int n, int k, int start, List<Integer> list) {
        // 到达叶子节点才返回
        if (k == list.size()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            backtrack(n,k, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

}
