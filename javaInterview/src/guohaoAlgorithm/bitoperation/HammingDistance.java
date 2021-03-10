package guohaoAlgorithm.bitoperation;

/**
 * @Author guohao
 * @Date 2021/3/10 9:41
 * @Version 1.0
 *
 * 461. ��������
 * ��������֮��ĺ�������ָ�������������ֶ�Ӧ������λ��ͬ��λ�õ���Ŀ��
 *
 * ������������ x �� y����������֮��ĺ������롣
 *
 * ע�⣺
 * 0 �� x, y < 231.
 *
 * ʾ��:
 *
 * ����: x = 1, y = 4
 *
 * ���: 2
 *
 * ����:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ��   ��
 *
 * ����ļ�ͷָ���˶�Ӧ������λ��ͬ��λ�á�
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int ans = 0;
        ans = Integer.bitCount(x ^ y);
        return ans;
    }

    // ������������
    public int hammingDistance2(int x, int y) {
        int distance = 0;
        int xor = x ^ y;
        while (xor != 0) {
            if ((xor&1) == 1) {
                distance++;
            }
            xor>>=1;
        }
        return distance;
    }

    public static void main(String[] args) {
        HammingDistance h = new HammingDistance();
        System.out.println(h.hammingDistance2(2,4));
    }
}
