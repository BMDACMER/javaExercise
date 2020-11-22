/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/10/18 10:47
 */
public class SubClass extends Parent {
    public static String s_StaticField = "子类--静态变量";
    public String s_Field = "子类--变量";
    static {
        System.out.println(s_StaticField);
        System.out.println("子类--静态初始化块");
    }

    {
        System.out.println(s_Field);
        System.out.println("子类--初始化块");
    }

    public SubClass() {
        System.out.println("子类--构造器");
        System.out.println("i=" + i + ",j=" + j);
    }

    public static void main(String[] args) {
//        System.out.println("子类main方法");
//        new SubClass();
    }
}
