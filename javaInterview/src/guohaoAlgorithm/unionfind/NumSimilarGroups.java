package guohaoAlgorithm.unionfind;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/31 9:37
 *
 * 839. �����ַ�����
 * ��������ַ��� X �е�������ͬλ�õ���ĸ��ʹ�������ַ��� Y ��ȣ���ô�� X �� Y �����ַ������ơ�����������ַ�����������ȵģ�������Ҳ�����Ƶġ�
 *
 * ���磬"tars" �� "rats" �����Ƶ� (���� 0 �� 2 ��λ��)�� "rats" �� "arts" Ҳ�����Ƶģ����� "star" ���� "tars"��"rats"���� "arts" ���ơ�
 *
 * ��֮������ͨ���������γ������������飺{"tars", "rats", "arts"} �� {"star"}��ע�⣬"tars" �� "arts" ����ͬһ���У���ʹ���ǲ������ơ���ʽ�ϣ���ÿ������ԣ�Ҫȷ��һ�����������У�ֻ��Ҫ����ʺ͸���������һ���������ơ�
 *
 * ����һ���ַ����б� strs���б��е�ÿ���ַ������� strs �����������ַ�����һ����ĸ��λ�ʡ����� strs ���ж��ٸ������ַ����飿
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺strs = ["tars","rats","arts","star"]
 * �����2
 */
public class NumSimilarGroups {

    public int numSimilarGroups(String[] strs) {
        if (strs == null || strs.length < 2) return 0;
        int n = strs.length;
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (check(strs[i], strs[j])) {
                    uf.union(i,j);
                }
            }
        }
        return uf.getCount();
    }

    private boolean check(String p, String q) {
        int num = 0;
        int n = p.length();  // ��Ϊp,q�ĳ��ȶ����
        for (int i = 0; i < n; i++) {
            if (p.charAt(i) != q.charAt(i)) {
                num++;
            }
            if (num > 2) {
                return false;
            }
        }
        return true;
    }
}
