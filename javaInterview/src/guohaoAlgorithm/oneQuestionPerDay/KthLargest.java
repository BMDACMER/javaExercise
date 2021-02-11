package guohaoAlgorithm.oneQuestionPerDay;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/11 9:10
 *
 * 703. �������еĵ� K ��Ԫ��
 * ���һ���ҵ��������е� k ��Ԫ�ص��ࣨclass����ע���������ĵ� k ��Ԫ�أ����ǵ� k ����ͬ��Ԫ�ء�
 *
 * ��ʵ�� KthLargest �ࣺ
 *
 * KthLargest(int k, int[] nums) ʹ������ k �������� nums ��ʼ������
 * int add(int val) �� val ���������� nums �󣬷��ص�ǰ�������е� k ���Ԫ�ء�
 *
 *
 * ʾ����
 *
 * ���룺
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * �����
 * [null, 4, 5, 5, 8, 8]
 *
 * ���ͣ�
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 *
 *
 * ��ʾ��
 * 1 <= k <= 104
 * 0 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * -104 <= val <= 104
 * ������ add ���� 104 ��
 * ��Ŀ���ݱ�֤���ڲ��ҵ� k ��Ԫ��ʱ�������������� k ��Ԫ��
 */
public class KthLargest {

    // ���ȶ���
    PriorityQueue<Integer> q;
    int k;

    public KthLargest(int k, int[] nums) {
        q = new PriorityQueue<>(k);  // ����С����
        this.k = k;
        for (int num : nums)
            add(num);
    }

    public int add(int val) {
        if (q.size() < k) {
            q.offer(val);
        } else if (q.peek() < val) {
            q.poll();
            q.offer(val);
        }
        return q.peek();
    }
}
