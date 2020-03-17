package java01;

public class Code_004_Singleton {
    // ����ʽ �ĵ���ģʽ
    private static volatile Code_004_Singleton instance = null;

    private Code_004_Singleton(){
        System.out.println(Thread.currentThread().getName() + "\t���ǹ��췽��Singleton");
    }

    //  ����һ
//    public static synchronized Code_004_Singleton getInstance(){
//        if (instance == null){
//            instance = new Code_004_Singleton();
//        }
//        return instance;
//    }
    // DCL(Double check Lock˫�˼�������)  ������
    // ��һ���̰߳�ȫ��ԭ������ָ��������Ĵ��ڣ�����volatile���Խ�ָֹ������
    public static Code_004_Singleton getInstance(){
        if (instance == null){
            synchronized (Code_004_Singleton.class){
                if (instance == null)
                    instance = new Code_004_Singleton();
            }
        }
        return instance;
    }



    public static void main(String[] args) {
        // ���߳� ��main�̵߳Ĳ���������������
//        System.out.println(Code_004_Singleton.getInstance() == Code_004_Singleton.getInstance());
//        System.out.println(Code_004_Singleton.getInstance() == Code_004_Singleton.getInstance());
//        System.out.println(Code_004_Singleton.getInstance() == Code_004_Singleton.getInstance());

        // �������̺߳���������˺ܴ�ı仯
        for (int i = 1; i <= 10; i++) {
            new Thread(() ->{
                Code_004_Singleton.getInstance();
            }, String.valueOf(i)).start();
        }
    }

}
