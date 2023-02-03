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
    public static double MyFindMedianSortedArrays1(int[] nums1, int[] nums2) {
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
     * 我自己实现的代码
     * 时间复杂度O(n+m) 空间复杂度 O(1)
     * 使用数组下标移动的方法求出中位数，不使用数组合并方法
     * 不足的地方，循环因该考虑到最后的一种情况，可以使用变量将倒数第二变量存取下来
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 中位数
     */
    public static double MyFindMedianSortedArrays2(int[] nums1, int[] nums2) {
        //计算出中位数的位置
        int medianIndex = (nums1.length + nums2.length + 1) / 2 - 1;
        //创建数组的两个下标用于移动
        int n1 = 0, n2 = 0;
        while (medianIndex > 0){
            if(n1 < nums1.length && n2 < nums2.length){
                if (nums1[n1] < nums2[n2]){
                    n1 ++;
                }else {
                    n2 ++;
                }
            }else if (n1 >= nums1.length){
                n2 ++;
            } else {
                n1 ++;
            }
            medianIndex --;
        }

        if (n1 == nums1.length){
            if ((nums1.length + nums2.length) % 2 == 0){
                return (nums2[n2] + nums2[n2 + 1]) / 2.0;
            }else {
                return nums2[n2];
            }
        }

        if (n2 == nums2.length){
            if ((nums1.length + nums2.length) % 2 == 0){
                return (nums1[n1] + nums1[n1 + 1]) / 2.0;
            }else {
                return nums1[n1];
            }
        }

        if ((nums1.length + nums2.length) % 2 == 0){
            double a = (nums1[n1] + nums2[n2]) / 2.0;
            int b =  Math.min(nums1[n1], nums2[n2]);
            if (nums1[n1] < nums2[n2]){
                n1 ++;
            }else {
                n2 ++;
            }
            if(n1 == nums1.length || n2 == nums2.length){
                return a;
            }
            int c =  Math.min(nums1[n1], nums2[n2]);
            return (b + c) / 2.0;
        }else {
            return Math.min(nums1[n1], nums2[n2]);
        }
    }

    /**
     * 现在需要考虑题目所给的时间复杂度了
     * 所以需要使用二分查找法，来进行
     * 查找 中位数 我们可以将起看成查找第K小的数
     * 这里K又分为两种情况，第一种情况，当 nums1.length + nums2.length 的长度为偶数时，这时就有 两个 K 需要求出来然后除以2
     *                   第二种情况，当 nums1.length + nums2.length 的长度为奇数时，这时就有 一个 K 需要求出来。
     * 偶数时(K表示是在数组中的下标)  K1 = (nums1.length + nums2.length + 1) / 2 , K2 = (nums1.length + nums2.length + 2) / 2
     * 奇数时(K表示是在数组中的下标)  K = (nums1.length + nums2.length + 1)  / 2
     *
     * 自己写的存在问题：
     *  1、代码不够节俭，重复代码较多。
     *  2、边界值考虑不全
     *  时间复杂度O(log (m+n)) 空间复杂度 O(1)
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 中位数
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2){
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
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

        int k1 = (nums1Length + nums2Length + 1)  / 2;
        int k2 = (nums1Length + nums2Length + 2)  / 2;

        if ((nums1Length + nums2Length) % 2 == 0){
            return (findMinimumTheKth(nums1,nums2,k1) + findMinimumTheKth(nums1, nums2, k2)) / 2.0;
        }else {
            return findMinimumTheKth(nums1,nums2,k1);
        }
    }

    /**
     *
     * @param nums1 数组
     * @param nums2 数组
     * @param k 第k小的数
     * @return 数
     */
    public static int findMinimumTheKth(int[] nums1, int[] nums2, int k){
        //记录总的
        int sum = k;
        //创建两个下标用于在两个数组中移动
        int n1 = 0, n2 = 0;
        int half = -1;
        while (half != 0 && k != 1){
            // 每次去掉数组前面 half 个
            half = k / 2;
            // 还剩下几个没有被去掉，需要留一个表示它自己
            k = k - half;


            if (nums1.length <= half && k != 1){
                if (nums1[nums1.length - 1] > nums2[half - 1]){
                    n2 = half + n2;
                    continue;
                }else {
                    n2 = n2 + (sum - nums1.length) - 1;
                    return nums2[n2];
                }
            }else if (nums2.length <= half && k != 1){
                if (nums2[nums2.length - 1] > nums1[half - 1]){
                    n1 = half + n1;
                    continue;
                }else {
                    n1 = n1 + (sum - nums2.length) - 1;
                    return nums1[n1];
                }
            }

            if(nums1.length == n1){
                n2 = n2 + (sum - nums1.length) - 1;
                return nums2[n2];
            }
            if (nums2.length == n2){
                n1 = n1 + (sum - nums2.length) - 1;
                return nums1[n1];
            }

            if (nums1[n1 + half - 1] < nums2[n2 + half - 1]){
                n1 = n1 + half;
            }else {
                n2 = n2 + half;
            }
        }
        if(nums1.length == n1){
            return nums2[n2];
        }
        if (nums2.length == n2){
            return nums1[n1];
        }
        return Math.min(nums1[n1], nums2[n2]);
    }


    public static void main(String[] args) {
        findMedianSortedArrays(new int[]{1,2, 3},new int[]{4, 5, 6, 7});
    }
}
