import java.util.LinkedList;
import java.util.Queue;

/**
 * ���л�������
 *
 *��ʵ�������������ֱ��������л��ͷ����л�������

 �����������л���ָ����һ�ö���������ĳ�ֱ�����ʽ�Ľ����ĳ�ָ�ʽ����Ϊ�ַ������Ӷ�ʹ���ڴ��н��������Ķ�
 �������Գ־ñ��档���л����Ի����������򡢺��򡢲���Ķ�����������ʽ�������޸ģ����л��Ľ����һ���ַ�����
 ���л�ʱͨ�� ĳ�ַ��ű�ʾ�սڵ㣨#������ �� ��ʾһ�����ֵ�Ľ�����value!����

 �������ķ����л���ָ������ĳ�ֱ���˳��õ������л��ַ������str���ع���������
 *
 */
public class Test62 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }


    public String Serialize(TreeNode root) {
        StringBuilder ans = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 1; // ������¼��ǰ�ڵ㼰�����ǿսڵ�ĸ���
        while (!queue.isEmpty() && root != null) {
            TreeNode node = queue.poll();
            if (node == null) {
                ans.append("#");
            } else {
                ans.append(node.val);
                sum--;
                if (node.left != null) {
                    sum++;
                }
                if (node.right != null) {
                    sum++;
                }
                queue.add(node.left);
                queue.add(node.right);
            }
            if (sum != 0) {
                ans.append(",");
            } else {
                break;
            }
        }
        ans.append("]");
        return ans.toString();
    }
    public TreeNode Deserialize(String str) {
        String s = str.substring(1,str.length() - 1);  // ȥ�� �� ��
        if ("".equals(s)) {
            return null;   // str=[]
        }
        String[] a = s.split(",");
        int index = 0;
        Queue<TreeNode> queue = new LinkedList<>();
//        TreeNode root = new TreeNode(change(a[index++]));
        TreeNode root = new TreeNode(Integer.parseInt(a[index++]));
        queue.add(root);
        while (!queue.isEmpty() && index < a.length) {
            TreeNode node = queue.poll();
            if (!"#".equals(a[index])) {
                node.left = new TreeNode(Integer.parseInt(a[index++]));
                queue.add(node.left);
            } else {
                index++;
            }
            if (index < a.length && !"#".equals(a[index])) {
                node.right = new TreeNode(Integer.parseInt(a[index++]));
                queue.add(node.right);
            } else {
                index++;
            }
        }
        return root;
    }

    private int change(String s) {
        int res = 0;
        int i = 0;
        int flag = 1;
        if (s.charAt(0) == '-') {
            i++;
            flag = -1;
        }
        for (; i < s.length(); i++) {
            res = res * 10 + s.charAt(i) - '0';
        }
        return res * flag;
    }

}
