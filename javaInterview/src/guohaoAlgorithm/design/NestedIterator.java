package guohaoAlgorithm.design;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/29 22:42
 *
 * 341. 扁平化嵌套列表迭代器
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 *
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 */
public class NestedIterator implements Iterator<Integer> {

    /// 执行耗时 2ms   击败java用户100%   75%
    private Iterator<Integer> it;

    public NestedIterator(List<NestedInteger> nestedList) {
        // 存放将nestedList打平后的结果
        LinkedList<Integer> res = new LinkedList<>();
        for(NestedInteger node : nestedList) {
            // 以每个根为节点遍历
            traverse(node, res);
        }
        this.it = res.iterator();
    }

    private void traverse(NestedInteger node, LinkedList<Integer> res) {
        if (node.isInteger()) {
            res.add(node.getInteger());
            return;
        }

        // 遍历框架
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
