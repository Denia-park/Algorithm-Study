package CodingTest.LeetCode;

public class Quiz {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.convert("PAYPALISHIRING", 3).equals("PAHNAPLSIIGYIR"));
        System.out.println(solution.convert("PAYPALISHIRING", 4).equals("PINALSIGYAHRPI"));
        System.out.println(solution.convert("A", 1).equals("A"));
        System.out.println(solution.convert("ABC", 1));
    }
}

class Solution {
    public String convert(String s, int numRows) {
        //배열을 만든다.
        final int maxCol = s.length();
        char[][] arr = new char[numRows][maxCol];

        //순서대로 집어 넣는다.
        final char[] charArray = s.toCharArray();
        boolean isDown = true; // 0이면 true, numRows - 1 이면 false
        //true이면, 한줄로 내려간다.
        //flase이면, col을 계속 한칸씩 옮긴다.

        int curRowIdx = 0;
        int curColIdx = 0;

        for (char ch : charArray) {
            arr[curRowIdx][curColIdx] = ch;

            if (!isDown) {
                //col을 옮긴다.
                curColIdx++;
                //row를 감소
                curRowIdx--;

                if (curRowIdx == -1) {
                    isDown = true;
                    curRowIdx += 2;
                    curColIdx--;
                }
            } else {
                //row를 증가
                curRowIdx++;

                if (curRowIdx == numRows) {
                    isDown = false;
                    curRowIdx -= 2;
                    curColIdx++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        //쭉 표시한다.
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                char ch = arr[row][col];
                if (ch != '\0') {
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }
}

