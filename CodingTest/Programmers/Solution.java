package CodingTest.Programmers;

class Solution {
    public int[] solution(final int[] array, final int[][] commands) {
        final int[] answer = new int[commands.length];

        for (int commandIdx = 0; commandIdx < commands.length; commandIdx++) {
            final int[] command = commands[commandIdx];

            final int startIdx = command[0] - 1;
            final int endIdx = command[1] - 1;
            final int targetIdx = command[2] - 1;

            answer[commandIdx] = getValue(array, startIdx, endIdx, targetIdx);
        }

        return answer;
    }

    private int getValue(final int[] array, final int startIdx, final int endIdx, final int targetIdx) {
        final int[] tempArr = new int[endIdx - startIdx + 1];
        System.arraycopy(array, startIdx, tempArr, 0, tempArr.length);

        //버블 정렬
        bubbleSort(tempArr);

        return tempArr[targetIdx];
    }

    private void bubbleSort(final int[] tempArr) {
        for (int count = 0; count < tempArr.length - 1; count++) {
            for (int diffIdx = 0; diffIdx < tempArr.length - 1 - count; diffIdx++) {
                final int first = tempArr[diffIdx];
                final int second = tempArr[diffIdx + 1];

                if (first > second) {
                    swap(tempArr, diffIdx, diffIdx + 1);
                }
            }
        }
    }

    private void swap(final int[] tempArr, final int idxA, final int idxB) {
        final int temp = tempArr[idxA];
        tempArr[idxA] = tempArr[idxB];
        tempArr[idxB] = temp;
    }
}
