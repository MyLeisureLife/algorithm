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


    public static void main(String[] args) {
        int i = new Algorithm_1351_LeetCode().binarySearchCountNegatives(new int[][]{{3, 2}, {1, 0}});
        System.out.println(i);
    }
}
