package com.company;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int peopleNum, String[] words) {
        Map<String, Integer> answerMap = new HashMap<>();
        int forIndex = 0;
        char lastChar = '\0';

        for (forIndex = 0; forIndex < words.length; forIndex++) {
            if(lastChar != '\0' && words[forIndex].charAt(0) != lastChar) break;

            if(answerMap.getOrDefault(words[forIndex], 0) + 1 == 2) break;

            answerMap.put(words[forIndex], answerMap.getOrDefault(words[forIndex], 0) + 1);
            lastChar = words[forIndex].charAt(words[forIndex].length() - 1);
        }

        return forIndex == words.length ? new int[]{0, 0} : new int[]{forIndex % peopleNum + 1, forIndex / peopleNum + 1};
    }
}
