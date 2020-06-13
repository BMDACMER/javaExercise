package leetcode;
// ²Î¿¼ https://leetcode-cn.com/problems/integer-to-english-words/solution/stringbuilder-static-hashmap-by-newhans/

public class Integer2English {

    public String numberToWords(int num) {
        StringBuilder sb = new StringBuilder();
        if (num == 0) return getValue(num);
        if (num >= 1000000000){
            lessThanThousand(num / 1000000000, sb);
            sb.append(" ").append(getValue(1000000000));
            num = num % 1000000000;
        }
        if (num >= 1000000){
            lessThanThousand(num / 1000000, sb);
            sb.append(" ").append(getValue(1000000));
            num = num % 1000000;
        }
        if (num >= 1000){
            lessThanThousand(num / 1000, sb);
            sb.append(" ").append(getValue(1000));
            num = num % 1000;
        }
        lessThanThousand(num, sb);
        return sb.toString();
    }

    private StringBuilder lessThanThousand(int n, StringBuilder sb){
        if (n >= 100){
            if (sb.length() > 0) sb.append(" ");
            sb.append(getValue(n / 100)).append(" ").append(getValue(100));
            n = n % 100;
        }
        if (n >= 20){
            if (sb.length() > 0) sb.append(" ");
            int tmp = n / 10;
            sb.append(getValue(tmp * 10));
            if (n % 10 > 0) sb.append(" ").append(getValue(n % 10));
        }else if (n > 0){
            if (sb.length() > 0) sb.append(" ");
            sb.append(getValue(n));
        }
        return sb;
    }

    private String getValue(int number) {
        switch (number) {
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
            case 20: return "Twenty";
            case 30: return "Thirty";
            case 40: return "Forty";
            case 50: return "Fifty";
            case 60: return "Sixty";
            case 70: return "Seventy";
            case 80: return "Eighty";
            case 90: return "Ninety";
            case 100: return "Hundred";
            case 1000: return "Thousand";
            case 1000000: return "Million";
            case 1000000000: return "Billion";
            default: return "Zero";
        }
    }
}
