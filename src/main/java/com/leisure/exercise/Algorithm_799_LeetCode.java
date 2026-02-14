package com.leisure.exercise;

/**
 * ClassName: Algorithm_799_LeetCode
 * Package: com.leisure.exercise
 * Description:
 * 我们把玻璃杯摆成金字塔的形状，其中 第一层 有 1 个玻璃杯， 第二层 有 2 个，依次类推到第 100 层，每个玻璃杯将盛有香槟。
 * 从顶层的第一个玻璃杯开始倾倒一些香槟，当顶层的杯子满了，任何溢出的香槟都会立刻等流量的流向左右两侧的玻璃杯。当左右两边的杯子也满了，就会等流量的流向它们左右两边的杯子，依次类推。（当最底层的玻璃杯满了，香槟会流到地板上）
 * 例如，在倾倒一杯香槟后，最顶层的玻璃杯满了。倾倒了两杯香槟后，第二层的两个玻璃杯各自盛放一半的香槟。在倒三杯香槟后，第二层的香槟满了 - 此时总共有三个满的玻璃杯。在倒第四杯后，第三层中间的玻璃杯盛放了一半的香槟，他两边的玻璃杯各自盛放了四分之一的香槟，如下图所示。
 * 现在当倾倒了非负整数杯香槟后，返回第 i 行 j 个玻璃杯所盛放的香槟占玻璃杯容积的比例（ i 和 j 都从0开始）。
 * 0 <= poured <= 10^9
 * 0 <= query_glass <= query_row < 100
 * @Author: MyLeisureLife
 * @Date: 2026/2/14:12:57:02 星期六
 */
public class Algorithm_799_LeetCode {
    /**
     *
     * @param poured 总投放水数量
     * @param query_row 行 - 1
     * @param query_glass 第几杯 - 1
     * @return 查询的那杯 有多少水量
     */
    public double champagneTower(int poured, int query_row, int query_glass) {

        // 第一层
        double[] row_glass = {poured};
        // 从第二层开始循环
        for (int i = 1; i <= query_row; i++) {
            // 第二层
            double[] row_glass_next = new double[i + 1];
            // 变量第一层的水看怎么分
            for (int j = 0; j < i; j++) {
                // 首先第一层的水量必须大于1才能分给第二层
                if (row_glass[j] > 1) {
                    row_glass_next[j] += (row_glass[j] - 1) / 2;
                    row_glass_next[j + 1] += (row_glass[j] - 1) / 2;
                }
            }
            // 将第二层变成第一层
            row_glass = row_glass_next;
        }

        return Math.min(row_glass[query_glass], 1);
    }

    public static void main(String[] args) {
        double v = new Algorithm_799_LeetCode().champagneTower(1, 1, 1);
        System.out.println(v);
    }
}
