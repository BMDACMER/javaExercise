package xiaohaoAlgorithm.backtrack;

import xiaohaoAlgorithm.��ָoffer.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/28 0:12
 *
 * 22. ��������
 */
public class GenerateParenthesis {

    /**
     * �����������ɣ�
     * 1�������������
     * 2�������ִ��������ŵ�������Ҫ���ڵ��������ŵ�����
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        // ��¼���кϷ�����������
        List<String> list = new ArrayList<>();
        if (n == 0) return list;
        // ���ݹ����е�;��
        StringBuilder track = new StringBuilder();
        // ���õ������ź�������������ʼ��Ϊn
        backtrack(n,n,track,list);
        return list;
    }


    private void backtrack(int left, int right, StringBuilder track, List<String> res) {
        if (left < 0 || right < 0) return;
        // ������ʣ�¶��� ˵�����Ϸ�
        if (right < left) return;

        if (left == 0 && right == 0) {
           res.add(track.toString());
            return;
        }
        // �������һ��������
        track.append("(");
        backtrack(left-1,right,track,res);
        track.deleteCharAt(track.length() - 1);

        // �������һ��������
        track.append(")");
        backtrack(left,right-1,track,res);
        track.deleteCharAt(track.length() - 1);
    }

    // �������� ����dfs�㷨
    /**
     * ����������������
     *      * 1�������������
     *      * 2�������ִ��������ŵ�������Ҫ���ڵ��������ŵ�����
     * @param n
     * @return
     */
    public List<String> generateParenthesis2(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) return result;
        String track = "";
        dfs(n,n,track,result);
        return result;
    }

    private void dfs(int left, int right, String track, List<String> result) {
        if (left < 0 || right < 0) return;
        if (right < left) return;
        if (left == 0 && right == 0) {
            result.add(track);
            return;
        }

        if (left > 0) {
            dfs(left-1,right,track+"(",result);
        }
        if (right > 0) {
            dfs(left,right-1,track+")",result);
        }

    }


    public static void main(String[] args) {
        GenerateParenthesis g = new GenerateParenthesis();
        List<String> list = g.generateParenthesis2(3);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
