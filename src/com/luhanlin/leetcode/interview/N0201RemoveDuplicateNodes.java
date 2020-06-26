package com.luhanlin.leetcode.interview;

import java.util.HashSet;

/**
 * 类详细描述：
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/26 1:27 下午
 */
public class N0201RemoveDuplicateNodes {

    /**
     * 使用hash缓存
     * @param head
     * @return
     */
    public ListNode removeDuplicateNodes(ListNode head) {
        HashSet<Integer> cache = new HashSet<>();
        ListNode tmp = head;
        if (tmp == null) return null;
        cache.add(tmp.val);
        while (tmp.next != null) {
            ListNode next = tmp.next;
            if (cache.contains(next.val)) {
                tmp.next = next.next;
            } else {
                cache.add(next.val);
                tmp = tmp.next;
            }
        }

        return head;
    }
}
