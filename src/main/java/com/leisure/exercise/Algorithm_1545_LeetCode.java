package com.leisure.exercise;

/**
 * ClassName: Algorithm_1545_LeetCode
 * Package: com.leisure.exercise
 * Description:
 *给你两个正整数 n 和 k，二进制字符串  Sn 的形成规则如下：
 * S1 = "0"
 * 当 i > 1 时，Si = Si-1 + "1" + reverse(invert(Si-1))
 * 其中 + 表示串联操作，reverse(x) 返回反转 x 后得到的字符串，而 invert(x) 则会翻转 x 中的每一位（0 变为 1，而 1 变为 0）。
 * 1 <= n <= 20
 * 1 <= k <= 2^n - 1
 * 例如，符合上述描述的序列的前 4 个字符串依次是：
 * @Author: MyLeisureLife
 * @Date: 2026/3/3:12:36:26 星期二
 */
public class Algorithm_1545_LeetCode {
    /**
     * 时间复杂度O(n * m) n：次数 m：字符长度 空间复杂度O(n*m)
     * @param n 需要执行的次数
     * @param k 得到最后s的第k位
     * @return k位的结果
     */
    public char findKthBit(int n, int k) {
        StringBuilder s = new StringBuilder();
        s.append('0');
        for (int i = 2; i <= n; i++) {
            StringBuilder string = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    string.append('0');
                }else {
                    string.append('1');
                }
            }
            s.append("1").append(string.reverse());
        }
        return s.charAt(k - 1);
    }


    public static void main(String[] args) {
        char kthBit = new Algorithm_1545_LeetCode().findKthBit(4, 11);
        System.out.println(kthBit);
    }
}
