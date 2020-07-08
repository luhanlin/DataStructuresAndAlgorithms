package com.luhanlin.leetcode.link;

import java.util.Stack;

/**
 * <类详细描述> 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 进阶：
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-07 17:44]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N445TwoNumSum2 {

    /**
     * 此种解法会出现数字溢出
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode root = res;
        long v1 = 0L;
        long v2 = 0L;

        while (l1 != null) {
            v1 = v1 * 10 + l1.val;
            l1 = l1.next;
        }

        while (l2 != null) {
            v2 = v2 * 10 + l2.val;
            l2 = l2.next;
        }

        long sum = v1 + v2;
        if (sum == 0) return res;
        while (sum != 0) {
            root.next = new ListNode((int)sum % 10);
            root = root.next;
            sum = sum/10;
        }
        res.printVal();
        return reverse(res.next);
    }

    /**
     * 使用 栈 进行辅助
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode res = new ListNode(0);
        ListNode root = res;
        int carry = 0;

        while (!stack1.isEmpty() || !stack2.isEmpty() || carry !=0) {
            int sum = carry;
            sum += stack1.isEmpty() ? 0 : stack1.pop();
            sum += stack2.isEmpty() ? 0 : stack2.pop();

            root.next = new ListNode(sum % 10);
            root = root.next;
            carry = sum / 10;
        }

        return reverse(res.next);
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
