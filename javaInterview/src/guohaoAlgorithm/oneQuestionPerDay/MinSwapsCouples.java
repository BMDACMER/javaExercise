package guohaoAlgorithm.oneQuestionPerDay;

/**
 * @Author guohao
 * @Date 2021/2/14 11:42
 * @Version 1.0
 *
 * 765. ����ǣ��
 * N �����������������е� 2N ����λ�ϣ���Ҫǣ���Է����֡� �������ٽ�����λ�Ĵ������Ա�ÿ�����¿��Բ�������һ�� һ�ν�����ѡ���������ˣ�������վ����������λ��
 *
 * �˺���λ�� 0 �� 2N-1 ��������ʾ�������ǰ�˳���ţ���һ���� (0, 1)���ڶ����� (2, 3)���Դ����ƣ����һ���� (2N-2, 2N-1)��
 *
 * ��Щ���µĳ�ʼ��λ  row[i] �������ʼ���ڵ� i ����λ�ϵ��˾����ġ�
 *
 * ʾ�� 1:
 *
 * ����: row = [0, 2, 1, 3]
 * ���: 1
 * ����: ����ֻ��Ҫ����row[1]��row[2]��λ�ü��ɡ�
 * ʾ�� 2:
 *
 * ����: row = [3, 2, 0, 1]
 * ���: 0
 * ����: ���轻����λ�����е����¶��Ѿ�������ǣ���ˡ�
 * ˵��:
 *
 * len(row) ��ż������ֵ�� [4, 60]��Χ�ڡ�
 * ���Ա�֤row ������ 0...len(row)-1 ��һ��ȫ���С�
 */
public class MinSwapsCouples {

    // ���鼯
    public int minSwapsCouples(int[] row) {
        int len = row.length;
        int  N = len / 2;
        UnionFind uf = new UnionFind(N);
        for (int i = 0; i < len; i += 2) {
            uf.union(row[i] / 2, row[i + 1] / 2);
        }
        return N - uf.getCount();
    }
}
