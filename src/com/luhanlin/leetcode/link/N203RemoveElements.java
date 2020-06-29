package com.luhanlin.leetcode.link;

/**
 * 类详细描述：删除链表中等于给定值 val 的所有节点。
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/26 11:45 下午
 */
public class N203RemoveElements {

    public ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return null;
        }

        ListNode node = new ListNode();
        node.next = head;

        ListNode res = head;

        while (res != null && res.next != null) {
            if (res.next.val == val) {
                res.next = res.next.next;
            } else {
                res = res.next;
            }
        }

        return node.next;
    }
}
