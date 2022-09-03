package com.company;

import java.util.*;

class Solution {
    String[] gInfo;
    Map<String, List<Integer>> map;
    public int[] solution(String[] infos, String[] query) {
        List<Integer> answer = new ArrayList<Integer>();
        map = new HashMap<>();
        for (String info : infos) {
            gInfo = info.split(" ");
            dfs("",0);
        }

        for (List<Integer> list : map.values()) {
            list.sort(null);
        }

        for (String str : query) {
            String editStr = str.replace(" and ", "");
            int splitIndex =  editStr.lastIndexOf(" ");
            int targetScore = Integer.parseInt(editStr.substring(splitIndex + 1));
            String targetStr = editStr.substring(0, splitIndex);

            List<Integer> valueList = map.getOrDefault(targetStr, new ArrayList<>());

            int targetNum = bisectLeft(valueList,targetScore);
            answer.add(valueList.size() - targetNum);

        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private void dfs(String str , int index) {
        if(index == 4){
            List<Integer> list = map.getOrDefault(str, new ArrayList<>());
            list.add(Integer.valueOf(gInfo[index]));
            map.put(str, list);
            return;
        }

        String tempStr1 = str + gInfo[index];
        dfs(tempStr1,index + 1);
        String tempStr2 = str + "-";
        dfs(tempStr2,index + 1);
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
