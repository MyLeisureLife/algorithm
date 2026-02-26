package com.leisure.exercise;

/**
 * ClassName: Algorithm_1404_LeetCode
 * Package: com.leisure.exercise
 * Description:
 *  给你一个以二进制形式表示的数字 s 。请你返回按下述规则将其减少到 1 所需要的步骤数：
 * 如果当前数字为偶数，则将其除以 2 。
 * 如果当前数字为奇数，则将其加上 1 。
 * 题目保证你总是可以按上述规则将测试用例变为 1 。
 * 1 <= s.length <= 500
 * s 由字符 '0' 或 '1' 组成。
 * s[0] == '1'
 * @Author: MyLeisureLife
 * @Date: 2026/2/26:12:45:35 星期四
 */
public class Algorithm_1404_LeetCode {
    /**
     * 时间复杂度O(n) 空间复杂度O(1)
     * @param s 二进制字符串
     * @return 需要执行多少次操作
     */
    public int numSteps(String s) {
        int ans = 0;
        boolean carryBit = false;
        for (int i = s.length() - 1; i > 0; i--) {
            // 四种情况：当前为0 不进位 只执行删除
            if (s.charAt(i) == '0' && !carryBit) {
                ans++;
                continue;
            }
            // 四种情况：当前为1 不进位  需要执行+1进位 和 删除
            if (s.charAt(i) == '1' && !carryBit) {
                carryBit = true;
                ans += 2;
                continue;
            }
           // 四种情况：当前为0 进位 需要执行+1进位 和 删除
            if (s.charAt(i) == '0' && carryBit) {
                ans += 2;
                continue;
            }
            // 四种情况：当前为1 进位 只需要执行 删除
            if (s.charAt(i) == '1' && carryBit) {
                ans ++;
            }

        }
        if (carryBit) { ans ++; }
        return ans;
    }

    public static void main(String[] args) {
        int i = new Algorithm_1404_LeetCode().numSteps("11000");
        System.out.println(i);
    }
}
