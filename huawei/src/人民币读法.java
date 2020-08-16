import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/15 10:23
 *
 *
 * ʵ�ָ�����ת��������Ҷ����ַ���
 * ��дһ�����򣬽�������ת��������Ҷ����ַ�����
 *
 * ���磺    ��1006.333ת��ΪҼǧ��½Ԫ�������֡�
 * �ο���https://www.cnblogs.com/Reyon/p/8665961.html
 */
public class ����Ҷ��� {
    private String[] str1 = {"��","Ҽ","��","��","��","��","½","��","��","��"};
    private String[] str2 = {"ʮ","��","ǧ"};
    private String[] str3 = {"��","��"};
    private String[] str4 = {"Ԫ","��","��"};

    // 1) ���������ֽ�����������ַ���
    private String divide2Long(double num) {
        long integer = (long)num;
        return String.valueOf(integer);
    }

    // 2) ���������ֽ��С�������ַ���
    private String divide2Decimal(double num) {
        long tmp = (long) num;
        long decimal = Math.round((num - tmp)*100);
        return String.valueOf(decimal);
    }

    // 3) ��С�����ֵ������ַ���ת���ɺ����ַ���
    private String toStr1(String decimal) {
        String rel = "";
        int len = decimal.length();
        if (len == 2) {
            for (int i = 0; i < 2; i++) {
                int num = decimal.charAt(i) - 48;
                // ���ֲ�Ϊ������Ҫ�ӵ�λ��Ϊ���򲻲���
                if (num != 0) {
                    rel += str1[num] + str3[i];
                }
            }
        }

        // ������Ϊ1������ 12.09 С������Ϊ9
        if (len == 1 && decimal.charAt(0) != '0') {
            int num = decimal.charAt(0) - 48;
            // ��ʱֻ�з֣� �ӵ�λstr[1]
            rel += str1[num] + str3[1];
        }
        return rel;
    }

    // 4) ��һ����λ�������ַ�����ɺ����ַ���
    private String toStr(String integer) {
        String re = "";
        int j = 0;
        int lenInteger = integer.length();
        // �����������0.89ʱ�������ַ���Ϊ0�Ĵ���
        if (integer.charAt(0) == '0' && lenInteger == 1) {
            re += "��";
            return re;
        }

        // ����ÿһλ����
        for (int i = 0; i < lenInteger; i++) {
            int num = integer.charAt(i) - 48;
            // ���������һλ���������ֲ�Ϊ�㣬����Ҫ��ӵ�λ
            if (i != lenInteger -1 && num != 0) {
                re += str1[num] + str2[lenInteger-2-i];
            }
            // ��������0���ֵ����⴦����1009���ڶ����㲻���в���
            else if (!(num == 0 && re.charAt(j-1) == '��')) {
                re += str1[num];
            }
            j = re.length();
        }
        // ������������һλ����Ĵ�����1990��ɾ����ĩβ����
        if (re.charAt(j-1) == '��') {
            re = re.substring(0, j-1);
        }
        return re;
    }

    // 5) ���ڽ�������������12λ�����ڵĴ�����4λ��Ϊһ�顣
    ///    ��1234���ڣ�,5678����,1234��Ԫ��.89��
    private String integerDivide(String integer) {
        int len = integer.length();
        String Re = "";
        int n = 0;
        // �ж��������ֵĳ��ȣ�������Ҫ�ּ���
        if (len >= 9)
            n = 3;
        else if (len >= 5)
            n = 2;
        else if (len >= 1)
            n = 1;
        //        ��λ����4�ı���������ǰ�油0��ֱ��λ��Ϊ4�ı���Ϊֹ
        //        �� 12,2345��Ϊ0012,2345
        if (len % 4 != 0) {
            String zh = "";
            int s = len % 4;
            // ��ǰ�油0
            for (int i = 0; i < (4-s); i++) {
                zh += "0";
            }
            zh += integer;
            integer = zh;
        }
        // ����n����ϵĴ���
        for (int i = 0; i < n; i++) {
            String Zheng = "";
            String sss = "";
            // �����ڱ仯
            len = integer.length();
            // ��ȡ���������ֺ���λ�����зֿ���ת��
            Zheng = integer.substring(len - 4);
            // ��ȥ�Ѿ���ȡ���ַ���������ַ������ַ�������
            integer = integer.substring(0,len-4);
            int m = 0, me = 0;
            // ���ַ��������������ͣ���0012ת����12
            for (int j = 3; j >= 0; j--) {
                m = (int) ((Zheng.charAt(j) - 48)*Math.pow(10,3-j));
                me += m;
            }
            // ������12ת�����ַ���12
            Zheng = String.valueOf(me);
            // ���ַ���12 ת���� Ҽʰ��
            sss = this.toStr(Zheng);
            //  �ν���  Ԫ �ȵ�λ���ټ����Ѿ�ת���õ� �����ַ���   ���˴�ע��ÿ���ַ������˳��
            sss += str4[i] + Re;
            Re = sss;
        }
        return Re;
    }

    public static void main(String[] args) {
        ����Ҷ��� money  = new ����Ҷ���();
        Scanner scan = new Scanner(System.in);
        double v = scan.nextDouble();
        System.out.println("�����" + money.integerDivide(money.divide2Long(v)) + money.toStr1(money.divide2Decimal(v)));
    }
}
