package CodingTest.Programmers;

//정답 참고
//출처 : https://velog.io/@qodlstjd12/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%ED%98%BC%EC%9E%90%EC%84%9C-%ED%95%98%EB%8A%94-%ED%8B%B1%ED%83%9D%ED%86%A0-java
class Solution {
    char[][] gBoard;

    public int solution(String[] board) {
        int firstPlaceCount = 0;
        int secondPlaceCount = 0;

        gBoard = new char[3][3];
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                char ch = board[r].charAt(c);
                gBoard[r][c] = ch;
                if (ch == 'O') {
                    firstPlaceCount++;
                } else if (ch == 'X') {
                    secondPlaceCount++;
                }
            }
        }

        boolean[] winArr = checkWin();

        boolean firstWin = winArr[0];
        boolean secondWin = winArr[1];

        //둘 다 이겼다는 안됨
        if (firstWin && secondWin) {
            return 0;
        }
        //후공의 개수가 더 많을 수가 없다. , 선공이 2개 차이나게 둘 수 없다.
        else if ((firstPlaceCount < secondPlaceCount) ||
                ((firstPlaceCount - secondPlaceCount) > 1)) {
            return 0;
        }
        //선공이 이겼는데 개수가 동일하면 안됨
        else if ((firstWin && firstPlaceCount == secondPlaceCount)) {
            return 0;
        }
        //후공이 이겼는데 선공의 수가 더 많아도 안됨
        else if ((secondWin && firstPlaceCount > secondPlaceCount)) {
            return 0;
        }

        return 1;
    }

    private boolean[] checkWin() {
        boolean firstWin = false;
        boolean secondWin = false;

        for (int c = 0; c < 3; c++) {
            if (gBoard[0][c] == gBoard[1][c] && gBoard[1][c] == gBoard[2][c]) {
                if (gBoard[0][c] == 'O') {
                    firstWin = true;
                } else if (gBoard[0][c] == 'X') {
                    secondWin = true;
                }
            }
        }

        for (int r = 0; r < 3; r++) {
            if (gBoard[r][0] == gBoard[r][1] && gBoard[r][1] == gBoard[r][2]) {
                if (gBoard[r][0] == 'O') {
                    firstWin = true;
                } else if (gBoard[r][0] == 'X') {
                    secondWin = true;
                }
            }
        }

        if (gBoard[0][0] == gBoard[1][1] && gBoard[1][1] == gBoard[2][2]) {
            if (gBoard[0][0] == 'O') {
                firstWin = true;
            } else if (gBoard[0][0] == 'X') {
                secondWin = true;
            }
        }

        if (gBoard[0][2] == gBoard[1][1] && gBoard[1][1] == gBoard[2][0]) {
            if (gBoard[0][2] == 'O') {
                firstWin = true;
            } else if (gBoard[0][2] == 'X') {
                secondWin = true;
            }
        }

        return new boolean[]{firstWin, secondWin};
    }
}
