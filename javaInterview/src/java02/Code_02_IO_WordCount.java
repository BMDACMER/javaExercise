package java02;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Code_02_IO_WordCount {
    @Test
    public void testWordCount() throws IOException {
        Map<Character, Integer> map = new HashMap<>();

        FileReader fr = new FileReader("src\\dbcp.txt");
        int count = 0;
        while ((count = fr.read()) != -1){
            char ch = (char) count;
            if (map.get(ch) == null){
                map.put(ch,1);
            }else {
                map.put(ch,map.get(ch) + 1);
            }
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter("src\\wordcount.txt"));

        Set<Map.Entry<Character,Integer>> entrySet = map.entrySet();
        for (Map.Entry<Character,Integer> entry:entrySet){
            switch (entry.getKey()){
                case ' ':
                    bw.write("空格 = " + entry.getValue());
                    break;
                case '\t':
                    bw.write("tab键 = " + entry.getValue());
                    break;
                case '\r':
                    bw.write("回车 = " + entry.getValue());
                    break;
                case '\n':
                    bw.write("换行 = " + entry.getValue());
                    break;
                 default:
                    bw.write(entry.getKey() + "=" + entry.getValue());
                        break;
            }
            bw.newLine();
        }

        fr.close();
        bw.close();
    }
}
