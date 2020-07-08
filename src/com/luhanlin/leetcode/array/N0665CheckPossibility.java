package com.luhanlin.leetcode.array;

/**
 * 类详细描述：给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/24 3:50 下午
 */
public class N0665CheckPossibility {

    /**
     * 其实说的简单点，有2种情况：
     * 升序序列中，突然有个数字小了，则nums[i]=nums[i-1]
     * [1,2,3,4,5,3,7,8]
     * 升序序列中，突然有个数字大了，则nums[i-1]=nums[i]
     * [1,2,3,4,5,9,7,8]
     *
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {
        int fix=0;
        for (int i=1;i<nums.length && fix<=1;i++){
            if (nums[i]>=nums[i-1]){
                continue;
            }
            fix++;
            if (i-2>=0&&(nums[i]<nums[i-2])){//突然有个数字小了
                nums[i]=nums[i-1];
            }else {//突然有个数字大了
                nums[i-1]=nums[i];
            }
        }
        return fix<=1;
    }
}
