package org.leisure;

/**
 * LeetCode: 两数之和
 * 题目: 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 *
 * 条件：1、你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *      2、你可以按任意顺序返回答案。
 *      3、2 <= nums.length <= 104
 *      4、-109 <= nums[i] <= 109
 *      5、-109 <= target <= 109
 *      6、只会存在一个有效答案
 *
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 */

public class OneSolution {
    /**
     * 暴力解决方法
     * 时间复杂对: (n^2) 空间复杂度:O(1)
     * @param nums 数组
     * @param target 目标数
     * @return 返回结果
     */
    public static int[] twoSum(int[] nums, int target) {
        //第2个整数
        int target2;
        for (int i = 0; i < nums.length; i++) {
            //目标值 减 第1个整数 得到第二个整数
            target2 = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (target2 == nums[j]){
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 进阶解决方法
     * 时间复杂对: (n) 空间复杂度:O(n)
     * 可以使用散列表(Hash)的数据结构来解决问题。
     * 问题：hash冲突
     * @param nums 数组
     * @param target 目标数
     * @return 返回结果
     */
    public static int[] AdvanceTwoSum(int[] nums, int target) {

        return new int[0];
    }



    public static void main(String[] args) {
        twoSum(new int[]{3,2,4}, 6);
    }
}












/*
  来源：力扣（LeetCode）
  链接：https://leetcode.cn/problems/two-sum
  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */