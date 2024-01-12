package CodingTest.Programmers;

//정답 해설
//https://school.programmers.co.kr/questions/35224

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(final String[] arr) {
        // 숫자와 연산자를 분리해서 저장
        // numbers : 숫자를 저장하는 리스트
        // operators : 연산자를 저장하는 리스트
        final List<Integer> numbers = new ArrayList<>();
        final List<String> operators = new ArrayList<>();

        // arr의 원소를 순회하면서, 숫자와 연산자를 분리해서 numbers와 operators에 저장
        for (final String str : arr) {
            if (str.equals("+") || str.equals("-")) {
                operators.add(str);
            } else {
                numbers.add(Integer.parseInt(str));
            }
        }

        final int numsLength = numbers.size();

        // maxDp[i][j] : i번째 숫자부터 j번째 숫자까지의 연산 결과의 최대값
        final int[][] maxDp = new int[numsLength][numsLength];
        // minDp[i][j] : i번째 숫자부터 j번째 숫자까지의 연산 결과의 최소값
        final int[][] minDp = new int[numsLength][numsLength];

        // step을 조금씩 늘려가면서 계산 (bottom-up 방식)
        for (int step = 0; step < numsLength; step++) {
            // startIdx는 0부터 numsLength-step까지 이동 가능
            for (int startIdx = 0; startIdx < numsLength - step; startIdx++) {
                // endIdx는 startIdx에서 step만큼 떨어진 위치
                final int endIdx = startIdx + step;

                if (startIdx == endIdx) { // startIdx == endIdx인 경우, 해당 숫자를 그대로 사용
                    maxDp[startIdx][endIdx] = numbers.get(startIdx);
                    minDp[startIdx][endIdx] = numbers.get(startIdx);
                } else { // startIdx != endIdx인 경우, startIdx ~ endIdx까지의 연산 결과를 구해야 함
                    //초기값 설정
                    int max = Integer.MIN_VALUE;
                    int min = Integer.MAX_VALUE;

                    // 괄호를 한칸씩 이동하면서, 최대값과 최소값을 구함
                    // bracketIdx는 괄호의 위치를 의미, 괄호의 위치를 기준으로 왼쪽과 오른쪽으로 나누어서 계산
                    // 괄호는 startIdx ~ endIdx-1까지 이동 가능 (숫자 및 연산자의 위치는 고정이, 연산자는 숫자보다 개수가 1개 적음)
                    for (int bracketIdx = startIdx; bracketIdx < endIdx; bracketIdx++) {
                        final String op = operators.get(bracketIdx);

                        if (op.equals("+")) { // 덧셈인 경우
                            max = Math.max(max, maxDp[startIdx][bracketIdx] + maxDp[bracketIdx + 1][endIdx]);
                            min = Math.min(min, minDp[startIdx][bracketIdx] + minDp[bracketIdx + 1][endIdx]);
                        } else { // 뺄셈인 경우
                            max = Math.max(max, maxDp[startIdx][bracketIdx] - minDp[bracketIdx + 1][endIdx]);
                            min = Math.min(min, minDp[startIdx][bracketIdx] - maxDp[bracketIdx + 1][endIdx]);
                        }
                    }

                    // 최대값과 최소값을 저장
                    maxDp[startIdx][endIdx] = max;
                    minDp[startIdx][endIdx] = min;
                }
            }
        }

        // 최종 결과는 0번째 숫자부터 마지막 숫자까지의 연산 결과의 최대값
        return maxDp[0][numsLength - 1];
    }
}
