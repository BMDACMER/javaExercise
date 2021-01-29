package guohaoAlgorithm.design;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/29 22:42
 *
 * 341. ��ƽ��Ƕ���б������
 * ����һ��Ƕ�׵������б��������һ����������ʹ���ܹ�������������б��е�����������
 *
 * �б��е�ÿһ�����Ϊһ����������������һ���б������б��Ԫ��Ҳ�������������������б�
 *
 *
 *
 * ʾ�� 1:
 *
 * ����: [[1,1],2,[1,1]]
 * ���: [1,1,2,1,1]
 * ����: ͨ���ظ����� next ֱ�� hasNext ���� false��next ���ص�Ԫ�ص�˳��Ӧ����: [1,1,2,1,1]��
 */
public class NestedIterator implements Iterator<Integer> {

    /// ִ�к�ʱ 2ms   ����java�û�100%   75%
    private Iterator<Integer> it;

    public NestedIterator(List<NestedInteger> nestedList) {
        // ��Ž�nestedList��ƽ��Ľ��
        LinkedList<Integer> res = new LinkedList<>();
        for(NestedInteger node : nestedList) {
            // ��ÿ����Ϊ�ڵ����
            traverse(node, res);
        }
        this.it = res.iterator();
    }

    private void traverse(NestedInteger node, LinkedList<Integer> res) {
        if (node.isInteger()) {
            res.add(node.getInteger());
            return;
        }

        // �������
        for (NestedInteger child : node.getList()) {
            traverse(child, res);
        }
    }

    @Override
    public Integer next() {
        return it.next();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }
}
