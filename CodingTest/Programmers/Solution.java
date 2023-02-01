package CodingTest.Programmers;

import java.util.Stack;

class Solution {
    final int[] hamberger = {1, 2, 3, 1};

    public int solution(int[] ingredient) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for (int val : ingredient) {
            stack.push(val);

            if (stack.size() >= 4 && stack.peek() == 1) {
                int changeIdx = stack.size() - 4;
                boolean makeFlag = true;

                for (int tmpIdx = 0; tmpIdx < 4; tmpIdx++) {
                    if (stack.get(changeIdx + tmpIdx) != hamberger[tmpIdx]) {
                        makeFlag = false;
                        break;
                    }
                }

                if (makeFlag) {
                    for (int j = 0; j < 4; j++) {
                        stack.pop();
                    }

                    answer++;
                }
            }
        }

        return answer;
    }
}
