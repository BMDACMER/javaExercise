package xiaohaoAlgorithm.tree;

import java.util.HashSet;
import java.util.Set;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/9 9:22
 *
 * 752. ��ת����
 */
public class OpenLock2 {

    /**
     * ������������˫HashSet������У����Ч��
     * ���ø÷���ǰ���ǣ���Ҫֱ��target
     */
    public int openLock(String[] deadends, String target) {
        // ��ԭ���Ķ��л�ΪHashSet
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();

        Set<String> visited = new HashSet<>();
        Set<String> deads = new HashSet<>();
        for (String s : deadends)
            deads.add(s);

        int step = 0;  // ͳ�Ʋ���
        // ��ʼ�������յ�
        q1.add("0000");
        q2.add(target);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.size() > q2.size()) {
                Set<String> temp = q1;
                q1 = q2;
                q2 = temp;
            }
            // �����������ߵ�Ԫ��
            Set<String> temp = new HashSet<>();
            // ��q1��ʼ��ɢ
            for (String cur : q1) {
                // �ж��Ƿ�ﵽ�յ�
                if (deads.contains(cur))
                    continue;
                if (q2.contains(cur)) {
                    return step;
                }
                visited.add(cur);

                // ����һ���ڵ�� δ�������ڽڵ���뼯��
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        temp.add(up);
                    }
                    String down = reduceOne(cur, j);
                    if (!visited.contains(down)) {
                        temp.add(down);
                    }
                }
            }
            step++;
            // ����q2��ɢ
            q1 = q2;
            q2 = temp;
        }
        // û���ҵ�
        return -1;
    }

    /*private String reduceOne(String cur, int j) {
        char[] chars = cur.toCharArray();
        if (chars[j] == '0') {
            chars[j] = '9';
        } else {
            chars[j] -= 1;
        }
        return new String(chars);
    }

    private String plusOne(String cur, int j) {
        char[] chars = cur.toCharArray();
        if (chars[j] == '9') {
            chars[j] = '0';
        } else {
            chars[j] += 1;
        }
        return new String(chars);
    }*/

    private String reduceOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0') {
            ch[j] = '9';
        } else {
            ch[j] -= 1;
        }
        return new String(ch);
    }

    private String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9') {
            ch[j] = '0';
        } else {
            ch[j] += 1;
        }
        return new String(ch);
    }

    public static void main(String[] args) {
        OpenLock2 op = new OpenLock2();
        String[] deadends = {"0201","0101","0102","1212","0202"};
        String target = "0202";
        System.out.println(op.openLock(deadends, target));;
    }

}
