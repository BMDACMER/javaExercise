package guohaoAlgorithm.dynamic;

import java.util.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/20 21:28
 *
 * 740. ɾ�����õ���
 *
 * ��̬�滮
 */
public class DeleteAndEarn {

    /**
     * ˼·������������Ԫ�أ��ǵ�ǰԪ��Ϊnum[i]��������ֵnum[i]-1, num[i-2]����ʣ��Ԫ�ش�ŵ�������
     * �����ǰԪ�ص�����Ԫ���ڶ����У�����Ӷ�����ȫ��ɾ������Ҫ����hashset���������԰Ѷ�γ��ֵ���ͬԪ�ض�ɾ����
     * ������в�Ϊ�գ��Ӷ�����ȡ��һ��Ԫ�أ��ۼӣ�������������ֵ���ظ�����������ֱ������Ϊ�ա�����ɾ����ǰԪ��nums[i]��
     * ��õĵ����浽ArrayList�У�  ���α�������Ԫ�أ����ȡ���������������ء�
     *
     * ������ [3,7,10,5,2,4,8,9,9,4,9,2,6,4,6,5,4,7,6,10]��������һֱ�����ˣ����ʴ������
     * @param nums
     * @return
     */
    public int deleteAndEarn2(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        ArrayList<Integer> dp = new ArrayList<>();

        int ans;
        HashSet<Integer> set = new HashSet<>();  // ���������ظ�����
        for (int i = 0; i < n; i++) {
            // ������ͬԪ���ظ�����  ����[2,2,2,3,4,4,5]  ����������2   �����ٴ�����2������  ֱ����3���λ��
            if (set.contains(i)) continue;
            set.add(i);

            ans = nums[i];
            int left = nums[i] - 1, right = nums[i] + 1;
            HashMap<Integer, Integer> map = new HashMap<>();   // map��-----> ������������ɾ����ͬԪ��
            Deque<Integer> queue = new ArrayDeque<>();

            // �����˵�ǰԪ���������Ԫ�ض����
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    map.put(nums[j], map.getOrDefault(nums[j],0) + 1);
                    queue.offer(nums[j]);
                }
            }

            while (!queue.isEmpty()) {
                // �Ƴ��������뵱ǰԪ�����ڵ�Ԫ��  num[i] - 1
                while (map.containsKey(left) && map.get(left) != 0) {
                    map.put(left, map.get(left) - 1);
                    queue.remove(left);
                }
                // �Ƴ��������뵱ǰԪ�����ڵ�Ԫ��  num[i] + 1
                while (map.containsKey(right) && map.get(right) != 0) {
                    map.put(right, map.get(right) - 1);
                    queue.remove(right);
                }

                // ������в�Ϊ��   Ϊ��һ�β�����׼��
                if (!queue.isEmpty()) {
                    // ȡ����ͷԪ��
                    int tmp = queue.poll();
                    // ��ǰԪ���ۼӵ����ans��
                    ans += tmp;
                    // ��ǰԪ�ص�����Ԫ��
                    left = tmp - 1;
                    right = tmp + 1;
                }
            }
            dp.add(ans);
        }

        // Ѱ��dp������Ԫ��
        int max = dp.get(0);
        for(int num : dp) {
            max = Math.max(max, num);
        }
        return max;
    }

    /**
     * ��̬�滮   �����ҽ���
     * �ο���https://leetcode-cn.com/problems/delete-and-earn/solution/ru-guo-ni-li-jie-liao-da-jia-jie-she-zhe-ti-ni-ken/
     * @param
     */
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        // ����������  ת���� ��ҽ�������
        // Ѱ�����ֵ
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
        }

        int[] dp = new int[max + 1];
        int [] help = new int[max + 1];
        for (int num : nums) {
            help[num]++;
        }

        dp[0] = 0;
        dp[1] = help[1];
        for (int i = 2; i < dp.length; ++i) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + help[i] * i);
        }
        return dp[max];
    }

    public static void main(String[] args) {
        DeleteAndEarn d = new DeleteAndEarn();
        int[] nums = {3,7,10,5,2,4,8,9,9,4,9,2,6,4,6,5,4,7,6,10};
        System.out.println(d.deleteAndEarn2(nums));
    }
}
