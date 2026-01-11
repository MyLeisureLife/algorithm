package com.leisure.exercise;

import java.util.concurrent.ForkJoinPool;

/**
 * ClassName: Algorithm_85_LeetCode
 * Package: com.leisure.exercise
 * Description:
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * @Author: MyLeisureLife
 * @Date: 2026/1/11:14:14:16 星期日
 */
public class Algorithm_85_LeetCode {
    /**
     * Brute-Force Algorithm 暴力算法
     * 时间复杂度O(m²n²) 空间复杂度：O(1)
     * @param matrix 矩阵
     * @return 1最大矩形面积
     */
    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                maxArea = Math.max(maxArea, pointMaxArea(i, j, matrix));
            }
        }
        return maxArea;
    }

    /**
     *
     * @param matrix 矩阵
     * @param row 行
     * @param col 列
     * @return 当前矩阵点最大面积
     */
    public  int pointMaxArea(int row, int col, char[][] matrix) {
        //初始面积
        int area = 0;
        int minLength = Integer.MAX_VALUE;
        // 以高为主，当高度不在增加就结束
        int height = 0;
        for(int i = row ; i < matrix.length; i++){
            if(matrix[i][col] == '1'){
                height ++;
            // 当高度不在增加时，就返回当前点的最大面积
            }else {
                return area;
            }
            // 再特定高度下去算当前面积
            int length = 0;
            for(int j = col ; j < matrix[i].length ; j++){
                if(matrix[i][j] == '1'){
                    length++;

                }
                // 当长度达到最大时就需要比较范围了，保留最大范围
                if(matrix[i][j] == '0' || j == matrix[i].length - 1){
                    minLength = Math.min(length, minLength);
                    area = Math.max(area, height*minLength);
                    break;
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int i = new Algorithm_85_LeetCode().maximalRectangle(
                new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}});
        System.out.println(i);


    }
}
