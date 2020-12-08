package xiaohaoAlgorithm.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/8 11:32
 * 752. 打开转盘锁
 */
public class OpenLock {

    public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> deads = new HashSet<>();
        for (String dead : deadends) {
            deads.add(dead);
        }
        int step = 0;

        q.offer("0000");
        visited.add("0000");

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                String cur = q.poll();
                // 判断是否达访问过，是否到终点
                if (deads.contains(cur))
                    continue;
                if (target.equals(cur))
                    return step;

                // 将一个节点的相邻节点加入队列
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = reduceOne(cur, j);
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        // 如果穷举完都没有找到目标密码，那就是找不到了
        return -1;
    }

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
        OpenLock op = new OpenLock();
        String[] deadends = {"0202","0101","0102","1212","0201"};
        String target = "0202";
        System.out.println(op.openLock(deadends, target));;
    }

}
