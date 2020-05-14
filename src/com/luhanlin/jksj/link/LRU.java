package com.luhanlin.jksj.link;

import java.util.Scanner;

/**
 * 类详细描述：使用单向链表实现
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/5/13 8:33 AM
 */
public class LRU<T> {

    // 定义单向链表结构
    private class Node <T> {
        private T value;
        private Node next;

        Node(){
        }

        Node(T value){
            this.value = value;
        }
    }

    public static final Integer DEFAULT_CAPACITY = 10;

    // 定义容量限制
    private int limit;

    private Node<T> headNode;

    private int length;

    // 初始化存储容器
    public LRU (){
        this(DEFAULT_CAPACITY);
    }

    // 初始化存储容器
    public LRU (int limit){
        this.limit = limit;
        this.length = 0;
        headNode = new Node<>();
    }

    public Node insert (T value){

        if (limit <= 0) {
            return headNode;
        }

        // 找到值是否在链表中存在
        Node preNode = findPreNode(value);

        // 如果能在链表中找到,删除当前节点数据，在首节点插入数据
        if (preNode != null) {
            deleteCurNode(preNode);
            addValueInHead(value);
        } else {
            if (length > limit) {
                // 删除尾节点
                deleteEndNode();
            }

            addValueInHead(value);
        }

        return headNode;

    }

    private void deleteEndNode() {
        Node endPreNode = headNode;

        if (endPreNode.next == null) return;

        while (endPreNode.next.next != null) {
            endPreNode = endPreNode.next;
        }

        endPreNode.next = null;

        length --;
    }


    private void addValueInHead(T value) {
        Node headNextNode = headNode.next;
        Node<T> nNode = new Node<>(value);
        headNode.next = nNode;
        nNode.next = headNextNode;
        length ++;

    }

    private void deleteCurNode(Node preNode) {
        preNode.next = preNode.next.next;
        length --;
    }

    private Node findPreNode(T value) {
        Node node = headNode;

        while (node.next != null) {
            if (node.next.value.equals(value)) {
                return node;
            }

            node = node.next;
        }

        return null;
    }

    private void printAll(){
        Node nextNode = headNode.next;

        while (nextNode != null) {
            System.out.print(nextNode.value + " ");
            nextNode = nextNode.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        LRU<Integer> cache = new LRU<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            cache.insert(scanner.nextInt());
            cache.printAll();
        }

    }

}
