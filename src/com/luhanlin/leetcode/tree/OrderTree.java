package com.luhanlin.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * <类详细描述> 前序 中序 后序 的递归以及迭代写法
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-24 08:51]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class OrderTree {

    /**
     * 前序递归 N 144
     * @param root
     * @return
     */
    public List<Integer> preOrder(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    private void preOrder(TreeNode root, ArrayList<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }

    /**
     * 前序迭代 N144
     * @param root
     * @return
     */
    public List<Integer> preOrder2(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }

        return res;
    }

    /**
     * 前序迭代 N144
     * @param root
     * @return
     */
    public List<Integer> preOrder3(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                res.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                cur = cur.right;
            }
        }

        return res;
    }

    /**
     * 中序遍历 N94 递归
     * @param root
     * @return
     */
    public List<Integer> midOrder(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        midOrder(root, res);
        return res;
    }

    private void midOrder(TreeNode root, ArrayList<Integer> res) {
        if (root == null) return;
        midOrder(root.left, res);
        res.add(root.val);
        midOrder(root.right, res);
    }

    /**
     * 中序遍历 N94 迭代
     * @param root
     * @return
     */
    public List<Integer> midOrder2(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }

        return res;
    }

    /**
     * 后序遍历 N145 递归
     * @param root
     * @return
     */
    public List<Integer> postOrder(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        postOrder(root, res);
        return res;
    }

    private void postOrder(TreeNode root, ArrayList<Integer> res) {
        if (root == null) return;
        postOrder(root.left, res);
        postOrder(root.right, res);
        res.add(root.val);
    }

    /**
     * 后序遍历 N145 迭代
     * @param root
     * @return
     */
    public List<Integer> postOrder2(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                res.addFirst(cur.val);
                stack.push(cur);
                cur = cur.right;
            } else {
                cur = stack.pop();
                cur = cur.left;
            }
        }

        return res;
    }
}
