package com.luhanlin.leetcode.link;

/**
 * <类详细描述>
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-07 20:52]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N92ReverseBetween {
    private ListNode post = null;
    /**
     * 递归解法
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseBetweenN(head, n);
        }

        head.next = reverseBetween(head.next, m-1,n-1);

        return head;
    }

    private ListNode reverseBetweenN(ListNode head, int n) {
        if (n == 1) {
            post = head.next;
            return head;
        }

        ListNode last = reverseBetweenN(head.next, n-1);

        head.next.next = head;
        head.next = post;

        return last;
    }

    public ListNode reverseBetween2(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;
        int count = 0;

        ListNode mPre = null;
        ListNode mNode = null;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            count++;

            if (count >=m && count <=n) {
                if (count == m) {
                    mPre = pre;
                    mNode = cur;
                }
                ListNode next = cur.next;
                cur.next = pre;
                if (count == n) {
                    mNode.next = next;
                    if (mPre != null) {
                        mPre.next = cur;
                    } else {
                        return cur;
                    }
                }
                pre = cur;
                cur = next;

            } else {
                pre = cur;
                cur = cur.next;
            }

        }
        return head;
    }

    public ListNode reverseBetween3(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;

        ListNode node = new ListNode(0);
        node.next = head;

        // 寻找前置节点
        ListNode pre = node;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }

        head = pre.next;
        for (int i = m; i < n; i++) {
            ListNode next = head.next;
            head.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return node.next;
    }
}
