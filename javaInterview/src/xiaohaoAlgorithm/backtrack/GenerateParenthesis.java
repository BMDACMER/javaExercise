package xiaohaoAlgorithm.backtrack;

import xiaohaoAlgorithm.剑指offer.ListNode;

import java.util.ArrayList;
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
        StringBuilder track = new StringBuilder();
        // 可用的左括号和右括号数量初始化为n
        backtrack(n,n,track,list);
        return list;
    }


    private void backtrack(int left, int right, StringBuilder track, List<String> res) {
        if (left < 0 || right < 0) return;
        // 左括号剩下多了 说明不合法
        if (right < left) return;

        if (left == 0 && right == 0) {
           res.add(track.toString());
            return;
        }
        // 尝试添加一个左括号
        track.append("(");
        backtrack(left-1,right,track,res);
        track.deleteCharAt(track.length() - 1);

        // 尝试添加一个右括号
        track.append(")");
        backtrack(left,right-1,track,res);
        track.deleteCharAt(track.length() - 1);
    }

    // 方法二： 采用dfs算法
    /**
     * 还是满足两条规律
     *      * 1、左右括号相等
     *      * 2、对于字串，左括号的数量都要大于等于右括号的数量
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
