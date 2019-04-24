package com.luhanlin.structures;

import java.util.HashMap;

/**
 * @description: 删除最少使用数据算法 代码可以直接使用 LinkedHashMap 实现
 * @author: Mr.Lu
 * @create: 2019-04-24 17:38
 **/
public class LRUCache {

    private HashMap<String, Node> cache;

    private Node head;  // 表示最少使用的
    private Node tail;  // 表示最近使用的

    private int limit;

    public LRUCache(int limit) {
        this.limit = limit;
        cache = new HashMap();
    }

    /**
     * 获取信息
     * @param key
     * @return
     */
    public String get(String key){
        Node node = cache.get(key);
        if (node == null) {
            return null;
        }

        refresh(node);

        return node.value;
    }

    public void put(String key, String value){
        Node node = cache.get(key);

        if (node == null) {
            // 添加节点
            if (cache.size() >= limit) {
                // 超过范围，删除第一个节点
                String oldKey = remove(head);
                cache.remove(oldKey);
            }

            Node node1 = new Node(key, value);

            addNode(node1);
            cache.put(key, node1);
        } else {
            // 如果存在，刷新key-value
            node.value = value;
            refresh(node);
        }
    }

    /**
     * 刷新节点排序
     * @param node
     */
    private void refresh(Node node) {
        if (node != tail) {
            remove(node);
            addNode(node);
        }
    }

    /**
     * 移除节点
     * @param node
     */
    private String remove(Node node) {
        if (node == tail) {
            tail.pre.next = null;
        } else if (node == head) {
            head = head.next;
        } else {
            // 移除中间节点
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        System.out.println("节点：" + node.key + " 被移除.");
        return node.key;
    }

    /**
     * 尾部插入节点
     * @param node
     */
    private void addNode(Node node) {
        if (tail != null) {
            tail.next = node;
            node.pre = tail;
            node.next = null;
        }

        tail = node;

        if (head == null) {
            head = node;
        }
    }


    class Node {
        private Node pre;
        private Node next;
        private String key;
        private String value;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);

        cache.put("001", "user 01");
        cache.put("002", "user 02");
        cache.put("003", "user 03");
        cache.put("004", "user 04");

        cache.get("003");

        cache.put("002", "user 02 update");
        cache.put("005", "user 05");

        System.out.println(cache.get("001"));
        System.out.println(cache.get("002"));
        System.out.println(cache.get("005"));
    }
}
