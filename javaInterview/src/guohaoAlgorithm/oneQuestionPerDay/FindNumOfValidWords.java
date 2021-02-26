package guohaoAlgorithm.oneQuestionPerDay;

import java.util.*;

/**
 * @Author guohao
 * @Date 2021/2/26 9:09
 * @Version 1.0
 *
 * 1178. ������
 * ������˷����й����������һ��Ӣ�İ������С��Ϸ���������²¿��ɡ�
 *
 * ���յ����� puzzle ���ַ�����ʽ���������һ������ word ��������������������ô���Ϳ��������յף�
 *
 * ���� word �а������� puzzle �ĵ�һ����ĸ��
 * ���� word �е�ÿһ����ĸ������������ puzzle ���ҵ���
 * ���磬������յ������� "abcdefg"����ô������Ϊ�յ׵ĵ����� "faced", "cabbage", �� "baggage"���� "beefed"��������ĸ "a"���Լ� "based"�����е� "s" û�г����������У���
 * ����һ�������� answer�������е�ÿ��Ԫ�� answer[i] ���ڸ����ĵ����б� words �п�����Ϊ�������� puzzles[i] ����Ӧ���յ׵ĵ�����Ŀ��
 *
 *
 * ���룺
 * words = ["aaaa","asas","able","ability","actt","actor","access"],
 * puzzles = ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
 * �����[1,1,3,2,4,0]
 * ���ͣ�
 * 1 �����ʿ�����Ϊ "aboveyz" ���յ� : "aaaa"
 * 1 �����ʿ�����Ϊ "abrodyz" ���յ� : "aaaa"
 * 3 �����ʿ�����Ϊ "abslute" ���յ� : "aaaa", "asas", "able"
 * 2 �����ʿ�����Ϊ "absoryz" ���յ� : "aaaa", "asas"
 * 4 �����ʿ�����Ϊ "actresz" ���յ� : "aaaa", "asas", "actt", "access"
 * û�е��ʿ�����Ϊ "gaswxyz" ���յף���Ϊ�б��еĵ��ʶ�������ĸ 'g'��
 *
 * ��ʾ��
 *
 * 1 <= words.length <= 10^5
 * 4 <= words[i].length <= 50
 * 1 <= puzzles.length <= 10^4
 * puzzles[i].length == 7
 * words[i][j], puzzles[i][j] ����СдӢ����ĸ��
 * puzzles[i] ���������ַ������ظ���
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/number-of-valid-words-for-each-puzzle
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class FindNumOfValidWords {

    // �����㷨  --- ͨ�� 9/10   ��ʱ
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        int n = puzzles.length;
        List<Integer> res = new ArrayList<>(n);
        int m = words.length;
        for (int i = 0; i < n; i++) {
            char[] str = puzzles[i].toCharArray();
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < str.length; j++) {
                set.add(str[j]);
            }
            int count = 0;
            // �Ƚ� words �����ַ�
            for (int j = 0; j < m; j++) {
                char[] word = words[j].toCharArray();
                Set<Character> set2 = new HashSet<>();
                boolean flag = true;
                for (char c : word) {
                    if (!set.contains(c)) {
                        flag = false;
                        break;
                    }
                    set2.add(c);
                }

                if (flag && set2.contains(str[0]) && set.containsAll(set2))
                    count++;
            }
            res.add(count);
        }
        return res;
    }

    // �Ż��㷨 https://leetcode-cn.com/problems/number-of-valid-words-for-each-puzzle/solution/cai-zi-mi-by-leetcode-solution-345u/
    public List<Integer> findNumOfValidWords2(String[] words, String[] puzzles) {
        Map<Integer, Integer> frequency = new HashMap<Integer, Integer>();

        for (String word : words) {
            int mask = 0;
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                mask |= (1 << (ch - 'a'));
            }
            if (Integer.bitCount(mask) <= 7) {
                frequency.put(mask, frequency.getOrDefault(mask, 0) + 1);
            }
        }

        List<Integer> ans = new ArrayList<Integer>();
        for (String puzzle : puzzles) {
            int total = 0;

            // ö���Ӽ�����һ
            // for (int choose = 0; choose < (1 << 6); ++choose) {
            //     int mask = 0;
            //     for (int i = 0; i < 6; ++i) {
            //         if ((choose & (1 << i)) != 0) {
            //             mask |= (1 << (puzzle.charAt(i + 1) - 'a'));
            //         }
            //     }
            //     mask |= (1 << (puzzle.charAt(0) - 'a'));
            //     if (frequency.containsKey(mask)) {
            //         total += frequency.get(mask);
            //     }
            // }

            // ö���Ӽ�������
            int mask = 0;
            for (int i = 1; i < 7; ++i) {
                mask |= (1 << (puzzle.charAt(i) - 'a'));
            }
            int subset = mask;
            do {
                int s = subset | (1 << (puzzle.charAt(0) - 'a'));
                if (frequency.containsKey(s)) {
                    total += frequency.get(s);
                }
                subset = (subset - 1) & mask;
            } while (subset != mask);

            ans.add(total);
        }
        return ans;
    }
}
