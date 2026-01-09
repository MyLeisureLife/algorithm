package com.leisure.exercise;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Algorithm_865_LeetCode
 * Package: com.leisure.exercise
 * Description:
 * 给定一个根为 root 的二叉树，每个节点的深度是 该节点到根的最短距离 。
 * 返回包含原始树中所有 最深节点 的 最小子树 。
 * 如果一个节点在 整个树 的任意节点之间具有最大的深度，则该节点是 最深的 。
 * 一个节点的 子树 是该节点加上它的所有后代的集合。
 * @Author: MyLeisureLife
 * @Date: 2026/1/9:11:02:16 星期五
 */
public class Algorithm_865_LeetCode {
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

    /**
     * Depth-First Search 深度优先搜索
     * 需要注意当最深节点只有一个时最深子树就是它自己
     * 树中节点的数量在 [1, 500] 范围内。
     * 0 <= Node.val <= 500
     * @param root 二叉树
     * @return 最深节点的子树
     */
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).getKey();
    }

    /**
     *  用于求当前树根所在深度
     * @param root 树
     * @return 键值对，键：树根位置， 值:坐在深度
     */
    public Pair<TreeNode, Integer> dfs(TreeNode root) {
        // 递归停止条件
        if (root == null) return new Pair<>(null, 0);

        // 其余情况root不为null，计算左节点树根深度 和 右节树根深度
        Pair<TreeNode, Integer> l = dfs(root.left);
        Pair<TreeNode, Integer> r = dfs(root.right);

        // 判断左右两边那边深度更深
        if (l.getValue() > r.getValue()){
            return new Pair<>(l.getKey(), l.getValue() + 1);
        }
        if (r.getValue() > l.getValue()){
            return new Pair<>(r.getKey(), r.getValue() + 1);
        }

        // 如果深度相等情况返回上一层节点，而且深度需要+1
        return new Pair<>(root, l.getValue() + 1);
    }
}
