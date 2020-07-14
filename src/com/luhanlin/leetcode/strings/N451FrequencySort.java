package com.luhanlin.leetcode.strings;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * <类详细描述> 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-14 14:17]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N451FrequencySort {

    /**
     * 使用大顶堆
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        StringBuilder builder = new StringBuilder();

        if (s.length() <= 2) return s;

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> queue = new PriorityQueue<>((c1, c2) -> map.get(c2) - map.get(c1));

        for (Character c : map.keySet()) {
            queue.add(c);
        }

        while (!queue.isEmpty()) {
            Character c = queue.poll();
            for (int i = 0; i < map.get(c); i++) {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
