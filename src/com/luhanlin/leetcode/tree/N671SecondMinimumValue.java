package com.luhanlin.leetcode.tree;

/**
 * <类详细描述> 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 *
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-23 16:59]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N671SecondMinimumValue {

    public int findSecondMinimumValue(TreeNode root) {
        return findBigger(root, root.val);
    }

    private int findBigger(TreeNode root, int val) {
        if (root == null) return -1;

        if (root.val > val) {
            return root.val;
        }

        int l = findBigger(root.left, val);
        int r = findBigger(root.right, val);

        if (l == -1) return r;
        if (r == -1) return l;
        return Math.min(l, r);
    }
}
