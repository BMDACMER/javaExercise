package jvm;

public class MyObject {
    public static void main(String[] args) {
        Object object = new Object();
//        System.out.println(object.getClass().getClassLoader().getParent().getParent());
//        System.out.println(object.getClass().getClassLoader().getParent());  // Exception in thread "main" java.lang.NullPointerException
//        System.out.println(object.getClass().getClassLoader());  // null
//
//        System.out.println("\n\n\n\n");
//
//        MyObject myObject = new MyObject();
//        System.out.println(myObject.getClass().getClassLoader().getParent().getParent());  // null
//        System.out.println(myObject.getClass().getClassLoader().getParent()); // sun.misc.Launcher$ExtClassLoader@677327b6
//        System.out.println(myObject.getClass().getClassLoader()); // sun.misc.Launcher$AppClassLoader@18b4aac2

        //-------------------------------------------------------
        System.out.println("------------------------------------------------------");
        //��ȡϵͳ�������
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);    // sun.misc.Launcher$AppClassLoader@18b4aac2

        // ��ȡ���ϲ㣺��չ�������
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);   // sun.misc.Launcher$ExtClassLoader@677327b6

        // ��ȡ���ϲ�:  ��ȡ���������������
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println(bootstrapClassLoader);   // null

        // �����û��Զ�������˵��Ĭ��ʹ��ϵͳ����������м���
        ClassLoader classLoader = MyObject.class.getClassLoader();
        System.out.println(classLoader);    // sun.misc.Launcher$AppClassLoader@18b4aac2(��������ͬ)

        //  ʹ�������������  ----> java������ⶼ��ʹ�������ࣨ��������bootstrap�����������м��ص�
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);

    }
}
