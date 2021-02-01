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
 * 22. ��������
 * ���� n �����������ŵĶ������������һ�������������ܹ��������п��ܵĲ��� ��Ч�� ������ϡ�
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺n = 3
 * �����["((()))","(()())","(())()","()(())","()()()"]
 * ʾ�� 2��
 *
 * ���룺n = 1
 * �����["()"]
 */
public class GenerateParenthesis {

    /**
     * Լ������
     * 1�������ŵ������������ŵ�����һ��
     * 2������[0,i]�����ŵ�������С�������ŵ�����
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

        // ���������
        path.addLast('(');
        dfs(l - 1, r, path);
//        path.removeLast();
        path.pollLast();

        // ���������
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
        // �������һ��������
        path.append("(");
        dfs(left-1,right,path);
        path.deleteCharAt(path.length() - 1);

        // �������һ��������
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
