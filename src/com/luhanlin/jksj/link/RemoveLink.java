package com.luhanlin.jksj.link;

import com.luhanlin.Utils.CommonUtils;

/**
 * 类详细描述：给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/5/14 9:59 AM
 */
public class RemoveLink {

    private int count = 0;

    // 递归反向求解
    public ListNode removeNthFromEnd2(ListNode head, int n){

        if (head == null) return null;

        head.next = removeNthFromEnd2(head.next, n);

        count++;

        if (count == n) {
            return head.next;
        }

        return head;
    }

    // 双指针
    public ListNode removeNthFromEnd(ListNode head, int n){

        if (head == null || head.next == null) return null;

        ListNode first = head;
        ListNode second = head;

        // 先将first指针往前走n步
        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        if (first == null) return null;

        while (first.next != null){
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return head;

    }


    public static void main(String[] args) {
        RemoveLink removeLink = new RemoveLink();

        ListNode head = new ListNode(1);
        head.setNext(new ListNode(2))
                .setNext(new ListNode(3))
                .setNext(new ListNode(4))
                .setNext(new ListNode(5));


        CommonUtils.printAll(removeLink.removeNthFromEnd2(head,2));


    }
}
