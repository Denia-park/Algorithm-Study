package com.company;

import java.util.*;

class Solution {
    String dfsString;
    Set<String> tempGlobalSet;
    boolean[] isVisited;

    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<String>();

        char[] orderChars;
        int[] courseMaxValue = new int[course.length];

        Map<String, Integer> answerMap = new HashMap<String, Integer>();

        for (String order : orders) {
            orderChars = order.toCharArray();

            Arrays.sort(orderChars);

            tempGlobalSet = new HashSet<>();

            //최소 2글자를 저장해야 하므로 length -1 까지만 확인한다.
            for (int i = 0; i < orderChars.length - 1; i++) {
                dfsString = String.valueOf(orderChars).substring(i);
                isVisited = new boolean[dfsString.length()];
                dfs("", 0);
            }

            for (String element : tempGlobalSet) {
                answerMap.put(element, answerMap.getOrDefault(element, 0) + 1);
                for (int i = 0; i < course.length; i++) {
                    if (element.length() == course[i]) {
                        courseMaxValue[i] = Math.max(courseMaxValue[i], answerMap.get(element));
                    }
                }
            }
        }

        for (int i = 0; i < course.length; i++) {
            for (String str : answerMap.keySet()) {
                if (answerMap.get(str) != 1 && str.length() == course[i] && answerMap.get(str) == courseMaxValue[i]) {
                    answer.add(str);
                }
            }
        }

        answer.sort(null);

        return answer.toArray(new String[0]);
    }

    private void dfs(String str, int depth) {
        if (str.length() == dfsString.length()) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            tempGlobalSet.add(String.valueOf(chars));
            return;
        } else {
            if (str.length() > 1) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                tempGlobalSet.add(String.valueOf(chars));
            }
        }

        for (int i = 0; i < dfsString.length(); i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                dfs(str + dfsString.charAt(i), depth + 1);
                isVisited[i] = false;
            }
        }
    }
}


