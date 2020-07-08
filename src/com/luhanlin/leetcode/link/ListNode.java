package com.luhanlin.leetcode.link;

import javafx.beans.binding.When;

/**
 * 类详细描述：
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/26 1:28 下午
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode add(int a){
        this.next = new ListNode(a);
        return this.next;
    }

    public void printVal(){
        ListNode root = this;
        StringBuilder b = new StringBuilder();
        while (root != null) {
            b.append(root.val).append("->");
            root = root.next;
        }
        System.out.println(b.toString());
    }
}
