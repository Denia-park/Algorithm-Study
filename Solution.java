package com.company;

import java.util.*;

class Solution {
    String dfsString;
    Set<String> tempGlobalSet;
    boolean[] isVisited;
    int minCourseValue;
    int maxCourseValue;

    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<String>();

        minCourseValue = course[0];
        maxCourseValue = course[course.length - 1];

        int[] courseMaxValue = new int[course.length];

        Map<String, Integer> answerMap = new HashMap<String, Integer>();

        for (String order : orders) {

            tempGlobalSet = new HashSet<>();

            dfsString = order;
            isVisited = new boolean[dfsString.length()];

            dfs("");

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

    private void dfs(String str) {
        if (str.length() >= minCourseValue && maxCourseValue >= str.length()){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            tempGlobalSet.add(String.valueOf(chars));
        }
        if(str.length() == dfsString.length()) return;

        for (int i = 0; i < dfsString.length(); i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                dfs(str + dfsString.charAt(i));
                isVisited[i] = false;
            }
        }
    }
}


