package 分治;

import java.util.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/18 22:04
 *
 * 241. 为运算表达式设计优先级
 *
 * https://leetcode-cn.com/problems/different-ways-to-add-parentheses/
 *
 * https://leetcode-cn.com/problems/different-ways-to-add-parentheses/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-5-5/
 * 输入: "2-1-1"
 * 输出: [0, 2]
 * 解释:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 */
public class 为运算表达式设计优先级 {


    HashMap<String,List<Integer>> map = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {
        // 边界处理
        if (input == null || input.length() < 1) return null;

        // 1）拆分  除去运算符，拆解到只剩下一个单个元素为止
        //如果已经有当前解了，直接返回
        if(map.containsKey(input)){
            return map.get(input);
        }

        // 将单个元素转换为整数形式
        List<Integer> result = new ArrayList<>();
        int num = 0;
        int i;
        for (i = 0; i < input.length() && !isOperation(input.charAt(i)); i++) {
            num = num * 10 + input.charAt(i) - '0';
        }
        //将全数字的情况直接返回
        if (i == input.length()){
            result.add(num);
            // 存到map
            map.put(input, result);
            return result;
        }

        // 2）解决子问题
        for (int j = 0; j < input.length(); j++) {
            // 通过运算符将字符串分为两部分
            if (isOperation(input.charAt(j))) {
                List<Integer> result1 = diffWaysToCompute(input.substring(0,j)); // 左闭右开区间
                List<Integer> result2 = diffWaysToCompute(input.substring(j+1));  // 省略最右边界
                // 将两个结果依次运算
                for (int k = 0; k < result1.size(); k++) {
                    for (int l = 0; l < result2.size(); l++) {
                        char op = input.charAt(j);
                        result.add(calculate(result1.get(k), op, result2.get(l)));
                    }
                }
            }
        }

        //存到 map
        map.put(input, result);
        Collections.reverse(result);
        return result;
    }

    private int calculate(int num1, char c, int num2) {
        switch (c) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
        }
        return -1;
    }

    private boolean isOperation(char c) {
        return c == '+' || c == '-' || c == '*';
    }


}
