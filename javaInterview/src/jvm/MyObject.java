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
        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);    // sun.misc.Launcher$AppClassLoader@18b4aac2

        // 获取其上层：扩展类加载器
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);   // sun.misc.Launcher$ExtClassLoader@677327b6

        // 获取其上层:  获取不到引导类加载器
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println(bootstrapClassLoader);   // null

        // 对其用户自定义类来说：默认使用系统类加载器进行加载
        ClassLoader classLoader = MyObject.class.getClassLoader();
        System.out.println(classLoader);    // sun.misc.Launcher$AppClassLoader@18b4aac2(与上面相同)

        //  使用引导类加载器  ----> java核心类库都是使用引导类（即启动类bootstrap）加载器进行加载的
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);

    }
}
