package guohaoAlgorithm.string;

/**
 * @Author guohao
 * @Date 2021/3/10 10:10
 * @Version 1.0
 *
 * 38. �������
 * ����һ�������� n �����������еĵ� n �
 *
 * ��������С���һ���������У������� 1 ��ʼ�������е�ÿһ��Ƕ�ǰһ���������
 *
 * ����Խ����������ɵݹ鹫ʽ����������ַ������У�
 *
 * countAndSay(1) = "1"
 * countAndSay(n) �Ƕ� countAndSay(n-1) ��������Ȼ��ת������һ�������ַ�����
 * ǰ�������£�
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * ��һ�������� 1
 * ����ǰһ�������� 1 �� �� һ �� 1 �������� "11"
 * ����ǰһ�������� 11 �� �� �� �� 1 �� ������ "21"
 * ����ǰһ�������� 21 �� �� һ �� 2 + һ �� 1 �� ������ "1211"
 * ����ǰһ�������� 1211 �� �� һ �� 1 + һ �� 2 + �� �� 1 �� ������ "111221"
 */
public class CountAndSay {
    // ֱ�ӱ������  ����Ҫ�� 1<=n<=30
    // �ο���https://leetcode-cn.com/problems/count-and-say/solution/shua-chuan-lc-100-mo-ni-ti-shi-yong-shao-w8jl/
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = nextString(s);
        }
        return s;
    }

    private String nextString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int cnt = 1;
        char ch = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == ch) {
                cnt++;
            }else {
                sb.append(cnt);
                sb.append(ch);

                ch = chars[i];
                cnt = 1;
            }
        }
        // �����һ��Ҳ�Ž�ȥ
        sb.append(cnt);
        sb.append(ch);
        return sb.toString();
    }

    public static void main(String[] args) {
        CountAndSay c = new CountAndSay();
        for (int i = 1; i <= 8; i++) {
            System.out.println(c.countAndSay(i));
        }
    }
}
