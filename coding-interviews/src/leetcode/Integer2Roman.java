package leetcode;
//12. 整数转罗马数字

public class Integer2Roman {
    int[] number = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] s = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    StringBuilder sb = new StringBuilder();
    public String intToRoman(int num) {
        for (int i = 0; i < number.length; i++) {
            while (num >= number[i]) {
                sb.append(s[i]);
                num -= number[i];
            }
            if (num == 0)
                break;
        }

        return sb.toString();
    }


}
