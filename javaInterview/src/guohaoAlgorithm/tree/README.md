### `BST` ������������·

�α�P235--259

**01 �Ѷ��������нڵ��е�ֵ��һ**

```java
void plusOne(TreeNode root) {
    if(root == null) return;
    root.val += 1;
    plusOne(root.left);
    plusOne(root.right);
}
```



**02 ����ж϶������Ƿ���ȫ��ͬ**

```java
boolean isSame(TreeNode root1, TreeNode root2){
    if(root1 == null && root2 == null) return true;
    if(root1 == null || root2 == null) return false;
    if(root1.val != root2.val) return false;
    return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
}
```



**03 �ж�BST�ĺϷ���**

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



**04 ��BST�в���һ�����Ƿ����**

```java
// ������е���
boolean isInBST(TreeNode root, int target) {
	if(root == null) return false;
    if(root.val == target) return true;
    
    return isInBST(root.left, target) && isInBST(root.right, target);
}

// ���BST
boolean isInBST(TreeNode root, int target){
	if(root == null) return false;
    if(root.val == target) return true;
    // �ݹ���
    if(root.val < target) {
    	// ������
        return isInBST(root.right, target);
    } 
    if(root.val > target) {
    	return isInBST(root.left, target);
    }
}   
```



**05 ��BST�в���һ����**

```java
TreeNode insertIntoBST(TreeNode root, int val) {
	// �ҵ���λ�ò����½ڵ�
    if(root == null) return new TreeNode(val);
    // ����Ѿ����ھͲ�Ҫ�ظ������ˣ�ֱ�ӷ���
    if(root.val == val) return root;
    
    if(root.val < val) return insertIntoBST(root.right, val);
    if(root.val > val) return insertIntoBST(root.left, val);
    return root;
}
```



==**06 ��BST��ɾ��һ����**==

```java
TreeNode deleteNode(TreeNode root, int key) {
	if(root == null) return null;
    if(root.val == key) {
        if(root.left == null) return root.right;
        if(root.right == null) return root.left;
    	// �ҵ�����������С�ڵ㣬����ɾ��
        TreeNode minNode = getMin(root.right);
        root.val = minNode.val;
        root.right = deleteNode(root.right, minNode.val);
    }else if(root.val < key) {
    	// ȥ������Ѱ��key
        root.left = deleteNode(root.left, key);
    }else if(root.val > key) {
    	// ȥ������Ѱ��key
        root.right = deleteNode(root.right, key);
    }
    return root;
}

TreeNode getMin(TreeNode node) {
    // BST����ߵľ�����С��
	while(node.left != null) node = node.left;
    return node;
} 
```



### ��ȫ������



01 ͳ����ȫ�������Ľڵ����

```java
public int countNodes(TreeNode root) {
	TreeNode l = root, r = root;
    // ��¼���������ĸ߶�
    int h1 = 0, hr = 0;
    while(l != null) {
    	l = l.left;
        hl++;
    }
    while(r != null) {
    	r = r.right;
        hr++;
    }
    // ������������ĸ߶���ͬ��˵����һ����������
    if(hl == hr) {
    	return (int)Math.pow(2, hl) - 1;
    }
    // ������Ҹ߶Ȳ�ͬ��������ͨ���������߼�����
    return 1 + countNodes(root.left) + countNodes(root.right);
}
```

ʱ�临�Ӷ�Ϊ��O($logN$ * $logN$)







