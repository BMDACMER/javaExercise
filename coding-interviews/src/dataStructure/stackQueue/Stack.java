package dataStructure.stackQueue;

public interface Stack<E> {

    int getSize();   // Ĭ�Ͼ���public����
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
