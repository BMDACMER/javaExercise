package guohaoAlgorithm.剑指offer;

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
        // 3. 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
        while(cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        // 4. 构建新链表的 next 和 random 指向
        while(cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        // 5. 返回新链表的头节点
        return map.get(head);
    }*/

    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Node cur = head;
        HashMap<Node, Node> map = new HashMap<>();
        // 复制各节点    原节点---新节点
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        // 复制源节点的next、random域
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        // 返回头节点
        return map.get(head);
    }
}
