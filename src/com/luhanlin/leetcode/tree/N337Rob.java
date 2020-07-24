package com.luhanlin.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * <类详细描述> 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-23 16:13]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N337Rob {

    Map<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) return 0;

        if (memo.containsKey(root)) return memo.get(root);
        int res = root.val;
        // 抢这家，不能抢下家
        res += (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right));
        res += (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        // 不抢这家，可抢可不抢下家
        int not_do = rob(root.left) + rob(root.right);
        res = Math.max(res, not_do);
        memo.put(root,res);
        return res;
    }

    public int rob2(TreeNode root) {
        int[] res = dp(root);
        return Math.max(res[0], res[1]);
    }

    /* 返回一个大小为 2 的数组 arr
    arr[0] 表示不抢 root 的话，得到的最大钱数
    arr[1] 表示抢 root 的话，得到的最大钱数 */
    int[] dp(TreeNode root) {
        if (root == null)
            return new int[]{0, 0};
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        // 抢，下家就不能抢了
        int rob = root.val + left[0] + right[0];
        // 不抢，下家可抢可不抢，取决于收益大小
        int notRob = Math.max(left[0], left[1])
                + Math.max(right[0], right[1]);

        return new int[]{notRob, rob};
    }
}
