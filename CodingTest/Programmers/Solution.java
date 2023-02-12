package CodingTest.Programmers;

//자신보다 크면서 , 가장 가까이 있는 수 => 뒷 큰수
//뒷 큰수의 배열
//존재하지 않으면 -1을 담는다.

import java.util.Stack;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Stack<Number> stack = new Stack<>();

        for (int i = 0; i < numbers.length; i++) {
            if (stack.isEmpty()) {
                stack.push(new Number(numbers[i], i));
                continue;
            }
            
            while (!stack.isEmpty() && numbers[i] > stack.peek().num) {
                Number top = stack.pop();
                answer[top.idx] = numbers[i];
            }

            stack.push(new Number(numbers[i], i));
        }

        while (!stack.isEmpty()) {
            Number top = stack.pop();
            answer[top.idx] = -1;
        }

        return answer;
    }
}

class Number {
    int num;
    int idx;

    public Number(int num, int idx) {
        this.num = num;
        this.idx = idx;
    }
}
