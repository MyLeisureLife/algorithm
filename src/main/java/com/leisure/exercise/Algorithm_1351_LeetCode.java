package com.leisure.exercise;

import sun.applet.Main;

/**
 * ClassName: Algorithm_1351_LeetCode
 * Package: com.leisure.exercise
 * Description:
 * 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非严格递减顺序排列。 请你统计并返回 grid 中 负数 的数目。
 *
 * @Author: MyLeisureLife
 * @Date: 2025/12/30:09:51:03 星期二
 */
public class Algorithm_1351_LeetCode {
    /**
     * 暴力算法直接遍历矩阵
     * 时间复杂度：O(n * m)  空间复杂度O(1)  n:矩阵的行数 m:矩阵的列数
     *
     * @param grid 递减矩阵
     * @return 矩阵中所有负数个数
     */
    public int violenceCountNegatives(int[][] grid) {
        int count = 0;
        for (int[] row : grid) {
            for (int col : row) {
                if (col < 0) count++;
            }
        }
        return count;
    }

    /**
     * 每行都是递减的所有可以使用二分法依次处理每行
     *时间复杂度：O(n * log m)  空间复杂度O(1)  n:矩阵的行数 m:矩阵的列数
     * @param grid 递减矩阵
     * @return 矩阵中所有负数个数
     */
    public int binarySearchCountNegatives(int[][] grid) {
        // 统计负数个数
        int num = 0;

        // 遍历矩阵每一行
        for (int[] row : grid) {

            //执行二分法，l 左边界  r 右边界  pos找到的中心点位置
            int l = 0, r = row.length - 1, pos = -1;
            while (l <= r){
                // 计算中间位置
                int mid = l + (r - l) / 2;

                // 找到二分准确位置时
                if (row[mid] < 0) {
                    pos = mid;
                    //right 左移动
                    r = mid - 1;
                }else{
                    // right 右移动
                    l = mid + 1;
                }
            }

            if (pos != -1) {
                num += row.length - pos;
            }


        }

        return num;
    }


    /**
     *  分治算法
     * @param l
     * @param r
     * @param L
     * @param R
     * @param grid
     * @return
     */
    private int solve(int l, int r, int L, int R, int[][] grid) {
        if (l > r) {
            return 0;
        }

        int mid = l + (r - l) / 2;
        int pos = -1;
        // 在当前行中查找第一个负数
        for (int i = L; i <= R; i++) {
            if (grid[mid][i] < 0) {
                pos = i;
                break;
            }
        }

        int ans = 0;
        if (pos != -1) {
            // 当前行找到负数，计算当前行的负数个数
            ans += grid[0].length - pos;
            // 递归处理上半部分（使用更小的列范围）
            ans += solve(l, mid - 1, pos, R, grid);
            // 递归处理下半部分（使用相同的列起始范围）
            ans += solve(mid + 1, r, L, pos, grid);
        } else {
            // 当前行没有负数，只需要递归处理下半部分
            ans += solve(mid + 1, r, L, R, grid);
        }
        return ans;
    }

    public int countNegatives(int[][] grid) {
        return solve(0, grid.length - 1, 0, grid[0].length - 1, grid);
    }



    public int countNegatives(int[][] grid) {

        //使用二分法进行查找

        // 查找行

        return 0;
    }

    public static void main(String[] args) {
        int i = new Algorithm_1351_LeetCode().binarySearchCountNegatives(new int[][]{{3, 2}, {1, 0}});
        System.out.println(i);
    }
}
