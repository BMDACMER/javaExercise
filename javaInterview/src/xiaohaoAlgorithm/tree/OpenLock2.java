package xiaohaoAlgorithm.tree;

import java.util.HashSet;
import java.util.Set;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/9 9:22
 *
 * 752. 打开转盘锁
 */
public class OpenLock2 {

    /**
     * 方法二：采用双HashSet代替队列，提高效率
     * 采用该方法前提是：需要直到target
     */
    public int openLock(String[] deadends, String target) {
        // 将原来的队列换为HashSet
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();

        Set<String> visited = new HashSet<>();
        Set<String> deads = new HashSet<>();
        for (String s : deadends)
            deads.add(s);

        int step = 0;  // 统计步数
        // 初始化起点和终点
        q1.add("0000");
        q2.add(target);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.size() > q2.size()) {
                Set<String> temp = q1;
                q1 = q2;
                q2 = temp;
            }
            // 后续交换两者的元素
            Set<String> temp = new HashSet<>();
            // 从q1开始扩散
            for (String cur : q1) {
                // 判断是否达到终点
                if (deads.contains(cur))
                    continue;
                if (q2.contains(cur)) {
                    return step;
                }
                visited.add(cur);

                // 将下一个节点的 未遍历相邻节点加入集合
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
            // 换成q2扩散
            q1 = q2;
            q2 = temp;
        }
        // 没有找到
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
