package guohaoAlgorithm.backtrack;

import guohaoAlgorithm.list.ListNode;
import javafx.beans.binding.StringBinding;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/1 11:08
 *
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 */
public class GenerateParenthesis {

    /**
     * 约定规则：
     * 1）左括号的数量与右括号的数量一样
     * 2）对于[0,i]左括号的数量不小于右括号的数量
     * @param n
     * @return
     */
    private List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n < 1) return res;
        StringBuilder path = new StringBuilder();
        dfs(n, n, path);
        return res;
    }

   /* private void dfs(int l, int r, LinkedList<Character> path) {
        if (l < 0 || r < 0) return;
        if (r < l) return;

        if (l == 0 && r == 0) {
            StringBuilder sb = new StringBuilder(path.size());
            while (!path.isEmpty()) {
                sb.append(path.pollFirst());
            }
            res.add(sb.toString());
            return;
        }

        // 添加左括号
        path.addLast('(');
        dfs(l - 1, r, path);
//        path.removeLast();
        path.pollLast();

        // 添加右括号
        path.addLast(')');
        dfs(l, r - 1, path);
//        path.removeLast();
        path.pollLast();
    }*/

    private void dfs(int left, int right, StringBuilder path) {
        if (left < 0 || right < 0) return;
        if (right < left) return;

        if (left == 0 && right == 0) {
            res.add(path.toString());
            return;
        }
        // 尝试添加一个左括号
        path.append("(");
        dfs(left-1,right,path);
        path.deleteCharAt(path.length() - 1);

        // 尝试添加一个右括号
        path.append(")");
        dfs(left,right-1,path);
        path.deleteCharAt(path.length() - 1);
    }

    public static void main(String[] args) {
        GenerateParenthesis g = new GenerateParenthesis();
        List<String> list = g.generateParenthesis(3);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
