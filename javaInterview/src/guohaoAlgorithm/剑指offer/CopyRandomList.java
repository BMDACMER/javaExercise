package guohaoAlgorithm.��ָoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/3 12:13
 */
public class CopyRandomList {

    /*public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        // 3. ���Ƹ��ڵ㣬������ ��ԭ�ڵ� -> �½ڵ㡱 �� Map ӳ��
        while(cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        // 4. ����������� next �� random ָ��
        while(cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        // 5. �����������ͷ�ڵ�
        return map.get(head);
    }*/

    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Node cur = head;
        HashMap<Node, Node> map = new HashMap<>();
        // ���Ƹ��ڵ�    ԭ�ڵ�---�½ڵ�
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        // ����Դ�ڵ��next��random��
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        // ����ͷ�ڵ�
        return map.get(head);
    }
}
