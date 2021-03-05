package guohaoAlgorithm.acm.test;

import java.util.HashMap;

/**
 * @Author guohao
 * @Date 2021/3/5 18:49
 * @Version 1.0
 */
public class TreeNode {
    /**
     * content：用于存储当前节点存储的内容
     * childs：用于存储子节点信息，HashMap的string存储的是子节点内容，childs采用HashMap
     * 实现有利于实现子节点快速查找
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
