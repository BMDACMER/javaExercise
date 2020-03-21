package java02;

import java.util.HashMap;

public class Code_01_HashMap {
    public static void main(String[] args) {
        HashMap<HS, String> map = new HashMap<HS, String>();

        // 存入重写过equals的HS子类对象
        map.put(new HS(),"1");
        map.put(new HS(),"2");
        System.out.println(map);   // {java02.HS@1=1, java02.HS@1=2}

        // 存入重写过equals的HS子类对象
        map.put(new HS(){
            @Override
            public boolean equals(Object obj) {
                return true;
            }
        },"3");
        System.out.println(map);   // {java02.HS@1=3, java02.HS@1=2}

        // 存入重写过equals和hashCode的HS子类对象
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
    // 重写hashCode，默认返回1
    public int hashCode(){
        return 1;
    }
}