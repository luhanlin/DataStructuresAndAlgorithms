package com.luhanlin.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <类详细描述> 二叉查找树 （所有数据不重复）
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-20 18:43]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class SelectTree {

    TreeNode head;

    public SelectTree() {
    }

    public SelectTree(TreeNode head) {
        this.head = head;
    }

    public void add (int data) {
        if (head == null) {
            head = new TreeNode(data);
        }

        TreeNode node = head;
        while (node != null) {
            if (node.val > data) {
                if (node.left == null) {
                    node.left = new TreeNode(data);
                    return;
                }
                node = node.left;
            } else {
                if (node.right == null) {
                    node.right = new TreeNode(data);
                    return;
                }
                node = node.right;
            }
        }
    }

    public TreeNode find (int data) {
        if (head == null) {
            return null;
        }

        TreeNode node = head;
        while (node != null) {
            if (node.val > data) {
                node = node.left;
            } else if (node.val < data) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;
    }

    public void delete (int data) {
        if (head == null) return;

        TreeNode p = head;
        TreeNode pp = null;
        while (p != null && p.val != data) {
            pp = p;
            if (p.val > data) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        // 没有找到
        if (p == null) return;
        // 有两个子节点,寻找右节点的最小节点,
        if (p.left != null && p.right != null) {
            TreeNode minP = p.right;
            TreeNode minPP = p;
            while (minP != null && minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            // 装变成为叶子节点删除
            p.val = minP.val;
            pp = minPP;
            p = minP;
        }
        // 只有一个子节点或者为叶子节点
        TreeNode child;     // 可能存在删除根节点 pp为null的情况
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            // 叶子节点
            child = null;
        }

        // 删除的是根节点
        if (pp == null) {
            head = child;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
    }

    public TreeNode findMin() {
        if (head == null) return null;
        TreeNode p = head;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    public TreeNode findMax() {
        if (head == null) return null;
        TreeNode p = head;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }

    /**
     * 最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        TreeNode node = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int front = 0;// 队头
        int rear = queue.size();// 队尾
        int floor = 0;
        while (!queue.isEmpty()){
            node = queue.poll();
            front++;
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
            if(front == rear){// 进入下一层
                front = 0;
                rear = queue.size();
                floor++;// 层数+1
            }
        }
        return floor;
    }

    public void preOrder(TreeNode head){
        if (head == null) return;
        System.out.print(head.val + "->");
        preOrder(head.left);
        preOrder(head.right);
    }

//    public static void main(String[] args) {
//        SelectTree tree = new SelectTree(new TreeNode(5));
//        tree.add(3);
//        tree.add(1);
//        tree.add(6);
//        tree.add(8);
//        tree.add(7);
//
//        tree.preOrder(tree.head);
//        int level = tree.maxDepth(tree.head);
//        tree.delete(6);
//        System.out.println(level);
//        tree.preOrder(tree.head);
//    }
}
