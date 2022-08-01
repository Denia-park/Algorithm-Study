public class Solution {
    static public void main(String[] args) {
        int[] quiz1 = { 1, 1, 1, 1, 1 };
        int quizTarget1 = 3;
        int[] quiz2 = { 4, 1, 2, 1 };
        int quizTarget2 = 4;

        System.out.println(solution(quiz1, quizTarget1) == 5);
        System.out.println(solution(quiz2, quizTarget2) == 2);
    }

    static int answer;
    static int target;
    static char[] operators = {'+','-'};
    static int[] numbers;

    static public int solution(int[] quizNumbers, int quizTarget) {
        answer = 0;
        target = quizTarget;
        numbers = quizNumbers;
        int index = 0;

        for (char operator : operators) {
            answer += dfs(operator,index,target);
        }
        
        return answer;
    }

    private static int dfs(char op, int index, int quizTarget) {
        int tempAnswer = 0;

        if(numbers.length == index && quizTarget == 0){
            return 1;
        }else if (numbers.length == index && quizTarget != 0){
            return 0;
        }

        if(op == '+'){
            quizTarget = quizTarget - numbers[index];
        }
        //op == '-'
        else{
            quizTarget = quizTarget + numbers[index];
        }

        //재귀함수 타기
        index++;
        for (char operator : operators) {
            tempAnswer += dfs(operator,index,quizTarget);
        }

        return tempAnswer;
    }
}
