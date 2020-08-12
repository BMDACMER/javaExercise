import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/10 14:48
 *
 * HJ1 计算字符串最后一个单词的长度，单词以空格隔开。
 * https://www.nowcoder.com/practice/8c949ea5f36f422594b306a2300315da?tpId=37&&tqId=21224&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 */
public class HJ1 {
    // 将字符串转换为字符数组，按 空格 切分
    private static int str2Array(String s) {
        String[] str = s.split(" ");
        String temp = "";
        for (int i = 0; i < str.length; i++) {
            if (!str[i].equals("")) {
                temp = str[i];
            }
        }
        return temp.length();
    }

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();

            System.out.println(str2Array(s));
        }
    }
}
