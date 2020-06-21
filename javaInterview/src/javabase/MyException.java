package javabase;

public class MyException extends Exception {
    static final long serialVersionUID = 121565745724L;

    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}
