package guohaoAlgorithm.unionfind;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/11 17:01
 * <p>
 * 990. 等式方程的可满足性
 */
public class EquationsPossible {

    /**
     * 算法思路：
     * 1）将等式首字符和第四个字符一家放到并查集中，判断是否连通
     * 2）判断第二个字符是否是 !
     * 如果是 ！  则判断 首个字符和第四个字符是否在连通，如果联通了则 返回false
     * 否则  遍历完毕后  返回true
     *
     * @param equations
     * @return
     */
    public boolean equationsPossible(String[] equations) {
        // 26个英文字母
        UnionFind uf = new UnionFind(26);
        // 先让相等的字母行程连通分量
        for (String equation : equations) {
            if (equation.charAt(1) == '=')
                uf.union(equation.charAt(0) - 'a', equation.charAt(3) - 'a');
        }

        // 检查不等关系是否打破相等关系的连通性
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                if (uf.connect(equation.charAt(0) - 'a', equation.charAt(3) - 'a'))
                    return false;
            }
        }

        return true;
    }
}
