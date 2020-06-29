package com.luhanlin.leetcode.link;

/**
 * 类详细描述：请判断一个链表是否为回文链表。
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/27 8:21 下午
 */
public class N234Palindrome {

    /**
     * 使用快慢指针翻转前半部分节点
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;

        ListNode pre = head;
        ListNode prePre = null;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            ListNode tmp = pre.next;
            pre.next = prePre;
            prePre = pre;
            pre = tmp;
        }

        // 当链表元素为奇数时
        if (fast != null) {
            slow = slow.next;
        }

        // 开始对比前后部分
        ListNode font = prePre;
        while (slow != null && font != null) {
            if (slow.val != font.val) return false;
            slow = slow.next;
            font = font.next;
        }

        // 执行完毕后翻转回去
        while (prePre != null) {
            ListNode tmp2 = prePre.next;
            prePre.next = pre;
            pre = prePre;
            prePre = tmp2;
        }
        return true;
    }
}
