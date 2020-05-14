package com.luhanlin.jksj.link;

/**
 * 类详细描述：给定一个链表，判断链表中是否有环。 leetcode 141
 *
 *    为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/5/14 7:19 AM
 */
public class CycleLinkList {

    public boolean hasCycle(ListNode head){

        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) return false;

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;

    }

    public static void main(String[] args) {
        CycleLinkList cycleLinkList = new CycleLinkList();

        ListNode head = new ListNode(1);
        head.setNext(new ListNode(2))
                .setNext(new ListNode(3))
                .setNext(new ListNode(4))
                .setNext(new ListNode(5))
                .setNext(head);


        System.out.println(cycleLinkList.hasCycle(head));


    }
}
