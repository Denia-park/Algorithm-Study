package com.company;

public class Solution {
    static public void main(String[] args) {
        int n1 = 2;
        String[] data1 = { "N~F=0", "R~T>2" };
        int n2 = 2;
        String[] data2 = {"M~C<2", "C~M>1"};

//        System.out.println(solution(n1, data1) == 3648);
        System.out.println(solution(n1, data1));
//        System.out.println(solution(n2, data2) == 0);
        System.out.println(solution(n2, data2) );
    }

    static String[] conditions;
    static int answer;
    static String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};

    static public int solution(int n, String[] data) {
        boolean[] isVisited = new boolean[friends.length];
        conditions = data;
        answer = 0;

        dfs("",isVisited);

        return answer;
    }

    private static void dfs(String curMemberPicture, boolean[] isVisited) {
        if(curMemberPicture.length() == 8){
            if (checkCondition(curMemberPicture)) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < friends.length; i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                dfs(curMemberPicture + friends[i], isVisited);
                isVisited[i] = false;
            }
        }
    }

    private static boolean checkCondition(String memberPicture) {
        for (String condition : conditions) {
            char member1 = condition.charAt(0);
            char member2 = condition.charAt(2);
            char operator = condition.charAt(3);
            int compareValue = condition.charAt(4) - '0' + 1; //간격을 구하기 위해서는 + 1 을 해야함
            int absOfPositionDiffValueInMemberPicture = Math.abs(memberPicture.indexOf(member1) - memberPicture.indexOf(member2));

            if (operator == '=') {
                if (!(absOfPositionDiffValueInMemberPicture == compareValue)) {
                    return false;
                }
            } else if (operator == '<') {
                if (!(absOfPositionDiffValueInMemberPicture < compareValue)) {
                    return false;
                }
            } else if (operator == '>') {
                if (!(absOfPositionDiffValueInMemberPicture > compareValue)) {
                    return false;
                }
            }
        }

        return true;
    }
}
