package com.luhanlin.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * <类详细描述> 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个
 * 更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-09 19:37]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N503NextGreaterElements {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            while(!stack.isEmpty() && num > nums[stack.peek()]){
                res[stack.pop()] = num;
            }
            if(i < n) stack.add(i);

        }
        return res;
    }
}
