package guohaoAlgorithm.design;

import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/29 22:43
 *
 * 参考P346-347
 */
public class NestedInteger {

    private Integer val;
    private List<NestedInteger> list;

    public NestedInteger(Integer val, List<NestedInteger> list) {
        this.val = val;
        this.list = list;
    }

    public NestedInteger(Integer val) {
        this.val = val;
        this.list = null;
    }

    public NestedInteger(List<NestedInteger> list) {
        this.list = list;
        this.val = null;
    }

    // 如果其中存的是一个整数，则返回这个整数，否则返回false
    public boolean isInteger() {
        return val != null;
    }

    // 如果其中存的是个整数，则返回整数，否则返回 null
    public Integer getInteger() {
        return this.val;
    }

    // 如果其中存的是一个列表，则返回这个列表，否则返回 null
    public List<NestedInteger> getList() {
        return this.list;
    }
}
