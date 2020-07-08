package com.luhanlin.leetcode.link;

/**
 * <类详细描述> 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-08 08:39]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N25ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode root = head;
        int count = 0;

        ListNode pre = null;

        while (root != null && count < k) {
            ListNode next = root.next;
            root.next = pre;
            pre = root;
            root = next;
            count++;
        }
        if (count < k) { //把后续节点翻转回去
            ListNode pre2 = null;
            while (pre != null && count > 0) {
                ListNode next = pre.next;
                pre.next = pre2;
                pre2 = pre;
                pre = next;
                count--;
            }
            return pre2;
        }

        head.next = reverseKGroup(root, k);

        return pre;
    }

}
