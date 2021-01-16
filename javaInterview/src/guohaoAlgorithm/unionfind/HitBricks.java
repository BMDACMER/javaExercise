package guohaoAlgorithm.unionfind;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/16 19:43
 */
public class HitBricks {
        private int rows;
        private int cols;

        public static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        public int[] hitBricks(int[][] grid, int[][] hits) {
            this.rows = grid.length;
            this.cols = grid[0].length;

            // �� 1 ������ grid �е�שͷȫ�����飬ͨ���㷨���ⲻ���޸��������ݣ���һ���Ǳ��裬������Ϊ��һ�ִ���淶
            int[][] copy = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    copy[i][j] = grid[i][j];
                }
            }

            // �� copy �е�שͷȫ������
            for (int[] hit : hits) {
                copy[hit[0]][hit[1]] = 0;
            }

            // �� 2 ������ͼ����ש���ש������ӹ�ϵ���벢�鼯��size ��ʾ��ά����Ĵ�С��Ҳ��ʾ����ġ��ݶ����ڲ��鼯�еı��
            int size = rows * cols;
            UnionFind unionFind = new UnionFind(size + 1);

            // ���±�Ϊ 0 ����һ�е�ש���롸�ݶ�������
            for (int j = 0; j < cols; j++) {
                if (copy[0][j] == 1) {
                    unionFind.union(j, size);
                }
            }

            // �������������ש�����ϡ�����һ�£����Ҳ��ש�飬�ڲ��鼯�н��кϲ�
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (copy[i][j] == 1) {
                        // ����Ϸ�Ҳ��ש��
                        if (copy[i - 1][j] == 1) {
                            unionFind.union(getIndex(i - 1, j), getIndex(i, j));
                        }
                        // ������Ҳ��ש��
                        if (j > 0 && copy[i][j - 1] == 1) {
                            unionFind.union(getIndex(i, j - 1), getIndex(i, j));
                        }
                    }
                }
            }

            // �� 3 �������� hits �������� copy �в���ש�飬��ÿһ����Ϊ����ש������ݶ�������ש���������¼�� res ������
            int hitsLen = hits.length;
            int[] res = new int[hitsLen];
            for (int i = hitsLen - 1; i >= 0; i--) {
                int x = hits[i][0];
                int y = hits[i][1];

                // ע�⣺���ﲻ���� copy�������ϱ�ʾ�����ԭ���� grid �У���һ���ǿհף���һ����������κ�ש�����
                // ���򲹻ص�ʱ�����ݶ�������ש������Ҳ�϶���������
                if (grid[x][y] == 0) {
                    continue;
                }

                // ����֮ǰ���ݶ�������ש����
                int origin = unionFind.getSize(size);

                // ע�⣺������ص��������ڵ� 1 �У�Ҫ���߲��鼯�����ݶ��������߼�ͬ�� 2 ����
                if (x == 0) {
                    unionFind.union(y, size);
                }

                // �� 4 �������Ͽ�һ�£�������ڵ� 4 ��������ש�飬�ϲ�����
                for (int[] direction : DIRECTIONS) {
                    int newX = x + direction[0];
                    int newY = y + direction[1];

                    if (inArea(newX, newY) && copy[newX][newY] == 1) {
                        unionFind.union(getIndex(x, y), getIndex(newX, newY));
                    }
                }

                // ����֮�����ݶ�������ש����
                int current = unionFind.getSize(size);
                // ��ȥ�� 1 �����򲹻ص�ש�飨�����Ƴ���ש�飩���� 0 �Ƚϴ�С������Ϊ����һ���������ӵ�ǰש�飬����ʹ�����ݶ����ӵ�ש��������
                res[i] = Math.max(0, current - origin - 1);

                // �����������ש��
                copy[x][y] = 1;
            }
            return res;
        }

        /**
         * ���������ڶ�ά�������Ƿ�Խ��
         *
         * @param x
         * @param y
         * @return
         */
        private boolean inArea(int x, int y) {
            return x >= 0 && x < rows && y >= 0 && y < cols;
        }

        /**
         * ��ά����ת��Ϊһά����
         *
         * @param x
         * @param y
         * @return
         */
        private int getIndex(int x, int y) {
            return x * cols + y;
        }

        private class UnionFind {

            /**
             * ��ǰ���ĸ��׽��
             */
            private int[] parent;
            /**
             * �Ե�ǰ���Ϊ�����������Ľ������
             */
            private int[] size;

            public UnionFind(int n) {
                parent = new int[n];
                size = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                    size[i] = 1;
                }
            }

            /**
             * ·��ѹ����ֻҪ��ÿ�����ཻ���ϵġ�����㡹�����������Ľ��������ֵ��ȷ���ɣ������·��ѹ���Ĺ����в���ά������ size
             *
             * @param x
             * @return
             */
            public int find(int x) {
                if (x != parent[x]) {
                    parent[x] = find(parent[x]);
                }
                return parent[x];
            }

            public void union(int x, int y) {
                int rootX = find(x);
                int rootY = find(y);

                if (rootX == rootY) {
                    return;
                }
                parent[rootX] = rootY;
                // �ںϲ���ʱ��ά������ size
                size[rootY] += size[rootX];
            }

            /**
             * @param x
             * @return x �ڲ��鼯�ĸ��������������Ľ������
             */
            public int getSize(int x) {
                int root = find(x);
                return size[root];
            }
        }
}
