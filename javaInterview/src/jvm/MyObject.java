package jvm;

public class MyObject {
    public static void main(String[] args) {
        Object object = new Object();
//        System.out.println(object.getClass().getClassLoader().getParent().getParent());
//        System.out.println(object.getClass().getClassLoader().getParent());  // Exception in thread "main" java.lang.NullPointerException
        System.out.println(object.getClass().getClassLoader());  // null

        System.out.println("\n\n\n\n");

        MyObject myObject = new MyObject();
        System.out.println(myObject.getClass().getClassLoader().getParent().getParent());  // null
        System.out.println(myObject.getClass().getClassLoader().getParent()); // sun.misc.Launcher$ExtClassLoader@677327b6
        System.out.println(myObject.getClass().getClassLoader()); // sun.misc.Launcher$AppClassLoader@18b4aac2
    }
}
