//정답 참고
//전제
class Solution {
    public void solution(int candiNum, int nameLen, String[] table) {
        StringBuilder sb = new StringBuilder();

        char[][] chars = new char[candiNum][nameLen];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = table[i].toCharArray();
        }

        for (int col = 0; col < nameLen; col++) {
            int digitDiff = 0;

            for (int row = 1; row < candiNum; row++) {
                //각 자리별로 몇개의 문자가 다른지 확인
                if (chars[0][col] != chars[row][col]) {
                    digitDiff++;
                }

                int rowDiff = 0;
                for (int col2 = 0; col2 < nameLen; col2++) {
                    if (chars[0][col2] != chars[row][col2]) {
                        rowDiff++;
                    }
                }

                if (rowDiff > 2) {
                    System.out.println("CALL FRIEND");
                    return;
                }
            }

            if (digitDiff == (candiNum - 1)) {
                chars[0][col] = chars[candiNum - 1][col];
            }
        }

        System.out.println(chars[0]);
    }
}
