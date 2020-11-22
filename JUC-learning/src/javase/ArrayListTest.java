package javase;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/4 15:41
 */
public class ArrayListTest {

    public static void main(String[] args) {
        System.out.println(5.00-4.10);
        System.out.println(300-210);
    }


    ArrayList<Integer> a1 = new ArrayList<>();
    LinkedList<Integer> l1 = new LinkedList<>();

    void init(int len) {
        for (int i = 0; i < len; i++) {
            a1.add(i);
            l1.add(i);
        }
    }

    @Test
    public void cloneTest() {

    }


    /**
     * 查询性能对比
     */


    /**
     * 插入性能对比
     */

    /**
     * 插入、删除数据
     */


}
