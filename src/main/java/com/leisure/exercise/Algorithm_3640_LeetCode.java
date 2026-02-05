package com.leisure.exercise;

/**
 * ClassName: Algorithm_3640_LeetCode
 * Package: com.leisure.exercise
 * Description:
 *三段式子数组 是一个连续子数组 nums[l...r]（满足 0 <= l < r < n），并且存在下标 l < p < q < r，使得：
 * nums[l...p] 严格 递增，
 * nums[p...q] 严格 递减，
 * nums[q...r] 严格 递增。
 * 请你从数组 nums 的所有三段式子数组中找出和最大的那个，并返回其 最大 和。
 * 4 <= n = nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * @Author: MyLeisureLife
 * @Date: 2026/2/4:20:06:54 星期三
 */
public class Algorithm_3640_LeetCode {
    /**
     * 时间复杂度O(n) 空间复杂度(1)
     * @param nums 数组
     * @return 最大符合条件的子数组
     */
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        // 结果
        long ans = Long.MIN_VALUE;
        int i;
        int j = 0;
        while (j < n - 1){
            i = j;
            // 符合趋势总和
            long sum = 0;
            // 第一段：上升趋势 求出趋势结束位置
            while (i < n - 1 && nums[i] < nums[i + 1]){
                i++;
            }
            // 如果第一阶段的开始和结束位置相同就表示当前位置不行，需要向后移动一位在进行处理
            if (i == j){
                j ++;
                continue;
            }
            // 当第一阶段到最后一个位置就直接跳出循环就可以了，不需要在进行如何处理了
            if (i == n - 1){
                break;
            }
            // 得到第一段的结束位置
            int end1 = i;


            // 第二段：下降趋势 求出下跌趋势位置
            while (i < n - 1 && nums[i] > nums[i + 1]){
                sum += nums[i];
                i++;
            }
            // 如果第一段结束位置和第二段结束位置相同就跳过, 只有两个数相同的情况
            if (end1 == i){
                j = i + 1;
                continue;
            }
            // 判断结束的位置是否符合条件
            if (i == n - 1){
                break;
            }
            // 计算出第二阶段的结束位置
            int end2 = i;

            // 将必定相加的位置加入到sum中
            sum += (long)nums[end1 - 1] + nums[end2] + nums[end2 + 1];

            // 第三段：上升趋势 去除上升趋势位置
            while (i < n - 1 && nums[i] < nums[i + 1]){
                i++;
            }
            // 判断第三阶段结束坐标是否符合条件，如果第三阶段结束位置和第二阶段结束位置一样时就有问题 就是两个数一样时
            if (end2 == i){
                j = end2 + 1;
                continue;
            }
            // 计算出第三阶段的结束位置
            int end3 = i;

            // 计算第一阶段最大值
            long maxSum = sum;
            for (int k = end1 - 2; k >= j; k--) {
                maxSum += nums[k];
                sum = Math.max(maxSum, sum);
            }
            // 计算第三阶段最大值
            maxSum = sum;
            for (int k = end2 + 2; k <= end3; k++) {
                maxSum += nums[k];
                sum = Math.max(maxSum, sum);
            }

            // 最终结果
            ans = Math.max(ans, sum);

            // 需要跳转到第二段结束的时候开始计算
            j = end2;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                0,-2,-1,-3,0,0,2,-1};
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        System.out.println(sum);
        long l = new Algorithm_3640_LeetCode().maxSumTrionic(nums);
        System.out.println(l);
    }
}
