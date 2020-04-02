/**
 * ��Ŀ����ʵ��һ�����������ַ����е�ÿ���ո��滻��"%20"�����硰We are happy.���������
 * ��We%20are%20happy.����
 */
public class Test04 {

    // ����һ��
    public static String replaceSpace(StringBuilder str){

        if (str == null){
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' '){
                stringBuilder.append('%');
                stringBuilder.append('2');
                stringBuilder.append('0');
            }else {
                stringBuilder.append(str.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    // ��������
    /*
    ����1���滻�ַ���������ԭ�����ַ��������滻�������¿���һ���ַ������滻��
    ����2���ڵ�ǰ�ַ����滻����ô�滻�Ÿ���Ч�ʣ�������java�����е�replace��������
          ��ǰ�����滻��������ַ�Ҫ���������ƶ���Ҫ����ƶ�������Ч�ʵ���
          �Ӻ���ǰ���ȼ�����Ҫ���ٿռ䣬Ȼ��Ӻ���ǰ�ƶ�����ÿ���ַ�ֻΪ�ƶ�һ�Σ�����Ч�ʸ���һ�㡣
    */
    public static String replaceSpace2(StringBuffer str){
        if (str == null){
            return null;
        }

        int countBlank = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' '){
                countBlank++;
            }
        }

        int stringOld = str.length() - 1;   // ԭʼ�ַ�������(�±꣩
        int stringNew2 = str.length() + 2 * countBlank;  // ����20%����ַ�������
        int stringNew = stringNew2 - 1;  // ����20%����ַ�������(�±꣩
        str.setLength(stringNew2);  // ��ֹ����Խ��

        for (; stringOld >= 0; --stringOld) {
            if (str.charAt(stringOld) == ' '){
                str.setCharAt(stringNew--, '0');
                str.setCharAt(stringNew--, '2');
                str.setCharAt(stringNew--, '%');
            }else{
                str.setCharAt(stringNew--, str.charAt(stringOld));
            }
        }

        return str.toString();
    }


    public static void main(String[] args) {
//        String s = "We Are happy";
        // ����һ
        StringBuilder s = new StringBuilder("We Are happy");
        String str = replaceSpace(s);
        System.out.println(str);

        System.out.println("============================");

        // ������
        StringBuffer stringBuffer = new StringBuffer("We Are happy");
        System.out.println(replaceSpace2(stringBuffer));
    }
}
