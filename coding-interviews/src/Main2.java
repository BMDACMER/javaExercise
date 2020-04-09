import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        while (true) {
        for (int i = 0; i < n; i++) {
            String str = scanner.next();
            // 循环的次数
            for (int j = str.length(); j > 0; j--) {
                if (Huiwen(str)) {
                    System.out.println("Cassidy");
                    break;
                } else {
                    // 重排字符串
                    str = str.substring(0, str.length() - 1);
                    if (Huiwen(str)) {
                        System.out.println("Eleanore");
                        break;
                    }
                }
            }

        }
    }
//    }

    public static boolean Huiwen(String str) {
        char[] s = str.toCharArray();
        if (s.length < 1) {
            return false;   // 空串设置为false
        }
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            if (s[i] == s[j]) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;

    }
}
