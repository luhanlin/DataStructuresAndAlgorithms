package com.luhanlin.jksj.link;

/**
 * 类详细描述：
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/5/14 7:20 AM
 */
public class ListNode {

    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public int getVal() {
        return val;
    }

    public ListNode setNext(ListNode node){
        this.next = node;
        return node;
    }

    public ListNode getNext() {
        return next;
    }
}
