## leetCode 

`此项目于2021.1.7号 下午创建，旨在回顾数据结构与算法，刷leetCode 准备春招。
之前已经累计算够210题，难易比例大致：4:5:1   此次目的在于二刷，解决第一次
刷题中没弄明白的问题，以及提高刷题速度，回顾总结。`

![image-20210107154707258](E:\dev\javaweb\IDEA\javaExercise\javaInterview\src\guohaoAlgorithm\images\leetCode.png)

### 刷题顺序：

 - **tree** 

   | 题号                                                         | 题名                                                         | 难易程度 | 备注                                                         |
   | ------------------------------------------------------------ | ------------------------------------------------------------ | -------- | ------------------------------------------------------------ |
   | [94](https://leetcode-cn.com/problems/binary-tree-inorder-traversal) | [二叉树的中序遍历](guohaoAlgorithm/tree/InorderTraversal)    | 中等     | 递归<br/>非递归（借助栈）                                    |
   | [226](https://leetcode-cn.com/problems/invert-binary-tree/)  | [翻转二叉树](guohaoAlgorithm.tree.InvertTree)                | 简单     | 递归                                                         |
   | [114](https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list) | [二叉树展为链表](guohaoAlgorithm.tree.Flatten)               | 中等     | 递归<br/>非递归                                              |
   | [652](https://leetcode-cn.com/problems/find-duplicate-subtrees) | [寻找重复的子树](guohaoAlgorithm.tree.FindDuplicateSubtrees) | 中等     | 采用后序遍历，序列化以当前节点为根节点的子树，采用<br/>hashMap<String,Integer> 统计各子树出现的次数，<br/>只将出现一次的加入到结果集中 |
   | [654](https://leetcode-cn.com/problems/maximum-binary-tree)  | [最大二叉树](guohaoAlgorithm.tree.ConstructMaximumBinaryTree) | 中等     | 找出最大值及索引，分区间递归                                 |
   | [116](https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node) | [填充每个节点的下一个右侧指针]()                             | 中等     | 递归<br>非递归（BFS）                                        |
   | [297](https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree) | [二叉树的序列化与反序列化](guohaoAlgorithm.tree.Codec_Postorder) | 困难     | 经典！  前序、后续及BFS三种方法                              |
   | [105](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal) | [从前序与中序遍历序列构造二叉树](guohaoAlgorithm.tree.BuildTree) | 中等     |                                                              |
   | [106](https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal) | [从中序与后序遍历序列构造二叉树](guohaoAlgorithm.tree.BuildTree2) | 中等     |                                                              |
   | [230](https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/) | [二叉搜索树中第K小的元素](guohaoAlgorithm.tree.KthSmallest)  | 中等     | 中序遍历                                                     |
   | [538](https://leetcode-cn.com/problems/convert-bst-to-greater-tree/) | [把二叉搜索树转换为累加树](guohaoAlgorithm.tree.ConvertBST)  | 中等     | 中序遍历                                                     |
   | [1038](https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/) | [把二叉搜索树转换为累加树](guohaoAlgorithm.tree.ConvertBST)  | 中等     |                                                              |
   | [124](https://leetcode-cn.com/problems/binary-tree-maximum-path-sum) | [二叉树中的最大路径和](guohaoAlgorithm.tree.MaxPathSum)      | 困难     | 后序遍历                                                     |
   | [99](https://leetcode-cn.com/problems/recover-binary-search-tree/) | [恢复二叉搜索树](guohaoAlgorithm.tree.RecoverTree)           | 困难     | ==比较抽象，中序遍历==                                       |
   |                                                              |                                                              |          |                                                              |
   |                                                              |                                                              |          |                                                              |
   |                                                              |                                                              |          |                                                              |
   |                                                              |                                                              |          |                                                              |
   |                                                              |                                                              |          |                                                              |
   |                                                              |                                                              |          |                                                              |
   |                                                              |                                                              |          |                                                              |
   |                                                              |                                                              |          |                                                              |
   |                                                              |                                                              |          |                                                              |
   |                                                              |                                                              |          |                                                              |
   |                                                              |                                                              |          |                                                              |
   |                                                              |                                                              |          |                                                              |
   |                                                              |                                                              |          |                                                              |
   |                                                              |                                                              |          |                                                              |
   |                                                              |                                                              |          |                                                              |
   |                                                              |                                                              |          |                                                              |
   |                                                              |                                                              |          |                                                              |
   |                                                              |                                                              |          |                                                              |
   |                                                              |                                                              |          |                                                              |
   |                                                              |                                                              |          |                                                              |
   |                                                              |                                                              |          |                                                              |
   |                                                              |                                                              |          |                                                              |
   |                                                              |                                                              |          |                                                              |
   |                                                              |                                                              |          |                                                              |
   |                                                              |                                                              |          |                                                              |
   |                                                              |                                                              |          |                                                              |
   |                                                              |                                                              |          |                                                              |
   |                                                              |                                                              |          |                                                              |
   |                                                              |                                                              |          |                                                              |
   |                                                              |                                                              |          |                                                              |
   |                                                              |                                                              |          |                                                              |
   |                                                              |                                                              |          |                                                              |
   |                                                              |                                                              |          |                                                              |
   |                                                              |                                                              |          |                                                              |
   |                                                              |                                                              |          |                                                              |
   |                                                              |                                                              |          |                                                              |
   |                                                              |                                                              |          |                                                              |
   |                                                              |                                                              |          |                                                              |
   |                                                              |                                                              |          |                                                              |

- **dynamic** 动态规划

  | [121](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock) | [买卖股票的最佳时机](guohaoAlgorithm.dynamic.MaxProfitI)     | easy   |                    |
  | ------------------------------------------------------------ | ------------------------------------------------------------ | ------ | ------------------ |
  | [122](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii) | [买卖股票的最佳时机 II](guohaoAlgorithm.dynamic.MaxProfitII) | easy   |                    |
  | [123](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii) | [买卖股票的最佳时机 III](guohaoAlgorithm.dynamic.MaxProfitIII) | hard   |                    |
  | [188](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv) | [买卖股票的最佳时机 IV](guohaoAlgorithm.dynamic.MaxProfitIV) | hard   |                    |
  | [714](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee) | [买卖股票的最佳时机含手续费](guohaoAlgorithm.dynamic.MaxProfitV) | medium |                    |
  | [309](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown) | [最佳买卖股票时机含冷冻期](guohaoAlgorithm.dynamic.MaxProfitVI) | medium |                    |
  | [剑指offer63](https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof) | [股票的最大利润](guohaoAlgorithm.dynamic.MaxProfitVII)       | medium | 跟121一样 算easy题 |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |
  |                                                              |                                                              |        |                    |

- **unionfind** 并查集

  | [990](https://leetcode-cn.com/problems/satisfiability-of-equality-equations) | 等式方程的可满足性 | medium | 并查集更简单/dfs |
  | ------------------------------------------------------------ | ------------------ | ------ | ---------------- |
  | [130](https://leetcode-cn.com/problems/surrounded-regions/)  | 被围绕的区域       | medium | 并查集/dfs更简单 |
  |                                                              |                    |        |                  |
  |                                                              |                    |        |                  |
  |                                                              |                    |        |                  |
  |                                                              |                    |        |                  |
  |                                                              |                    |        |                  |
  |                                                              |                    |        |                  |
  |                                                              |                    |        |                  |
  |                                                              |                    |        |                  |
  |                                                              |                    |        |                  |
  |                                                              |                    |        |                  |
  |                                                              |                    |        |                  |
  |                                                              |                    |        |                  |
  |                                                              |                    |        |                  |
  |                                                              |                    |        |                  |
  |                                                              |                    |        |                  |
  |                                                              |                    |        |                  |
  |                                                              |                    |        |                  |
  |                                                              |                    |        |                  |

  



----
