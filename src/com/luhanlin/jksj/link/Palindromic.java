package com.luhanlin.jksj.link;

/**
 * 类详细描述：回文数判断 使用链表实现
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/5/13 3:57 PM
 */
public class Palindromic {

    // 回文数链表
    private Node palNode;

    public Boolean isPalindromic(String pal){
        if (pal == null) {
            return false;
        }

        // 将回文数放入链表中
        String[] split = pal.split("");
        if (split.length == 1) {
            return true;
        }
        Node nextNode = palNode = new Node(Integer.valueOf(split[0]));
        for (int i = 1; i < split.length; i++) {
            nextNode.next = new Node(Integer.valueOf(split[i]));

            nextNode = nextNode.next;
        }

        printAll();

        // 寻找中间点
        Node p = palNode;
        Node q = palNode;
        while (p.next != null && q.next != null && q.next.next != null) {
            p = p.next;
            q = q.next.next;
        }

        Node rightLink = null;
        Node leftLink = null;
        // 判断奇偶
        if (q.next == null) {
            // 偶数，则p一定是中间点，将p之前的节点进行反转
            rightLink = p.next;
            leftLink = reverseLinkLeft(p).next;
        } else {
            rightLink = p.next;
            leftLink = reverseLinkLeft(p);
        }

        System.out.println("p->" + p.value + ",q->" + q.value);

        printAll(rightLink);
        printAll(leftLink);

        while (leftLink != null && rightLink != null ){
            if (leftLink.value == rightLink.value) {
                leftLink = leftLink.next;
                rightLink = rightLink.next;
                continue;
            }

            return false;
        }

        return true;
    }

    private Node reverseLinkLeft(Node p) {
        Node pre = null;
        Node cur = palNode;
        Node next = null;

        while(cur != p) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        cur.next = pre;

        return cur;
    }


    private void printAll(){
        printAll(palNode);
    }

    private void printAll(Node node){
        Node nextNode = node;

        while (nextNode != null) {
            System.out.print(nextNode.value + " ");
            nextNode = nextNode.next;
        }

        System.out.println();
    }

    private class Node {
        private int value;
        private Node next;

        public Node(){}

        public Node(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Palindromic palindromic = new Palindromic();

        System.out.println(palindromic.isPalindromic("12324554321"));
    }
}
