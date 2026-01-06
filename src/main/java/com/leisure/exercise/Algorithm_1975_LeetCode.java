package com.leisure.exercise;

/**
 * ClassName: Algorithm_1975_LeetCode
 * Package: com.leisure.exercise
 * Description:
 *给你一个 n x n 的整数方阵 matrix 。你可以执行以下操作 任意次 ：
 * 选择 matrix 中 相邻 两个元素，并将它们都 乘以 -1 。
 * 如果两个元素有 公共边 ，那么它们就是 相邻 的。
 * 你的目的是 最大化 方阵元素的和。请你在执行以上操作之后，返回方阵的 最大 和。
 * @Author: MyLeisureLife
 * @Date: 2026/1/5:20:29:32 星期一
 */
public class Algorithm_1975_LeetCode {
    /**
     * Tricky question
     * 这道题是个脑筋急转弯对于多个负数情况
     * 当负数是偶数个时总有办法将所有的负数全部变成正数
     * 当负数为奇数时就表明矩阵中肯定有一个负数，所以只需要找一个绝对值最小的数就可以了
     *
     * @param matrix 含有负数的矩阵
     * @return 所有正数的和
     */
    public long maxMatrixSum(int[][] matrix) {
        // 记录矩阵中绝对值最小的数
        int min = Integer.MAX_VALUE;
        // 记录矩阵中负数的个数
        int num = 0;
        // 记录整个矩阵的和
        long sum = 0;
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (anInt < 0) {
                    num++;
                }
                if (Math.abs(anInt) < min) {
                    min = Math.abs(anInt);
                }
                sum += Math.abs(anInt);
            }
        }
        // 如果矩阵的正数是偶数个，就直接返回矩阵正数和就行了。
        if (num % 2 == 0){ return sum; }

        // 如果矩阵正数个数是奇数个就需要减去最小的返回就可以了,应为sum多计算了一次所以要多减去一次。
        return sum - 2L * min;
    }

    public static void main(String[] args) {
        long l = new Algorithm_1975_LeetCode().maxMatrixSum(new int[][]{{1, 2, 3}, {-1, -2, -3}, {1, 2, 3}});
        System.out.println(l);
    }
}
