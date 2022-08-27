package com.company;

import java.util.*;

class Solution {
    String dfsString;
    Set<String> tempGlobalSet;
    boolean[] isVisited;

    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<String>();

        int[] courseMaxValue = new int[course.length];

        Map<String, Integer> orderCountMap = new HashMap<String, Integer>();
        Map<Integer, Integer> courseAndMaxValueMap = new HashMap<Integer, Integer>();

        for (String order : orders) {
            tempGlobalSet = new HashSet<>();

            //최소 2글자를 저장해야 하므로 length -1 까지만 확인한다.
            for (int i = 0; i < order.length() - 1; i++) {
                dfsString = order.substring(i);
                isVisited = new boolean[dfsString.length()];
                dfs("");
            }

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

        return answer.toArray(new String[0]);
    }

    private void dfs(String str) {
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
                dfs(str + dfsString.charAt(i));
                isVisited[i] = false;
            }
        }
    }
}


