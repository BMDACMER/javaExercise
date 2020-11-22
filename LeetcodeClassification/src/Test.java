import sun.misc.Launcher;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/10/18 17:07
 */

public class Test {
    public static void main(String[] args) {
        System.out.printf(Test_1_B.str + "\n");
//        new Test_1_B();

        /*// 启动类加载器
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println(urL);
        }

        System.out.println("------------------------------");
        // 扩展类加载器
        ClassLoader classLoader = ClassLoader.getSystemClassLoader().getParent();
        URLClassLoader urlClassLoader = (URLClassLoader) classLoader;

        URL[] urls = urlClassLoader.getURLs();
        for (URL url : urls) {
            System.out.println(url);
        }*/

        // 应用类加载器
        /*String[] urls = System.getProperty("java.class.path").split(":");

        for (String url : urls) {
            System.out.println(url);
        }

        System.out.println("================================");

        URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();

        URL[] urls1 = classLoader.getURLs();
        for (URL url : urls1) {
            System.out.println(url);
        }*/
    }
}

class Test_1_A {
    public static String str = "A str";

    static {
        System.out.println("A Static Block");
    }
}

class Test_1_B extends Test_1_A {
    static {
        System.out.println("B Static Block");
    }
}