package С��;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/8 18:44
 * ��һ��  ����������
 * ��������Ƿ���ȷ
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String str = sc.next();
            String[] arr = str.split(" ");
            // �������ж��߼�
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].length() < 8 || arr[i].length() > 120) {
                    System.out.println("1");
                } else {
                    // ���ַ����е�ÿ��Ԫ�ؼ��
                    int num1 = 0;  // ͳ������
                    int num2 = 0;  // ͳ�ƴ�д��ĸ
                    int num3 = 0;  // ͳ��Сд��ĸ
                    for (int j = 0; j < arr[i].length(); j++) {
                        if (arr[i].charAt(j) >= '0' && arr[i].charAt(j) <= '9') {
                            num1++;
                        } else if (arr[i].charAt(j) >= 'A' && arr[i].charAt(j) <= 'Z') {
                            num2++;
                        } else if (arr[i].charAt(j) >= 'a' && arr[i].charAt(j) <= 'z') {
                            num3++;
                        }
                    }
                    int num4 = arr[i].length() - num1 - num2 - num3;
                    if (num1 > 0 && num2 > 0 && num3 > 0 && num4 > 0) {
                        System.out.println("0");
                    } else {
                        System.out.println("2");
                    }
                }

            }
        }
    }
}
