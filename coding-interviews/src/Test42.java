import java.util.ArrayList;

/**
 * ��ΪS��������������
 *
 * ������к�ΪS�������������С������ڰ��մ�С�����˳�����м䰴�տ�ʼ���ִ�С�����˳��
 */
public class Test42 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        // ���ö�̬���ڷ�ʽ�����ô�������ָ��ֱ�ΪpLeft,pRight �����ǵȲ�Ϊ1�ĵȲ�����
        // ���� ��pLeft + pRight��* n / 2 Ϊ�����ڵ�ֵ   �ж��Ƿ�Ϊsum
        // < sum  pRgiht++
        // > sum  pLeft++
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        int pLeft = 1, pRight = 2;
        while (pRight > pLeft) {
            int s = (pLeft + pRight) * (pRight - pLeft + 1) / 2;
            if (s == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = pLeft; i <= pRight; i++) {
                    list.add(i);
                }
                lists.add(list);
                pLeft++;
            } else if (s < sum) {
                pRight++;
            } else {
                pLeft++;
            }
        }
        return lists;
    }
}
