package com.luhanlin.leetcode.link;

/**
 * <类详细描述>
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-07 16:05]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N707MyLinkedList {

    private Node head;
    private Node tail;
    int size = 0;

    /** Initialize your data structure here. */
    public N707MyLinkedList() {
        head = new Node(-1);
        tail = head;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        Node cur = getNode(index);
        if (cur == null) return -1;
        return cur.val;
    }

    public Node getNode(int index) {

        Node cur = head;
        for (int i=0; i<=index;i++) {
            cur = cur.next;
        }
        return cur;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node next = head.next;
        Node cur = new Node(val);

        head.next = cur;
        cur.pre = head;
        cur.next = next;

        if (next != null) {
            next.pre = cur;
        } else { // 说明还没有尾节点
            tail = cur;
        }

        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node cur = new Node(val);
        tail.next = cur;
        cur.pre = tail;
        tail = cur;
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index == size) {
            addAtTail(val);
        } else if (index < 0) {
            addAtHead(val);
        } else {
            Node next = getNode(index);

            Node pre = next.pre;

            Node cur = new Node(val);
            pre.next = cur;
            cur.pre = pre;
            cur.next = next;
            next.pre = cur;
            size++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        if (index == size - 1) { // 头部使用哨兵节点，尾部需要判断删除
            tail = tail.pre;
        } else {
            Node delNode = getNode(index);
            delNode.pre.next = delNode.next;
            delNode.next.pre = delNode.pre;
        }
        size--;
    }

    public int getSize(){
        return size;
    }

    static class Node {
        int val;
        Node pre;
        Node next;

        public Node () {}
        public Node (int val) {
            this.val = val;
        }
    }
}
