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
//        StringBuilder path = new StringBuilder();
        LinkedList<String> path = new LinkedList<>();
        dfs(n, n, path);
        return res;
    }

    private void dfs(int l, int r, LinkedList<String> path) {
        if (l < 0 || r < 0) return;
        if (r < l) return;

        if (l == 0 && r == 0) {
            StringBuilder sb = new StringBuilder(path.size());
            for (int i = 0; i < path.size(); i++) {
                sb.append(path.get(i));
            }
            // ����д������    ��Ϊ���ƻ�path·��
//            while (!path.isEmpty())
//                sb.append(path.pollFirst());
            res.add(sb.toString());
            return;
        }

        // ���������
        path.addLast("(");
        dfs(l - 1, r, path);
        path.pollLast();

        // ���������
        path.addLast(")");
        dfs(l, r - 1, path);
        path.pollLast();
    }

    /*private void dfs(int left, int right, LinkedList<String> path) {
        if (left < 0 || right < 0) return;
        if (right < left) return;

        if (left == 0 && right == 0) {
            StringBuilder sb = new StringBuilder(path.size());
            for (int i = 0; i < path.size(); i++) {
                sb.append(path.get(i));
            }
            res.add(sb.toString());
            return;
        }
        // �������һ��������
        path.addLast("(");
        dfs(left-1,right,path);
        path.pollLast();

        // �������һ��������
        path.addLast(")");
        dfs(left,right-1,path);
        path.pollLast();
    }*/

    public static void main(String[] args) {
        GenerateParenthesis g = new GenerateParenthesis();
        List<String> list = g.generateParenthesis(3);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
