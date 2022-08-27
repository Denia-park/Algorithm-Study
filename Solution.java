package com.company;

import java.util.*;

class Solution {
    String dfsString;
    Set<String> tempGlobalSet;
    boolean[] isVisited;

    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<String>();

        Map<String, Integer> orderCountMap = new HashMap<String, Integer>();
        Map<Integer, Integer> courseAndMaxValueMap = new HashMap<Integer, Integer>();

        for (String order : orders) {
            tempGlobalSet = new HashSet<>();
            dfsString = order;

            isVisited = new boolean[dfsString.length()];
            dfs("");

            for (String element : tempGlobalSet) {
                int elementLen = element.length();
                orderCountMap.put(element, orderCountMap.getOrDefault(element, 0) + 1);
                courseAndMaxValueMap.put(elementLen,Math.max(courseAndMaxValueMap.getOrDefault(elementLen,0), orderCountMap.get(element)));
            }
        }

        for (String str : orderCountMap.keySet()) {
            if (orderCountMap.get(str) != 1 && Objects.equals(courseAndMaxValueMap.get(str.length()), orderCountMap.get(str))) {
                answer.add(str);
            }
        }

        answer.sort(null);

        tempGlobalSet = new HashSet<>();

        for (String str : answer) {
            char[] tempStr = str.toCharArray();
            Arrays.sort(tempStr);
            tempGlobalSet.add(String.valueOf(tempStr));
        }

        String[] answerArr = tempGlobalSet.toArray(new String[0]);

        Arrays.sort(answerArr);

        return answerArr;
    }

    private void dfs(String str) {
        if (str.length() > 1) {
            tempGlobalSet.add(str);
            if(str.length() == dfsString.length())
                return;
        }

        for (int i = 0; i < dfsString.length(); i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                dfs(str + dfsString.charAt(i));
                isVisited[i] = false;
            }
        }
    }
}


