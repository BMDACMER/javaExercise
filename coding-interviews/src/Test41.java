import java.util.*;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class Test41 {
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i],1);
            } else {
                map.put(array[i],map.get(array[i]) + 1);
            }
        }

        // 统计了数组中个数字出现的次数，只要将value中值为1的数字输出即可
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
     <<      :     左移运算符，num << 1,相当于num乘2
     >>      :     右移运算符，num >> 1,相当于num除2
     >>>(无符号右移)  无符号右移，忽略符号位，空位都以0补齐
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
