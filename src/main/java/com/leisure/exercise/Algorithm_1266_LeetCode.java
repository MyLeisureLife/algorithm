package com.leisure.exercise;

/**
 * ClassName: Algorithm_1266_LeetCode
 * Package: com.leisure.exercise
 * Description:
 * 平面上有 n 个点，点的位置用整数坐标表示 points[i] = [xi, yi] 。请你计算访问所有这些点需要的 最小时间（以秒为单位）。
 * 你需要按照下面的规则在平面上移动：
 * 每一秒内，你可以：
 * 沿水平方向移动一个单位长度，或者
 * 沿竖直方向移动一个单位长度，或者
 * 跨过对角线移动 sqrt(2) 个单位长度（可以看作在一秒内向水平和竖直方向各移动一个单位长度）。
 * 必须按照数组中出现的顺序来访问这些点。
 * 在访问某个点时，可以经过该点后面出现的点，但经过的那些点不算作有效访问。
 * @Author: MyLeisureLife
 * @Date: 2026/1/12:07:28:42 星期一
 */
public class Algorithm_1266_LeetCode {
    /**
     * Chebyshev distance Algorithm 切比雪夫距离
     * 两点之间最短
     * @param points 点的位置
     * @return 点的所有最短距离所花时间之和
     */
    public int minTimeToVisitAllPoints(int[][] points) {
        int minPath = 0;
        for (int i = 0; i < points.length - 1; i++) {
            minPath +=  Math.max(Math.abs(points[i][0] - points[i + 1][0]), Math.abs(points[i][1] - points[i + 1][1]));
        }
        return minPath;
    }
}
