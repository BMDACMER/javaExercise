package guohaoAlgorithm.acm.test;

import java.util.HashMap;

/**
 * @Author guohao
 * @Date 2021/3/5 18:49
 * @Version 1.0
 */
public class TreeNode {
    /**
     * content�����ڴ洢��ǰ�ڵ�洢������
     * childs�����ڴ洢�ӽڵ���Ϣ��HashMap��string�洢�����ӽڵ����ݣ�childs����HashMap
     * ʵ��������ʵ���ӽڵ���ٲ���
     */
    private String content;
    private HashMap<String, TreeNode> childs;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public HashMap<String, TreeNode> getChilds() {
        return childs;
    }

    public void setChilds(HashMap<String, TreeNode> childs) {
        this.childs = childs;
    }
}
