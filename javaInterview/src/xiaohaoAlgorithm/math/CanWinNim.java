package xiaohaoAlgorithm.math;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/7 11:21
 *
 * 292. Nim ��Ϸ
 */
public class CanWinNim {

    /**
     * ���ο� ��labuladong���㷨С����P414
     * @param n
     * @return
     */
    public boolean canWinNim(int n) {
        return (n >> 2) != 0;
    }
}
