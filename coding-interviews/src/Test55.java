import java.util.HashMap;

/**
 * ��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ������磬�����ַ�����ֻ����ǰ�����ַ�"go"ʱ��
 * ��һ��ֻ����һ�ε��ַ���"g"�� ���Ӹ��ַ����ж���ǰ�����ַ���google"ʱ����һ��ֻ����һ�ε��ַ���"l"��
 */
public class Test55 {
    HashMap<Character,Integer> map = new HashMap<>();
    StringBuilder sb = new StringBuilder();
    int index = 0;

    //Insert one char from stringstream
    public void Insert(char ch)
    {
        sb.append(ch);
        map.put(ch,map.getOrDefault(ch,0) + 1);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        while (index < sb.length()) {
            if (map.get(sb.charAt(index)) == 1) {
                return sb.charAt(index);
            }
            index++;
        }
        return '#';
    }
}
