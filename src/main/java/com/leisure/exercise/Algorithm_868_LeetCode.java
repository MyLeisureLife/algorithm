package com.leisure.exercise;

import sun.reflect.misc.FieldUtil;

/**
 * ClassName: Algorithm_868_LeetCode
 * Package: com.leisure.exercise
 * Description:
 *给定一个正整数 n，找到并返回 n 的二进制表示中两个 相邻 1 之间的 最长距离 。如果不存在两个相邻的 1，返回 0 。
 * 如果只有 0 将两个 1 分隔开（可能不存在 0 ），则认为这两个 1 彼此 相邻 。两个 1 之间的距离是它们的二进制表示中位置的绝对差。例如，"1001" 中的两个 1 的距离为 3 。
 * 1 <= n <= 109
 * @Author: MyLeisureLife
 * @Date: 2026/2/22:19:20:02 星期日
 */
public class Algorithm_868_LeetCode {
    /**
     * 时间复杂度O(lng n) 空间复杂度O(1)
     * @param n 需要判断的二进制数
     * @return 二进制数1之间相最大相差多少个0
     */
    public int binaryGap(int n) {
        int ans = 0;
        int last = -1;
        for (int i = 0; n != 0; i++) {
            if ((n & 1) == 1) {
                if (last != -1) {
                    ans = Math.max(ans, i - last);
                }
                last = i;
            }
            n = n >> 1;
        }
     return ans;
    }
}
