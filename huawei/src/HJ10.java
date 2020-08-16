import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/15 9:41
 */
public class HJ10 {
    public static HashMap<Character,String> numMap = new HashMap<Character,String>();
    public static HashMap<Integer,String> danweiMap = new HashMap<Integer,String>();

    static{
        numMap.put('0',"零");
        numMap.put('1',"壹");
        numMap.put('2',"贰");
        numMap.put('3',"叁");
        numMap.put('4',"肆");
        numMap.put('5',"伍");
        numMap.put('6',"陆");
        numMap.put('7',"柒");
        numMap.put('8',"捌");
        numMap.put('9',"玖");
        numMap.put('.',"");

        danweiMap.put(1,"分");
        danweiMap.put(2,"角");
        danweiMap.put(3,"");
        danweiMap.put(4,"元");
        danweiMap.put(5,"拾");
        danweiMap.put(6,"佰");
        danweiMap.put(7,"仟");
        danweiMap.put(8,"万");
        danweiMap.put(9,"拾");
        danweiMap.put(10,"佰");
        danweiMap.put(11,"仟");
        danweiMap.put(12,"拾");
        danweiMap.put(13,"佰");
        danweiMap.put(14,"仟");
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        while((input = br.readLine())!=null){
            char[] cArray = input.toCharArray();

            StringBuilder result = new StringBuilder("人民币");

            int length = cArray.length;

            //用于记录数字是否为0
            boolean flag = true;
            if(input.equals("0.00")){
                result.append("零元整");
            }else if(cArray.length>=4 && cArray[0] != '0'){
                for(int i=0;i<length;i++){
                    if(input.endsWith(".00") && (length-i) == 3){
                        result.append("整");
                        break;
                    }else if(input.endsWith("0") && (length-i) == 1){
                        break;
                    }

                    //如果前面不是0，当前是0，不需要单位
                    if(flag == true && cArray[i] == '0' && (length-i)>2){
                        result.append(numMap.get(cArray[i]));
                        flag = false;
                    }else if(cArray[i] != '0'){
                        if(cArray[i] == '1' && ((length-i)==5 || (length-i)==9 ||(length-i)==12)){
                            result.append(danweiMap.get(length-i));
                        }else{
                            result.append(numMap.get(cArray[i]));
                            result.append(danweiMap.get(length-i));
                        }
                        flag = true;
                    }
                }
            }else if(cArray.length == 4 && cArray[0] == '0'){
                for(int i=1;i<length;i++){
                    result.append(numMap.get(cArray[i]));
                    result.append(danweiMap.get(length-i));

                    if(input.endsWith(".00") && (length-i) == 3){
                        result.append("整");
                    }
                }
            }
            System.out.println(result);
        }
    }
}
