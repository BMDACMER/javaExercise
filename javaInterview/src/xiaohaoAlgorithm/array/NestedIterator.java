package xiaohaoAlgorithm.array;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/4 16:07
 *
 * 341. ��ƽ��Ƕ���б������
 */
public class NestedIterator implements Iterator<Integer> {

    private Iterator<Integer> it;

    // ����������һ��NestedInteger �б�
    public NestedIterator(List<NestedInteger> nestedList) {
        // ��Ž�nestedList��ƽ�Ľ��
        List<Integer> result = new LinkedList<>();
        for (NestedInteger node : nestedList) {
            traverse(node, result);
        }
        // �õ�result�б�ĵ�����
        this.it = result.iterator();
    }

    // ������һ������
    @Override
    public Integer next() {
        return it.next();
    }

    // �Ƿ�����һ��Ԫ��
    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    // ������rootΪ���Ķ��������Ҷ�ӽڵ�ֵ����result�б�
    private void traverse(NestedInteger root, List<Integer> result) {
        if (root.isInteger()) {
            // �ﵽҶ�ڵ�
            result.add(root.getInteger());
            return;
        }
        // �������
        for (NestedInteger child : root.getList()) {
            traverse(child, result);
        }
    }
}
