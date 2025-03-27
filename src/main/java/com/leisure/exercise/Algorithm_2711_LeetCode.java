package com.leisure.exercise;

import java.util.*;

/**
 * ClassName: Algorithm_2711_LeetCode
 * Package: com.leisure.exercise
 * Description: 这种方法可以解出问题答案，时间复杂度：O(x * y * min(x, y)) ， 空间复杂度：O(min(x, y))
 * 给你一个下标从 0 开始、大小为 m x n 的二维矩阵 grid ，
 * 请你求解大小同样为 m x n 的答案矩阵 answer 。
 * 矩阵 answer 中每个单元格 (r, c) 的值可以按下述方式进行计算：
 * 令 topLeft[r][c] 为矩阵 grid 中单元格 (r, c) 左上角对角线上 不同值 的数量。
 * 令 bottomRight[r][c] 为矩阵 grid 中单元格 (r, c) 右下角对角线上 不同值 的数量。
 * 然后 answer[r][c] = |topLeft[r][c] - bottomRight[r][c]| 。
 * 返回矩阵 answer 。
 * 矩阵对角线 是从最顶行或最左列的某个单元格开始，向右下方向走到矩阵末尾的对角线。
 * 如果单元格 (r1, c1) 和单元格 (r, c) 属于同一条对角线且 r1 < r ，则单元格 (r1, c1) 属于单元格 (r, c) 的左上对角线。类似地，可以定义右下对角线。
 * @Author: MyLeisureLife
 * @Date: 2025/3/25:19:16:03 星期二
 */
public class Algorithm_2711_LeetCode {

    public int[][] differenceOfDistinctValues(int[][] grid) {
        int[][] answer = new int[grid.length][grid[0].length];
        // 循环遍历
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                int[] diagonal = getDiagonal(i,j,grid);
                answer[i][j] = Math.abs(diagonal[0] - diagonal[1]);
            }
        }
        return answer;
    }

    /**
     * 获取grid某点的左上角 和 右下角 不同的数的个数
     * @return 数组， index0:topLeft的个数，index1:bottomRight个数
     */
    public int[] getDiagonal(int x, int y, int[][] grid) {
        int[] answer = new int[2];
        Set<Integer> saveNumber = new HashSet<Integer>();
        int gridX, gridY;
        // 找寻对角线的起始坐标
        if (x >= y){
            gridX = x - y;
            gridY = 0;
        }else {
            gridY = y - x;
            gridX = 0;
        }

        while ( gridX < grid.length && gridY < grid[0].length){
            if (gridX == x ){saveNumber.clear();}

            if (!saveNumber.contains(grid[gridX][gridY])&& gridX != x){
                saveNumber.add(grid[gridX][gridY]);
                // 记录听添加类型,还是右上角添加的还是右下角添加的
                if ( gridX < x){
                    answer[0]++;
                }else {
                    answer[1]++;
                }
            }

            gridX ++;
            gridY ++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] a = new Algorithm_2711_LeetCode().differenceOfDistinctValues(new int[][]{{1, 2, 3}, {3, 1, 5}, {3, 2, 1}});
        System.out.println(Arrays.deepToString(a));
    }

}
