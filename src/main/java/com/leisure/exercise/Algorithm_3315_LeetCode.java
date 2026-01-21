package com.leisure.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: Algorithm_3315_LeetCode
 * Package: com.leisure.exercise
 * Description:
 * 给你一个长度为 n 的 质数 数组 nums 。你的任务是返回一个长度为 n 的数组 ans ，对于每个下标 i ，以下 条件 均成立：
 * ans[i] OR (ans[i] + 1) == nums[i]
 * 除此以外，你需要 最小化 结果数组里每一个 ans[i] 。
 * 如果没法找到符合 条件 的 ans[i] ，那么 ans[i] = -1 。
 * 质数 指的是一个大于 1 的自然数，且它只有 1 和自己两个因数。
 * 将时间复杂度规定为O(n)
 * @Author: MyLeisureLife
 * @Date: 2026/1/21:16:20:46 星期三
 */
public class Algorithm_3315_LeetCode {
    /**
     * 使用| & ~ ^ 方式 位运行 解决问题
     * @param nums 质数列表
     * @return 符合条件的数组
     */
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int a = nums.get(i);
            if (a == 2){
                ans[i] = -1;
            }else{
                // 取反求出所有0的位置
                int c = ~a;
                // 找出第一个0的位置
                int d = -c; // c的负数，是将c的二进制取反后加1
                int e = d & c; //然后两个位都是1时为1，其他为0，所以这样就求出了第一个0的位置
                // 将第一个0的位置向前移动一位，a对应的这一位变成0就是满足条件的数
                int f = e >> 1; //将位置向右移动一位。
                ans[i] = f ^ a; //进行异或操作就可以得到结果了
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        List<Integer> objects = new ArrayList<>();
        objects.add(2);
        objects.add(3);
        objects.add(5);
        objects.add(7);
        int[] ints = new Algorithm_3315_LeetCode().minBitwiseArray(objects);
        System.out.println(Arrays.toString(ints));
    }
}