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
     * 分两个步骤，首先通过快慢指针的方法判断链表是否有环；接下来如果有环，则寻找入环的第一个节点。具体的方法为，首先假定链表
     * 起点到入环的第一个节点A的长度为a【未知】，到快慢指针相遇的节点B的长度为（a + b）【这个长度是已知的】。现在我们想知道a的值，
     * 注意到快指针p2始终是慢指针p走过长度的2倍，所以慢指针p从B继续走（a + b）又能回到B点，如果只走a个长度就能回到节点A。
     * 但是a的值是不知道的，解决思路是曲线救国，注意到起点到A的长度是a，那么可以用一个从起点开始的新指针q和从节点B开始的慢指针p同步走，
     * 相遇的地方必然是入环的第一个节点A
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
