package java01;

import java.util.Optional;

public class Code_010_Optional {
    public static void main(String[] args) {
        Optional<String> s1 = Optional.of("Hello");
        // 判断是否有值
        if (s1.isPresent()){
            System.out.println(s1.get());  // 获取值
        }
        Optional<String> s2 = Optional.ofNullable(null);
        if (s2.isPresent()){
            System.out.println(s2.get());
        }
    }

}
