package guohaoAlgorithm.springoffer.genshuixue;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author guohao
 * @Date 2021/2/28 19:39
 * @Version 1.0
 *
 * ����λ��
 * ʱ�����ƣ� 3000MS
 * �ڴ����ƣ� 589824KB
 * ��Ŀ������
 * ��������������������λ��
 *
 *
 *
 * ��������
 * ��һ������һ������������������ĳ���n
 *
 * �ڶ�������n�����������������е�n��Ԫ��
 *
 * �������
 * ��һ�а���һ�����������������������
 */
public class Main4 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int [] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        Arrays.sort(nums);
        int mid = nums.length / 2;
        System.out.println(nums[mid]);
    }

}
