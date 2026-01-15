package com.leisure.exercise;

import sun.applet.resources.MsgAppletViewer;

import java.util.Arrays;

/**
 * ClassName: Algorithm_2943_LeetCode
 * Package: com.leisure.exercise
 * Description:给你两个整数 n 和 m，以及两个整数数组 hBars 和 vBars。网格由 n + 2 条水平线和 m + 2 条竖直线组成，形成 1x1 的单元格。网格中的线条从 1 开始编号。
 * 你可以从 hBars 中 删除 一些水平线条，并从 vBars 中删除一些竖直线条。注意，其他线条是固定的，无法删除。
 * 返回一个整数表示移除一些线条（可以不移除任何线条）后，网格中 正方形空洞的最大面积 。
 *
 * @Author: MyLeisureLife
 * @Date: 2026/1/15:15:38:58 星期四
 */
public class Algorithm_2943_LeetCode {

    /**
     * 排序 sort 算法
     * 时间复杂度O(H log H + V log V) 空间复杂度: O(log H + log V)
     *  H = hBars.length   V = vBars.length
     * @param n n+2 竖线
     * @param m m+2 横线
     * @param hBars 可以删除的竖线
     * @param vBars 可以删除的横线
     * @return 删除的线的正方行面积
     */
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int side = Math.min(getSide(n, hBars) + 1, getSide(m, vBars) + 1);
        return side * side;
    }

    public int getSide(int n, int[] bars) {
        int b_side = 1;
        int b_side_max = 1;
        for (int i = 0; i < bars.length - 1;  i++){
            if ( 1 < bars[i] && bars[i] < n + 2 && bars[i] + 1 == bars[i + 1] ){
                b_side ++;
                b_side_max = Math.max(b_side_max, b_side);
            }else {
                b_side = 1;
            }
        }
        return b_side_max;
    }

    public static void main(String[] args) {
        int i = new Algorithm_2943_LeetCode().maximizeSquareHoleArea(3, 2, new int[]{4,2,3}, new int[]{3,2});
        System.out.println(i);
    }
}
