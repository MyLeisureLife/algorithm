package org.leisure;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 提示：
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目据保证列表表示的数字不含前导零
 */
public class TwoSolution {
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
     *
     * @param l1 第一个数的倒序链表
     * @param l2 第二个数的倒叙链表
     * @return 两个数相加的倒叙链表
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode startPosition = result;
        int carry = 0;

        while (l1.val >= 0 || l2.val >= 0 || carry == 1){
            if (l1.val < 0) l1.val = 0;
            if (l2.val < 0) l2.val = 0;

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

    public static void main(String[] args) {
        addTwoNumbers(new ListNode(0,new ListNode(5)), new ListNode(0));
    }


}
