package guohaoAlgorithm.design;

import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/29 22:43
 *
 * �ο�P346-347
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

    // ������д����һ���������򷵻�������������򷵻�false
    public boolean isInteger() {
        return val != null;
    }

    // ������д���Ǹ��������򷵻����������򷵻� null
    public Integer getInteger() {
        return this.val;
    }

    // ������д����һ���б��򷵻�����б����򷵻� null
    public List<NestedInteger> getList() {
        return this.list;
    }
}
