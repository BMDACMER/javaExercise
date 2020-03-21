package java02;

import java.util.HashMap;

public class Code_01_HashMap {
    public static void main(String[] args) {
        HashMap<HS, String> map = new HashMap<HS, String>();

        // ������д��equals��HS�������
        map.put(new HS(),"1");
        map.put(new HS(),"2");
        System.out.println(map);   // {java02.HS@1=1, java02.HS@1=2}

        // ������д��equals��HS�������
        map.put(new HS(){
            @Override
            public boolean equals(Object obj) {
                return true;
            }
        },"3");
        System.out.println(map);   // {java02.HS@1=3, java02.HS@1=2}

        // ������д��equals��hashCode��HS�������
        map.put(new HS(){
            @Override
            public int hashCode() {
                return 2;
            }

            @Override
            public boolean equals(Object obj) {
                return true;
            }
        },"3");
        System.out.println(map); // {java02.HS@1=3, java02.HS@1=2, java02.Code_01_HashMap$2@2=3}
    }
}

class HS{
    // ��дhashCode��Ĭ�Ϸ���1
    public int hashCode(){
        return 1;
    }
}