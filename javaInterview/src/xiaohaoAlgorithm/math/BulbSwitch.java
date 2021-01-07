package xiaohaoAlgorithm.math;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/7 11:18
 *
 * 319. 灯泡开关
 */
public class BulbSwitch {

    /**
     *  详解参考 《labuladong的算法小抄》P416
     *
     *  就是要找规律
     * @param n
     * @return
     */
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}
