package CodingTest.Programmers;

class Solution {
    int[][] globalArr;

    public int[] solution(final int[][] arr) {
        globalArr = arr;

        return calculate(0, 0, arr.length);
    }

    private int[] calculate(final int startRow, final int startCol, final int length) {
        //모든 값이 같은지 판단
        final int saveValue = globalArr[startRow][startCol];
        boolean sameFlag = true;
        for (int row = startRow; row < startRow + length; row++) {
            for (int col = startCol; col < startCol + length; col++) {
                final int curValue = globalArr[row][col];

                if (saveValue != curValue) {
                    sameFlag = false;
                    break;
                }
            }

            if (!sameFlag) {
                break;
            }
        }

        if (sameFlag) {
            return globalArr[startRow][startCol] == 0 ? new int[]{1, 0} : new int[]{0, 1};
        }

        //다르면 4등분
        final int[] sumArr = {0, 0};
        final int halfLength = length / 2;
        //11시
        sum(sumArr, calculate(startRow, startCol, halfLength));
        //1시
        sum(sumArr, calculate(startRow, startCol + halfLength, halfLength));
        //7시
        sum(sumArr, calculate(startRow + halfLength, startCol, halfLength));
        //5시
        sum(sumArr, calculate(startRow + halfLength, startCol + halfLength, halfLength));

        return sumArr;
    }

    private void sum(final int[] sumArr, final int[] calculate) {
        sumArr[0] += calculate[0];
        sumArr[1] += calculate[1];
    }
}
