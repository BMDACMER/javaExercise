package guohaoAlgorithm.��ָoffer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/5 11:25
 *
 * ��ָ Offer 59 - II. ���е����ֵ
 * �붨��һ�����в�ʵ�ֺ��� max_value �õ�����������ֵ��Ҫ����max_value��push_back �� pop_front �ľ�̯ʱ�临�Ӷȶ���O(1)��
 *
 * ������Ϊ�գ�pop_front �� max_value?��Ҫ���� -1
 *
 * ʾ�� 1��
 *
 * ����:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * ���:?[null,null,null,2,1,2]
 * ʾ�� 2��
 *
 * ����:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * ���:?[null,-1,-1]
 *
 */
public class MaxQueue {

    Queue<Integer> queue;
    Deque<Integer> deque;
    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!deque.isEmpty() && deque.peekLast() < value) {
            deque.pollLast();
        }
        deque.offerLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) return -1;
        if (queue.peek().equals(deque.peekFirst()))
            deque.pollFirst();
        return queue.poll();
    }
}
