package java01;

import java.util.Optional;

public class Code_010_Optional {
    public static void main(String[] args) {
        Optional<String> s1 = Optional.of("Hello");
        // �ж��Ƿ���ֵ
        if (s1.isPresent()){
            System.out.println(s1.get());  // ��ȡֵ
        }
        Optional<String> s2 = Optional.ofNullable(null);
        if (s2.isPresent()){
            System.out.println(s2.get());
        }
    }

}
