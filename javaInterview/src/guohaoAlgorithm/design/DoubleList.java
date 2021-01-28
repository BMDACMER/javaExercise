package guohaoAlgorithm.design;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/28 12:49
 *
 * 参考P221页
 */
public class DoubleList {
    // 头尾两节点
    private Node head, tail;
    // 链表元素
    private int size;

    public DoubleList() {
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }

    // 在链表尾部添加节点
    public void addLast(Node node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
        size++;
    }

    // 移除节点
    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    // 移除首部节点
    public Node removeFirst() {
        if (head.next == tail) return null;
        Node first = head.next;
        remove(first);
        return first;
    }
    // 返回链表中元素个数
    public int size() {
        return this.size;
    }
}
