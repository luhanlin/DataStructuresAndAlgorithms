package com.luhanlin.leetcode.link;

/**
 * <类详细描述>
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-07 16:10]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class TestMain {

    public static void main(String[] args) {
//        N707MyLinkedList link = new N707MyLinkedList();
//        link.addAtHead(1);
//        link.addAtTail(3);
//        printLinkedList(link.getNode(0));
//        link.addAtIndex(1,2);
//        printLinkedList(link.getNode(0));
//        System.out.println(link.get(1));
//        link.deleteAtIndex(1);
//        System.out.println(link.get(1));

        ListNode l1 = new ListNode(3);
        l1.add(9).add(9).add(9).add(9).add(9).add(9).add(9).add(9).add(9);
        ListNode l2 = new ListNode(7);
        N445TwoNumSum2 su = new N445TwoNumSum2();
        su.addTwoNumbers(l1,l2);
    }

    public static void printLinkedList (N707MyLinkedList.Node head) {
        StringBuilder builder = new StringBuilder();
        while (head != null) {
            builder.append(head.val + "->");
            head = head.next;
        }
        System.out.println(builder.toString());
    }
}
