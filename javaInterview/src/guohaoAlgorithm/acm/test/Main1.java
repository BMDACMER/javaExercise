package guohaoAlgorithm.acm.test;

import sun.applet.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @Author guohao
 * @Date 2021/3/5 18:18
 * @Version 1.0
 */
public class Main1 {

    // �ҳ�����B��Ԫ����A�е�Ԫ�ص��±�
    //  A[]={5,3,1,5,4}  B[] = {5,3}   ���أ�{0��1��3}
    public List<Integer> findAIndexFromB(int[] A, int[] B) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                map.get(A[i]).add(i);
                continue;
            }
            List<Integer> t = new ArrayList<>();
            t.add(i);
            map.put(A[i], t);
        }

        // ����B�е�Ԫ��
        for (int i = 0; i < B.length; i++) {
            ans.addAll(map.getOrDefault(B[i], new ArrayList<>()));
        }
        return ans;
    }


    public static void main(String[] args) {
        Main1 t = new Main1();
        int[] A = {5,3,1,5,4};
        int[] B = {5,3};
        List<Integer> aIndexFromB = t.findAIndexFromB(A, B);
        for (Integer i : aIndexFromB) {
            System.out.print(i + " ");
        }
    }
}
