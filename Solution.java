package com.company;

import java.util.*;

class Solution {
    int answer;
    boolean[] isVisited;
    int columnNumber;
    int rowNumber;
    List<String> combinationList;
    public int solution(String[][] relation) {
        answer = 0;
        rowNumber = relation.length;
        columnNumber = relation[0].length;
        isVisited = new boolean[columnNumber];
        combinationList = new ArrayList<>();

        dfs(null,0);

        combinationList.sort(new MyComparator());

        for (String str : combinationList) {
            String[] split = str.split(" ");
            List<Integer> tempList = new ArrayList<>();
            Set<String> tempSet = new HashSet<>();

            for (String str2 : split) {
                tempList.add(Integer.valueOf(str2));
            }

            for (int i = 0; i < rowNumber; i++) {
                String tempStr = "";
                for (Integer temp : tempList) {
                    if(!isVisited[temp]){
                        tempStr += relation[i][temp];
                    }
                }
                tempSet.add(tempStr);
            }

            if(tempSet.size() == rowNumber){
                for (Integer temp : tempList) {
                    isVisited[temp] = true;
                }
                answer++;
            }
        }

        return answer;
    }

    private void dfs(String str, int index) {
        for (int i = index; i < columnNumber; i++) {
            if(!isVisited[i]){
                String tempStr;
                if(str == null)
                    tempStr = "" + i;
                else
                    tempStr = str + " " + i;

                combinationList.add(tempStr);
                dfs(tempStr, i + 1);
            }
        }
    }
}

class MyComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if(o1.length() < o2.length())
            return -1;
        else return 0;
    }
}
