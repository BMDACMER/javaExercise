package java03;

public class Code_02_JVM_Reflect01 {
    public static void main(String[] args) {
        // ����Class������
        ClassLoader clApp = Code_02_JVM_Reflect01.class.getClassLoader();
        System.out.println(clApp);  // �Զ�����
        // ������һ��Class������
        ClassLoader clExt = clApp.getParent();
        System.out.println(clExt);  // ��չ��
        // ���ø���Class������
        ClassLoader clBoot = clExt.getParent();
        System.out.println(clBoot);   // ϵͳ��
    }
}
