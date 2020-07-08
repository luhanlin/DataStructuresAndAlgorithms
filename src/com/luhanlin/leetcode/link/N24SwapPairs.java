package com.luhanlin.leetcode.link;

import java.util.ArrayList;
import java.util.Collections;

/**
 * <类详细描述> 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-07 19:00]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N24SwapPairs {

    /**
     * 递归解法
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {

        // 递归终止条件
        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = head;
        ListNode second = head.next;

        first.next = swapPairs(second.next);
        second.next = first;

        return second;
    }

        /**
         * 三指针
         * @param head
         * @return
         */
    public ListNode swapPairs2(ListNode head) {

        ListNode res = new ListNode();
        ListNode root = res;
        res.next = head;

        while (res.next !=null && res.next.next != null ) {
            ListNode one = res.next;
            ListNode two = res.next.next;
            ListNode next = res.next.next.next;

            res.next = two;
            two.next = one;
            one.next = next;

            res = one;
        }

        return root.next;
    }


}
