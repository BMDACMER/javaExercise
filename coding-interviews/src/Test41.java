import java.util.*;

/**
 * һ�����������������������֮�⣬���������ֶ����������Ρ���д�����ҳ�������ֻ����һ�ε����֡�
 */
public class Test41 {
    //num1,num2�ֱ�Ϊ����Ϊ1�����顣��������
    //��num1[0],num2[0]����Ϊ���ؽ��
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i],1);
            } else {
                map.put(array[i],map.get(array[i]) + 1);
            }
        }

        // ͳ���������и����ֳ��ֵĴ�����ֻҪ��value��ֵΪ1�������������
        ArrayList<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        num1[0] = list.get(0).getKey();
        num2[0] = list.get(1).getKey();
    }

    /**
     <<      :     �����������num << 1,�൱��num��2
     >>      :     �����������num >> 1,�൱��num��2
     >>>(�޷�������)  �޷������ƣ����Է���λ����λ����0����
     * @param args
     */
    public static void main(String[] args) {
//        if(array.length < 2) return ;
//        int myxor = 0;
//        int flag = 1;
//        for(int i = 0 ; i < array.length; ++ i )
//            myxor ^= array[i];
//        while((myxor & flag) == 0) flag <<= 1;
//        // num1[0] = myxor;
//        //num2[0] = myxor;
//        for(int i = 0; i < array.length; ++ i ){
//            if((flag & array[i]) == 0) num2[0]^= array[i];
//            else num1[0]^= array[i];
//        }

    }
}
