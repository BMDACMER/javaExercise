package guohaoAlgorithm.oneQuestionPerDay;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author guohao
 * @Date 2021/2/12 13:27
 * @Version 1.0
 *
 * 119. ������� II
 * ����һ���Ǹ����� k������ k �� 33������������ǵĵ� k �С�
 *
 *
 *
 * ����������У�ÿ�����������Ϸ������Ϸ������ĺ͡�
 *
 * ʾ��:
 *
 * ����: 3
 * ���: [1,3,3,1]
 * ���ף�
 *
 * ������Ż�����㷨�� O(k) �ռ临�Ӷ���
 */
public class GetRow {

    // �������   ʱ�临�Ӷ�ΪO(rowIndex^2)   �ռ临�Ӷ�Ϊ��O(n)
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> C = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                }else {
                    row.add(C.get(i - 1).get(j - 1) + C.get(i - 1).get(j));
                }
            }
            C.add(row);
        }
        return C.get(rowIndex);
    }

    // �Ż��ռ临�Ӷ�Ϊ O(1)
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            row.add(0);
            for (int j = i; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }

}
