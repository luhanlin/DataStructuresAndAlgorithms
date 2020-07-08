package com.luhanlin.leetcode.link;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <类详细描述>
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-08 17:57]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N23MergeKLists {

    /**
     * 使用递归方式合并
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        return merge(lists, 0, lists.length -1);
    }

    private ListNode merge(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];

        int mid = start + (end - start) / 2;

        ListNode left = merge(lists, start, mid);
        ListNode right = merge(lists, mid + 1, end);

        return merge2List(left, right);
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        int k = lists.length;
        if (k == 0) return null;

        while (k > 1) {
            int ide = 0;
            for (int i = 0; i < k; i+=2) {
                if (i == k-1) {
                    lists[ide++] = lists[i];
                } else {
                    lists[ide++] = merge2List(lists[i], lists[i+1]);
                }
            }
            k = ide;
        }

        return lists[0];
    }

    /**
     * 使用小顶堆
     * @param lists
     * @return
     */
    public ListNode mergeKLists3(ListNode[] lists) {
        if (lists.length == 0) return null;
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(v -> v.val));
        for (ListNode node : lists) {
            if (node != null) queue.add(node);
        }
        ListNode res = new ListNode(-1);
        ListNode sentry = res;
        while (!queue.isEmpty()) {
            ListNode min = queue.poll();
            res.next = min;
            res = res.next;
            if (min.next != null) queue.add(min.next);
        }
        return sentry.next;
    }

    /**
     * 递归合并两个链表
     * @param l1
     * @param l2
     * @return
     */
    private ListNode merge2List(ListNode l1, ListNode l2){
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = merge2List(l1.next, l2);
            return l1;
        }
        l2.next = merge2List(l1, l2.next);

        return l2;
    }

    /**
     * 迭代的合并两个链表
     * @param l1
     * @param l2
     * @return
     */
    private ListNode merge2List2(ListNode l1, ListNode l2){
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode sentry = new ListNode(-1);
        ListNode pre = sentry;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }

        pre.next = l1 == null ? l2 : l1;

        return sentry.next;
    }


}
