package xiaohaoAlgorithm.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/7 12:46
 * 46. ȫ����
 */
public class Permute {

    static List<List<Integer>> ans = new LinkedList<>();

    public static List<List<Integer>> permute(int[] nums) {
        // ��¼·��
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return ans;
    }

    private static void backtrack(int[] nums, LinkedList<Integer> track) {
        // ��������
        if (track.size() == nums.length) {
            ans.add(new LinkedList<>(track));
            return;
        }

        // ���б���ѡ��
        for (int i = 0; i < nums.length; i++) {
            // �ų������ʵ�
            if (track.contains(nums[i]))
                continue;
            // ��ѡ��
            track.add(nums[i]);
            // ������һ�������
            backtrack(nums, track);
            // ȡ��ѡ��
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};

        List<List<Integer>> lists = permute(nums);
        for (List<Integer> list : lists) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
