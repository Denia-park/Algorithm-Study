package com.company;

import java.util.*;

class Solution {
    String bfsString;
    Set<String> tempGlobalSet;
    boolean[] isVisited;

    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<String>();

        Map<String, Integer> orderCountMap = new HashMap<String, Integer>();
        Map<Integer, Integer> courseAndMaxValueMap = new HashMap<Integer, Integer>();

        for (String order : orders) {
            tempGlobalSet = new HashSet<>();
            char[] tempCharArr = order.toCharArray();
            Arrays.sort(tempCharArr);

            for (int i = 0; i < order.length(); i++) {
                bfsString = String.valueOf(tempCharArr).substring(i);
                // i = 0 일때는 제외 , 왜냐 1글자는 필요없어서
                for (int j = 1; j < bfsString.length(); j++) {
                    String bfsSubString = bfsString.substring(0, j);
                    for (int k = j; k < bfsString.length(); k++) {
                        tempGlobalSet.add("" + bfsSubString + bfsString.charAt(k));
                    }
                }
            }

            for (String element : tempGlobalSet) {
                int elementLen = element.length();
                orderCountMap.put(element, orderCountMap.getOrDefault(element, 0) + 1);
                courseAndMaxValueMap.put(elementLen,Math.max(courseAndMaxValueMap.getOrDefault(elementLen,0), orderCountMap.get(element)));
            }
        }

        for (int i = 0; i < course.length; i++) {
            int courseMaxCount = courseAndMaxValueMap.getOrDefault(course[i],-1);
            if(courseMaxCount == -1) continue;

            for (String str : orderCountMap.keySet()) {
                if(str.length() == course[i] && courseAndMaxValueMap.get(str.length()) == orderCountMap.get(str) && orderCountMap.get(str) != 1)
                    answer.add(str);
            }
        }

        answer.sort(null);

        return answer.toArray(new String[0]);
    }
}

//        for (int i = 1; i < bfsString.length(); i++) {
//            tempGlobalSet.add("" + bfsString.substring(0,1) + bfsString.charAt(i));
//        }
//
//        for (int i = 2; i < bfsString.length(); i++) {
//            tempGlobalSet.add("" + bfsString.substring(0,2) + bfsString.charAt(i));
//        }
//
//        for (int i = 3; i < bfsString.length(); i++) {
//            tempGlobalSet.add("" + bfsString.substring(0,3) + bfsString.charAt(i));
//        }
//
//        for (int i = 4; i < bfsString.length(); i++) {
//            tempGlobalSet.add("" + bfsString.substring(0,4) + bfsString.charAt(i));
//        }
