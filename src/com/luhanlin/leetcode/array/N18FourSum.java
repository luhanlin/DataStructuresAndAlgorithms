package com.luhanlin.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <类详细描述>
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-02 14:54]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N18FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) return res;
        Arrays.sort(nums);
        if (nums[0] > target) return res;
        for (int k = 0; k < nums.length -2; k++) {
            if(nums[k] > target) break;
            if(k > 0 && nums[k] == nums[k - 1]) continue;

            for (int i = k+1; i < nums.length -1; i++) {
                if(nums[i] > target) break;
                if(i > 1 && nums[i] == nums[i - 1]) continue;

                int l = i+1;
                int r = nums.length - 1;

                while(l < r) {
                    int sum = nums[k] + nums[i] + nums[l] + nums[r];
                    if (sum == target) {
                        List<Integer> list = Arrays.asList(nums[k],nums[i], nums[l], nums[r]);
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
                    } else if (sum < target) {
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
        }

        return res;
    }
}
