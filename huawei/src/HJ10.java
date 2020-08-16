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
        numMap.put('0',"��");
        numMap.put('1',"Ҽ");
        numMap.put('2',"��");
        numMap.put('3',"��");
        numMap.put('4',"��");
        numMap.put('5',"��");
        numMap.put('6',"½");
        numMap.put('7',"��");
        numMap.put('8',"��");
        numMap.put('9',"��");
        numMap.put('.',"");

        danweiMap.put(1,"��");
        danweiMap.put(2,"��");
        danweiMap.put(3,"");
        danweiMap.put(4,"Ԫ");
        danweiMap.put(5,"ʰ");
        danweiMap.put(6,"��");
        danweiMap.put(7,"Ǫ");
        danweiMap.put(8,"��");
        danweiMap.put(9,"ʰ");
        danweiMap.put(10,"��");
        danweiMap.put(11,"Ǫ");
        danweiMap.put(12,"ʰ");
        danweiMap.put(13,"��");
        danweiMap.put(14,"Ǫ");
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        while((input = br.readLine())!=null){
            char[] cArray = input.toCharArray();

            StringBuilder result = new StringBuilder("�����");

            int length = cArray.length;

            //���ڼ�¼�����Ƿ�Ϊ0
            boolean flag = true;
            if(input.equals("0.00")){
                result.append("��Ԫ��");
            }else if(cArray.length>=4 && cArray[0] != '0'){
                for(int i=0;i<length;i++){
                    if(input.endsWith(".00") && (length-i) == 3){
                        result.append("��");
                        break;
                    }else if(input.endsWith("0") && (length-i) == 1){
                        break;
                    }

                    //���ǰ�治��0����ǰ��0������Ҫ��λ
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
                        result.append("��");
                    }
                }
            }
            System.out.println(result);
        }
    }
}
