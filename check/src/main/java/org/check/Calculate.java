package org.check;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Calculate {
    public static double cal (String str1,String str2) {
        Map<Character, Integer> charCount1 = new HashMap<>();
        Map<Character, Integer> charCount2 = new HashMap<>();

        // 统计第一个字符串中每个字符的出现次数
        for (char c : str1.toCharArray()) {
            charCount1.put(c, charCount1.getOrDefault(c, 0) + 1);
        }

        // 统计第二个字符串中每个字符的出现次数
        for (char c : str2.toCharArray()) {
            charCount2.put(c, charCount2.getOrDefault(c, 0) + 1);
        }

        int totalCount = 0;

        // 遍历第一个字符串中的字符
        for (char c : charCount1.keySet()) {
            // 如果第二个字符串也包含相同的字符
            if (charCount2.containsKey(c)) {
                // 计算两个字符串中重复字符的个数，并累加到totalCount中
                totalCount += Math.min(charCount1.get(c), charCount2.get(c));
            }
        }

        if (totalCount >= str1.length()) return 1;

        return (double) totalCount / str2.length();

    }

}
