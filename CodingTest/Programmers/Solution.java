package CodingTest.Programmers;

class Solution {
    public int solution(final int col, final int row, final int[][] puddles) {
        final int[][] answers = new int[row + 1][col + 1];
        insertPuddle(puddles, answers);

        for (int r = 1; r <= row; r++) {
            for (int c = 1; c <= col; c++) {
                //집은 출발점이니 세지 않는다.
                if (r == 1 && c == 1) {
                    answers[r][c] = 1;
                    continue;
                }

                //웅덩이를 만나면 가는 길이 아니다.
                if (answers[r][c] == -1) {
                    continue;
                }

                //오른쪽과 아래로만 갈 수 있으므로, 왼쪽이랑 위쪽의 값을 더하면 해당하는 길로 가는 개수.
                //왼쪽
                int leftVal = answers[r][c - 1];
                //위쪽
                int upVal = answers[r - 1][c];

                //웅덩이의 값은 더하면 안된다.
                if (leftVal == -1 || upVal == -1) {
                    answers[r][c] = Math.max(leftVal, upVal);
                    continue;
                }

                //위의 경우에 해당하지 않는다면 가는 길을 2개 더하면 된다.
                answers[r][c] = leftVal + upVal;
            }
        }

//        System.out.println(Arrays.deepToString(answers));

        return answers[row][col];
    }

    private void insertPuddle(final int[][] puddles, final int[][] answers) {
        for (final int[] puddle : puddles) {
            final int c = puddle[0];
            final int r = puddle[1];

            answers[r][c] = -1;
        }
    }
}
