package guohaoAlgorithm.design;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/28 12:49
 *
 * �ο�P221ҳ
 */
public class DoubleList {
    // ͷβ���ڵ�
    private Node head, tail;
    // ����Ԫ��
    private int size;

    public DoubleList() {
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }

    // ������β����ӽڵ�
    public void addLast(Node node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
        size++;
    }

    // �Ƴ��ڵ�
    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    // �Ƴ��ײ��ڵ�
    public Node removeFirst() {
        if (head.next == tail) return null;
        Node first = head.next;
        remove(first);
        return first;
    }
    // ����������Ԫ�ظ���
    public int size() {
        return this.size;
    }
}
