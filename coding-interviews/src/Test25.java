import java.util.HashMap;
import java.util.Map;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Test25 {

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }

    }
    public RandomListNode Clone(RandomListNode pHead) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode randomListNode = pHead;
        // 去创建新链表中结点元素与原链表节点元素与新链表节点元素之间的映射关系
        while (randomListNode != null) {
            RandomListNode node = new RandomListNode(randomListNode.label);
            map.put(randomListNode, node);
            randomListNode = randomListNode.next;
        }
        // 去创建新链表中每个结点的结构关系（根据原链表的结点的结构关系）
        randomListNode = pHead;
        while (randomListNode != null) {
            RandomListNode node = map.get(randomListNode);
            node.next = map.get(randomListNode.next);
            node.random = map.get(randomListNode.random);
            randomListNode = randomListNode.next;
        }
        return map.getOrDefault(pHead, null);
    }
}