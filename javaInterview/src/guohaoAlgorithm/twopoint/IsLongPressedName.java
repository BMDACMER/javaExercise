package guohaoAlgorithm.twopoint;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/22 13:26
 *
 * 925. ��������
 */
public class IsLongPressedName {

    /**
     * ˼·��typed�ַ��� Ҫ����Ҫ�� ֻ�������������������
     * 1�� name[i] == typed[j]   i++,j++
     * 2��j > 0  type[j] == type[j-1]  j++;
     * �������name��δ���ֵ��ַ���Ϊfalse
     * @param name
     * @param typed
     * @return
     */
    public boolean isLongPressedName(String name, String typed) {
        if (name == null || typed == null || "".equals(name) || "".equals(typed)) return false;
        if (name.length() > typed.length()) return false;

        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }

    public static void main(String[] args) {
        IsLongPressedName test = new IsLongPressedName();
        System.out.println(test.isLongPressedName("alex", "aaleexa"));
    }
}
