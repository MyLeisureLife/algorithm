package com.leisure.exercise;

import javax.sql.rowset.FilteredRowSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: Algorithm_1536_LeetCode
 * Package: com.leisure.exercise
 * Description:
 * 给你一个 n x n 的二进制网格 grid，每一次操作中，你可以选择网格的 相邻两行 进行交换。
 * 一个符合要求的网格需要满足主对角线以上的格子全部都是 0 。
 * 请你返回使网格满足要求的最少操作次数，如果无法使网格符合要求，请你返回 -1 。
 * 主对角线指的是从 (1, 1) 到 (n, n) 的这些格子。
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 200
 * grid[i][j] 要么是 0 要么是 1 。
 * @Author: MyLeisureLife
 * @Date: 2026/3/2:12:47:04 星期一
 */
public class Algorithm_1536_LeetCode {
    /**
     * 使用了链表交换不会改变顺序后续顺序
     * 时间复杂度O(n^2) 空间复杂度O(n)
     * @param grid 二维表格
     * @return 最少需要换行几次
     */
    public int minSwaps(int[][] grid) {
        int ans = 0;
        List<Integer> list = new LinkedList<>();
        for (int[] ints : grid) {
            int c = 0;
            for (int j = grid.length - 1; j >= 0; j--) {
                if (ints[j] == 0) {
                    c++;
                } else {
                    break;
                }
            }
            list.add(c);
        }

        // 将最小的移动到最后
        for (int i = 0; i < list.size(); i++){
            for (int j = i; j < list.size(); j++){
                // 如果找到找到了 符合当前行的0的个数行 就当前行和它交换
                if(list.size() - i - 1 <= list.get(j)){
                    ans += j - i;
                    // 是否需要执行交换操作
                    if (j - i > 0){
                        Integer temp = list.get(j);
                        list.remove(j);
                        list.add(i, temp);
                    }
                    break;
                // 当判断到最后一行都没有执行交换操作就表示没有符合的
                }else if(j == list.size() - 1){return -1;}

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int i = new Algorithm_1536_LeetCode().minSwaps(new int[][]{
                {0,0,1},{1,1,0},{1,0,0}
        });
        System.out.println(i);
    }
}
