package CodingTest.LeetCode;

import CodingTest.Programmers.BracketUtil;

import java.util.HashMap;
import java.util.Map;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println("1 : " + solution.numSubmatrixSumTarget(
                BracketUtil.convertStringToJavaIntTwoDimensionalArray("[[0,1,0],[1,1,1],[0,1,0]]"),
                0));
        System.out.println("2 : " + solution.numSubmatrixSumTarget(
                BracketUtil.convertStringToJavaIntTwoDimensionalArray("[[1,-1],[-1,1]]"),
                0));
        System.out.println("3 : " + solution.numSubmatrixSumTarget(
                BracketUtil.convertStringToJavaIntTwoDimensionalArray("[[904]]"),
                0));
    }
}

/*
아이디어 - 누적합
 */

class Solution {
    public int numSubmatrixSumTarget(final int[][] matrix, final int target) {
        int count = 0; // 카운터 초기화: 타겟 합을 가진 서브 매트릭스의 수를 세기 위함
        final int rows = matrix.length; // 행렬의 행 수
        final int cols = matrix[0].length; // 행렬의 열 수

        // 행을 기준으로 반복
        for (int startRow = 0; startRow < rows; startRow++) {
            final int[] sum = new int[cols]; // 각 열의 누적 합을 저장할 배열

            // 서브 매트릭스의 시작 행을 startRow로 고정하고, row로 끝 행을 변경하면서 반복
            for (int row = startRow; row < rows; row++) {
                // 각 열의 누적 합을 업데이트
                for (int col = 0; col < cols; col++) {
                    sum[col] += matrix[row][col];
                }

                // 서브 매트릭스의 합을 계산하고 타겟과 비교
                count += subarraySum(sum, target);
            }
        }
        return count; // 결과 반환
    }

    private int subarraySum(final int[] sum, final int k) {
        int count = 0; // 카운터 초기화
        int curSum = 0; // 현재까지의 누적 합
        final Map<Integer, Integer> prevSum = new HashMap<>(); // 이전 누적 합을 저장하는 해시맵
        prevSum.put(0, 1); // 기본값 설정

        // 각 열의 누적 합에 대해 반복
        for (final int s : sum) {
            curSum += s; // 현재 열의 누적 합 추가
            count += prevSum.getOrDefault(curSum - k, 0); // 타겟 합을 찾으면 카운트 증가
            prevSum.put(curSum, prevSum.getOrDefault(curSum, 0) + 1); // 현재 누적 합 업데이트
        }

        return count; // 결과 반환
    }
}
