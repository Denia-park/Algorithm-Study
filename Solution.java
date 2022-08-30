package com.company;

import java.util.*;

class Solution {
    //Column 의 수
    int columnNumber;
    //모든 조합 구하기.
    List<String> combinationList;
    public int solution(String[][] relation) {
        //answer을 0으로 초기화
        int answer = 0;
        //행의 수를 count
        int rowNumber = relation.length;
        //열의 수를 count
        columnNumber = relation[0].length;
        //조합을 구할때 사용할 List 할당
        combinationList = new ArrayList<>();
        //Integer List 를 보관할 List 생성
        List<List<Integer>> completeIndexList = new LinkedList<>();

        //dfs를 이용하여 모든 조합의 수 구하기.
        dfs(null,0);

        // dfs를 사용하여 조합을 구할 경우 정렬이 제대로 되어있지 않다.
        // 길이가 짧으면서 , 사전순으로 정렬을 해야한다. 그리고 나서 앞에서부터 후보키 판별을 해야
        // 추후에 해당 후보키가 최소성을 만족하는지 확인을 할수가 있다.
        combinationList.sort(new MyComparator());

        //for문을 돌면서 모든 조합에 대해서 유일성 및 최소성을 확인한다.
        for (String str : combinationList) {
            //공백을 기준으로 숫자가 구분되어 있으므로 " " 로 split 하여 확인한다.
            String[] splitArr = str.split(" ");
            //splitArr의 원소들을 Integer로 변환하여 Integer List로 관리하기 위해서 List 생성
            List<Integer> indexList = new ArrayList<>();
            //유일성을 확인하기 위해서 set을 생성
            Set<String> checkDupliSet = new HashSet<>();

            //string을 받아서 Integer로 변환 후 indexList에 추가
            for (String str2 : splitArr) {
                indexList.add(Integer.valueOf(str2));
            }

            //각 열에 해당하는 값들을 string으로 변환 후 조합하여 set에 저장한다.
            for (int i = 0; i < rowNumber; i++) {
                String tempStr = "";
                for (Integer temp : indexList) {
                    tempStr += relation[i][temp];
                }
                checkDupliSet.add(tempStr);
            }

            //set의 크기가 rowNumber 와 동일하면 유일성을 만족한다.
            if(checkDupliSet.size() == rowNumber){
                //최소성을 확인하기 위해서 boolean 변수 생성
                boolean addFlag = true;

                //completeIndexList 는 후보키에 만족하는 애들을 추가해둔 List
                //기존 후보키에 해당하는 값이 indexList(이번 조합)에 포함되어 있다면 해당 indexList(이번 조합) 는
                // 최소성을 만족하지 못한다.
                for (List<Integer> eachList : completeIndexList) {
                    //completeIndexList의 값중에 한개라도 포함되어 있으면 최소성을 만족하지 못하므로 addFlag 를 false로 반환 후 break
                    if (indexList.containsAll(eachList)) {
                        addFlag = false;
                        break;
                    }
                }

                //최소성을 만족하지 못하면 후보키가 될 수 없다.
                if(!addFlag) continue;

                //유일성 + 최소성 모두 만족하면 completeIndexList에 추가 하고 answer의 값을 1개 올린다.
                completeIndexList.add(indexList);
                answer++;
            }
        }

        return answer;
    }

    //dfs 이용하여 모든 조합의 경우의 수를 구함.
    private void dfs(String str, int index) {
        for (int i = index; i < columnNumber; i++) {
                String tempStr;
                //처음에 null이 들어갈때를 고려하여 if 분기 처리
                if(str == null)
                    tempStr = "" + i;
                else
                    tempStr = str + " " + i;

                combinationList.add(tempStr);
                dfs(tempStr, i + 1);
        }
    }
}

//comparator 를 직접 구현
class MyComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        //길이가 짧은 것을 앞에 둔다.
        // 길이가 동일하다면 사전순으로 정렬한다.
        if(o1.length() < o2.length())
            return -1;
        else if(o1.length() > o2.length())
            return 1;
        else
            return o1.compareTo(o2);
    }
}
