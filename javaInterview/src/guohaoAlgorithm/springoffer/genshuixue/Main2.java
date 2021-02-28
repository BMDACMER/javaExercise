package guohaoAlgorithm.springoffer.genshuixue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Author guohao
 * @Date 2021/2/28 19:31
 * @Version 1.0
 *
 * �жϴ���
 * ʱ�����ƣ� 3000MS
 * �ڴ����ƣ� 589824KB
 * ��Ŀ������
 * �жϸ�����Ӣ�ĵ��������Ƿ񹹳ɴ�����ǰ���������ʣ���ĸ������һһ��Ӧ�����ҽ���һ����ĸ��ͬ��
 * ��abc��abd��ɴ�����abc��ab�����ɴ�����abc�� bcd�����ɴ�����
 *
 * �ָ���һ������N��Ӣ�ĵ������飬���������ڵ�N-1�鵥�ʣ����ܹ��ɴ���������
 *
 * ��������
 * ��һ�ж���һ���������������鳤�� N
 *
 * ֮�����N���ַ�����ÿһ���ַ������������е�һ������
 *
 * �������
 * ���һ�У�����һ�����������������в��ܹ��ɴ��������������ܹ��ɴ������0
 *
 *
 * ��������
 * 4
 * ape
 * app
 * ppa
 * pp
 * �������
 * 2
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = scan.nextLine();
        }

        // �㷨����
        String base = strs[0];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            int count = 0;
            if (base.length() == strs[i].length()) {
                for (int j = 0; j < base.length(); j++) {
                    if (base.charAt(j) != strs[i].charAt(j)) {
                        count++;
                    }
                }
                // ����count=1  ����Ϊ����
                if (count != 1) ans++;
            } else {
                ans++;
            }
            base = strs[i];
        }
        System.out.println(ans);
    }
}
