/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/10/18 10:46
 */
public class Parent {
    public static String p_StaticField = "����--��̬����";
    public String p_Field = "����--����";
    protected  int i = 9;
    protected int j = 0;
    static {
        System.out.println(p_StaticField);
        System.out.println("����--��̬��ʼ����");
    }
    {
        System.out.println(p_Field);
        System.out.println("����--��ʼ����");
    }

    public Parent() {
        System.out.println( "����--������" );
        System.out.println( "i=" + i + ", j=" + j );
        j = 20;
    }
}
