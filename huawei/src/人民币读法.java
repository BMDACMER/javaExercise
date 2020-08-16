import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/15 10:23
 *
 *
 * 实现浮点数转换成人民币读法字符串
 * 编写一个程序，将浮点数转换成人民币读法字符串，
 *
 * 例如：    将1006.333转换为壹千零陆元叁角叁分。
 * 参考：https://www.cnblogs.com/Reyon/p/8665961.html
 */
public class 人民币读法 {
    private String[] str1 = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
    private String[] str2 = {"十","百","千"};
    private String[] str3 = {"角","分"};
    private String[] str4 = {"元","万","亿"};

    // 1) 将浮点数分解成整数部分字符串
    private String divide2Long(double num) {
        long integer = (long)num;
        return String.valueOf(integer);
    }

    // 2) 将浮点数分解成小数部分字符串
    private String divide2Decimal(double num) {
        long tmp = (long) num;
        long decimal = Math.round((num - tmp)*100);
        return String.valueOf(decimal);
    }

    // 3) 把小数部分的数字字符串转换成汉字字符串
    private String toStr1(String decimal) {
        String rel = "";
        int len = decimal.length();
        if (len == 2) {
            for (int i = 0; i < 2; i++) {
                int num = decimal.charAt(i) - 48;
                // 数字不为零则需要加单位，为零则不操作
                if (num != 0) {
                    rel += str1[num] + str3[i];
                }
            }
        }

        // 若长度为1，例： 12.09 小数部分为9
        if (len == 1 && decimal.charAt(0) != '0') {
            int num = decimal.charAt(0) - 48;
            // 此时只有分， 加单位str[1]
            rel += str1[num] + str3[1];
        }
        return rel;
    }

    // 4) 把一个四位的数字字符串变成汉字字符串
    private String toStr(String integer) {
        String re = "";
        int j = 0;
        int lenInteger = integer.length();
        // 特殊情况输入0.89时，整数字符串为0的处理
        if (integer.charAt(0) == '0' && lenInteger == 1) {
            re += "零";
            return re;
        }

        // 遍历每一位数字
        for (int i = 0; i < lenInteger; i++) {
            int num = integer.charAt(i) - 48;
            // 若不是最后一位数字且数字不为零，则需要添加单位
            if (i != lenInteger -1 && num != 0) {
                re += str1[num] + str2[lenInteger-2-i];
            }
            // 对于连续0出现的特殊处理，如1009，第二个零不进行操作
            else if (!(num == 0 && re.charAt(j-1) == '零')) {
                re += str1[num];
            }
            j = re.length();
        }
        // 对特殊情况最后一位是零的处理，如1990，删除掉末尾的零
        if (re.charAt(j-1) == '零') {
            re = re.substring(0, j-1);
        }
        return re;
    }

    // 5) 对于金额的整数部分在12位数以内的处理，以4位数为一组。
    ///    如1234（亿）,5678（万）,1234（元）.89，
    private String integerDivide(String integer) {
        int len = integer.length();
        String Re = "";
        int n = 0;
        // 判断整数部分的长度，考虑需要分几组
        if (len >= 9)
            n = 3;
        else if (len >= 5)
            n = 2;
        else if (len >= 1)
            n = 1;
        //        若位数非4的倍数，则在前面补0，直到位数为4的倍数为止
        //        如 12,2345补为0012,2345
        if (len % 4 != 0) {
            String zh = "";
            int s = len % 4;
            // 在前面补0
            for (int i = 0; i < (4-s); i++) {
                zh += "0";
            }
            zh += integer;
            integer = zh;
        }
        // 进行n个组合的串联
        for (int i = 0; i < n; i++) {
            String Zheng = "";
            String sss = "";
            // 长度在变化
            len = integer.length();
            // 提取出整数部分后四位，进行分开的转换
            Zheng = integer.substring(len - 4);
            // 出去已经提取的字符串以外的字符串，字符串更新
            integer = integer.substring(0,len-4);
            int m = 0, me = 0;
            // 把字符串正换成整数型，如0012转换成12
            for (int j = 3; j >= 0; j--) {
                m = (int) ((Zheng.charAt(j) - 48)*Math.pow(10,3-j));
                me += m;
            }
            // 把数字12转换成字符串12
            Zheng = String.valueOf(me);
            // 把字符串12 转换成 壹拾贰
            sss = this.toStr(Zheng);
            //  衔接上  元 等单位，再加上已经转换好的 汉字字符串   ，此处注意每组字符串间的顺序
            sss += str4[i] + Re;
            Re = sss;
        }
        return Re;
    }

    public static void main(String[] args) {
        人民币读法 money  = new 人民币读法();
        Scanner scan = new Scanner(System.in);
        double v = scan.nextDouble();
        System.out.println("人民币" + money.integerDivide(money.divide2Long(v)) + money.toStr1(money.divide2Decimal(v)));
    }
}
