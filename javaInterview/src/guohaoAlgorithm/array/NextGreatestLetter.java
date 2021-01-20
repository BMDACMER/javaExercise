package guohaoAlgorithm.array;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/20 20:56
 */
public class NextGreatestLetter {

    // ʱ�临�Ӷ�Ϊ O��N��   �ռ临�Ӷ�ΪO(1)
    public char nextGreatestLetter(char[] letters, char target) {
        for (char c : letters) {
            if (c > target) return c;
        }
        return letters[0];
    }

    // ���ֲ���   ʱ�临�Ӷ�ΪO(logn)  �ռ临�Ӷ�ΪO(1)
    public char nextGreatestLetter2(char[] letters, char target) {
        int left = 0, right = letters.length;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (letters[mid] <= target) left = mid + 1;
            else right = mid;
        }
        return letters[left % letters.length];
    }

}
