package xiaohaoAlgorithm.oneQuestionPerDay;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/20 10:32
 *
 * 316. 去除重复字母
 */
public class RemoveDuplicateLetters {

    /**
     * 1、需要借助栈，作为辅助的数据结构
     * 2、需要记录每一个字符最后一次出现的字符
     * 3、判断当前读到的字母在栈中是否已经出现
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        int len = s.length();

        char[] charArray = s.toCharArray();
        int[] lastIndex = new int[26];
        for (int i = 0; i < len; i++) {
            lastIndex[charArray[i] - 'a'] = i;
        }

        Deque<Character> stack = new ArrayDeque<Character>();
        boolean[] visited = new boolean[26];
        for (int i = 0; i < len; i++) {
            if (visited[charArray[i] - 'a'])
                continue;
            // 当栈不为空且要装进的字符比栈顶元素大，且栈顶元素后续还会出现
            while (!stack.isEmpty() && stack.peekLast() > charArray[i] && lastIndex[stack.peekLast() - 'a'] > i) {
                Character top = stack.removeLast();
                visited[top - 'a'] = false;
            }

            stack.addLast(charArray[i]);
            visited[charArray[i] - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}
