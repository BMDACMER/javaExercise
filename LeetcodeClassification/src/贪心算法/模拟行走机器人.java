package 贪心算法;

import java.util.HashSet;
import java.util.Set;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/6 18:44
 * 874 模拟行走机器人
 * 参考：https://leetcode-cn.com/problems/walking-robot-simulation/solution/mo-ni-xing-zou-ji-qi-ren-by-intgrp/
 */
public class 模拟行走机器人 {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0;
        int dir_index = 0;
        int ans = 0;
        Set<String> blockSet = new HashSet<String>();
        for (int i = 0; i < obstacles.length; i++) {
            blockSet.add(obstacles[i][0] + "," + obstacles[i][1]);
        }

        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -1) {
                dir_index = (dir_index + 1) % 4;
            } else if (commands[i] == -2) {
                dir_index = (dir_index + 3) % 4;
            } else if (commands[i] > 0) {
                for (int j = 1; j <= commands[i]; j++) {
                    int next_x = x + dir[dir_index][0];
                    int next_y = y + dir[dir_index][1];
                    if (blockSet.contains(next_x + "," + next_y)) {
                        break;
                    } else {
                        x = next_x;
                        y = next_y;
                        ans = Math.max(ans, x * x + y * y);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        模拟行走机器人 m = new 模拟行走机器人();
        int[] commands = {4,-1,4,-2,4};
        int[][] obstacles = {{2,4}};
        System.out.println(m.robotSim(commands, obstacles));
    }
}
