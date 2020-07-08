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

    /**
     * 判断是否有环
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;

        while (slow.next != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }
        return false;
    }

    /**
     * 环的起始节点
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        boolean hasCycle = false;
        // 判断是否有环
        ListNode s = head;
        ListNode f = head;

        while (s.next != null && f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
            if (s == f) {
                hasCycle = true;
                break;
            }
        }
        // 寻找节点 s
        if (hasCycle) {
            f = head;
            while (f != s) {
                f = f.next;
                s = s.next;
            }
            return s;
        }

        return null;
    }
}
