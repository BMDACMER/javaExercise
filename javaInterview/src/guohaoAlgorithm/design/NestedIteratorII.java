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
 * 参考P350
 */
public class NestedIteratorII implements Iterator<Integer> {

    // 更加高效方法  然而效率更低  运行5ms
    LinkedList<NestedInteger> res;
    public NestedIteratorII(List<NestedInteger> nestedList) {
        res = new LinkedList<>(nestedList);
    }

    @Override
    public Integer next() {
        // hasNet方法保证了第一个元素一定是整数类型
        return res.remove(0).getInteger();
    }

    @Override
    public boolean hasNext() {
        // 循环拆分列表元素，直到列表第一个元素是整数类型
        while (!res.isEmpty() && !res.get(0).isInteger()) {
            // 当列表第一个元素是列表类型时，进入循环
            List<NestedInteger> first = res.remove(0).getList();
            // 将第一个列表打平并按顺序添加到开头
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
