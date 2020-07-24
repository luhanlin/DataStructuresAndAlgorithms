package com.luhanlin.leetcode.tree;

import java.util.LinkedList;

/**
 * <类详细描述> 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-23 18:23]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N230KthSmallest {

    /**
     * 二叉搜索树 中序遍历有序
     * @param root
     * @param k
     * @return
     */
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;

        kthSmallest(root.left,k);

        count++;
        if (count == k) return root.val;

        kthSmallest(root.right, k);

        return -1;
    }

    /**
     * 迭代的方式进行中序遍历
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest2(TreeNode root, int k) {
        LinkedList<TreeNode> queue = new LinkedList<>();

        while (true) {
            while (root != null) {
                queue.add(root);
                root = root.left;
            }
            root = queue.removeLast();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }
}
