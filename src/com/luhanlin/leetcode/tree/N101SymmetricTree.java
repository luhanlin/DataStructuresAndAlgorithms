package com.luhanlin.leetcode.tree;

import java.util.LinkedList;

/**
 * <类详细描述> 给定一个二叉树，检查它是否是镜像对称的。
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-23 14:00]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N101SymmetricTree {

    /**
     * 递归版本
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;

        if (root1 == null || root2 == null) return false;

        if (root1.val != root2.val) return false;

        return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
    }

    /**
     * 迭代进行
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.offer(root.left);
        queue.offer(root.right);

        while(!queue.isEmpty()) {
            TreeNode lNode = queue.poll();
            TreeNode rNode = queue.poll();
            if (lNode == null && rNode == null) continue;
            if (lNode == null || rNode == null || lNode.val != rNode.val) return false;

            queue.offer(lNode.left);
            queue.offer(rNode.right);
            queue.offer(lNode.right);
            queue.offer(rNode.left);
        }
        return true;
    }

}
