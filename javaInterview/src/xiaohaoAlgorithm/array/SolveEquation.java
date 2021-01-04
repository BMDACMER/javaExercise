package xiaohaoAlgorithm.array;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/4 16:52
 *
 * 640. ��ⷽ��
 */
public class SolveEquation {

    /**
     * ˼·������ʽ�ĸ��� = ���Ⱥţ��ָ�������� ��x�ƶ���ߣ�ʣ�µ��ַ��������֣�һ����һ��
     * �� +- ���� -  ���ں�������
     *
     *      �� x���ֵĴ���Ϊ0�ҳ���ϵ����Ϊ�㣬�� xΪ Infinite solutions
     *      �� x���ֵĴ�����Ϊ0����ʣ�µ�Ԫ��֮�� ����x�Ĵ�����Ϊx��ֵ
     *      ��x=���ֵĴ���Ϊ0��ʣ��Ԫ��֮�Ͳ�Ϊ0���� No solution
     * @param equation
     * @return
     */
    public String solveEquation(String equation) {
        int xCoefficient = 0, constantCoefficient = 0;
        int op = 1;   // Ĭ�����Ϊ1  �ұ�Ϊ-1��
        for (String eq : equation.split("=")) {
            eq.replace("-","+-");
            for (String num : eq.split("\\+")) {
                // ��԰���x�����
                if (num.contains("x")) {
                    // ���ֻ��x�����
                    if (num.length() == 1) xCoefficient += op;
                    // ��� -x���
                    else if (num.length() == 2 && num.contains("-")) xCoefficient += -op;
                    else xCoefficient += op * Integer.parseInt(num.substring(0,num.length() - 1));
                }else {
                    constantCoefficient += op * Integer.parseInt(num);
                }
            }
            op = -1;  // ��ת
        }
        // �� x���ֵ�ϵ��Ϊ0�ҳ���ϵ��Ϊ�㣬�� xΪ Infinite solutions
        if (xCoefficient == 0 && constantCoefficient == 0) return "Infinite solutions";
        // ��xϵ��Ϊ���ҳ���ϵ����Ϊ0
        else if (xCoefficient == 0 && constantCoefficient != 0) return "No solution";
        else return "x=" +  (-1 * constantCoefficient * (double) 1 / xCoefficient);
    }

}
