package guohaoAlgorithm.design;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/29 22:53
 *
 *
 * �ο�P350
 */
public class NestedIteratorII implements Iterator<Integer> {

    // ���Ӹ�Ч����  Ȼ��Ч�ʸ���  ����5ms
    LinkedList<NestedInteger> res;
    public NestedIteratorII(List<NestedInteger> nestedList) {
        res = new LinkedList<>(nestedList);
    }

    @Override
    public Integer next() {
        // hasNet������֤�˵�һ��Ԫ��һ������������
        return res.remove(0).getInteger();
    }

    @Override
    public boolean hasNext() {
        // ѭ������б�Ԫ�أ�ֱ���б��һ��Ԫ������������
        while (!res.isEmpty() && !res.get(0).isInteger()) {
            // ���б��һ��Ԫ�����б�����ʱ������ѭ��
            List<NestedInteger> first = res.remove(0).getList();
            // ����һ���б��ƽ����˳����ӵ���ͷ
//            for (NestedInteger node : first) {
//                res.addLast(node);
//            }
            for (int i = first.size() - 1; i >= 0; --i) {
                res.addFirst(first.get(i));
            }
        }
        return !res.isEmpty();
    }
}
