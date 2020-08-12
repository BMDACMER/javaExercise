import java.util.*;

import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bufrd = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while((input=bufrd.readLine())!=null){
            int count=Integer.parseInt(input);
            StringBuilder result = new StringBuilder();
            for(int i=0;i<count;i++){
                input = bufrd.readLine();
                int start=0;
                int end=8;
                int length = input.length()/8;
                if (input.length()%8>0){
                    length++;
                }

                for (int j=0;j<length;j++){
                    if(end>input.length()){
                        end=input.length();
                    }
                    String current = input.substring(start,end);
                    result.append(current);
                    if(current.length()<8);
                    for(int k=0;k<8-current.length();k++){
                        result.append("0");
                    }
                    result.append("\n");
                    start+=8;
                    end+=8;
                }
            }
            System.out.println(result.toString().trim());
        }
    }
}