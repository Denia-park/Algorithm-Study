package CodingTest.Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private int answer;

    public int solution(int[] arrayA, int[] arrayB) {
        answer = 0;

        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        int minA = arrayA[0];
        int minB = arrayB[0];

        List<Integer> dividersA = getDividers(minA);
        List<Integer> dividersB = getDividers(minB);

        checkMaxDivideValue(dividersA, arrayA, arrayB);
        checkMaxDivideValue(dividersB, arrayB, arrayA);

        return answer;
    }

    private void checkMaxDivideValue(List<Integer> dividers, int[] doDivideArr, int[] doNotDivideArr) {
        for (int idx = dividers.size() - 1; idx >= 0; idx--) {

            boolean doDivideFlag = true;
            int divideVal = dividers.get(idx);

            for (int arrVal : doDivideArr) {
                if (arrVal % divideVal != 0) {
                    doDivideFlag = false;
                    break;
                }
            }

            if (doDivideFlag) {
                boolean doNotDivideFlag = true;

                for (int arrVal : doNotDivideArr) {
                    if (arrVal % divideVal == 0) {
                        doNotDivideFlag = false;
                        break;
                    }
                }

                if (doNotDivideFlag) {
                    answer = Math.max(answer, divideVal);
                    return;
                }
            }
        }
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
