package com.leisure.exercise;

/**
 * ClassName: Algorithm_3510_LeetCode
 * Package: com.leisure.exercise
 * Description:
 * 给你一个数组 nums，你可以执行以下操作任意次数：
 * 选择 相邻 元素对中 和最小 的一对。如果存在多个这样的对，选择最左边的一个。
 * 用它们的和替换这对元素。
 * 返回将数组变为 非递减 所需的 最小操作次数 。
 * 如果一个数组中每个元素都大于或等于它前一个元素（如果存在的话），则称该数组为非递减。
 * 1 <= nums.length <= 10 ^ 5
 * -10 ^ 9 <= nums[i] <= 10 ^ 9
 * @Author: MyLeisureLife
 * @Date: 2026/1/23:22:43:54 星期五
 */
public class Algorithm_3510_LeetCode {

    /**
     * 节点
     */
    class Node {
        // 值
        long value;
        int left;
        Node right;
        Node next;
        Node(int value, int left) {
            this.value = value;
            this.left = left;
        }
    }
    


    /**
     * Brute-Force 暴力算法 时间复杂太高过不了， 需要降低时间复杂度
     * 时间复杂度O(n n)   空间复杂度O(1)  n:数组长度
     * @param nums 数组
     * @return 执行特定条件次数
     */
    public int minimumPairRemoval(int[] nums) {
        // 由于数据量太大合并的时候int类型存储不了，
        long[] nums2 = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums2[i] = nums[i];
        }

        int ans = 0;
        while (true){
            int key1 = -1;
            int key2 = -1;
            long value = Long.MAX_VALUE;
            int status = 0;
            // 不进行两两合并
            for (int i = 0, j = 0; i < nums2.length - 1; i = j){
                // 找到没有被合并的第一个数
                if (nums2[i] == Integer.MIN_VALUE) continue;
                // 找到没有被合并的第二个数
                j = i + 1;
                while (j < nums2.length && nums2[j] == Integer.MIN_VALUE) {
                    j ++;
                }
                // 没找到第二个就直接退出就可以了
                if (j >= nums2.length) break;

                // 只要有一个不满足条件就退出循环
                if (nums2[i] > nums2[j]){
                    status ++;
                    break;
                }
            }

            // 位置为0 就证明全部符合条件不用再进行下面的运算了
            if (status == 0){
                return ans;
            }

            // 进行两两合并
            for (int i = 0, j = 0; i < nums2.length - 1; i = j){
                // 找到没有被合并的第一个数
                if (nums2[i] == Integer.MIN_VALUE) continue;
                // 找到没有被合并的第二个数
                j = i + 1;
                while (j < nums2.length && nums2[j] == Integer.MIN_VALUE) {
                    j ++;
                }

                // 找完了就退出
                if (j >= nums2.length) break;

                // 两两合并找到最小合并的位置key1 key2
                if (value > nums2[j] + nums2[i]) {
                    // 否者 并记录位置 和并两个数
                    key1 = i;
                    key2 = j;
                    value = nums2[j] + nums2[i];
                };
            }

            // 进行合并
            nums2[key1] = nums2[key1] + nums2[key2] ;
            nums2[key2] = Integer.MIN_VALUE ;
            ans ++;
        }
    }

    public static void main(String[] args) {
        int i = new Algorithm_3510_LeetCode().minimumPairRemoval(new int[]{1,2,2});
        System.out.println(i);
    }
}
