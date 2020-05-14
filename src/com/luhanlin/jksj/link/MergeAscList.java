package com.luhanlin.jksj.link;

import com.luhanlin.Utils.CommonUtils;

/**
 * 类详细描述：将两个升序链表合并为一个新的升序链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/5/14 8:08 AM
 */
public class MergeAscList {

    // 采用归并类似的遍历模式
    public ListNode mergeTwoLists(ListNode p, ListNode q) {
        ListNode mergeHead = new ListNode(0);
        
        ListNode cur = mergeHead;

        while (p != null && q != null) {
            if (p.val < q.val) {
                cur.next = p;
                p = p.next;     // 指针后移
            } else {
                cur.next = q;
                q = q.next;     // 指针后移
            }
            cur = cur.next; // 指针后移
        }
        
        if (p == null) {
            cur.next = q;
        } else {
            cur.next = p;
        }
        
        return mergeHead.next;
    }

    // 使用递归进行求解
    public ListNode mergeTwoLists2(ListNode p, ListNode q) {
        if (p == null) {
            return q;
        }

        if (q == null) {
            return p;
        }

        if (p.val < q.val) {
            p.next =  mergeTwoLists2(p.next, q);
            return p;
        } else {
            q.next = mergeTwoLists2(p, q.next);
            return q;
        }
    }



    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.setNext(new ListNode(2))
                .setNext(new ListNode(4));

        ListNode head2 = new ListNode(1);
        head2.setNext(new ListNode(3))
                .setNext(new ListNode(4));

        MergeAscList mergeAscList = new MergeAscList();

//        ListNode result = mergeAscList.mergeTwoLists(head1, head2);
        ListNode result = mergeAscList.mergeTwoLists2(head1, head2);

        CommonUtils.printAll(result);

    }
}
