package xiaohaoAlgorithm.array;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/4 16:07
 *
 * 341. 扁平化嵌套列表迭代器
 */
public class NestedIterator implements Iterator<Integer> {

    private Iterator<Integer> it;

    // 构造器输入一个NestedInteger 列表
    public NestedIterator(List<NestedInteger> nestedList) {
        // 存放将nestedList打平的结果
        List<Integer> result = new LinkedList<>();
        for (NestedInteger node : nestedList) {
            traverse(node, result);
        }
        // 得到result列表的迭代器
        this.it = result.iterator();
    }

    // 返回下一个整数
    @Override
    public Integer next() {
        return it.next();
    }

    // 是否还有下一个元素
    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    // 遍历以root为根的多叉树，将叶子节的值加入result列表
    private void traverse(NestedInteger root, List<Integer> result) {
        if (root.isInteger()) {
            // 达到叶节点
            result.add(root.getInteger());
            return;
        }
        // 遍历框架
        for (NestedInteger child : root.getList()) {
            traverse(child, result);
        }
    }
}
