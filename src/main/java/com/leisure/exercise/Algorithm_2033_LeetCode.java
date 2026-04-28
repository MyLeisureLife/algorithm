package com.leisure.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ClassName: Algorithm_2033_LeetCode
 * Package: com.leisure.exercise
 * Description:
 * 给你一个大小为 m x n 的二维整数网格 grid 和一个整数 x 。每一次操作，你可以对 grid 中的任一元素 加 x 或 减 x 。
 * 单值网格 是全部元素都相等的网格。
 * 返回使网格化为单值网格所需的 最小 操作数。如果不能，返回 -1 。
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10^5
 * 1 <= m * n <= 10^5
 * 1 <= x, grid[i][j] <= 10^4
 * @Author: MyLeisureLife
 * @Date: 2026/4/28:12:28:15 星期二
 */
public class Algorithm_2033_LeetCode {
    public int minOperations(int[][] grid, int x) {
        int res1 = 0;
        int res2 = 0;
        int c = grid[0][0] % x;
        List<Integer> list = new ArrayList<>();
        for (int[] ints : grid) {
            for (int anInt : ints) {
                if (anInt % x != c) {
                    return -1;
                }
                list.add(anInt);
            }
        }
        Collections.sort(list);
        Integer i = list.get(list.size() / 2);
        for (int anInt : list) {
            res1 += Math.abs(anInt - i) / x;
        }

        Integer j = list.get((list.size() - 1) / 2);
        for (int anInt : list) {
            res2 += Math.abs(anInt - j) / x;
        }

        return Math.min(res1, res2);
    }

    public static void main(String[] args) {
        int i = new Algorithm_2033_LeetCode().minOperations(new int[][]{{1, 5}, {2, 3}}, 1);
        System.out.println(i);
    }
}
