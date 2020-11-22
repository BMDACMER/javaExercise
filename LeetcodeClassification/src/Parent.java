/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/10/18 10:46
 */
public class Parent {
    public static String p_StaticField = "父类--静态变量";
    public String p_Field = "父类--变量";
    protected  int i = 9;
    protected int j = 0;
    static {
        System.out.println(p_StaticField);
        System.out.println("父类--静态初始化块");
    }
    {
        System.out.println(p_Field);
        System.out.println("父类--初始化块");
    }

    public Parent() {
        System.out.println( "父类--构造器" );
        System.out.println( "i=" + i + ", j=" + j );
        j = 20;
    }
}
