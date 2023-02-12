package CodingTest.Programmers;

//자신보다 크면서 , 가장 가까이 있는 수 => 뒷 큰수
//뒷 큰수의 배열
//존재하지 않으면 -1을 담는다.

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Arrays.fill(answer, -1);

        Stack<Integer> stack = new Stack<>();

        for (int arrIdx = 0; arrIdx < numbers.length; arrIdx++) {
            while (!stack.isEmpty() && numbers[arrIdx] > numbers[stack.peek()]) {
                int stkIdx = stack.pop();
                answer[stkIdx] = numbers[arrIdx];
            }

            stack.push(arrIdx);
        }

        return answer;
    }
}
