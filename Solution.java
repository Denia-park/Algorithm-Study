package com.company;

import java.util.*;

class Solution {
    int answer;
    int columnNumber;
    int rowNumber;
    List<String> combinationList;
    public int solution(String[][] relation) {
        answer = 0;
        rowNumber = relation.length;
        columnNumber = relation[0].length;
        combinationList = new ArrayList<>();
        List<List<Integer>> completeIndexList = new LinkedList<>();

        dfs(null,0);

        combinationList.sort(new MyComparator());

        for (String str : combinationList) {
            String[] splitArr = str.split(" ");
            List<Integer> indexList = new ArrayList<>();
            Set<String> checkDupliSet = new HashSet<>();

            for (String str2 : splitArr) {
                indexList.add(Integer.valueOf(str2));
            }

            for (int i = 0; i < rowNumber; i++) {
                String tempStr = "";
                for (Integer temp : indexList) {
                    tempStr += relation[i][temp];
                }
                checkDupliSet.add(tempStr);
            }

            if(checkDupliSet.size() == rowNumber){
                boolean addFlag = true;

                for (List<Integer> eachList : completeIndexList) {
                    if ((indexList).containsAll(eachList)) {
                        addFlag = false;
                        break;
                    }
                }

                if(!addFlag) continue;

                completeIndexList.add(indexList);
//                System.out.println("tempList : " + indexList);
                answer++;
            }
        }

        System.out.println(completeIndexList);

        return answer;
    }

    private void dfs(String str, int index) {
        for (int i = index; i < columnNumber; i++) {
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

class MyComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if(o1.length() < o2.length())
            return -1;
        else return 0;
    }
}
