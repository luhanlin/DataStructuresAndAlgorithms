package com.luhanlin.leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;

/**
 * <类详细描述>给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-23 10:08]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N124MaxPathSum {

    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int l = Math.max(0,dfs(root.left));
        int r = Math.max(0,dfs(root.right));

        max = Math.max(max, l + root.val + r);

        return Math.max(l, r) + root.val;
    }
}
