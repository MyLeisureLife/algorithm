package com.leisure.exercise;

import sun.security.provider.Sun;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Algorithm_1161_LeetCode
 * Package: com.leisure.exercise
 * Description:
 * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 * 返回总和 最大 的那一层的层号 x。如果有多层的总和一样大，返回其中 最小 的层号 x。
 * @Author: MyLeisureLife
 * @Date: 2026/1/6:10:42:46 星期二
 */

public class Algorithm_1161_LeetCode {
    public class TreeNode {
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
     * BFS Breadth-First Search
     * 首先看到这个题目就可以想到广度优先算法
     * 使用队列
     * 时间复杂度O(n)  空间复杂度(n) n:节点个数
     * @param root 树
     * @return 每层和最大，层最小·
     */
    public int maxLevelSumBFS(TreeNode root) {
        // 层数
        int level = 1;
        // 层节点和最大是那层
        int ans = 1;
        // 某层的各个节点总和
        int levelSum = Integer.MIN_VALUE;
        //上一层队列
        List<TreeNode> preQueue = new ArrayList<>();
        preQueue.add(root);
        // 判定当前层是否存在节点
        while (!preQueue.isEmpty()) {

            //当层节点的和
            int curSum = 0;
            // 计算当层节点总和 并 存储下一层节点位置
            List<TreeNode> nextQueue = new ArrayList<>();
            for (TreeNode node : preQueue) {
                // 计算当层节点和
                curSum += node.val;
                // 存储下一层节点
                if (node.left != null) {
                    nextQueue.add(node.left);
                }
                if (node.right != null) {
                    nextQueue.add(node.right);
                }
            }

            // 向下走一层
            preQueue = nextQueue;

            // 判断当前层节点的和是否比其他层的和大
            if (curSum > levelSum) {
                levelSum = curSum;
                ans = level;
            }

            //到下一层
            level++;
        }

       return ans;
    }

}
