package com.leisure;

/**
 * Author: leisure1456
 * Date: 2023/2/1:12:06:19 星期三
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n))
 *
 * 提示：
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class Algorithm_4_LeetCode {
    /**
     * 首先不考虑时间复杂度，使用两个有序数组排序合并的方法求出中位数,不能达到题目的要求
     * 时间复杂度 O(m + n)   空间复杂度（m + n）
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 中位数
     */
    public static double MyFindMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        // 创建一个可以容纳两个小数组的大数组
        int[] sumNums = new int[nums1Length + nums2Length];

        // 防止出现空数组
        if(nums1Length == 0){
            if(nums2Length % 2 == 0){
                return (nums2[nums2Length / 2 - 1] + nums2[nums2Length / 2]) / 2.0;
            }else {
                return nums2[nums2Length / 2];
            }
        }
        if(nums2Length == 0){
            if(nums1Length % 2 == 0){
                return (nums1[nums1Length / 2 - 1] + nums1[nums1Length / 2]) / 2.0;
            }else {
                return nums1[nums1Length / 2];
            }
        }
        //设置三个相当于指针的变量 用于在数组中移动
        int sum = 0;
        int n1 = 0, n2 = 0;
        while ((n1 + n2) != (nums1Length + nums2Length)){

            if (nums1[n1] <= nums2[n2]){
                sumNums[sum ++] = nums1[n1 ++];
            }else{
                sumNums[sum ++] = nums2[n2 ++];
            }
            // 当需要合并的其中一个数组合并完后的处理
            if (n1 == nums1Length){
                while (n2 < nums2Length){
                    sumNums[sum ++] = nums2[n2 ++];
                }
            }
            if (n2 == nums2Length){
                while (n1 < nums1Length){
                    sumNums[sum ++] = nums1[n1 ++];
                }
            }
        }

        //使用合并数组计算中位数
        if(sumNums.length % 2 == 0){
            return (sumNums[sumNums.length / 2 - 1] + sumNums[sumNums.length / 2]) / 2.0;
        }else {
            return sumNums[sumNums.length / 2];
        }
    }

    /**
     * 使用数组下标移动的方法求出中位数，不使用数组合并方法
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 中位数
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //创建数组的两个下标用于移动

        return 0;
    }
    public static void main(String[] args) {

    }
}
