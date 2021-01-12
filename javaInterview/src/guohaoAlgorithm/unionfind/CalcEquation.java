package guohaoAlgorithm.unionfind;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/11 23:49
 *
 * 399. ������ֵ
 */
public class CalcEquation {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsSize = equations.size();

        UnionFind unionFind = new UnionFind(2 * equationsSize);
        // �� 1 ����Ԥ������������ֵ�� id ����ӳ�䣬ʹ�ò��鼯�ĵײ�ʹ������ʵ�֣��������
        Map<String, Integer> map = new HashMap<>(2 * equationsSize);
        int id = 0;
        for (int i = 0; i < equationsSize; i++) {
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);

            if (!map.containsKey(var1)) {
                map.put(var1, id);
                id++;
            }
            if (!map.containsKey(var2)) {
                map.put(var2, id);
                id++;
            }
            unionFind.union(map.get(var1), map.get(var2), values[i]);
        }

        // �� 2 ��������ѯ
        int queriesSize = queries.size();
        double[] res = new double[queriesSize];
        for (int i = 0; i < queriesSize; i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);

            Integer id1 = map.get(var1);
            Integer id2 = map.get(var2);

            if (id1 == null || id2 == null)
                res[i] = -1.0d;
            else
                res[i] = unionFind.isConnected(id1,id2);
        }
        return res;
    }


    private class UnionFind {

        private int[] parent;

        /**
         * ָ��ĸ�����Ȩֵ
         */
        private double[] weight;


        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            parent[rootX] = rootY;
            // ��ϵʽ���Ƶ�������ο����롹�·���ʾ��ͼ
            weight[rootX] = weight[y] * value / weight[x];
        }

        /**
         * ·��ѹ��
         *
         * @param x
         * @return ������ id
         */
        public int find(int x) {
            if (x != parent[x]) {
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return weight[x] / weight[y];
            } else {
                return -1.0d;
            }
        }
    }
}


