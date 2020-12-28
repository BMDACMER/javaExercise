package xiaohaoAlgorithm.backtrack;

import xiaohaoAlgorithm.剑指offer.ListNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/28 0:12
 *
 * 22. 括号生成
 */
public class GenerateParenthesis {

    /**
     * 满足两条规律：
     * 1、左右括号相等
     * 2、对于字串，左括号的数量都要大于等于右括号的数量
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        // 记录所有合法的括号生成
        List<String> list = new ArrayList<>();
        if (n == 0) return list;
        // 回溯过程中的途径
        LinkedList<String> track = new LinkedList<>();
        // 可用的左括号和右括号数量初始化为n
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
        // 尝试添加一个左括号
        track.offerLast("(");
        backtrack(left-1,right,track,res);
        track.pollLast();

        // 尝试添加一个右括号
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
