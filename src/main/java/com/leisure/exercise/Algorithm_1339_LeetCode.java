package com.leisure.exercise;

/**
 * ClassName: Algorithm_1339_LeetCode
 * Package: com.leisure.exercise
 * Description:
 * 给你一棵二叉树，它的根为 root 。
 * 请你删除 1 条边，使二叉树分裂成两棵子树，且它们子树和的乘积尽可能大。
 * 由于答案可能会很大，请你将结果对 10^9 + 7 取模后再返回
 * 每棵树最多有 50000 个节点，且至少有 2 个节点。
 * 每个节点的值在 [1, 10000] 之间。
 * @Author: MyLeisureLife
 * @Date: 2026/1/7:11:28:52 星期三
 */
public class Algorithm_1339_LeetCode {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    // 记录两颗树的最大乘积
    long ans = 0;
    int MOD = 1000000007;
    /**
     * Depth-First Search 深度优先算法
     * 应为需要遍历所有树节点，所以不需要回溯
     * 时间复杂度O(n) 两次完整遍历，线性时间
     * 空间复杂度 O(h)，最坏 O(n)  由递归栈深度决定，h 为树高
     * @param root 二叉树
     * @return 将二叉树分成两个二叉树，并让两个二叉树的成绩最大
     */
    public int maxProduct(TreeNode root) {
        // treeSum: 树各个节点的和
        long treeSum = dfs(root);
        // 求子树的根的位置
        findMaxTowTreeProduct(root, treeSum);
        // 将结果取模
        return (int)(ans % MOD);
    }

    /**
     * Depth-First Search 深度优先搜索
     * @param root 树的根节点
     * @return 当前节点下的所有节点和
     */
    public long dfs(TreeNode root) {
        if (root == null) return 0;
        return root.val + dfs(root.left) + dfs(root.right);
    }

    /**
     * 找到最大两个子树的乘积
     * @param root 根节点
     * @param treeSum 树节点的总和
     */
    public long findMaxTowTreeProduct(TreeNode root, long treeSum) {
        // 如果当前树是空的就返回0
        if (root == null) return 0;
        // 如果不是就去找他root树的和
        long left = findMaxTowTreeProduct(root.left, treeSum);
        long right = findMaxTowTreeProduct(root.right, treeSum);
        long rootSum = left + right + root.val;
        // 在这样递归的找下去会让每个节点都成为树根一次
        // 这时我们只需要判断和这个树是不是子树就可以了
        // 当不是子树的时候
        if (treeSum != rootSum){
            ans = Math.max(ans, rootSum * (treeSum - rootSum));
        };
       return rootSum;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

//        treeNode.left.left = new TreeNode(4);
//        treeNode.left.right = new TreeNode(5);
//
//        treeNode.right.left = new TreeNode(6);


        int i = new Algorithm_1339_LeetCode().maxProduct(treeNode);

        System.out.println(i);


    }
}
