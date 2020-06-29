package com.luhanlin.leetcode.link;

/**
 * 类详细描述：反转一个单链表。
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/27 10:59 上午
 */
public class N206ReverseList {

    /**
     * 迭代
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        ListNode res = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = res;
            res = head;
            head = tmp;
        }
        return res;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode res = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return res;
    }

    /**
     * 双指针
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {
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
