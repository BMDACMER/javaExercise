import java.util.HashMap;
import java.util.Map;

/**
 * ����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬
 * ��һ������ָ��ָ������һ���ڵ㣩�����ؽ��Ϊ���ƺ��������head��
 * ��ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
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
        // ȥ�����������н��Ԫ����ԭ����ڵ�Ԫ����������ڵ�Ԫ��֮���ӳ���ϵ
        while (randomListNode != null) {
            RandomListNode node = new RandomListNode(randomListNode.label);
            map.put(randomListNode, node);
            randomListNode = randomListNode.next;
        }
        // ȥ������������ÿ�����Ľṹ��ϵ������ԭ����Ľ��Ľṹ��ϵ��
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