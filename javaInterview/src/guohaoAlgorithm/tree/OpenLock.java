package guohaoAlgorithm.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/21 22:47
 *
 * 752. 打开转盘锁
 */
public class OpenLock {

    // bfs   转换为树的遍历
    public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        Set<String> dead = new HashSet<>();
        Set<String> visited = new HashSet<>();
        int ans = 0;
        for (String str : deadends) {
            dead.add(str);
        }
        q.add("0000");
        visited.add("0000");
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String node = q.poll();
                if (dead.contains(node))
                    continue;
                if (node.equals(target))  return ans;
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(node, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(node, j);
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            ans++;
        }
        return -1;
    }

    private String minusOne(String node, int j) {
        char[] chars = node.toCharArray();
        if (chars[j] == '0')
            chars[j] = '9';
        else chars[j] -= 1;
        return new String(chars);
    }

    private String plusOne(String node, int j) {
        char[] chars = node.toCharArray();
        if (chars[j] == '9')
            chars[j] = '0';
        else
            chars[j] += 1;
        return new String(chars);
    }

    // 优化
    public int openLock2(String[] deadends, String target) {
        Set<String> dead = new HashSet<>();
        for (String str : deadends) dead.add(str);
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        Set<String> visited = new HashSet<>();
        int ans = 0;
        q1.add("0000");
        q2.add(target);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.size() > q2.size()) {
                Set<String> tmp = q1;
                q1 = q2;
                q2 = tmp;
            }
            Set<String> tmp = new HashSet<>();

            for (String cur : q1) {
                if (dead.contains(cur)) continue;
                if (q2.contains(cur)) return ans;

                visited.add(cur);

                for (int i = 0; i < 4; i++) {
                    String up = plusOne(cur, i);
                    if (!visited.contains(up)) {
                        tmp.add(up);
                    }
                    String down = minusOne(cur, i);
                    if (!visited.contains(down)) {
                        tmp.add(down);
                    }
                }
            }
            ans++;
            q1 = q2;
            q2 = tmp;
        }
        return -1;
    }
}
