package com.leisure.exercise;

/**
 * ClassName: Algorithm_1292_LeetCode
 * Package: com.leisure.exercise
 * Description:
 * 给你一个大小为 m x n 的矩阵 mat 和一个整数阈值 threshold。
 * 请你返回元素总和小于或等于阈值的正方形区域的最大边长；如果没有这样的正方形区域，则返回 0 。
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 300
 * 0 <= mat[i][j] <= 104
 * 0 <= threshold <= 105
 * 时间复杂度O(n^5) 空间复杂度O(1)
 * @Author: MyLeisureLife
 * @Date: 2026/1/19:12:39:19 星期一
 */
public class Algorithm_1292_LeetCode {
    /**
     * Brute-Force Algorithm 暴力算法
     * 时间复杂度O(n^5) 空间复杂度O(1)
     * 时间复杂度太高了，需要增加空间来降低时间复杂度
     * @param mat 矩阵
     * @param threshold 介值
     * @return 最大正方形边
     */
    public int maxSideLength1(int[][] mat, int threshold) {
        int maxSide = 0;
        int min = Math.min(mat.length, mat[0].length);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                // 所有有可能的正方行边长
                for (int k = 1; k <= min; k++) {
                    // 获取mat[i][j]为顶点的k边长的面积
                    int squareArea = getSquareArea(i, j, mat, k);
                    // 如果面积小于等于阈值并且大于等于0就是可以形成最大的边长
                    if (squareArea <= threshold && squareArea >= 0) {
                        maxSide = Math.max(maxSide, k);
                    }
                }
            }
        }
        return maxSide;
    }
    public int getSquareArea1(int row, int col, int[][] mat, int sideLength) {
        // 如果矩阵点已经不能形成正方行就返回-1
        if (mat.length < sideLength + row  || mat[row].length  < sideLength + col)
            return -1;
        // sideLength边长的正方行面积
        int area = 0;
        for (int i = row; i < row + sideLength; i++) {
            for (int  j = col; j < col +sideLength; j++) {
                area += mat[i][j];
            }
        }
        return area;
    }

    /**
     * 二维前缀和
     * @param mat 矩阵
     * @param threshold 阀值
     * @return 最大边
     */
    public int maxSideLength(int[][] mat, int threshold) {
        int maxSide = 0;
        int min = Math.min(mat.length, mat[0].length);
        int row = mat.length;
        int col = mat[0].length;
        // 构建 (m+1) x (n+1) 的前缀和数组
        int [][] pre = new int[row + 1][col + 1];
        // 构建出来后计算任意矩形面积都可以在O(1)时间复杂度求出
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                pre[i + 1][j + 1] = mat[i][j]
                        + pre[i + 1][j] // 加上 左边
                        + pre[i][j + 1] // 加上 上边
                        - pre[i][j];    //  减去重叠部分
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                // 所有有可能的正方行边长
                for (int k = 1; k <= min; k++) {
                    // 获取mat[i][j]为顶点的k边长的面积
                    int squareArea = getSquareArea(i, j, pre, k);
                    // 如果面积小于等于阈值并且大于等于0就是可以形成最大的边长
                    if (squareArea <= threshold && squareArea >= 0) {
                        maxSide = Math.max(maxSide, k);
                    }
                }
            }
        }
        return maxSide;

    }

    /**
     * 获取任意矩形面积
     * @param row 开始行的坐标
     * @param col 开始列的坐标
     * @param pre 预处理的矩形
     * @param sideLength 正方行边长
     * @return 返回矩形面积
     */
    public int getSquareArea(int row, int col, int[][] pre, int sideLength) {
        // 如果矩阵点已经不能形成正方行就返回-1
        if (pre.length - 1 < sideLength + row  || pre[row].length - 1  < sideLength + col)
            return -1;
        // 矩形结束的坐标
        int endRow = row + sideLength;
        int endCol = col + sideLength;
        // 计算面积
        return pre[endRow][endCol] + pre[row][col] - pre[row][endCol] - pre[endRow][col];
    }

    public static void main(String[] args) {
        int [][] a = new int[][] { {2,2,2,2,2},{2,2,2,2,2},{2,2,2,2,2},{2,2,2,2,2},{2,2,2,2,2}};
        int i = new Algorithm_1292_LeetCode().maxSideLength(a, 1);
        System.out.println(i);
    }
}
