package guohaoAlgorithm.springoffer.genshuixue;

import java.util.Scanner;

/**
 * @Author guohao
 * @Date 2021/2/28 19:09
 * @Version 1.0
 * 1�����ֲ���
 *
 * ���Ҷ�λ
 * ʱ�����ƣ� 3000MS
 * �ڴ����ƣ� 589824KB
 * ��Ŀ������
 * ����һ��������������һ��Ŀ��ֵ����������������ҵ����ֵ�򷵻��±꣬���û�У��򷵻ظ�ֵ����������λ���±ꡣʱ�临�Ӷ���Ҫ<=O(log n)
 *
 *
 *
 * ��������
 * ��һ������һ������������һ�������������
 *
 * �ڶ�������һ������������Ŀ��ֵ
 *
 * �������
 * ���һ�У�����һ������������Ŀ��ֵ��������λ�õ��±�
 *
 *
 * ��������
 * 1 3 5 6
 * 5
 * �������
 * 2
 */
public class Main1 {

    public static int help(int[] nums, int number) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (number == nums[mid]) {
                return mid;
            }else if (number > nums[mid]){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c >= '0' && c <= '9') {
                sb.append(c);
            }
        }
        int[] nums = new int[sb.length()];
        for (int i = 0; i < sb.length(); i++) {
            nums[i] = sb.charAt(i) - '0';
        }
        int k = scan.nextInt();
        System.out.println(help(nums, k));
    }
}
