package com.luhanlin.leetcode.strings;

/**
 * <类详细描述> 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-13 16:59]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N76MinWindow {

    /**
     * 滑动窗口
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen == 0 || tLen == 0) return "";
        int needSize = 0;
        int[] need = new int[128];
        int[] window = new int[128];

        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            if (need[c] == 0) needSize++;
            need[c]++;
        }

        int count = 0;
        int start = 0;
        int end = 0;
        int left = 0;
        int right = 0;
        int resLen = Integer.MAX_VALUE;

        while (right < sLen) {
            // 移动右指针
            char rc = s.charAt(right);
            right++;
            if (need[rc] > 0) {
                window[rc]++;
                if (window[rc] == need[rc]) {
                    count++;
                }
            }
            // 如果子数组满足条件，开始移动左指针
            while (count == needSize) {
                if (right - left < resLen) {
                    start = left;
                    end = right;
                    resLen = right - left;
                }

                char lc = s.charAt(left);
                left++;
                if (need[lc] > 0) {
                    if (need[lc] == window[lc]) {
                        count--;
                    }
                    window[lc]--;
                }
            }
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(start, end);
    }
}
