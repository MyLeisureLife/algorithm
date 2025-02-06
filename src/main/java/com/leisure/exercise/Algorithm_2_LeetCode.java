package com.leisure.exercise;

/**
 * Author: leisure1456
 * Date: 2023/1/31:09:51:09 星期二
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 提示：
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目据保证列表表示的数字不含前导零
 *
 */
public class Algorithm_2_LeetCode {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 算法出现过的问题：1、代码有些复杂了，阅读体验感不好。
     *                2、判断条件没有考虑周全，满10进阶问题和都是0问题的考虑丢失。
     *                3、链表的节点开始位置丢失，result.next最开始没有被赋值，是null的，就算以后被赋值了你提前将其赋值给其他ListNode也不会跟着改变，
     *                4、链表中的节点如果已经被创建，后续你重新new一个节点出来赋值上去，内存地址会发生改变的，你不能直接赋值那个节点，你只能修改这个已经存在的节点。
     * 时间复杂度: O(n) 空间复杂度: O(n)
     * @param l1 第一个数的倒序链表
     * @param l2 第二个数的倒叙链表
     * @return 两个数相加的倒叙链表
     */
    public static ListNode MyAddTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode startPosition = result; //记住链表的开始位置
        int carry = 0; // 两个数相加大于10的进阶 1进阶 0不进阶


        while (l1.val >= 0 || l2.val >= 0 || carry == 1){
            //将复数 变成 0 防止影响相加结果
            if (l1.val < 0) l1.val = 0;
            if (l2.val < 0) l2.val = 0;

            //判断是否进阶
            if ((l1.val + l2.val + carry) >= 10){
                result.next = new ListNode((l1.val + l2.val + carry)%10);
                carry = 1;
            }else {
                result.next = new ListNode(l1.val + l2.val + carry);
                carry = 0;
            }

            result = result.next;


            if(l1.next != null){
                l1 = l1.next;
            }else {
                //如果li.next = null 就设置个负数 使可以跳出循环
                l1 = new ListNode(-1);
            }

            if(l2.next != null){
                l2 = l2.next;
            }else {
                l2 = new ListNode(-1);
            }
        }

        return startPosition.next;
    }

    /**
     * 这个算法是看来参考答案后自己写的
     * 也出现了判断问题。修改一次后正确。
     * @param l1 第一个数的倒序链表
     * @param l2 第二个数的倒叙链表
     * @return 两个数相加的倒叙链表
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode cursor = result; //链表的游标，方便移动
        int carry = 0;

        while (l1 != null || l2 != null){
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = (x + y + carry) % 10;
            carry = (x + y + carry) / 10;
            cursor.next = new ListNode(sum);
            if (l1 != null) l1 = l1.next; //出现问题的地方 if (l1.next != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            cursor = cursor.next;
        }

        if (carry == 1){
            cursor.next = new ListNode(carry);
        }

        return result.next;
    }



    public static void main(String[] args) {
        addTwoNumbers(new ListNode(0,new ListNode(5,new ListNode(6))), new ListNode(0));
    }
}
