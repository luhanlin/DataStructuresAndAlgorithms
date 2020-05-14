package com.luhanlin.jksj.link;

/**
 * 类详细描述：反转一个单链表。 leetcode 206
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶: 你可以迭代或递归地反转链表
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/5/13 9:23 PM
 */
public class ReserveLinkList {

    // 通过遍历反转link
    public static ListNode reserveList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while (cur.next != null) {
            ListNode tmpNode = cur.next;

            cur.next = pre;
            pre = cur;
            cur = tmpNode;
        }
        cur.next = pre;

        return cur;
    }

    // 通过尾递归反转
    public static ListNode reserveList2(ListNode head) {
        if (head == null) return null;

        return reserve(null,head);
    }

    private static ListNode reserve(ListNode pre, ListNode cur) {
        if (cur == null) return pre;

        ListNode next = cur.next;

        cur.next = pre;

        return reserve(cur, next);
    }

    private static void printAll(ListNode node){
        ListNode nextNode = node;

        while (nextNode != null) {
            System.out.print(nextNode.value + " ");
            nextNode = nextNode.next;
        }

        System.out.println();
    }

    static class ListNode {

        private int value;

        private ListNode next;

        public ListNode(){}

        public ListNode(int value){
            this.value = value;
        }

        public ListNode setNext(ListNode node){
            this.next = node;
            return node;
        }

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.setNext(new ListNode(2))
                .setNext(new ListNode(3))
                .setNext(new ListNode(4))
                .setNext(new ListNode(5));

        ListNode result = reserveList2(head);

        printAll(result);

    }

}
