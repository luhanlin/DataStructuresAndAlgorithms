package com.luhanlin.leetcode.array;

/**
 * <类详细描述>
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-02 15:32]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N11MaxArea {

    /**
     * 暴力法可以直接循环遍历 min(x,y)*d, 最优双指针法
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int res = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                res = Math.max(res, height[l] * (r - l));
                l++;
                while (l < r && height[l] == height[l-1]) {
                    l++;
                }
            } else {
                res = Math.max(res, height[r] * (r - l));
                r--;
                while (l < r && height[r] == height[r+1]) {
                    r--;
                }
            }
        }

        return res;
    }
}
