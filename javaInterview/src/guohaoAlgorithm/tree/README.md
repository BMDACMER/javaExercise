### `BST` 二叉搜索树套路

课本P235--259

**01 把二叉树所有节点中的值加一**

```java
void plusOne(TreeNode root) {
    if(root == null) return;
    root.val += 1;
    plusOne(root.left);
    plusOne(root.right);
}
```



**02 如何判断二叉树是否完全相同**

```java
boolean isSame(TreeNode root1, TreeNode root2){
    if(root1 == null && root2 == null) return true;
    if(root1 == null || root2 == null) return false;
    if(root1.val != root2.val) return false;
    return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
}
```



**03 判断BST的合法性**

```java
boolean isValidBST(TreeNode root) {
    return isValidBST(root, null, null);
}

boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
	if(root == null) return true;
    if(min != null && min.val >= root.val) return false;
    if(max != null && max.val <= root.val) return false;
    return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
}
```



**04 在BST中查找一个数是否存在**

```java
// 针对所有的树
boolean isInBST(TreeNode root, int target) {
	if(root == null) return false;
    if(root.val == target) return true;
    
    return isInBST(root.left, target) && isInBST(root.right, target);
}

// 针对BST
boolean isInBST(TreeNode root, int target){
	if(root == null) return false;
    if(root.val == target) return true;
    // 递归框架
    if(root.val < target) {
    	// 右子树
        return isInBST(root.right, target);
    } 
    if(root.val > target) {
    	return isInBST(root.left, target);
    }
}   
```



**05 在BST中插入一个数**

```java
TreeNode insertIntoBST(TreeNode root, int val) {
	// 找到空位置插入新节点
    if(root == null) return new TreeNode(val);
    // 如果已经存在就不要重复插入了，直接返回
    if(root.val == val) return root;
    
    if(root.val < val) return insertIntoBST(root.right, val);
    if(root.val > val) return insertIntoBST(root.left, val);
    return root;
}
```



==**06 在BST中删除一个数**==

```java
TreeNode deleteNode(TreeNode root, int key) {
	if(root == null) return null;
    if(root.val == key) {
        if(root.left == null) return root.right;
        if(root.right == null) return root.left;
    	// 找到右子树的最小节点，进行删除
        TreeNode minNode = getMin(root.right);
        root.val = minNode.val;
        root.right = deleteNode(root.right, minNode.val);
    }else if(root.val < key) {
    	// 去左子树寻找key
        root.left = deleteNode(root.left, key);
    }else if(root.val > key) {
    	// 去右子树寻找key
        root.right = deleteNode(root.right, key);
    }
    return root;
}

TreeNode getMin(TreeNode node) {
    // BST最左边的就是最小的
	while(node.left != null) node = node.left;
    return node;
} 
```



### 完全二叉树



01 统计完全二叉树的节点个数

```java
public int countNodes(TreeNode root) {
	TreeNode l = root, r = root;
    // 记录左右子树的高度
    int h1 = 0, hr = 0;
    while(l != null) {
    	l = l.left;
        hl++;
    }
    while(r != null) {
    	r = r.right;
        hr++;
    }
    // 如果左右子树的高度相同，说明是一颗满二叉树
    if(hl == hr) {
    	return (int)Math.pow(2, hl) - 1;
    }
    // 如果左右高度不同，则按照普通二叉树的逻辑计算
    return 1 + countNodes(root.left) + countNodes(root.right);
}
```

时间复杂度为：O($logN$ * $logN$)







