package xiaohaoAlgorithm.backtrack;

import xiaohaoAlgorithm.��ָoffer.ListNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
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
        LinkedList<String> track = new LinkedList<>();
        // ���õ������ź�������������ʼ��Ϊn
        backtrack(n,n,track,list);
        return list;
    }


    boolean first = true, last = false;
    private void backtrack(int left, int right, LinkedList<String> track, List<String> res) {
        if (left < 0 || right < 0) return;
        if (right < left) return;
        if (left == 0 && right == 0) {
            Iterator<String> it = track.iterator();
            StringBuilder sb = new StringBuilder();
            if (first) {
                sb.append("[");
                first = false;
            }
            sb.append("\"");
            while (it.hasNext()) {
                sb.append(it.next());
            }
            sb.append("\"").append(",");
            res.add(sb.toString());
            return;
        }
        // �������һ��������
        track.offerLast("(");
        backtrack(left-1,right,track,res);
        track.pollLast();

        // �������һ��������
        track.offerLast(")");
        backtrack(left,right-1,track,res);
        track.pollLast();
    }


    public static void main(String[] args) {
        GenerateParenthesis g = new GenerateParenthesis();
        List<String> list = g.generateParenthesis(3);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
