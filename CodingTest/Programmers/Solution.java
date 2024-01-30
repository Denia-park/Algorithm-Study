package CodingTest.Programmers;

/*
아이디어 - DFS
 */
class Solution {
    int gTarget;
    int answer;

    public int solution(final int[] numbers, final int target) {
        gTarget = target;
        answer = 0;

        dfs(numbers, 0, 0);

        return answer;
    }

    private void dfs(final int[] numbers, final int index, final int sum) {
        if (index == numbers.length) {
            if (sum == gTarget) {
                answer++;
            }

            return;
        }

        dfs(numbers, index + 1, sum + numbers[index]);
        dfs(numbers, index + 1, sum - numbers[index]);
    }
}
