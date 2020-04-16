import java.util.HashMap;

/**
 * ��һ���ַ���(0<=�ַ�������<=10000��ȫ������ĸ���)
 * ���ҵ���һ��ֻ����һ�ε��ַ�,����������λ��, ���û���򷵻� -1����Ҫ���ִ�Сд��
 */
public class Test35 {
    public static int FirstNotRepeatingChar(String str) {
        if (str==null || str.length() == 0)
            return -1;

        // �yӋ�ַ������ַ����ֵĴ���
        char[] chr = str.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < chr.length; i++) {
            if (!map.containsKey(chr[i])) {
                map.put(chr[i],1);
            } else {
                map.put(chr[i],map.get(chr[i])+1);
            }
        }
        // �����������飬Ѱ���״�Ϊһ�ε��ַ���
        int i;
        for (i = 0; i < chr.length; i++) {
            if (map.get(chr[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar("sadjjjjs"));
    }
}
