/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/10/18 10:47
 */
public class SubClass extends Parent {
    public static String s_StaticField = "����--��̬����";
    public String s_Field = "����--����";
    static {
        System.out.println(s_StaticField);
        System.out.println("����--��̬��ʼ����");
    }

    {
        System.out.println(s_Field);
        System.out.println("����--��ʼ����");
    }

    public SubClass() {
        System.out.println("����--������");
        System.out.println("i=" + i + ",j=" + j);
    }

    public static void main(String[] args) {
//        System.out.println("����main����");
//        new SubClass();
    }
}
