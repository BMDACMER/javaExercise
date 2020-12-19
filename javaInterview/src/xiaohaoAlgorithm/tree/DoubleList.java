package xiaohaoAlgorithm.tree;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/19 10:06
 */
public class DoubleList {
    // ͷβ��ڵ�
    private Node head, tail;
    // ����Ԫ����
    private int size;

    public DoubleList() {
        // ��ʼ��˫�����������
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    // ������β����ӽڵ�x��ʱ�临�Ӷ�ΪO(1)
    public void addLast(Node x) {
        x.prev = tail.prev;
        tail.prev.next = x;
        x.next = tail;
        tail.prev = x;
        size++;
    }

    // ɾ��������x�ڵ㣨xһ�����ڣ�
    // ������˫�����Ҹ�����Ŀ��Node�ڵ㣬ʱ�临�Ӷ�ΪO(1)
    public void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    // ɾ�������е�һ���ڵ㣬�����ظýڵ㣬ʱ�临�Ӷ�ΪO(1)
    public Node removeFirst() {
        if (head.next == tail)
            return null;
        Node first = head.next;
        remove(first);
        return first;
    }

    // ��������ĳ��ȣ�ʱ�临�Ӷ�ΪO(1)
    public int size() {
        return size;
    }
}
