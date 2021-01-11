package guohaoAlgorithm.unionfind;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/11 17:01
 * <p>
 * 990. ��ʽ���̵Ŀ�������
 */
public class EquationsPossible {

    /**
     * �㷨˼·��
     * 1������ʽ���ַ��͵��ĸ��ַ�һ�ҷŵ����鼯�У��ж��Ƿ���ͨ
     * 2���жϵڶ����ַ��Ƿ��� !
     * ����� ��  ���ж� �׸��ַ��͵��ĸ��ַ��Ƿ�����ͨ�������ͨ���� ����false
     * ����  ������Ϻ�  ����true
     *
     * @param equations
     * @return
     */
    public boolean equationsPossible(String[] equations) {
        // 26��Ӣ����ĸ
        UnionFind uf = new UnionFind(26);
        // ������ȵ���ĸ�г���ͨ����
        for (String equation : equations) {
            if (equation.charAt(1) == '=')
                uf.union(equation.charAt(0) - 'a', equation.charAt(3) - 'a');
        }

        // ��鲻�ȹ�ϵ�Ƿ������ȹ�ϵ����ͨ��
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                if (uf.connect(equation.charAt(0) - 'a', equation.charAt(3) - 'a'))
                    return false;
            }
        }

        return true;
    }
}
