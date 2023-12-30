package CodingTest.Programmers;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(final int[] numbers) {
        final Set<Integer> set = new HashSet<>();

        for (int firstIdx = 0; firstIdx < numbers.length; firstIdx++) {
            for (int secondIdx = firstIdx + 1; secondIdx < numbers.length; secondIdx++) {
                set.add(numbers[firstIdx] + numbers[secondIdx]);
            }
        }

        final int[] array = set.stream().mapToInt(i -> i).toArray();

        //정렬
        selectionSort(array);

        return array;
    }

    private void selectionSort(final int[] numbers) {
        //맨 앞부터 채워나간다.
        for (int positionIdx = 0; positionIdx < numbers.length; positionIdx++) {
            //제일 작은 수를 하나 고른다
            int minIdx = positionIdx;

            for (int idx = positionIdx; idx < numbers.length; idx++) {
                final int minValue = numbers[minIdx];
                final int selectValue = numbers[idx];

                if (minValue > selectValue) {
                    minIdx = idx;
                }
            }

            swap(numbers, positionIdx, minIdx);
        }
    }

    private void swap(final int[] numbers, final int positionIdx, final int minIdx) {
        final int temp = numbers[positionIdx];
        numbers[positionIdx] = numbers[minIdx];
        numbers[minIdx] = temp;
    }
}
