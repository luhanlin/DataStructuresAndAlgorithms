package com.luhanlin.leetcode.tree;

/**
 * <类详细描述> 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-22 09:10]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N524DiameterOfBinaryTree {

    int maxLength = 0;
    /**
     * 可以转化为 求节点左右子树的最大高度和
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return maxLength;
    }

    public int dfs (TreeNode root) {
        if (root == null) return 0;
        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);
        maxLength = Math.max(maxLength, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
