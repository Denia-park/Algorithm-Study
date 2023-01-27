package CodingTest.Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        int minA = arrayA[0];
        int minB = arrayB[0];

        List<Integer> dividersA = getDividers(minA);
        List<Integer> dividersB = getDividers(minB);

        for (int idx = dividersA.size() - 1; idx >= 0; idx--) {
            boolean parentDivide = true;
            int divideVal = dividersA.get(idx);
            for (int arrVal : arrayA) {
                if (arrVal % divideVal != 0) {
                    parentDivide = false;
                    break;
                }
            }

            if (parentDivide) {
                boolean doNotDivide = true;
                for (int arrVal : arrayB) {
                    if (arrVal % divideVal == 0) {
                        doNotDivide = false;
                        break;
                    }
                }
                if (doNotDivide) {
                    answer = divideVal;
                    break;
                }
            }
        }

        for (int idx = dividersB.size() - 1; idx >= 0; idx--) {
            boolean parentDivide = true;
            int divideVal = dividersB.get(idx);
            for (int arrVal : arrayB) {
                if (arrVal % divideVal != 0) {
                    parentDivide = false;
                    break;
                }
            }

            if (parentDivide) {
                boolean doNotDivide = true;
                for (int arrVal : arrayA) {
                    if (arrVal % divideVal == 0) {
                        doNotDivide = false;
                        break;
                    }
                }
                if (doNotDivide) {
                    answer = Math.max(answer, divideVal);
                    break;
                }
            }
        }

        return answer;
    }

    List<Integer> getDividers(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
            }
        }

        return list;
    }
}
