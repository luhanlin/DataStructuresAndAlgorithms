package com.luhanlin.leetcode.link;

/**
 * 类详细描述：给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/26 8:55 下午
 */
public class N141HasCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow.next != null && fast != null && fast.next != null) {
            if (slow == fast) return true;

            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
