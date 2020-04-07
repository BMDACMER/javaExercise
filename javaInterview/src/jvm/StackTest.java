package jvm;

import java.util.Stack;

public class StackTest {
    public void methodA(){
        int i = 10;
        int j = 20;

        methodB();
    }

    private void methodB() {
        int k = 20;
        int m = 40;
    }

    public static void main(String[] args) {
        StackTest stackTest = new StackTest();
        stackTest.methodA();
    }
}
