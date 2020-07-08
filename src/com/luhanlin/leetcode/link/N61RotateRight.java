package com.luhanlin.leetcode.link;

/**
 * <类详细描述> 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-08 09:35]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N61RotateRight {

    /**
     * 使用环
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode tail = head;
        int n;
        for (n=1; tail.next != null; n++) {
            tail = tail.next;
        }
        k = k % n;
        // 形成闭环
        tail.next = head;

        // 找到新的头尾节点
        ListNode newTail = head;
        for (int i = 1; i < n - k; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

    /**
     * 三次翻转
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode node = new ListNode();
        node.next = head;
        int n = 0;
        ListNode root = head;
        while (root != null) {
            root = root.next;
            n++;
        }
        k = k % n;

        node.next = reverse(node.next);
        ListNode kPre = node;
        ListNode kNode = node.next;
        for (int i=0; i<k; i++) {
            kPre = kNode;
            kNode = kNode.next;
        }
        kPre.next = null;

        ListNode pre = node.next;
        ListNode post = reverse(kNode);
        if(pre != null) {
            node.next = reverse(pre);
            pre.next = post;
        } else {
            node.next = post;
        }
        return node.next;
    }

    public ListNode reverse(ListNode head){
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
