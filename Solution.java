package com.company;

import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        List<Integer> answer = new ArrayList<Integer>();
        Map<Set<String>, List<Integer>> map = new HashMap<>();
        for (String str : info) {
            int splitIndex = str.lastIndexOf(" ");
            String[] keys = str.substring(0, splitIndex).split(" ");
            Set<String> set = new HashSet<>(Arrays.asList(keys));

            Integer value = Integer.valueOf(str.substring(splitIndex + 1));
            List<Integer> list = map.getOrDefault(set, new ArrayList<>());
            list.add(value);
            map.put(set, list);
        }

        for (String str : query) {
            String[] queryStrings =  str.replace(" and ", " ").split(" ");
            int targetScore = Integer.parseInt(queryStrings[queryStrings.length - 1]);
            Set<String> set = new HashSet<>();

            for (int i = 0; i < queryStrings.length - 1; i++) {
                if(!queryStrings[i].equals("-")) set.add(queryStrings[i]);
            }
            
            List<Integer> valueList = new ArrayList<>();
            for (Set<String> eachKeySet : map.keySet()) {
                if(eachKeySet.containsAll(set)){
                    valueList.addAll(map.get(eachKeySet));
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
