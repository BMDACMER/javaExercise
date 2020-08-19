package ����;

import java.util.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/18 22:04
 *
 * 241. Ϊ������ʽ������ȼ�
 *
 * https://leetcode-cn.com/problems/different-ways-to-add-parentheses/
 *
 * https://leetcode-cn.com/problems/different-ways-to-add-parentheses/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-5-5/
 * ����: "2-1-1"
 * ���: [0, 2]
 * ����:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 */
public class Ϊ������ʽ������ȼ� {


    HashMap<String,List<Integer>> map = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {
        // �߽紦��
        if (input == null || input.length() < 1) return null;

        // 1�����  ��ȥ���������⵽ֻʣ��һ������Ԫ��Ϊֹ
        //����Ѿ��е�ǰ���ˣ�ֱ�ӷ���
        if(map.containsKey(input)){
            return map.get(input);
        }

        // ������Ԫ��ת��Ϊ������ʽ
        List<Integer> result = new ArrayList<>();
        int num = 0;
        int i;
        for (i = 0; i < input.length() && !isOperation(input.charAt(i)); i++) {
            num = num * 10 + input.charAt(i) - '0';
        }
        //��ȫ���ֵ����ֱ�ӷ���
        if (i == input.length()){
            result.add(num);
            // �浽map
            map.put(input, result);
            return result;
        }

        // 2�����������
        for (int j = 0; j < input.length(); j++) {
            // ͨ����������ַ�����Ϊ������
            if (isOperation(input.charAt(j))) {
                List<Integer> result1 = diffWaysToCompute(input.substring(0,j)); // ����ҿ�����
                List<Integer> result2 = diffWaysToCompute(input.substring(j+1));  // ʡ�����ұ߽�
                // �����������������
                for (int k = 0; k < result1.size(); k++) {
                    for (int l = 0; l < result2.size(); l++) {
                        char op = input.charAt(j);
                        result.add(calculate(result1.get(k), op, result2.get(l)));
                    }
                }
            }
        }

        //�浽 map
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
