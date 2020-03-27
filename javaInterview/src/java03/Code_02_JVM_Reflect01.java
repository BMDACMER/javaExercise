package java03;

public class Code_02_JVM_Reflect01 {
    public static void main(String[] args) {
        // 调用Class加载器
        ClassLoader clApp = Code_02_JVM_Reflect01.class.getClassLoader();
        System.out.println(clApp);  // 自定义类
        // 调用上一层Class加载器
        ClassLoader clExt = clApp.getParent();
        System.out.println(clExt);  // 扩展类
        // 调用根部Class加载器
        ClassLoader clBoot = clExt.getParent();
        System.out.println(clBoot);   // 系统类
    }
}
