package com.company;

public class Solution {
    static public void main(String[] args) {
        int[] quiz1 = { 1, 1, 1, 1, 1 };
        int quizTarget1 = 3;
        int[] quiz2 = { 4, 1, 2, 1 };
        int quizTarget2 = 4;

        System.out.println(solution(quiz1, quizTarget1) == 5);
        System.out.println(solution(quiz2, quizTarget2) == 2);
    }

    //dfs 에서 값을 계산할떄 사용이 되어야 하므로 전역변수로 설정
    static char[] operators = {'+','-'};
    //dfs 에서 값을 계산할떄 사용이 되어야 하므로 전역변수로 설정
    static int[] numbers;

    static public int solution(int[] quizNumbers, int target) {
        int answer = 0;
        numbers = quizNumbers;
        //깊이 우선 탐색으로 진행을 할때 visited를 확인해야 하는데 index를 사용해서 대신 확인 , 처음에는 0으로 설정
        int index = 0;

        //numbers 숫자 앞에 각각 + , - 를 넣어보면서 target이 되는지 확인을 해야하므로 for문을 사용하여 시작노드를 정한다.
        for (char operator : operators) {
            answer += dfs(operator,index,target);
        }

        return answer;
    }

    private static int dfs(char op, int index, int quizTarget) {
        int tempAnswer = 0;

        if (op == '+') {
            quizTarget = quizTarget - numbers[index];
        } else { //op == '-'
            quizTarget = quizTarget + numbers[index];
        }

        //index를 사용해서 깊이의 정도를 확인함
        index++;
        //재귀함수 타기
        //dfs에서 해당 재귀함수가 깊이가 끝에 도달했는지 확인을 해서 아직 덜 도달했으면 계속해서 재귀함수를 실행한다.
        if (index != numbers.length) {
            for (char operator : operators) {
                tempAnswer += dfs(operator, index, quizTarget);
            }
        } else {
            if (quizTarget == 0)
                return 1;
            else
                return 0;
        }

        return tempAnswer;
    }
}
