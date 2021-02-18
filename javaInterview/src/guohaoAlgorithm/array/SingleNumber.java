package guohaoAlgorithm.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author guohao
 * @Date 2021/2/18 12:28
 * @Version 1.0
 *
 * 136. ֻ����һ�ε�����
 * ����һ���ǿ��������飬����ĳ��Ԫ��ֻ����һ�����⣬����ÿ��Ԫ�ؾ��������Ρ��ҳ��Ǹ�ֻ������һ�ε�Ԫ�ء�
 *
 * ˵����
 *
 * ����㷨Ӧ�þ�������ʱ�临�Ӷȡ� ����Բ�ʹ�ö���ռ���ʵ����
 *
 * ʾ�� 1:
 *
 * ����: [2,2,1]
 * ���: 1
 * ʾ�� 2:
 *
 * ����: [4,1,2,1,2]
 * ���: 4
 */
public class SingleNumber {

    /**
     * �����ɣ�a ^ b ^ c <=> a ^ c ^ b
     *
     * �κ�����0���Ϊ�κ��� 0 ^ n => n
     *
     * ��ͬ�������Ϊ0: n ^ n => 0
     *
     * var a = [2,3,2,4,4]
     *
     * 2 ^ 3 ^ 2 ^ 4 ^ 4�ȼ��� 2 ^ 2 ^ 4 ^ 4 ^ 3 => 0 ^ 0 ^3 => 3
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}
