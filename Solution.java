package com.company;

import java.util.*;

class Solution {
    String dfsString;
    Set<String> tempGlobalSet;
    boolean[] isVisited;

    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<String>();

        for (int courseNum : course) {
            Map<String, Integer> answerMap = new HashMap<String, Integer>();
            Map<Integer, Integer> maxValueMap = new HashMap<Integer, Integer>();

            for (String order : orders) {
                if(order.length() < courseNum) continue;
                tempGlobalSet = new HashSet<>();
                dfsString = order;
                isVisited = new boolean[dfsString.length()];

                dfs("",courseNum);

                for (String element : tempGlobalSet) {
                    answerMap.put(element, answerMap.getOrDefault(element, 0) + 1);
                    if(maxValueMap.getOrDefault(element.length(),0) < answerMap.get(element)){
                        maxValueMap.put(element.length(),answerMap.get(element));
                    }
                }
            }

            for (String str : answerMap.keySet()) {
                if (answerMap.get(str) != 1&& answerMap.get(str) >= maxValueMap.get(str.length())) {
                    answer.add(str);
                }
            }
        }

        answer.sort(null);

        return answer.toArray(new String[0]);
    }

    private void dfs(String str, int courseNum) {
        if (str.length() == courseNum ){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            tempGlobalSet.add(String.valueOf(chars));
            return;
        }

        for (int i = 0; i < dfsString.length(); i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                dfs(str + dfsString.charAt(i), courseNum);
                isVisited[i] = false;
            }
        }
    }
}


