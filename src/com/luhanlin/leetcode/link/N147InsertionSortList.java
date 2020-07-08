package com.luhanlin.leetcode.link;

/**
 * <类详细描述> 对链表进行插入排序。
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-08 15:06]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N147InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode sentry = new ListNode(-1);
        sentry.next = head;

        while (head.next != null) {
            if (head.val <= head.next.val) {
                head = head.next;
                continue;
            }
            // 头结点不用排序，对下一个数据进行插入拍讯
            ListNode cur = head.next;
            ListNode pre = sentry;
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }

            head.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
        }
        return sentry.next;
    }


}


