package com.luhanlin.leetcode.link;

/**
 * 类详细描述：给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/26 8:32 下午
 */
public class N83DeleteDuplicates {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode res = head;
        if (res == null) return null;

        while (res != null && res.next != null) {
            while (res.next != null && res.val == res.next.val) {
                res.next = res.next.next;
            }
            res = res.next;
        }
        return head;
    }

    /**
     * 递归实现
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) return head;

        head.next = deleteDuplicates2(head.next);

        if (head.val == head.next.val) return head.next;

        return head;
    }

}
