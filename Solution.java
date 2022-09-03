package com.company;

import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        List<Integer> answer = new ArrayList<Integer>();
        Map<String, List<Integer>> map = new HashMap<>();
        for (String str : info) {
            int splitIndex = str.lastIndexOf(" ");
            String key = str.substring(0, splitIndex);
            Integer value = Integer.valueOf(str.substring(splitIndex + 1));
            List<Integer> list = map.getOrDefault(key, new ArrayList<>());
            list.add(value);
            map.put(key, list);
        }

        for (String str : query) {
            String[] queryElements =  str.replace(" and ", " ").split(" ");
            StringBuilder tempQueryKey = new StringBuilder();
            int targetScore = Integer.parseInt(queryElements[queryElements.length - 1]);

            for (int i = 0; i < queryElements.length - 1; i++) {
                String condition = queryElements[i];
                if(condition.equals("-")) continue;
                tempQueryKey.append(condition).append(" ");
            }

            if(tempQueryKey.length() > 0)
                tempQueryKey.deleteCharAt(tempQueryKey.length() - 1);
            else
                tempQueryKey.append(" ");

            List<Integer> valueList = new ArrayList<>();
            for (String key : map.keySet()) {
                if(key.contains(tempQueryKey.toString())){
                    valueList.addAll(map.get(key));
                }
            }

            valueList.sort(null);

            int targetNum = bisectLeft(valueList,targetScore);
            answer.add(valueList.size() - targetNum);
        }


        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private int bisectLeft(List<Integer> valueList, int targetScore) {
        int start = 0;
        int end = valueList.size();

        while (start < end){
            int mid = (start + end) / 2;
            if(valueList.get(mid) >= targetScore){
                end = mid;
            }else{
                start = mid + 1;
            }
        }

        return end;
    }
}
