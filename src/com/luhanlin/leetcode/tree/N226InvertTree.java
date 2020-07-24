package com.luhanlin.leetcode.tree;

/**
 * <类详细描述>翻转一棵二叉树。
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-23 10:45]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N226InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        // 后序遍历
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
