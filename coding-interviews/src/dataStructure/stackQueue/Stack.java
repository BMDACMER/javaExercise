package dataStructure.stackQueue;

public interface Stack<E> {

    int getSize();   // 默认就是public类型
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
