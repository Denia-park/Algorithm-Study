package com.company;

import java.util.*;

class Solution {
    static public void main(String[] args){
        String[] id_list = {"con", "ryan"};
        String[] reportList = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;
//        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
//        String[] reportList = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
//        int k = 2;

        System.out.println(Arrays.toString(solution(id_list, reportList, k)));
    }

    static public int[] solution(String[] id_list, String[] reportList, int reportNum) {
        int[] answer = new int[id_list.length];
        HashMap<String, HashSet<String>> reportMap = new HashMap<>();
        HashMap<String, Integer> countMap = new HashMap<>();

        //HashSet을 이용한 MashMap을 구현
        //Key : 신고당한 사람 , Value : 신고한 사람의 Set [중복된 값이 들어가면 안되므로]
        for (String id : id_list) {
            HashSet<String> reportingIdSet = new HashSet<>();
            reportMap.put(id, reportingIdSet);

            countMap.put(id, 0);
        }

        //repostList를 이용해서 Map의 내용들을 업데이트
        for (String report  : reportList) {
            String reporter =  report.split(" ")[0]; //신고자
            String reportee =  report.split(" ")[1]; //피신고인

            reportMap.get(reportee).add(reporter); //HashMap의 Value인 Set을 가져와서 reporter를 추가해준다.
        }

        //reportingIdSet의 Size를 확인하면 해당 사람의 신고당한 Count를 확인 가능
        //신고당한 Count를 확인해서 reportNum 이상이면 mailNum 을 업데이트한다.
        for (String id : id_list) {
            HashSet<String> reportingIdSet = reportMap.get(id);
            if(reportingIdSet.size() >= reportNum){
                for (String reportingId : reportingIdSet) {
                    int mailNum = countMap.get(reportingId);
                    countMap.put(reportingId, mailNum + 1);
                }
            }
        }

        //countMap에서 answer 배열로 변환하는 과정
        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            answer[i] = countMap.get(id);
        }

        return answer;
    }
}