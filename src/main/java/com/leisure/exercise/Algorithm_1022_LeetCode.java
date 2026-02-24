package com.leisure.exercise;

/**
 * ClassName: Algorithm_1022_LeetCode
 * Package: com.leisure.exercise
 * Description:
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
 * 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 * 树中的节点数在 [1, 1000] 范围内
 * Node.val 仅为 0 或 1
 * @Author: MyLeisureLife
 * @Date: 2026/2/24:10:01:12 星期二
 */
public class Algorithm_1022_LeetCode {
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

    int ans = 0;
    /**
     * Depth First Search 深度优先算法
     * 时间复杂度O(n^2)  空间复杂度O(h) h：树的高度
     * @param root 树根节点
     * @return 根节点到叶子节点所有的和
     */
    public int sumRootToLeaf(TreeNode root) {
        DFS(root, new StringBuilder());
        return ans;
    }

    private void DFS(TreeNode root, StringBuilder s) {
        // 停止递归
        if (root == null) return;

        // 递归运算
        s.append(root.val);
        DFS(root.left, s);
        DFS(root.right, s);

        // 只能在叶子节点才能计算这个
        if (root.left == null && root.right == null) {
            ans += Integer.parseInt(s.toString(), 2);
        }


        // 递归回溯
        s.deleteCharAt(s.length() - 1);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(1);
        System.out.println(new Algorithm_1022_LeetCode().sumRootToLeaf(root));
    }

}
