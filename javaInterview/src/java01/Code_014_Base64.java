package java01;


import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Code_014_Base64 {
    public static void main(String[] args) {
        String str = "Hello world";
        String s = Base64.getEncoder().encodeToString(str.getBytes(StandardCharsets.UTF_8));
        System.out.println(s);  // SGVsbG8gd29ybGQ=
        String decodStr = new String(Base64.getDecoder().decode(s), StandardCharsets.UTF_8);
        System.out.println(decodStr);  // Hello world
    }
}
