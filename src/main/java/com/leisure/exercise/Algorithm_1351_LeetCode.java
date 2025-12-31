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
     * 暴力算法
     * 直接遍历矩阵
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
     * 二分法算法
     * 每行都是递减的所有可以使用二分法依次处理每行
     * 时间复杂度：O(m * log n)  空间复杂度O(1)  n:矩阵的行数 m:矩阵的列数
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
     * 分治算法
     * 将大问题分成相同的小问题，处理小问题然后合并得到最终结果
     * 可以划分成的小问题为：只找每一行的递减到刚好小于0时的位置。
     * 由于行也是递减的所有可以使用二分法
     * 每一行的 刚好小于0的位置又和上一个小问题计算出的位置有所关联，
     * 时间复杂度0(n log m) 空间复杂度O(log m)
     * @param grid 二维数组
     * @return 数组中小于0的个数
     */
    public int divideAndConquerCountNegatives(int[][] grid) {
        return divideAndConquerRecursive(0, grid.length - 1, 0, grid[0].length - 1, grid);
    }

    /**
     * 分治算法 divide and conquer
     * @param t top 顶部行的行号
     * @param b button底部行的行号
     * @param l left 某行的左边下标
     * @param r right 某行的右边下标
     * @param grid 二维矩阵
     * @return t ~ b 行的负数个数
     */
    private int divideAndConquerRecursive(int t, int b, int l, int r, int[][] grid) {
        // 递归停止条件
        if (b < t) return 0;

        // 寻找中间行
        int mid = t + (b - t) / 2;

        // 寻找中间行的小于0的位置,并将找到的位置记录下来
        int pos = -1;
        for (int i = l; i <= r; i++) {
            if (grid[mid][i] < 0) {
                pos = i;
                break;
            }
        }

        // 记录当前行小于0的个数
        int ans = 0;

        // 如果找到了中间行小于0的位置，就分别处理矩阵的上部分和小部分
        if (pos != -1) {
            // 计算当前行小于0的个数
            ans += grid[0].length - pos;

            // 处理上部分矩阵小于0的个数
            ans += divideAndConquerRecursive(t, mid - 1, pos, r, grid);

            // 处理下部分矩阵小于0的个数
            ans += divideAndConquerRecursive(mid + 1, b, l, pos, grid);

        // 如果当前行没有小于0的位置
        }else {
            // 处理下部分小于0的个数
            ans += divideAndConquerRecursive(mid + 1, b, l, r, grid);
        }

        // 返回当前行小于0的个数
        return ans;
    }


    public static void main(String[] args) {
        int i = new Algorithm_1351_LeetCode().divideAndConquerCountNegatives(new int[][]{{3, 2, -1}, {1, 0, -2},{0, -1, -2}});
        System.out.println(i);
    }
}
