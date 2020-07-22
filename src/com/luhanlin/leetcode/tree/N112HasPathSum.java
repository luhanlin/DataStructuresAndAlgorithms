package com.luhanlin.leetcode.tree;

import java.util.LinkedList;

/**
 * <类详细描述> 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-22 17:12]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N112HasPathSum {

    /**
     * DFS 搜索
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        if (root.left == null && root.right == null && sum == root.val) return true;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    /**
     * BFS 搜索
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) return false;
        LinkedList<TreeNode> nodeQueue = new LinkedList<>();
        LinkedList<Integer> valQueue = new LinkedList<>();

        nodeQueue.add(root);
        valQueue.add(root.val);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            Integer val = valQueue.poll();
            if (node.left == null && node.right == null && val == sum) return true;

            if (node.left != null) {
                nodeQueue.add(node.left);
                valQueue.add(val + node.left.val);
            }
            if (node.right != null) {
                nodeQueue.add(node.right);
                valQueue.add(val + node.right.val);
            }
        }
        return false;
    }

    boolean flag = false;
    public boolean hasPathSum3(TreeNode root, int sum) {
        dfs(root, sum ,0);
        return flag;
    }
    public void dfs(TreeNode root, int sum ,int curSum){
        if(flag || root== null) return;
        if(root.left == null&& root.right == null) {
            if(curSum + root.val == sum){
                flag = true;
                return;
            }
        }
        else{
            if(root.left != null)
                dfs(root.left, sum, curSum + root.val);
            if(root.right != null)
                dfs(root.right, sum ,curSum + root.val);
        }
    }
}
