package xiaohaoAlgorithm.oneQuestionPerDay;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/19 13:17
 * 48. ��תͼ��
 */
public class RotateImage {

    // ��ת�� �ھ���
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // ת��
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                swap(matrix, i, j);
            }
        }

        // ����
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }

    }

    private void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        //  ���·�ת
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }

        // �Խ�ת��
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    // ��������
    public void rotate3(int[][] matrix) {
        int n = matrix.length;
        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[j][n - i - 1] = matrix[i][j];
            }
        }

        // ���
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        RotateImage rotateImage = new RotateImage();
        int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
        rotateImage.rotate2(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }

//        rotateImage.rotate3(nums);
    }

}
