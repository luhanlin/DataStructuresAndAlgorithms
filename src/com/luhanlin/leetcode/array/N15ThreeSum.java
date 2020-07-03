package com.luhanlin.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <类详细描述>
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-02 14:13]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N15ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i+1;
            int r = nums.length - 1;

            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    List<Integer> list = Arrays.asList(nums[i], nums[l], nums[r]);
                    res.add(list);
                    l++;
                    r--;
                    // 排重
                    while (l < r && nums[l] == nums[l-1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r+1]) {
                        r--;
                    }
                } else if (sum < 0) {
                    l++;
                    while (l < r && nums[l] == nums[l-1]) {
                        l++;
                    }
                } else {
                    r--;
                    while (l < r && nums[r] == nums[r+1]) {
                        r--;
                    }
                }
            }
        }

        return res;
    }
}
