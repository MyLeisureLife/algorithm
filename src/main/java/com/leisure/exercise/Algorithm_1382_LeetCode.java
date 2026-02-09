package com.leisure.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Algorithm_1382_LeetCode
 * Package: com.leisure.exercise
 * Description:
 * 给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。如果有多种构造方法，请你返回任意一种。
 * 如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。
 *
 * @Author: MyLeisureLife
 * @Date: 2026/2/9:20:04:12 星期一
 */
public class Algorithm_1382_LeetCode {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    List<Integer> list = new ArrayList<Integer>();
    /**
     * 深度优先遍历 DFS
     * @param root 树
     * @return 平衡二叉树
     */
    public TreeNode balanceBST(TreeNode root) {
        // 将节点全部存储起来
        DFS(root);

        return buildTree(0, list.size() - 1);
    }

    public void DFS(TreeNode root) {
        // 左边递归
        if (root.left != null) DFS(root.left);
        // 添加到数组中
        list.add(root.val);
        // 右边递归
        if (root.right != null) DFS(root.right);
    }

    public TreeNode buildTree(int l, int r) {
        // 计算中间值
        int mid = (l + r) >> 1;
        // 生成一个节点
        TreeNode treeNode = new TreeNode(list.get(mid));
        // 左边的全部分给左边
        if (l <= mid - 1) treeNode.left = buildTree(l, mid - 1);
        // 右边的全部分给右边
        if (r >= mid + 1) treeNode.right = buildTree(mid + 1, r);
        return treeNode;
    }
}
