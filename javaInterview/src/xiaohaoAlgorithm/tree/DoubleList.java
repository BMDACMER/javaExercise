package xiaohaoAlgorithm.tree;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/19 10:06
 */
public class DoubleList {
    // 头尾虚节点
    private Node head, tail;
    // 链表元素数
    private int size;

    public DoubleList() {
        // 初始化双向链表的数据
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    // 在链表尾部添加节点x，时间复杂度为O(1)
    public void addLast(Node x) {
        x.prev = tail.prev;
        tail.prev.next = x;
        x.next = tail;
        tail.prev = x;
        size++;
    }

    // 删除链表中x节点（x一定存在）
    // 由于是双链表且给的是目标Node节点，时间复杂度为O(1)
    public void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    // 删除链表中第一个节点，并返回该节点，时间复杂度为O(1)
    public Node removeFirst() {
        if (head.next == tail)
            return null;
        Node first = head.next;
        remove(first);
        return first;
    }

    // 返回链表的长度，时间复杂度为O(1)
    public int size() {
        return size;
    }
}
