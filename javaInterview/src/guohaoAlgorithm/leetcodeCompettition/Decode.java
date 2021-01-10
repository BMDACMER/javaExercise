package guohaoAlgorithm.leetcodeCompettition;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/10 11:14
 *
 * 5649. 解码异或后的数组
 */
public class Decode {

    public int[] decode(int[] encoded, int first) {
        int[] res = new int[encoded.length + 1];
        res[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            res[i+1] = res[i] ^ encoded[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Decode d = new Decode();
        int[] encoded = {6,2,7,3};
        for (int num : d.decode(encoded, 4)) {
            System.out.print(num);
        }
    }
}
