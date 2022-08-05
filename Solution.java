package com.company;

public class Solution {
    static public void main(String[] args) {
        int n1 = 2;
        String[] data1 = { "N~F=0", "R~T>2" };
        int n2 = 2;
        String[] data2 = {"M~C<2", "C~M>1"};

        System.out.println(solution(n1, data1) == 3648);
        System.out.println(solution(n2, data2) == 0);
    }

    //https://youngest-programming.tistory.com/586 참조

    static String[] conditions;
    static int answer;
    static boolean[] isVisited;
    static String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};

    static public int solution(int n, String[] data) {
        //visited 를 가질 boolean 배열을 정의
        isVisited = new boolean[friends.length];
        //data 는 변경되지 않으므로 전역변수 사용하고 할당한다.
        conditions = data;
        //answer 초기화
        answer = 0;

        //DFS를 이용하여 완전 순회를 이용할 계획
        dfs("");

        return answer;
    }

    private static void dfs(String curMemberPicture) {
        // curMemberPicture.length() == 8 이면 8명 다 제대로 자리에 섯다는 의미기 때문에 조건에 맞는지 검사
        if(curMemberPicture.length() == 8){
            // 조건을 검사해서 true 가 나오면 answer 를 1 올려준다.
            if (checkCondition(curMemberPicture)) {
                answer++;
            }
            return;
        }

        // 순서대로 자리를 서게 만들기 위해서 for문을 이용
        for (int i = 0; i < friends.length; i++) {
            //자리에 서지 않은 친구만 자리에 서게한다.
            if(!isVisited[i]) {
                //자리에 섯으므로 true
                isVisited[i] = true;
                // 자리에 섯으므로 curMemberPicture 에 friends 를 붙인다.
                dfs(curMemberPicture + friends[i]);
                //모든 경우의 수를 구해야 하므로 isVisited 값을 false 로 만들어서 다시 자리에 서는 경우를 구한다.
                isVisited[i] = false;
            }
        }
    }

    private static boolean checkCondition(String memberPicture) {
        //모든 조건에 해당하는지 확인해야 하므로  for문 이용
        for (String condition : conditions) {
            char member1 = condition.charAt(0); //charAt 을 이용하여 condition 에서 어떤 멤버의 조건이지 확인
            char member2 = condition.charAt(2); //charAt 을 이용하여 condition 에서 어떤 멤버의 조건이지 확인
            char operator = condition.charAt(3); //charAt 을 이용하여 condition 에서 어떤 연산자인지 확인
            int compareValue = condition.charAt(4) - '0' + 1; //charAt 을 이용하여 condition 에서 간격 확인 , , 간격을 구하기 위해서는 + 1 을 해야함 Ex)바로 붙어있으면 index 는 1 이지만 간격은 0이다.
            int absOfPositionDiffValueInMemberPicture = Math.abs(memberPicture.indexOf(member1) - memberPicture.indexOf(member2)); // 간격을 쉽게 구하기 위해서 Math.abs를 이용

            //중간에 조건을 한번이라도 실패하면 더 이상 볼 필요가 없으므로 return false 한다.
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

        //모든 조건에 관해서 통과를 했으면 true를 반환
        return true;
    }
}
