package com.leisure.exercise;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ClassName: Algorithm_1123_LeetCode
 * Package: com.leisure.exercise
 * Description:
 *给你一个有根节点 root 的二叉树，返回它 最深的叶节点的最近公共祖先 。
 * 回想一下：
 * 叶节点 是二叉树中没有子节点的节点
 * 树的根节点的 深度 为 0，如果某一节点的深度为 d，那它的子节点的深度就是 d+1
 * 如果我们假定 A 是一组节点 S 的 最近公共祖先，S 中的每个节点都在以 A 为根节点的子树中，且 A 的深度达到此条件下可能的最大值。
 * @Author: MyLeisureLife
 * @Date: 2025/4/4:10:45:42 星期五
 */
public class Algorithm_1123_LeetCode {
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

    /**
     *
     * @param root 根节点
     * @return  最深的叶节点的最近公共祖先
     */
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        // 获取 最深的叶节点的最近公共祖先
        return f(root).getKey();
    }

    /**
     * 创建一个递归函数，遍历整个二叉树
     * @param root 节点
     * @return 键值对 键：节点， 值：二叉树的深度
     */
    public Pair<TreeNode, Integer> f(TreeNode root) {
        // 递归终止条件
        if (root == null) {
            return new Pair<TreeNode, Integer>(null, 0);
        }

        // 递归的遍历, 遍历左右两边 这里的 TreeNode 不等于 root.left
        Pair<TreeNode, Integer> left = f(root.left);
        Pair<TreeNode, Integer> right = f(root.right);

        // 当左边深度大于右边深度时 返回左边节点 和 对应深度 ，left.getValue() + 1 是为了准确描述节点所在深度，最后返回的数据会多加了一次，但是不要紧我们只是需要节点坐标而已
        if (left.getValue() > right.getValue()) {
            return new Pair<TreeNode, Integer>(left.getKey(), left.getValue() + 1);
        }
        // 当右边深度大于左边深度时 返回右边节点 和 对应深度
        if (left.getValue() < right.getValue()) {
            return new Pair<TreeNode, Integer>(right.getKey(), right.getValue() + 1);
        }

        // 剩下的情况就是 左右节点的深度相等时, 这时就返回自己本身 和 对应深度，这里的深度+1 选做或者右都是一样的
        return new Pair<TreeNode, Integer>(root, right.getValue() + 1);


    }
}
