package xiaohaoAlgorithm.math;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/7 11:21
 *
 * 292. Nim 游戏
 */
public class CanWinNim {

    /**
     * 详解参考 《labuladong的算法小抄》P414
     * @param n
     * @return
     */
    public boolean canWinNim(int n) {
        return (n >> 2) != 0;
    }
}
