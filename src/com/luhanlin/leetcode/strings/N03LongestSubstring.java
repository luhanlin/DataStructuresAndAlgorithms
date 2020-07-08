package com.luhanlin.leetcode.strings;

import java.util.HashMap;
import java.util.HashSet;

/**
 * <类详细描述> 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-06 17:43]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N03LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n < 2) return n;

        int res = 1;

        int j = 0; // 代表不重复字符串起始下标
        for (int i = 1; i < n; i++) {
            String subStr = s.substring(j,i);
            int ide = subStr.indexOf(s.charAt(i));
            if (ide == -1) {
                res = Math.max(res, i-j+1);
            } else {
                j = j + ide + 1;
            }
        }

        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        if (n < 2) return n;

        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int j = 0; // 代表不重复字符串起始下标
        for (int i = 0; i < n; i++) {
            char key = s.charAt(i);
            if (map.containsKey(key)) {
                j = Math.max(j, map.get(key) + 1);
            }
            res = Math.max(res, i-j+1);
            map.put(key, i);
        }
        return res;
    }

}
