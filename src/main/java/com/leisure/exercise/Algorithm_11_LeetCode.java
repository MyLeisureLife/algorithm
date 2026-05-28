package com.leisure.exercise;

/**
 * ClassName: Algorithm_11_LeetCode
 * Package: com.leisure.exercise
 * Description: 11. 盛最多水的容器
 *
 * @Author: MyLeisureLife
 * @Date: 2026/5/28:11:27:26 星期四
 */
public class Algorithm_11_LeetCode {
    /**
     * Time complexity: O(n ^ 2), Space complexity: O(1)
     * Drawback: The time complexity is too large and should be lowered.
     * @param height 高度
     * @return 最大矩形
     */
    public int maxArea1(int[] height) {
        int ans = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int width = Math.min(height[i], height[j]);
                int length = j - i;
                ans = Math.max(ans, width * length);
            }
        }
        return ans;
    }

    /**
     * Time complexity: O(n), Space complexity: O(1)
     * 双指针
     * @param height 高
     * @return 组成的面积
     */
    public int maxArea(int[] height) {
        int ans = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] < height[r]) {
                l ++;
            }else{
                r --;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int i = new Algorithm_11_LeetCode().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(i);
    }
}
