package com.luhanlin.leetcode.array;

/**
 * <类详细描述>
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-02 16:38]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N42Trap {

    /**
     * 暴力法
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int res = 0;
        if (height.length < 3) return 0;

        for (int i = 1; i < height.length; i++) {
            // 寻找左边柱子最大的值
            int left_max = 0;
            int right_max = 0;
            for (int j = i; j >= 0 ; j--) {
                left_max = Math.max(left_max,height[j]);
            }
            for (int k = i; k < height.length; k++) {
                right_max = Math.max(right_max, height[k]);
            }

            res += Math.min(left_max,right_max) - height[i];
        }
        return res;
    }

    /**
     * 先存储 左右最大高度再进行累加求和
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int res = 0;
        int n = height.length;
        if (n < 3) return 0;

        int[] left_max = new int[n];
        int[] right_max = new int[n];
        left_max[0] = height[0];
        for (int i = 1; i < n; i++) {
            left_max[i] = Math.max(left_max[i-1],height[i]);
        }
        right_max[n-1] = height[n-1];
        for (int i = n-2; i >=0; i--) {
            right_max[i] = Math.max(right_max[i+1],height[i]);
        }

        // 累加求和
        for (int i = 0; i < n; i++) {
            res += Math.min(left_max[i], right_max[i]) - height[i];
        }

        return res;
    }

    /**
     * 采用双指针进行实现
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        int res = 0;
        int n = height.length;
        if (n < 3) return 0;

        int l = 0;
        int r = height.length - 1;
        int left_max = 0;
        int right_max = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                if(height[l] >= left_max) {
                    left_max = height[l];
                } else {
                    res += left_max - height[l];
                }
                l++;
            } else {
                if(height[r] >= right_max) {
                    right_max = height[r];
                } else {
                    res += right_max - height[r];
                }
                r--;
            }
        }

        return res;
    }
}
