package com.luhanlin.leetcode.link;

/**
 * <类详细描述> 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-08 13:57]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N148SortList {

    /**
     *  递归分组，然后归并
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // 快慢指针找到中间节点
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tmp = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        // 对以上两个链表进行合并
        ListNode res = new ListNode(-1);
        ListNode merge = res;
        while (left != null && right != null) {
            if (left.val < right.val) {
                merge.next = left;
                left = left.next;
            } else {
                merge.next = right;
                right = right.next;
            }
            merge = merge.next;
        }
        // 合并多余的部分
        merge.next = (left == null ? right : left);
        return res.next;
    }
}
