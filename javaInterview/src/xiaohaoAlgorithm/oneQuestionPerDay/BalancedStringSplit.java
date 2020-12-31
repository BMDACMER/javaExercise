package xiaohaoAlgorithm.oneQuestionPerDay;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/1 0:46
 * 1221. �ָ�ƽ���ַ���
 */
public class BalancedStringSplit {
    /**
     * ��ΪS��ƽ���ַ��� ����S�ĳ���Ϊż��
     * @param s
     * @return
     */
    public int balancedStringSplit(String s) {
        int count = 0;
        int len = 0;  // �ִ���R��L�ĳ���
        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index) == 'R') len++;
            else len--;
            if (len == 0) count++;
            index++;
        }

        return count;
    }

    public static void main(String[] args) {
        BalancedStringSplit b = new BalancedStringSplit();
        System.out.println(b.balancedStringSplit("RLRRLLRLRL"));
    }
}
