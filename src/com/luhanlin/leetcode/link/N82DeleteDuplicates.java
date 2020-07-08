package com.luhanlin.leetcode.link;

/**
 * <类详细描述> 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-08 10:34]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N82DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode next = head.next;

        if (head.val == next.val) {
            while (next != null && head.val == next.val) {
                next = next.next;
            }
            head = deleteDuplicates(next);
        } else {
            head.next = deleteDuplicates(next);
        }

        return head;
    }

    /**
     * 使用双指针
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode node = new ListNode(-1);
        node.next = head;

        ListNode pre = node;
        ListNode cur = node.next;

        while (cur != null && cur.next != null) {
            int count = 0;
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
                count++;
            }
            if (count > 0) {
                pre.next = cur.next;
            } else {
                pre.next = cur;
            }

            pre = pre.next;
            cur = cur.next;
        }
        return node.next;
    }
}
